package com.githab.cs.model.ProductOffering;

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
    private OffsetDateTime lastTime;// перенести в репозиторий
    private ArrayList<String> category;
    private ArrayList <ProductOfferingPrice> productOfferingPrice;

    public void setName(String name) {
		this.name = name;
		// this.lastTime;
	}

	public void setDescription(String description) {
		this.description = description;
		// this.lastTime;
	}

	public void setCategory(ArrayList<String> category) {
		this.category = category;
		// this.lastTime;
	}

	public void setProductOfferingPrice(ArrayList<ProductOfferingPrice> productOfferingPrice) {
		this.productOfferingPrice = productOfferingPrice;
		// this.lastTime;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public OffsetDateTime getLastTime() {
		return lastTime;
	}

	public ArrayList<String> getCategory() {
		return category;
	}

	public ArrayList<ProductOfferingPrice> getProductOfferingPrice() {
		return productOfferingPrice;
	}
}
