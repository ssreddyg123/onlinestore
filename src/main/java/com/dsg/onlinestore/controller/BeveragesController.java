package com.dsg.onlinestore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dsg.onlinestore.model.Beverage;
import com.dsg.onlinestore.model.Bottle;
import com.dsg.onlinestore.model.Crate;
import com.dsg.onlinestore.repository.BeverageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/beverages")
public class BeveragesController {

	private final BeverageRepository beverageRepository;

	@Autowired
	public BeveragesController(BeverageRepository beverageRepository) {
		this.beverageRepository = beverageRepository;
	}

	@GetMapping
	public String getAllBeverages(Model model, @RequestParam(defaultValue = "0") int page) {
		log.info("Client requested all beverages");
		try {
		Page<Beverage> pagedBeverages = this.beverageRepository.findAll(PageRequest.of(page, 10));
		List<Beverage> beverages = pagedBeverages.getContent();
		List<Crate> crates = new ArrayList<>();
		List<Bottle> bottles = new ArrayList<>();
		beverages.stream().forEach(beverage ->{
			crates.addAll(beverage.getCrates());
			bottles.addAll(beverage.getBottles());
		});
		model.addAttribute("crates", crates);
		model.addAttribute("bottles", bottles);
		model.addAttribute("currentPage", page);
		//model.addAttribute("noOfPages", pagedBeverages.getTotalPages());
		model.addAttribute("beverage", new Beverage());
		} catch(Exception th) {
			log.error("Exception occured ..... ", th);
		}
		return "beverages";
	}

}
