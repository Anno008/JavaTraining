package models;

public class Dog extends Animal {

	private String owner;

	public Dog(String name, String owner) {
		super(name);
		this.owner = owner;
	}

	public String getInfo() {
		return "Dog class, name: " + this.name + " owner: " + owner;
	}
}
