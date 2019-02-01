package com.letstour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Iternary {

	@Id
	@GeneratedValue
	int id;
	int tourId;
	String details;
	
	public int getId() {
		return id;
	}
	
public void setId(int id) {
	this.id = id;
}
public int getTourId() {
	return tourId;
}
public void setTourId(int tourId) {
	this.tourId = tourId;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}

}
