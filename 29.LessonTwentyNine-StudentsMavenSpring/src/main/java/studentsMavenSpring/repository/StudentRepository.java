package studentsMavenSpring.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import studentsMavenSpring.model.Student;

@Component("studentRepository")
public class StudentRepository {
	private List<Student> students;
	private String path = "src/main/java/studentsMavenSpring/students.txt";
	
	public StudentRepository() {
		try {
			students = new ArrayList(readStudents());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Student> findAll() {
		try {
			return readStudents();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Student find(int id) {
		try {
			for (Student student : readStudents())
				if (student.getId() == id)
					return student;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Student student) {
		Student existingStudent = find(student.getId());
		if (existingStudent == null)
			students.add(student);
		else {
			student.setName(student.getName());
			student.setSurname(student.getSurname());
		}
		try {
			saveStudents(students);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getId() == id) {
				students.remove(i);
			}
		}
		try {
			saveStudents(students);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Student string2Student(String row) throws IOException {
		String[] s = row.split(",");
		return new Student(Integer.parseInt(s[0]), s[1], s[2]);
	}

	private String student2String(Student st) {
		return st.getId() + "," + st.getName() + "," + st.getSurname();
	}

	private List<Student> readStudents() throws IOException {
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

	private void saveStudents(List<Student> students) throws IOException {
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
