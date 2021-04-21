package com.service;

import java.util.Optional;

import com.model.Greeting;
import com.model.User;

public interface IGreetingService {

	public Greeting addGreeting(User user);

	Optional<Greeting> getGreetingById(long id);
}
