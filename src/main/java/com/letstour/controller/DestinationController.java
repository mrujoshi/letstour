package com.letstour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letstour.model.Destination;
import com.letstour.service.DestinationService;

@RestController
public class DestinationController {
	@Autowired
	DestinationService destinationService;
	
	@RequestMapping(method=RequestMethod.POST,value="/destination")
	public ResponseEntity<Destination> addDestination(@RequestBody Destination destination){
		return new ResponseEntity<Destination>(destinationService.addDestination(destination),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/destination/{id}")
	public ResponseEntity<Destination> updateDestination(@RequestBody Destination destination){
		return new ResponseEntity<Destination>(destinationService.updateDestination(destination),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/destination/{id}")
	public ResponseEntity<Destination> deleteDestination(@PathVariable int id){
		return new ResponseEntity<>(destinationService.deleteDestination(id),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/destination/{id}")
	public ResponseEntity<Destination> findDestination(@PathVariable int id){
		return new ResponseEntity<>(destinationService.findDestination(id),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/destination")
	public ResponseEntity<List<Destination>> findAllDestination(){
		return new ResponseEntity<>(destinationService.findAllDestination(),HttpStatus.OK);
	}
}
