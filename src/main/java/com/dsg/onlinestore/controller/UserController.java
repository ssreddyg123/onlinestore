package com.dsg.onlinestore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dsg.onlinestore.model.User;
import com.dsg.onlinestore.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/login")
public class UserController {
	
	@Autowired
	private HttpSession userSession;

	@Autowired
	private UserService userService;

	@GetMapping
	public String getLogin(Model model) {
		log.info("Client requested all beverages");
		try {
			model.addAttribute("user", new User());
		} catch (Exception th) {
			log.error("Exception occured ..... ", th);
		}
		return "login";
	}


	@RequestMapping(value="/user", method = RequestMethod.POST)
	public String loginUser(User user) {
	    /*if(bindingResult.hasErrors()) {
	        userSession.setAttribute("blogLogin", false);
	        System.out.println("Wrong Input!!");
	        return "users/login";
	    }*/

	    if(!userService.authenticate(user.getUsername(), user.getPassword())) {
	        userSession.setAttribute("blogLogin", false);
	        System.out.println("login failed!!");
	        return "login";
	    }
	    userSession.setAttribute("login", true);
	    userSession.setAttribute("username", user.getUsername());
	    System.out.println("Login succesfully.");
	    return "redirect:/beverages";
	}

}
