package com.letstour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.letstour.model.Destination;
import com.letstour.repository.DestinationRepository;

public class DestinationService {

	@Autowired
	DestinationRepository destinationRepository;
	
	public void addDestination(Destination destination){}
	public void updateDestination(Destination destination){}
	public void deleteDestination(int id){}
	public Destination findDestination(int id){
		return null;
	}
	public List<Destination> findAllDestination(){
		return null;
	}
}
