package introductionToOOP;

public class Student {
	private String name;
	private String surname;
	private int index;
	
	public Student(String name, String surname, int index){
		this.name = name;
		this.surname = surname;
		this.index = index;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}


	public void printInformation() {
		System.out.println("Name: " + name + ", Surname: " + surname + ", Index: " + index);
	}
}
