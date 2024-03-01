package com.fsoft.internet.entities;

public class Records {

	/**
	 * @author DuyNT58
	 * @TODO
	 * @UPDATE_DATE Mar 1, 2024
	 */
	
	  private RecordId recordId;

	  private Computer computer;

	  private Customer customer;

	  private Integer usingTime;

	  public Records() {
	  }

	  public Records(RecordId recordId, Computer computer, Customer customer,
	      Integer usingTime) {
	    this.recordId = recordId;
	    this.computer = computer;
	    this.customer = customer;
	    this.usingTime = usingTime;
	  }

	  public RecordId getRecordId() {
	    return recordId;
	  }

	  public void setRecordId(RecordId recordId) {
	    this.recordId = recordId;
	  }

	  public Computer getComputer() {
	    return computer;
	  }

	  public void setComputer(Computer computer) {
	    this.computer = computer;
	  }

	  public Customer getCustomer() {
	    return customer;
	  }

	  public void setCustomer(Customer customer) {
	    this.customer = customer;
	  }

	  public Integer getUsingTime() {
	    return usingTime;
	  }

	  public void setUsingTime(Integer usingTime) {
	    this.usingTime = usingTime;
	  }

	  @Override
	  public String toString() {
	    return "Record [recordId=" + recordId + ", computer=" + computer
	        + ", customer=" + customer + ", usingTime=" + usingTime + "]";
	  }

}
