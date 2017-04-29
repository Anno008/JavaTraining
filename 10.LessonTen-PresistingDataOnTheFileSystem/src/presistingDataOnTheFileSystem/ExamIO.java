package presistingDataOnTheFileSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExamIO{

	private static String path = "src/presistingDataOnTheFileSystem/exams.txt";
	
	private static Exam exam2String(String line) {
		String[] s = line.split(",");
		Subject sub = Main.subjects.stream().filter(su -> su.getIdentifier().equals(s[1])).findFirst().orElse(null);
		return new Exam(s[0], sub, Integer.parseInt(s[2]));
	}

	private static String exam2String(Exam e) {
		return e.getStudentIdentifier() + "," + e.getSubject().getIdentifier() + "," + e.getGrade();
	}
	
	public static void saveExams(List<Exam> exams) throws IOException{
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path, true));
			for (Exam ex : exams) {
				boolean exists = false;
				for (Exam existing : readExams(ex.getStudentIdentifier())){
					if(ex.getStudentIdentifier().equals(existing.getStudentIdentifier()) && ex.getSubject().getIdentifier().equals(existing.getSubject().getIdentifier()))
						exists = true;
				}
				if(!exists)
					outputStream.println(exam2String(ex));
			}
		} finally {
			if (outputStream != null) 
				outputStream.close();
		}
	}

	public static List<Exam> readExams(String index) throws IOException {
		BufferedReader inputStream = null;
		List<Exam> exams = null;
		File yourFile = new File(path);
		yourFile.createNewFile(); 
		try{
			inputStream = new BufferedReader(new FileReader(path));
			exams = new ArrayList<Exam>();
			String line;
			while((line = inputStream.readLine()) != null){
				if (exam2String(line) != null)
				exams.add(exam2String(line));
			}
			return exams.stream().filter(e -> e.getStudentIdentifier().equals(index)).collect(Collectors.toList());
		}finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
}
