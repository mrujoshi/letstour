package com.letstour.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letstour.model.Tour;

@RestController
public class TourController {
	@RequestMapping(method=RequestMethod.POST,value="/tour")
	public ResponseEntity<Tour> addTour(){return null;}

	@RequestMapping(method=RequestMethod.PUT,value="/tour/{id}")
	public void updateTour(){}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/tour/{id}")
	public void deleteTour(){}
	
	@RequestMapping(method=RequestMethod.GET,value="/tour/{id}")
	public Tour findTour(@PathVariable int id, @RequestParam(value="count",defaultValue="5") int count,@RequestParam(value="page",defaultValue="0") int page){
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/tour")
	public List<Tour> findAllTour(){
		return null;
	}
}
