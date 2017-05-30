package models;

public class Subject {
	private int id;
	private String name;
	private int espb;

	public Subject(int id, String name, int espb) {
		this.id = id;
		this.name = name;
		this.espb = espb;
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

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Id: " + getId() + " Subject: " + name + " carries: " + espb + " espb points";
	}
}
