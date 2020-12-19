package com.dsg.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dsg.onlinestore.model.Beverage;
import com.dsg.onlinestore.repository.BeverageRepository;

@Service
public class BeverageService {
	
	private final BeverageRepository beverageRepository;

	@Autowired
	public BeverageService(BeverageRepository beverageRepository) {
		this.beverageRepository = beverageRepository;
	}
	
	public Page<Beverage> getBeverages(int page) {
		return this.beverageRepository.findAll(PageRequest.of(page, 10));
	}

}
