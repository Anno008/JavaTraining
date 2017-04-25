package models;

import base.Person;

public class Teacher extends Person {
	private int id;
	
	public Teacher(String firstName, String lastName, int id) {
		super(firstName, lastName);
		this.id = id;
	}
}

