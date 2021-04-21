package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Greeting;
import com.model.User;
public interface IGreetingService {

	Greeting addGreeting(User user);

	Optional<Greeting> getGreetingById(long id);

	List<Greeting> getAllGreetings();

	Optional<Greeting> editGreetingById(long id, String name);

	String deleteGreeting(long id);

}
