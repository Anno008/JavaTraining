package introductionToOopPartTwo;

public class Subject {
	private int id;
	private String name;
	private int espb;
	
	private static int counter = 1;

	public Subject(SubjectsEnum name) {
		this.name = name.toString();
		espb = setEspbForSubject(name);
		id = counter++;
	}

	public Subject(String name, int espb) {
		this.name = name;
		this.espb = espb;
		id = counter ++;
	}

	private int setEspbForSubject(SubjectsEnum name) {
		switch (name) {
		case Math:
			return 10;
		case Art:
			return 9;
		case Economics:
			return 12;
		case Finance:
			return 7;
		case History:
			return 15;
		case Management:
			return 5;
		case Physics:
			return 18;
		case Programming:
			return 8;
		default:
			return 0;
		}
	}
	
	public void printInformation(){
		System.out.println("Id: " + id + " Subject: " + name + " carries: " + espb + " ESPB points.");
	}
	public int getId(){
		return id;
	}
	public String getName() {
		return name;
	}
	public int getEspb(){
		return espb;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setEspb(int espb){
		this.espb = espb;
	}
}
