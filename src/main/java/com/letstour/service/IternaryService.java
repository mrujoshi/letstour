package com.letstour.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.letstour.model.Iternary;
import com.letstour.repository.IternaryRepository;

@Service
public class IternaryService {
	@Autowired
	IternaryRepository iternaryRepository;
	
	public Iternary addIternary(Iternary iternary){
		return iternaryRepository.save(iternary);
	}
	
	public Iternary updateIternary(Iternary iternary){
		return iternaryRepository.save(iternary);
	}
	
	public Iternary deleteIternary(int id){
		Iternary iternary = iternaryRepository.findById(id).get();
		iternaryRepository.delete(iternary);
		return iternary;
	}
	
	public Iternary findIternary(int id){
		return iternaryRepository.findById(id).get();
	}
	
	public List<Iternary> findAllIternary(){
		List<Iternary> iternaryList = new ArrayList<>();
		iternaryRepository.findAll().forEach(i -> iternaryList.add(i));
		return iternaryList;
	}
}
