package com.githab.cs.entity.ProductOffering;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.githab.cs.model.ProductOfferingPrice.ProductOfferingPrice;

@Entity
public class ProductOffering {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
    private OffsetDateTime lastTime;
    private ArrayList<String> category;
    private ArrayList <ProductOfferingPrice> productOfferingPrice;

    public ProductOffering(String id, String name){
        this.name = name;
    }
}
