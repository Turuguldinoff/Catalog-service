package com.githab.cs.service.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import com.githab.cs.entity.ProductOfferingEntity;
import com.githab.cs.model.searchParams.SearchParams;

public interface ProductOfferingService {
   
    public ProductOfferingEntity createProductOffering(ProductOfferingEntity product);
    public ProductOfferingEntity upProductOffering(ProductOfferingEntity product, String id);
    public Optional<ProductOfferingEntity> getProductOfferingById(String id);
    public void removeProductOffering(String id);
    public List<ProductOfferingEntity> searchProductOffering(Map<String, String> params);
}
