package com.githab.cs.service.api;

import java.util.Optional;

import com.githab.cs.entity.ProductOfferingEntity;
import com.githab.cs.model.ProductOffering.ProductOffering;
import com.githab.cs.model.searchParams.SearchParams;

public interface ProductOfferingService {
   
    public ProductOffering createProductOffering(ProductOfferingEntity product);
    public ProductOffering upProductOffering(ProductOfferingEntity product);
    public Optional<ProductOfferingEntity> getProductOfferingById(String id);
    public void removeProductOffering(String id);
    public ProductOffering searchProductOffering(SearchParams params);
}
