package com.githab.cs.entity;

import java.util.ArrayList;

import com.githab.cs.model.ProductOfferingPrice.ProductOfferingPrice;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductOfferingBodyEntity {
    String name;
    String description;
    ArrayList<String> category;
    ArrayList <ProductOfferingPrice> productOfferingPrice;
}