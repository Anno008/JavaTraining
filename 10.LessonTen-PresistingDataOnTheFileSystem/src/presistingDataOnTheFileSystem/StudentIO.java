package presistingDataOnTheFileSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentIO{

	private static String path = "src/presistingDataOnTheFileSystem/students.txt";

	private static Student string2Student(String row) throws IOException {
		String[] s = row.split(",");
		return new Student(s[0], s[1], s[2]);
	}

	private static String student2String(Student st) {
		return st.getIndex() + "," + st.getName() + "," + st.getSurname();
	}

	public static List<Student> readStudents() throws IOException {
		BufferedReader inputStream = null;
		List<Student> students = null;
		File yourFile = new File(path);
		yourFile.createNewFile(); 
		try {
			inputStream = new BufferedReader(new FileReader(path));
			students = new ArrayList<Student>();
            String l;
			while ((l = inputStream.readLine()) != null) {
				students.add(string2Student(l));
			}
			return students;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
	public static void saveStudents(List<Student> students) throws IOException{
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path));
			for (Student student : students) 
				outputStream.println(student2String(student));
		} finally {
			if (outputStream != null) 
				outputStream.close();
		}
	}
}
