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

import studentsMavenSpring.model.Subject;

@Component("subjectRepository")
public class SubjectRepository {
	private List<Subject> subjects = new ArrayList<Subject>();
	private String path = "src/main/java/SubjectsMavenSpring/subjects.txt";

	public List<Subject> findAll() {
		try {
			return readSubjects();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Subject find(int id) {
		try {
			for (Subject Subject : readSubjects())
				if (Subject.getId() == id)
					return Subject;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Subject Subject) {
		Subject existingSubject = find(Subject.getId());
		if (existingSubject == null)
			subjects.add(Subject);
		else {
			Subject.setName(Subject.getName());
			Subject.setEspb(Subject.getEspb());
		}
		try {
			saveSubjects(subjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		Iterator<Subject> subjectsIterator = subjects.iterator();
		while (subjectsIterator.hasNext()) {
			if (subjectsIterator.next().getId() == id) {
				subjectsIterator.remove();
				return;
			}
		}
		try {
			saveSubjects(subjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Subject string2Subject(String row) {
		String[] s = row.split(",");
		return new Subject(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]));
	}

	private String subject2String(Subject st) {
		return st.getId() + "," + st.getName() + "," + st.getEspb();
	}

	private List<Subject> readSubjects() throws IOException {
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

	private void saveSubjects(List<Subject> subjects) throws IOException {
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
