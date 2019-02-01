package com.letstour.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.letstour.model.Tour;

public interface TourRepository  extends PagingAndSortingRepository<Tour,Integer> {

}
