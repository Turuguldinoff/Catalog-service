package com.githab.cs.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.githab.cs.model.ProductOfferingPrice.ProductOfferingPrice;

@Entity
public class ProductOfferingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    String name;
    String description;
    OffsetDateTime lastTime = OffsetDateTime.now();
    ArrayList<String> category;
    ArrayList <ProductOfferingPrice> productOfferingPrice;
    public OffsetDateTime getLacttime() {
        return lastTime;
    }
    public String getId() {
        return id;
    }
    public ArrayList<String> getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public ArrayList<ProductOfferingPrice> getProductOfferingPrice() {
        return productOfferingPrice;
    }
}
