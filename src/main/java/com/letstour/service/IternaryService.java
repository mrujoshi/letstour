package com.letstour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.letstour.model.Iternary;
import com.letstour.repository.IternaryRepository;

public class IternaryService {
	@Autowired
	IternaryRepository iternaryRepository;
	
	public void addIternary(Iternary iternary){}
	public void updateIternary(Iternary iternary){}
	public void deleteIternary(int id){}
	public Iternary findIternary(int id){
		return null;
	}
	public List<Iternary> findAllIternary(){
		return null;
	}
}
