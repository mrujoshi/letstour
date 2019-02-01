package com.letstour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.letstour.model.Destination;
import com.letstour.repository.DestinationRepository;

@Service
public class DestinationService {

	@Autowired
	DestinationRepository destinationRepository;
	
	public Destination addDestination(Destination destination){
		return destinationRepository.save(destination);
	}
	
	public Destination updateDestination(Destination destination){
		return destinationRepository.save(destination);
	}
	
	public Destination deleteDestination(int id){
		Destination destination = destinationRepository.findById(id).get();
		destinationRepository.delete(destination);
		return destination;
	}
	
	public Destination findDestination(int id){
		return destinationRepository.findById(id).get();
	}
	
	public List<Destination> findAllDestination(){
		List<Destination> destinationList = new ArrayList<Destination>();
		destinationRepository.findAll().forEach(d -> destinationList.add(d));
		return destinationList;
	}
}
