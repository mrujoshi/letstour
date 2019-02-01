package com.letstour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Destination {
	
@Id
@GeneratedValue
int destinationId;
String name;
public int getId() {
	return destinationId;
}
public void setId(int id) {
	destinationId = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
