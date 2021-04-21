package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	User user = new User();

	// http://localhost:8080/greeting/home
	@GetMapping(value = { "/home" })
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		user.setFirstName(name);
		return iGreetingService.addGreeting(user);
	}

	// http://localhost:8080/greeting/post
	@PostMapping("/post")
	public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		user.setFirstName(name);
		return iGreetingService.addGreeting(user);
	}

	// http://localhost:8080/greeting/2
	@GetMapping("/getGreeting/{id}")
	public Optional<Greeting> getGreetingById(@PathVariable(value = "id") long id) {
		return iGreetingService.getGreetingById(id);
	}

	// http://localhost:8080/greeting/getAllGreetings
	@GetMapping("/getAllGreetings")
	public List<Greeting> getAllGreeting() {
		return iGreetingService.getAllGreetings();
	}
	// http://localhost:8080/greeting//editGreeting/3

	@PutMapping("/editGreeting/{id}")
	public Optional<Greeting> editGreetingById(@PathVariable("id") long id, @RequestParam(value = "name") String name) {
		return iGreetingService.editGreetingById(id, name);
	}

	// http://localhost:8080/greeting//editGreeting/4?name=bhushan
	@DeleteMapping("/deleteGreeting/{id}")
	public String deletePerson(@PathVariable("id") long id) {
		iGreetingService.deleteGreeting(id);
		return "Greeting Deleted Successfully";
	}

}