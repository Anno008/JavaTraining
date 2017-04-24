package models;

public class Teacher extends Person {
	private Subject subject;
	
	public Teacher(String firstName, String lastName, Subject subject) {
		super(firstName, lastName);
		this.subject = subject;
	}

}
