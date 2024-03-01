package com.fsoft.internet.entities;

import java.time.LocalDate;
import java.time.LocalTime;


public class RecordId {

	/**
	 * @author DuyNT58
	 * @TODO
	 * @UPDATE_DATE Mar 1, 2024
	 */
	
	  private String customerId;

	  private String computerId;

	  private LocalDate startingDate;

	  private LocalTime startingHour;

	  public RecordId() {
	  }

	  public RecordId(String customerId, String computerId, LocalDate startingDate,
	      LocalTime startingHour) {
	    super();
	    this.customerId = customerId;
	    this.computerId = computerId;
	    this.startingDate = startingDate;
	    this.startingHour = startingHour;
	  }

	  public String getCustomerId() {
	    return customerId;
	  }

	  public void setCustomerId(String customerId) {
	    this.customerId = customerId;
	  }

	  public String getComputerId() {
	    return computerId;
	  }

	  public void setComputerId(String computerId) {
	    this.computerId = computerId;
	  }

	  public LocalDate getStartingDate() {
	    return startingDate;
	  }

	  public void setStartingDate(LocalDate startingDate) {
	    this.startingDate = startingDate;
	  }

	  public LocalTime getStartingHour() {
	    return startingHour;
	  }

	  public void setStartingHour(LocalTime startingHour) {
	    this.startingHour = startingHour;
	  }

	  @Override
	  public String toString() {
	    return "RecordId [customerId=" + customerId + ", computerId=" + computerId
	        + ", startingDate=" + startingDate + ", startingHour=" + startingHour
	        + "]";
	  }
}
