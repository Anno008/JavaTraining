package models;

public class Subject {
	private int index;
	private String name;
	private int espb;
	private Teacher teacher;

	public Subject(int id, String name, int espb) {
		this.index = id;
		this.name = name;
		this.espb = espb;
	}

	public Subject(int index, String name, int espb, Teacher teacher) {
		this(index, name, espb);
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

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void printInfo() {
		System.out.println(
				"Subject: " + name + " carries: " + espb + " espb points, held by teacher: " + teacher.getFullName());
	}
}
