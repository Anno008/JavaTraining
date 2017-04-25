package models;

public class Subject {
	private String name;
	private int espb;
	private Teacher teacher;
	
	public Subject(String name, int espb){
		this.name = name;
		this.espb = espb;
	}
	public Subject(String name, int espb, Teacher teacher){
		this(name,espb);
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
}
