package models;

import base.Person;

public class Teacher extends Person {
	public Teacher(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}
	
	public void printInfo() {
		System.out.println("Id: " + getId() + ", teacher: " + getFullName());
	}
}

