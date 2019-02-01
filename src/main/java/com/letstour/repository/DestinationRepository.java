package com.letstour.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.letstour.model.Destination;

public interface DestinationRepository extends PagingAndSortingRepository<Destination,Integer>  {
	
}
