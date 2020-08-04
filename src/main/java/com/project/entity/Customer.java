package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	private int custId;
	private String firstName;
	private String lastName;
	
	@OneToMany(targetEntity = Movie.class, cascade = CascadeType.ALL)
	@JoinColumn(name="cid_fk",referencedColumnName ="custId",nullable=false)
    private List<Movie> movie;
	
	public Customer() {
		
	}

	public Customer(int custId, String firstName, String lastName, List<Movie> movie) {
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.movie = movie;
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

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	
	
}
