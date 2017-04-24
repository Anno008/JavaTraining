package introductionToOopThree;

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
}
