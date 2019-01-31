package com.letstour.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letstour.model.Iternary;

@RestController
public class IternaryController {

	@RequestMapping(method=RequestMethod.POST,value="/iternary")
	public void addIternary(@RequestBody Iternary iternary){}

	@RequestMapping(method=RequestMethod.PUT,value="/iternary/{id}")
	public void updateIternary(@RequestBody Iternary iternary){}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/iternary/{id}")
	public void deleteIternary(@PathVariable int id){}
	
	@RequestMapping(method=RequestMethod.GET,value="/iternary/{id}")
	public Iternary findIternary(@PathVariable int id){
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/iternary")
	public List<Iternary> findAllIternary(){
		return null;
	}
}
