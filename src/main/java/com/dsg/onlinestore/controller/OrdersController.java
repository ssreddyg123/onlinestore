package com.dsg.onlinestore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsg.onlinestore.model.Order;
import com.dsg.onlinestore.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

	@Autowired
	private HttpSession userSession;

	@Autowired
	private UserService userService;

	@GetMapping
	public String getUserOrders(Model model) {
		String username = (String) userSession.getAttribute("username");
		log.info("Client requested orders : {} ", username);
		List<Order> orders = this.userService.getUserOrders(username);
		model.addAttribute("orders", orders);
		return "orders";
	}

}
