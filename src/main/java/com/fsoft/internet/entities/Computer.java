package com.fsoft.internet.entities;

import java.util.Set;

public class Computer {

	/**
	 * @author DuyNT58
	 * @TODO
	 * @UPDATE_DATE Mar 1, 2024
	 */
	

	  private String computerId;

	  private String location;

	  private String status;

	  private Integer deleteStatus;

	  Set<Records> records;

	  public Computer() {
	  }

	  public Computer(String computerId, String location, String status,
	      Integer deleteStatus) {
	    this.computerId = computerId;
	    this.location = location;
	    this.status = status;
	    this.deleteStatus = deleteStatus;
	  }

	  public String getComputerId() {
	    return computerId;
	  }

	  public void setComputerId(String computerId) {
	    this.computerId = computerId;
	  }

	  public String getLocation() {
	    return location;
	  }

	  public void setLocation(String location) {
	    this.location = location;
	  }

	  public String getStatus() {
	    return status;
	  }

	  public void setStatus(String status) {
	    this.status = status;
	  }

	  public Integer getDeleteStatus() {
	    return deleteStatus;
	  }

	  public void setDeleteStatus(Integer deleteStatus) {
	    this.deleteStatus = deleteStatus;
	  }

	  public Set<Records> getRecords() {
	    return records;
	  }

	  public void setRecords(Set<Records> records) {
	    this.records = records;
	  }

	  @Override
	  public String toString() {
	    return "Computer [computerId=" + computerId + ", location=" + location
	        + ", status=" + status + ", deleteStatus=" + deleteStatus + "]";
	  }
}
