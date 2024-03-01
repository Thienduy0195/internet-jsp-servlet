package com.fsoft.internet.entities;

import java.util.Set;

public class Product {

	/**
	 * @author DuyNT58
	 * @TODO
	 * @UPDATE_DATE Mar 1, 2024
	 */
	
	  private String productId;

	  private String productName;

	  private String unit;

	  private Double price;

	  private String image;

	  private Integer deleteStatus;

	  Set<Payment> payments;

	  public Product() {
	  }

	  public Product(String productId, String productName, String unit,
	      Double price, String image, Integer deleteStatus) {
	    this.productId = productId;
	    this.productName = productName;
	    this.unit = unit;
	    this.price = price;
	    this.image = image;
	    this.deleteStatus = deleteStatus;
	  }

	  public String getProductId() {
	    return productId;
	  }

	  public void setProductId(String productId) {
	    this.productId = productId;
	  }

	  public String getProductName() {
	    return productName;
	  }

	  public void setProductName(String productName) {
	    this.productName = productName;
	  }

	  public String getUnit() {
	    return unit;
	  }

	  public void setUnit(String unit) {
	    this.unit = unit;
	  }

	  public Double getPrice() {
	    return price;
	  }

	  public void setPrice(Double price) {
	    this.price = price;
	  }

	  public String getImage() {
	    return image;
	  }

	  public void setImage(String image) {
	    this.image = image;
	  }

	  public Integer getDeleteStatus() {
	    return deleteStatus;
	  }

	  public void setDeleteStatus(Integer deleteStatus) {
	    this.deleteStatus = deleteStatus;
	  }

	  public Set<Payment> getPayments() {
	    return payments;
	  }

	  public void setPayments(Set<Payment> payments) {
	    this.payments = payments;
	  }

	  @Override
	  public String toString() {
	    return "Product [productId=" + productId + ", productName=" + productName
	        + ", unit=" + unit + ", price=" + price + "]";
	  }
}
