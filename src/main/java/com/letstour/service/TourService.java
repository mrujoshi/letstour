package com.letstour.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.letstour.model.Tour;
import com.letstour.repository.TourRepository;

@Service
public class TourService {
	@Autowired
	TourRepository tourRepository;
	
	public Tour addTour(Tour tour){
		return tourRepository.save(tour);
	}
	
	public Tour updateTour(Tour tour){
		return tourRepository.save(tour);
	}
	
	public Tour deleteTour(int id){
		Tour tour = tourRepository.findById(id).get();
		tourRepository.delete(tour);
		return tour;
	}
	
	public Tour findTour(int id){
		return tourRepository.findById(id).get();
	}
	
	public List<Tour> findAllTour(){
		List<Tour> tourList = new ArrayList<>();
		tourRepository.findAll().forEach(t -> tourList.add(t));
		return tourList;
	}
}
