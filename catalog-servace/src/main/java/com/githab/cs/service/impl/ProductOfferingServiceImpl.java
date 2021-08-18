package com.githab.cs.service.impl;

import java.util.Optional;
import java.util.UUID;

import com.githab.cs.entity.ProductOfferingEntity;
import com.githab.cs.model.ProductOffering.ProductOffering;
import com.githab.cs.model.searchParams.SearchParams;
import com.githab.cs.repository.RepositoryProductOffering;
import com.githab.cs.service.api.ProductOfferingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductOfferingServiceImpl implements ProductOfferingService{
    @Autowired
    RepositoryProductOffering repositoryProductOffering;

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
    public ProductOffering searchProductOffering(SearchParams params) {
        return null;
    }

    // private static Map<String, String> columnsName(){
    //     Map<String, String> tableMap = new HashMap<>();
    //     Field<?>[] fields  = PUBLIC.PRODUCT_OFFERING.fields();
    //     java.lang.reflect.Field[] fieldClass = ProductOfferingEntity.class.getDeclaredFields();
    //     for (int i = 0; i < fieldClass.length; i++){
    //         tableMap.put(fieldClass[i].getName(), fields[i].getName());
    //     }
    //     return tableMap;
    // }
    // private static Map<String, String> columnJsonName(){
    //     Map<String, String> tableJsonMap = new HashMap<>();
    //     java.lang.reflect.Field[] fieldClass = ProductOfferingBodyEntity.class.getDeclaredFields();
    //     for (java.lang.reflect.Field aClass : fieldClass) {
    //         tableJsonMap.put(aClass.getName(), aClass.getName());
    //     }
    //     return tableJsonMap;
    // }
    
}
