package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import models.Author;
import models.Book;
import models.Publisher;
import wrappers.BaseWrapper;

public class BookIO {
	private static String path = "src/IO/books.txt";

	private static Book string2Book(String row) throws IOException {
		String[] s = row.split(",");
		Author a = new BaseWrapper<Author>(AuthorIO.readAuthors()).find(Integer.parseInt(s[4]));
		Publisher p = new BaseWrapper<Publisher>(PublisherIO.readPublishers()).find(Integer.parseInt(s[5]));
		return new Book(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), Double.parseDouble(s[3]), a, p);
	}

	private static String book2String(Book b) {
		return b.getId() + "," + b.getTitle() + "," + b.getReleaseYear() + "," + b.getPrice() + "," + b.getAuthor().getId() + "," + b.getPublisher().getId();
	}

	public static List<Book> readBooks() throws IOException {
		BufferedReader inputStream = null;
		List<Book> books = null;

		File file = new File(path);
		if (!file.exists())
			return new ArrayList<Book>();

		try {
			inputStream = new BufferedReader(new FileReader(path));
			books = new ArrayList<Book>();
			String l;
			while ((l = inputStream.readLine()) != null) {
				books.add(string2Book(l));
			}
			return books;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	public static void saveBooks(List<Book> books) throws IOException {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path));
			for (Book b : books)
				outputStream.println(book2String(b));
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}
}
