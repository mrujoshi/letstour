package com.letstour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.letstour.model.Tour;
import com.letstour.repository.TourRepository;

public class TourService {
	@Autowired
	TourRepository tourRepository;
	
	public void addTour(Tour tour){}
	public void updateTour(Tour tour){}
	public void deleteTour(int id){}
	public Tour findTour(int id){
		return null;
	}
	public List<Tour> findAllTour(){
		return null;
	}
}
