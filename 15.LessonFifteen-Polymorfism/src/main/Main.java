package main;

import java.util.ArrayList;

import models.Animal;
import models.Cat;
import models.Dog;

public class Main {
	public static void main(String[] args) {
		ArrayList<Animal> animalCollection = new ArrayList<Animal>();
		animalCollection.add(new Cat("Timmy",20));
		animalCollection.add(new Dog("Bob", "Wendy"));
		
		for (Animal animal : animalCollection) {
			System.out.println(animal.getInfo());
		}
	}

	// Function overloading, same method signature, different input parameters
	static void print(String s) {
		System.out.println(s);
	}

	static void print(int i) {
		System.out.println(i);
	}

	static void print(double d) {
		System.out.println(d);
	}
}
