package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import models.Publisher;

public class PublisherIO {
	private static String path = "src/IO/publishers.txt";

	private static Publisher string2Publisher(String row) throws IOException {
		String[] s = row.split(",");
		return new Publisher(Integer.parseInt(s[0]), s[1]);
	}

	private static String publisher2String(Publisher p) {
		return p.getId() + "," + p.getName();
	}

	public static List<Publisher> readPublishers() throws IOException {
		BufferedReader inputStream = null;
		List<Publisher> publishers = null;

		File file = new File(path);
		if (!file.exists())
			return new ArrayList<Publisher>();

		try {
			inputStream = new BufferedReader(new FileReader(path));
			publishers = new ArrayList<Publisher>();
			String l;
			while ((l = inputStream.readLine()) != null) {
				publishers.add(string2Publisher(l));
			}
			return publishers;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	public static void savePublishers(List<Publisher> publishers) throws IOException {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path));
			for (Publisher publisher : publishers)
				outputStream.println(publisher2String(publisher));
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}
}
