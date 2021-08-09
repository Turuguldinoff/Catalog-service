package com.githab.cs.model.ProductOfferingPrice;

import com.githab.cs.model.definition.Money;

public class ProductOfferingPrice {
    private String id;
    private Money price;

    public ProductOfferingPrice(String id, Money price){
        this.id = id;
        this.price = price;
    }
}
