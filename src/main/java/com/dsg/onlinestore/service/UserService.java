package com.dsg.onlinestore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsg.onlinestore.model.Order;
import com.dsg.onlinestore.model.User;
import com.dsg.onlinestore.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public boolean authenticate(String username, String password) {
		Optional<User> user = userRepository.findById(username);
		if (password.equals(user.get().getPassword())) {
			return true;
		}
		return false;
	}

	public List<Order> getUserOrders(String username) {
		Optional<User> user = userRepository.findById(username);
		List<Order> orders = new ArrayList<>();
		if (user.isPresent()) {
			orders.addAll(user.get().getOrders());
		}
		return orders;
	}

}
