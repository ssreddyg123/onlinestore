package com.dsg.onlinestore.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/basket")
public class BasketController {

	@GetMapping
	public String getBasket(Model model, @RequestParam(defaultValue = "0") int page) {
		log.info("Client requested basket");
		//Page<Movie> pagedMovies = this.movieRepository.findAll(PageRequest.of(page, 10));

		//model.addAttribute("movies", pagedMovies.getContent());
		model.addAttribute("currentPage", page);
	//	model.addAttribute("noOfPages", pagedMovies.getTotalPages());
		//model.addAttribute("movie", new Movie());
		return "movies";
	}

}
