package com.githab.cs.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.githab.cs.entity.ProductOfferingEntity;
import com.githab.cs.model.searchParams.SearchParams;
import com.githab.cs.repository.RepositoryProductOffering;
import com.githab.cs.repository.RepositorySearchServiceImpl;
import com.githab.cs.service.api.ProductOfferingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jooq.Condition;
import org.jooq.impl.DSL;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductOfferingServiceImpl implements ProductOfferingService{
    @Autowired
    RepositoryProductOffering repositoryProductOffering;
    @Autowired
    RepositorySearchServiceImpl repositorySearchService;

    @Override
    public ProductOfferingEntity createProductOffering(ProductOfferingEntity product) {
        product.setId(UUID.randomUUID().toString());
        ProductOfferingEntity prod = repositoryProductOffering.create(product);
        return prod;
    }

    @Override
    public ProductOfferingEntity upProductOffering(ProductOfferingEntity product, String id) {
        repositoryProductOffering.update(product, id);
        return product;
    }

    @Override
    public Optional<ProductOfferingEntity> getProductOfferingById(String id) {
        repositoryProductOffering.getId(id);
        return Optional.ofNullable(repositoryProductOffering.getId(id));
    }

    @Override
    public void removeProductOffering(String id) {
        repositoryProductOffering.delete(id);
    }

    @Override
    public List<ProductOfferingEntity> searchProductOffering(SearchParams params) {
        if(params.getFilters().size() == 0)
            return repositorySearchService.searchAll();
        return repositorySearchService.searchC(getConditionByParameters(params));
    }

    private static Condition getConditionByParameters(SearchParams params){
        Condition condition = DSL.trueCondition();
        String names = "category";
        String data = "lastUpdate";
        if (params.getFilters().containsKey(names) && params.getFilters().containsKey(data)) {
            condition = condition.and(AllParams(params.getFilters().get(names), params.getFilters().get(data)));
        }else{
            if (params.getFilters().containsKey(names)) {
                    condition = condition.and(JsonStringCondition(params.getFilters().get(names)));
            }
            if (params.getFilters().containsKey(data)) {
                if (params.getFilters().get(data).size() == 1) {
                    condition = condition.and(ColumnOneData(params.getFilters().get(data)));
                } else {
                    condition = condition.and(ColumnData(params.getFilters().get(data)));
                }
            }
        }
        return condition;
    }

    private static String ColumnOneData(List<String> a) {
            return String.format("last_update BETWEEN '%s' AND '%s'", a.get(0), LocalDateTime.now());
        }

    private static String AllParams(List<String> n, List<String> a) {
        String c = JsonStringCondition(n);
        c += " AND ";
        if(a.size() == 1)
            c += ColumnOneData(a);
        else if(a.size() == 2)
            c += ColumnData(a);
        return c;  
    }

    private static String JsonStringCondition(List<String> n) {        
        int i = 0;
        String c = "body @> '{\"category\": [";
        while (i < n.size()) {
            c += String.format("\"%s\"", n.get(i));
            if (i < n.size()-1)
                c += ", ";
            i++;
        }
        c += "]}' ";
        return c;
    }

    private static String ColumnData(List<String> a) {
        return String.format("last_update BETWEEN '%s' AND '%s'",  a.get(0), a.get(1));
    }
}
