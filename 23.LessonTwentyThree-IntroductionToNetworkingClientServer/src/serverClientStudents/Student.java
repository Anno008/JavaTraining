package serverClientStudents;

public class Student {
	private int id;
	private String name;
	private String surname;

	public Student(int id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void updateStudent(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", Name: " + name + ", Surname: " + surname;
	}
}
