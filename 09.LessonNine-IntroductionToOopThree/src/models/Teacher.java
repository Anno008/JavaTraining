package models;

import base.Person;

public class Teacher extends Person {
	public Teacher(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}
	
	public String getInfo() {
		return "Id: " + getId() + ", teacher: " + getFullName();
	}
}