package presistingDataOnTheFileSystem;

public class Subject {
	private String identifier;
	private String name;
	private int espb;

	public Subject(String identifier, String name, int espb) {
		this.identifier = identifier;
		this.name = name;
		this.espb = espb;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String oznaka) {
		this.identifier = oznaka;
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
	
	public String getInfo() {
		return identifier + " " + name + " " + espb;
	}
}
