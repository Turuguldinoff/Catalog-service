package com.githab.cs.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.githab.cs.entity.ProductOfferingEntity;
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
    public List<ProductOfferingEntity> searchProductOffering(Map<String, String> params) {
        if(params.size() == 0)
            return repositorySearchService.searchAll();
        return repositorySearchService.searchC(getConditionByParameters(params));
    }

        private static Condition getConditionByParameters(Map<String, String> map){
        Condition condition = DSL.trueCondition();
        String names = "category";
        String data = "lastUpdate";
        if (map.containsKey(names) && map.containsKey(data)) {
            condition = condition.and(AllParams(map.get(names),LocalDate.parse(map.get(data).substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-d")).atStartOfDay(), LocalDate.parse(map.get(data).substring(11), DateTimeFormatter.ofPattern("yyyy-MM-d")).atStartOfDay()));
        }else{
            if (map.containsKey(names)) {
                    condition = condition.and(JsonStringCondition(map.get(names)));
            }
            if (map.containsKey(data)) {
                condition = condition.and(ColumnData(LocalDate.parse(map.get(data).substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-d")).atStartOfDay(), LocalDate.parse(map.get(data).substring(11), DateTimeFormatter.ofPattern("yyyy-MM-d")).atStartOfDay()));
            }
        }
        return condition;
    }

    private static String AllParams(String n, LocalDateTime a, LocalDateTime b) {
        return String.format("body @> '{\"category\": \"%s\"}' AND last_update BETWEEN '%s' AND '%s'", n, a, b);
    }

    private static String JsonStringCondition( String list) {
        return String.format("body @> '{\"category\": \"%s\"}'", list);
    }

    private static String ColumnData(LocalDateTime one, LocalDateTime two) {
        return String.format("last_update BETWEEN '%s' AND '%s'",  one, two);
    }
}
