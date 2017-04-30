package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import models.*;

public class AuthorIO {
	private static String path = "src/IO/authors.txt";

	private static Author string2Author(String row) throws IOException {
		String[] s = row.split(",");
		return new Author(Integer.parseInt(s[0]), s[1], s[2]);
	}

	private static String author2String(Author a) {
		return a.getId() + "," + a.getName() + "," + a.getSurname();
	}

	public static List<Author> readAuthors() throws IOException {
		BufferedReader inputStream = null;
		List<Author> authors = null;

		File file = new File(path);
		if (!file.exists())
			return new ArrayList<Author>();

		try {
			inputStream = new BufferedReader(new FileReader(path));
			authors = new ArrayList<Author>();
			String l;
			while ((l = inputStream.readLine()) != null) {
				authors.add(string2Author(l));
			}
			return authors;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	public static void saveAuthors(List<Author> authors) throws IOException {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path));
			for (Author student : authors)
				outputStream.println(author2String(student));
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}
}
