package com.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Greeting;
import com.model.User;
import com.service.IGreetingService;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private IGreetingService greetingService;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "bhushan") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/greeting/{name}")
	public Greeting greetingNew(@PathVariable(value = "name") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	//http://localhost:8080/message
	@GetMapping("/message")
	public String message() {
		return greetingService.greet();
	}
	//http://localhost:8080/fullName
	@PostMapping("/fullName")
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getFirstName() + " " + user.getLastName() + " !";
	}
}