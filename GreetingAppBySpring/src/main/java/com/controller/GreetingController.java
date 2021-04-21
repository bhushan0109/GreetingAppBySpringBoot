package com.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Greeting;

@RestController
public class GreetingController {

	private AtomicLong counter = new AtomicLong();
	private String template = "Hello, %s!";

	// curl localhost:8080/greeting -w "\n
	@GetMapping("/greeting")
	public Greeting greeting() {
		return new Greeting(counter.incrementAndGet(), String.format(template, " "));
	}

	// curl localhost:8080/param/greeting -w "\n
	@GetMapping("/param/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	// curl -X POST -H "Content-Type: application/json" -d
	// '{"id":3,"greeting":"Hello post!"}' "http://localhost:8080/post/greeting" -w
	// "\n"{"id":3,"greeting":"Hello post!"}
	@PostMapping("/post/greeting")
	public Greeting greeting(@RequestBody Greeting greeting) {
		return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getGreeting()));
	}
	//localhost:8080/update?name=bhushan
	@PutMapping("/update")
	public Greeting putGreeting(@RequestParam(value = "name") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}