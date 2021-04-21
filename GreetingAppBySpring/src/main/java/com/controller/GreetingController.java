package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Greeting;
import com.model.User;
import com.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired
	private IGreetingService iGreetingService;

	@GetMapping(value = { "/home" })
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return iGreetingService.addGreeting(user);
	}

}