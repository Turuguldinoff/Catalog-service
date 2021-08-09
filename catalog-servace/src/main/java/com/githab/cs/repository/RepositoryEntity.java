package com.githab.cs.repository;

import java.util.ArrayList;

import com.githab.cs.entity.ProductOffering.ProductOffering;
import com.githab.cs.model.ProductOfferingPrice.ProductOfferingPrice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEntity extends CrudRepository<String, ProductOffering>{
    public ProductOffering creatProductOffering(String id, String name, String description, ArrayList<String> category, ArrayList<ProductOfferingPrice> productOfferingPrice);
    public ProductOffering upProductOffering(ProductOffering product);
    public ProductOffering getIdProductOffering(ProductOffering product);
    public ProductOffering removeProductOffering(ProductOffering product);
}
