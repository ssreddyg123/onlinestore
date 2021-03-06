package com.dsg.onlinestore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dsg.onlinestore.model.Beverage;
import com.dsg.onlinestore.model.Bottle;
import com.dsg.onlinestore.model.Crate;
import com.dsg.onlinestore.service.BeverageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/beverages")
public class BeveragesController {
	
	@Autowired
	private HttpSession userSession;

	private final BeverageService beverageService;

	@Autowired
	public BeveragesController(BeverageService beverageService) {
		this.beverageService = beverageService;
	}

	@GetMapping
	public String getAllBeverages(Model model, @RequestParam(defaultValue = "0") int page) {
		try {
			String username = (String) userSession.getAttribute("username");
			log.info("Client requested all beverages {} ", username);
			Page<Beverage> pagedBeverages = this.beverageService.getBeverages(page);
			List<Beverage> beverages = pagedBeverages.getContent();
			List<Crate> crates = new ArrayList<>();
			List<Bottle> bottles = new ArrayList<>();
			beverages.stream().forEach(beverage -> {
				crates.addAll(beverage.getCrates());
				bottles.addAll(beverage.getBottles());
			});
			model.addAttribute("crates", crates);
			model.addAttribute("bottles", bottles);
			model.addAttribute("currentPage", page);
			// model.addAttribute("noOfPages", pagedBeverages.getTotalPages());
			model.addAttribute("beverage", new Beverage());
		} catch (Exception th) {
			log.error("Exception occured ..... ", th);
		}
		return "beverages";
	}

}
