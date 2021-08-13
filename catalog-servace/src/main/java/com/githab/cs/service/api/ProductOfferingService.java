package com.githab.cs.service.api;

import com.githab.cs.model.ProductOffering.ProductOffering;
import com.githab.cs.model.searchParams.SearchParams;

public interface ProductOfferingService {
   
    public ProductOffering createProductOffering(ProductOffering product);
    public ProductOffering upProductOffering(ProductOffering product);
    public ProductOffering getProductOfferingById(String id);
    public ProductOffering removeProductOffering(ProductOffering product);
    public ProductOffering searchProductOffering(SearchParams params);
}
