package models;

public class Subject {
	private int id;
	private String name;
	private int espb;
	private Teacher teacher;

	public Subject(int id, String name, int espb, Teacher teacher) {
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public int getId() {
		return id;
	}

	public String getInfo() {
		return "Id: " + getId() + " Subject: " + name + " carries: " + espb + " espb points, held by teacher: " + teacher.getFullName();
	}
}
