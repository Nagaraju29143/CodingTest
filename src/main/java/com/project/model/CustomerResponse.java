package com.project.model;

public class CustomerResponse {
	
	private int custId;
	private String firstName;
	private String lastName;
	private double avgRating;
	
	public CustomerResponse(int custId, String firstName, String lastName, double avgRating) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avgRating = avgRating;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	
	

}
