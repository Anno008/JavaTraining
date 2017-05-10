package models;

public class Student {
	public String id;
	public String name;
	public String surname;

	public Student(String id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Name: " + name + ", Surname: " + surname;
	}
}
