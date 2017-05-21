package models;

public abstract class Animal {
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getInfo() {
		return "Base class, Animal " + name;
	}
}
