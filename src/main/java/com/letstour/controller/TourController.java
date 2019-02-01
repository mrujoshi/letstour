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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.letstour.model.Tour;
import com.letstour.service.TourService;

@RestController
public class TourController {
	
	@Autowired
	TourService tourService;
	
	@RequestMapping(method=RequestMethod.POST,value="/tour")
	public ResponseEntity<Tour> addTour(@RequestBody Tour tour){
		return new ResponseEntity<Tour>(tourService.addTour(tour),HttpStatus.OK);
		}

	@RequestMapping(method=RequestMethod.PUT,value="/tour/{id}")
	public ResponseEntity<Tour> updateTour(@RequestBody Tour tour){
		return new ResponseEntity<>(tourService.updateTour(tour),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/tour/{id}")
	public ResponseEntity<Tour> deleteTour(@PathVariable int id){
		return new ResponseEntity<>(tourService.deleteTour(id),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/tour/{id}")
	public ResponseEntity<Tour> findTour(@PathVariable int id, @RequestParam(value="count",defaultValue="5") int count,@RequestParam(value="page",defaultValue="0") int page){
		return new ResponseEntity<>(tourService.findTour(id),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/tour")
	public ResponseEntity<List<Tour>> findAllTour(){
		return new ResponseEntity<>(tourService.findAllTour(),HttpStatus.OK);
	}
}
