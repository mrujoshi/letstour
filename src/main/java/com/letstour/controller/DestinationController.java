package com.letstour.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letstour.model.Destination;

@RestController
public class DestinationController {
	@RequestMapping(method=RequestMethod.POST,value="/destination")
	public ResponseEntity<Destination> addDestination(@RequestBody Destination destination){
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/destination/{id}")
	public ResponseEntity<Destination> updateDestination(@RequestBody Destination destination){
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/destination/{id}")
	public ResponseEntity<Destination> deleteDestination(@PathVariable int id){
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/destination/{id}")
	public ResponseEntity<Destination> findDestination(@PathVariable int id){
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/destination")
	public ResponseEntity<List<Destination>> findAllDestination(){
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
}
