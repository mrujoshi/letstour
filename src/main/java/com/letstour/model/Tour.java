package com.letstour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tour {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int tourId;
	String tourName;
	@ManyToOne
	Destination boardingFrom;
	@ManyToOne
	Destination headedTo;
	int tourDuration;
	
public int getTourId() {
	return tourId;
}
public void setTourId(int tourId) {
	this.tourId = tourId;
}
public String getTourName() {
	return tourName;
}
public void setTourName(String tourName) {
	this.tourName = tourName;
}
public Destination getBoardingFrom() {
	return boardingFrom;
}
public void setBoardingFrom(Destination boardingFrom) {
	this.boardingFrom = boardingFrom;
}
public Destination getHeadedTo() {
	return headedTo;
}
public void setHeadedTo(Destination headedTo) {
	this.headedTo = headedTo;
}
public int getTourDuration() {
	return tourDuration;
}
public void setTourDuration(int tourDuration) {
	this.tourDuration = tourDuration;
}

}
