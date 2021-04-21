package com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Greeting {
	@Id
	@Column
	private long id;
	@Column
	private String message;

	public Greeting() {
		id = 0;
		message = "";
	}

	public Greeting(long id, String message) {
		this.id = id;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String name) {
		this.message = name;
	}
}