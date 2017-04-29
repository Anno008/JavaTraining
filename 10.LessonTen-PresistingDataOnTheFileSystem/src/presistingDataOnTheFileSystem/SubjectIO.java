package presistingDataOnTheFileSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectIO{

	private static String path = "src/presistingDataOnTheFileSystem/subjects.txt";

	private static Subject string2Subject(String row) {
		String[] s = row.split(",");
		return new Subject(s[0], s[1], Integer.parseInt(s[2]));
	}

	private static String subject2String(Subject st) {
		return st.getIdentifier() + "," + st.getName() + "," + st.getEspb();
	}

	public static List<Subject> readSubjects() throws IOException {
		BufferedReader inputStream = null;
		List<Subject> subjects = null;
		File yourFile = new File(path);
		yourFile.createNewFile(); 
		try {
			inputStream = new BufferedReader(new FileReader(path));
			subjects = new ArrayList<Subject>();
            String l;
			while ((l = inputStream.readLine()) != null) {
				subjects.add(string2Subject(l));
			}
			return subjects;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
	public static void saveSubjects(List<Subject> subjects) throws IOException{
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path));
			for (Subject subject : subjects) 
				outputStream.println(subject2String(subject));
		} finally {
			if (outputStream != null) 
				outputStream.close();
		}
	}
}
