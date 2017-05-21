package models;

public class Cat extends Animal {

	private int lives;

	public Cat(String name, int lives) {
		super(name);
		this.lives = lives;
	}

	@Override
	public String getInfo() {
		return "Cat class name: " + this.name + " lives: " + lives;
	}
}
