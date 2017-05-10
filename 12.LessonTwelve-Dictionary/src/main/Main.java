package main;

import dictionary.Dictionary;
import dictionary.KeyValuePair;
import models.Student;

public class Main {
	public static void main(String[] args) {
		Dictionary<String, Student> dict = new Dictionary<String, Student>();
		
		Student st1 = new Student("1243", "Jhon", "Something");
		Student st2 = new Student("2", "Megan", "New");
		Student st3 = new Student("3", "Amazing", "Moon");
		Student st4 = new Student("4", "Twilight", "Jack");

		dict.add(new KeyValuePair<String, Student>(st1.id, st1));
		dict.add(new KeyValuePair<String, Student>(st2.id, st2));
		dict.add(new KeyValuePair<String, Student>(st3.id, st3));
		dict.add(new KeyValuePair<String, Student>(st4.id, st4));
		
		dict.delete(st1.id);
		
		System.out.println("Item that I want" + dict.get("2"));
		
		for (int i = 0; i < 50; i++) {
			Student s = new Student(Integer.toString(i),"new","New");
			dict.add(new KeyValuePair<String, Student>(s.id, s));
		}
		
		System.out.println("All pairs");
		for (KeyValuePair<?, ?> pair : dict.getAllPairs()) 
			System.out.println(pair.value);
		
		System.out.println("All keys");
		for (KeyValuePair<?, ?> pair : dict.getAllPairs()) 
			System.out.println(pair.key);		
	}
}
