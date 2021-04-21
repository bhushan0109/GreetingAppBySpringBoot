package com.model;

public class Greeting {

	private long id;
	private String greeting;

	public Greeting(long id, String greeting) {				              //Constructor
		super();
		this.id = id;
		this.greeting = greeting;
	}

	public long getId() {
		return id;
	}
															               //getter/setter method used to access private variable
	public void setId(long id) {
		this.id = id;
	}

	

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	@Override
	public String toString() {												 //toString method override
		return "Greeting [id=" + id + ", greeting=" + greeting + "]";
	}

}