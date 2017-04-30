package view;

import util.StringHelper;
import wrappers.BaseWrapper;

import java.io.IOException;

import IO.*;
import models.*;

public class Main {
	private static BaseWrapper<Publisher> PublisherDAO;
	private static BaseWrapper<Author> AuthorDAO;
	private static BaseWrapper<Book> BookDAO;

	static {
		initialize();
	}

	private static void initialize() {
		try {
			PublisherDAO = new BaseWrapper<>(PublisherIO.readPublishers());
			AuthorDAO = new BaseWrapper<>(AuthorIO.readAuthors());
			BookDAO = new BaseWrapper<>(BookIO.readBooks());
		} catch (Exception e) {
			System.out.println("An error occured while loading the files");
			e.printStackTrace(System.out);
		}
	}

	private static void save() {
		try {
			PublisherIO.savePublishers(PublisherDAO.getAll());
			AuthorIO.saveAuthors(AuthorDAO.getAll());
			BookIO.saveBooks(BookDAO.getAll());
		} catch (IOException e) {
			System.out.println("An error occured while saving the files");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		boolean repeat = true;
		do {
			int option = StringHelper.readInteger(displayTheMenu());
			repeat = makeDecision(option, repeat);
			save();
		} while (repeat);
	}

	private static boolean makeDecision(int option, boolean repeat) {
		switch (option) {
		case 1:
			AuthorDAO.getAll().forEach(a -> System.out.println(a));
			break;
		case 2:
			findAuthor();
			break;
		case 3:
			createAuthor();
			break;
		case 4:
			updateAuthor();
			break;
		case 5:
			deleteAuthor();
			break;
		case 6:
			PublisherDAO.getAll().forEach(p -> System.out.println(p));
			break;
		case 7:
			findPublisher();
			break;
		case 8:
			createPublisher();
			break;
		case 9:
			updatePublisher();
			break;
		case 10:
			deletePublisher();
			break;
		case 11:
			displayBooks();
			break;
		case 12:
			findBook();
			break;
		case 13:
			createBook();
			break;
		case 14:
			updateBook();
			break;
		case 15:
			deleteBook();
			break;
		case 16:
			return false;
		}

		return true;
	}

	private static void findAuthor() {
		int id = StringHelper.readInteger("Enter the id of the author you are looking for.");
		Author a = AuthorDAO.find(id);
		if (a == null) {
			System.out.println("Publisher with an id of: " + id + " doesn't exist");
			return;
		}
		System.out.println(a);
	}

	private static void createAuthor() {
		String name = StringHelper.readString("Enter the name of the author.");
		String surname = StringHelper.readString("Enter the surname of the author.");

		Author newAuthor = new Author(AuthorDAO.getAll().size() + 1, name, surname);
		AuthorDAO.add(newAuthor);
		System.out.println("Author created\n" + newAuthor);
	}

	private static void updateAuthor() {
		int id = StringHelper.readInteger("Enter the id of the author that you want to update.");
		Author a = AuthorDAO.find(id);

		if (a == null) {
			System.out.println("Author with an id of: " + id + " doesn't exist");
			return;
		}
		String name = StringHelper.readString("Enter the name of the author.");
		String surname = StringHelper.readString("Enter the surname of the author.");
		a.update(name, surname);
		System.out.println("Author updated.\n" + a);
	}

	private static void deleteAuthor() {
		int id = StringHelper.readInteger("Enter the id of the author that you want to delete.");
		Author a = AuthorDAO.find(id);
		if (a == null) {
			System.out.println("Author with an id of: " + id + " doesn't exist");
			return;
		}

		AuthorDAO.delete(a);
		System.out.println("Author deleted.");
	}

	public static void findPublisher() {
		int id = StringHelper.readInteger("Enter the id of the publisher you are looking for.");
		Publisher p = PublisherDAO.find(id);
		if (p == null) {
			System.out.println("Publisher with an id of: " + id + " doesn't exist");
			return;
		}
		System.out.println(p);
	}

	public static void createPublisher() {
		String name = StringHelper.readString("Enter the name of the publisher.");

		Publisher newPublisher = new Publisher(PublisherDAO.getAll().size() + 1, name);
		PublisherDAO.add(newPublisher);
		System.out.println("Publisher created\n" + newPublisher);
	}

	public static void updatePublisher() {
		int id = StringHelper.readInteger("Enter the id of the publisher that you want to update.");
		Publisher p = PublisherDAO.find(id);

		if (p == null) {
			System.out.println("Author with an id of: " + id + " doesn't exist");
			return;
		}
		String name = StringHelper.readString("Enter the name of the publisher.");
		p.update(name);
		System.out.println("Publisher updated.\n" + p);
	}

	public static void deletePublisher() {
		int id = StringHelper.readInteger("Enter the id of the publisher that you want to delete.");
		Publisher p = PublisherDAO.find(id);
		if (p == null) {
			System.out.println("Publisher with an id of: " + id + " doesn't exist");
			return;
		}

		PublisherDAO.delete(p);
		System.out.println("Publisher deleted.");
	}

	private static void findBook() {
		int option = StringHelper.readInteger(findBookOn());
		switch (option) {
		case 1:
			int id = StringHelper.readInteger("Enter the id of the book you are looking for.");
			Book b = BookDAO.find(id);
			if (b == null) {
				System.out.println("Book with an id of: " + id + " doesn't exist");
				return;
			}
			System.out.println(b);
			break;
		case 2:
			String titlePart = StringHelper.readString("Enter the part of the books title.");
			BookDAO.getAll().stream().filter(b1 -> b1.getTitle().contains(titlePart))
					.forEach(bo -> System.out.println(bo));
			break;
		case 3:
			String name = StringHelper.readString("Enter a part of the authors name or surname.");
			BookDAO.getAll().stream()
					.filter(b1 -> b1.getAuthor().getName().contains(name) || b1.getAuthor().getSurname().contains(name))
					.forEach(bo -> System.out.println(bo));
			break;
		case 4:
			String publisher = StringHelper.readString("Enter a part of the authors name or surname.");
			BookDAO.getAll().stream().filter(b1 -> b1.getPublisher().getName().contains(publisher))
					.forEach(bo -> System.out.println(bo));
			break;
		case 5:
			double min = StringHelper.readDouble("Enter the min price");
			double max = StringHelper.readDouble("Enter the max price");
			System.out.println("Book that cost in between: " + min + " to " + max + " are:\n");
			BookDAO.getAll().stream().filter(b1 -> b1.getPrice() > min && b1.getPrice() < max)
					.forEach(bo -> System.out.println(bo));
			break;
		default:
			break;
		}
	}

	private static void createBook() {
		String title = StringHelper.readString("Enter the title of the book.");
		int releaseYear = StringHelper.readInteger("Enter the release year of the book.");
		double price = StringHelper.readDouble("Enter the price of the book.");

		int authorId = StringHelper.readInteger("Enter the id of the author that wrote this book.");
		Author a = AuthorDAO.find(authorId);

		if (a == null) {
			System.out.println("Author with an id of: " + authorId + " doesn't exist");
			return;
		}

		int publisherId = StringHelper.readInteger("Enter the id of the publisher that publisher this book.");
		Publisher p = PublisherDAO.find(publisherId);

		if (p == null) {
			System.out.println("Publisher with an id of: " + publisherId + " doesn't exist");
			return;
		}
		Book b = new Book(BookDAO.getAll().size() + 1, title, releaseYear, price, a, p);
		BookDAO.add(b);
		System.out.println("Book added.\n" + b);
	}

	private static void updateBook() {
		int bookId = StringHelper.readInteger("Enter the id of the book you want to update.");
		Book b = BookDAO.find(bookId);

		if (b == null) {
			System.out.println("A book with an id of: " + bookId + " doesn't exist.");
			return;
		}

		String title = StringHelper.readString("Enter the title of the book.");
		int releaseYear = StringHelper.readInteger("Enter the release year of the book.");
		double price = StringHelper.readDouble("Enter the price of the book.");

		b.update(title, releaseYear, price);
		System.out.println("Book updated.\n" + b);
	}

	private static void deleteBook() {
		int bookId = StringHelper.readInteger("Enter the id of the book you want to delete.");
		Book b = BookDAO.find(bookId);

		if (b == null) {
			System.out.println("A book with an id of: " + bookId + " doesn't exist.");
			return;
		}

		BookDAO.delete(b);
		System.out.println("Book deleted.");
	}

	private static void displayBooks() {
		int sortOption = StringHelper.readInteger(bookOrderingOptions());
		switch (sortOption) {
		case 1:
			BookDAO.getAll().stream().sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).forEach(b -> System.out.println(b));
			break;
		case 2:
			BookDAO.getAll().stream().sorted((p1, p2) -> Integer.compare(p1.getReleaseYear(), p2.getReleaseYear())).forEach(b -> System.out.println(b));
			break;
		default:
			BookDAO.getAll().forEach(b -> System.out.println(b));
			break;
		}
	}

	private static String bookOrderingOptions() {
		System.out.println(StringHelper.createString('=', 100));
		String output = "";
		output += "1. Sort by price\n";
		output += "2. Sort by release year\n";
		return output;
	}

	private static String findBookOn() {
		System.out.println(StringHelper.createString('=', 100));
		String output = "";
		output += "1. Base on the books id\n";
		output += "2. Part of the title\n";
		output += "3. Part of the authors name or surname\n";
		output += "4. Part of the publishers name\n";
		output += "5. Display all books in between a certain price range\n";
		return output;
	}

	private static String displayTheMenu() {
		System.out.println(StringHelper.createString('=', 100));
		String output = "";
		output += "1. Display authors\n";
		output += "2. Find an author\n";
		output += "3. Create an author\n";
		output += "4. Update an author\n";
		output += "5. Delete an author\n\n";

		output += "6. Display publishers\n";
		output += "7. Find a publisher\n";
		output += "8. Create a publisher\n";
		output += "9. Update a publisher\n";
		output += "10. Delete a publisher\n\n";

		output += "11. Display books\n";
		output += "12. Find a book\n";
		output += "13. Create a book\n";
		output += "14. Update a book\n";
		output += "15. Delete a book\n\n";
		output += "16. Exit";
		return output;
	}
}
