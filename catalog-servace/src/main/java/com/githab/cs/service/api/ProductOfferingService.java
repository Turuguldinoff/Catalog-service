package com.githab.cs.service.api;

import java.util.ArrayList;

import com.githab.cs.entity.ProductOffering.ProductOffering;
import com.githab.cs.model.ProductOfferingPrice.ProductOfferingPrice;
import com.githab.cs.model.searchParams.SearchParams;

public interface ProductOfferingService {
   
    public ProductOffering creatProductOffering(String id, String name, String description, ArrayList<String> category, ArrayList<ProductOfferingPrice> productOfferingPrice);
    public ProductOffering upProductOffering(ProductOffering product);
    public ProductOffering getIdProductOffering(ProductOffering product);
    public ProductOffering removeProductOffering(ProductOffering product);
    public ProductOffering searchProductOffering(SearchParams params);
}
