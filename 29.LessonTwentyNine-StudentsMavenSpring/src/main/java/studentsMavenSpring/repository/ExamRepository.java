package studentsMavenSpring.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import studentsMavenSpring.model.Exam;

@Component("examRepository")
public class ExamRepository {
	private List<Exam> exams = new ArrayList<Exam>();
	private String path = "src/main/java/studentsMavenSpring/exams.txt";

	public List<Exam> findAll() {
		try {
			return readExams();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Exam exam) {
		exams.add(exam);
		try {
			saveExams(exams);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Exam exam2String(String line) {
		String[] s = line.split(",");
		return new Exam(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
	}

	private String exam2String(Exam e) {
		return e.getStudent_id() + "," + e.getSubject_id() + "," + e.getGrade();
	}

	private void saveExams(List<Exam> exams) throws IOException {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path, true));
			for (Exam ex : exams)
				outputStream.println(exam2String(ex));
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}

	private List<Exam> readExams() throws IOException {
		BufferedReader inputStream = null;
		List<Exam> exams = null;
		File yourFile = new File(path);
		yourFile.createNewFile();
		try {
			inputStream = new BufferedReader(new FileReader(path));
			exams = new ArrayList<Exam>();
			String line;
			while ((line = inputStream.readLine()) != null) {
				if (exam2String(line) != null)
					exams.add(exam2String(line));
			}
			this.exams = exams;
			return exams;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
}
