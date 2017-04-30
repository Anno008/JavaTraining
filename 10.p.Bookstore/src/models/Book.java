package models;

public class Book extends BaseModel {
	private String title;
	private int releaseYear;
	private double price;
	private Author author;
	private Publisher publisher;

	public Book(int id, String title, int releaseYear, double price, Author author, Publisher publisher) {
		super(id);
		this.title = title;
		this.releaseYear = releaseYear;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "id: " + getId() + ", Title: " + title + ", released: " + releaseYear + " written by: "
				+ author.getFullName() + " and released by: " + publisher.getName() + " costs: " + price;
	}

	public void update(String title, int releaseYear, double price) {
		this.title = title;
		this.releaseYear = releaseYear;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public double getPrice() {
		return price;
	}

	public Author getAuthor() {
		return author;
	}

	public Publisher getPublisher() {
		return publisher;
	}
}
