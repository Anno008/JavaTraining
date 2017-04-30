package models;

public class Author extends BaseModel {
	private String name;
	private String surname;

	public Author(int id, String name, String surname) {
		super(id);
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public void update(BaseModel up) {
		Author other = (Author)up;
		update(other);
		this.name = other.name;
		this.surname = other.surname;
	}

	public void update(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Id: " + getId() + ", " + name + " " + surname;
	}

	public String getFullName() {
		return name + " " + surname;
	}
}
