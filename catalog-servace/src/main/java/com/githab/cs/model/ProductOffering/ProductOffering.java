package com.githab.cs.model.ProductOffering;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import com.githab.cs.entity.ProductOfferingBodyEntity;
import com.githab.cs.entity.ProductOfferingEntity;
import com.githab.cs.model.ProductOfferingPrice.ProductOfferingPrice;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOffering {
	String id;
    String name;
    String description;
    ArrayList<String> category;
    ArrayList <ProductOfferingPrice> productOfferingPrice;
    OffsetDateTime lastTime;

	public static ProductOfferingEntity convert(ProductOffering prod) {
		return new ProductOfferingEntity(
			prod.id,
			new ProductOfferingBodyEntity(
				prod.name,
				prod.description,
				prod.category,
				prod.productOfferingPrice
			),
			prod.lastTime
		);
		
	}

	public static ProductOffering convertD(ProductOfferingEntity prod) {
		return new ProductOffering(
			prod.getId(),
			prod.getBody().getName(),
			prod.getBody().getDescription(),
			prod.getBody().getCategory(),
			prod.getBody().getProductOfferingPrice(),
			prod.getLastTime()
		);
		
	}
}
