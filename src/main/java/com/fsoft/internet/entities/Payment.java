package com.fsoft.internet.entities;

public class Payment {

	/**
	 * @author DuyNT58
	 * @TODO
	 * @UPDATE_DATE Mar 1, 2024
	 */
	
	  private PaymentId paymentId;

	  private Product product;

	  private Customer customer;

	  private Integer amount;

	  public Payment() {
	  }

	  public Payment(PaymentId paymentId, Product product, Customer customer,
	      Integer amount) {
	    this.paymentId = paymentId;
	    this.product = product;
	    this.customer = customer;
	    this.amount = amount;
	  }

	  public PaymentId getPaymentId() {
	    return paymentId;
	  }

	  public void setPaymentId(PaymentId paymentId) {
	    this.paymentId = paymentId;
	  }

	  public Product getProduct() {
	    return product;
	  }

	  public void setProduct(Product product) {
	    this.product = product;
	  }

	  public Customer getCustomer() {
	    return customer;
	  }

	  public void setCustomer(Customer customer) {
	    this.customer = customer;
	  }

	  public Integer getAmount() {
	    return amount;
	  }

	  public void setAmount(Integer amount) {
	    this.amount = amount;
	  }

	  @Override
	  public String toString() {
	    return "Payment [paymentId=" + paymentId + ", product=" + product
	        + ", customer=" + customer + ", amount=" + amount + "]";
	  }
}
