package com.letstour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.letstour.model.Iternary;
import com.letstour.service.IternaryService;

@RestController
public class IternaryController {

	@Autowired
	IternaryService iternaryService;
	
	@RequestMapping(method=RequestMethod.POST,value="/iternary")
	public ResponseEntity<Iternary> addIternary(@RequestBody Iternary iternary){
		return new ResponseEntity<Iternary>(iternaryService.addIternary(iternary),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/iternary/{id}")
	public ResponseEntity<Iternary> updateIternary(@RequestBody Iternary iternary){
		return new ResponseEntity<>(iternaryService.updateIternary(iternary),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/iternary/{id}")
	public ResponseEntity<Iternary> deleteIternary(@PathVariable int id){
		return new ResponseEntity<>(iternaryService.deleteIternary(id),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/iternary/{id}")
	public ResponseEntity<Iternary> findIternary(@PathVariable int id){
		return new ResponseEntity<>(iternaryService.findIternary(id),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/iternary")
	public ResponseEntity<List<Iternary>> findAllIternary(){
		return new ResponseEntity<>(iternaryService.findAllIternary(),HttpStatus.OK);
	}
}
