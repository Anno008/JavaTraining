package wrappers;

import java.util.List;

import models.*;
import util.Utility;

public class ExamWrapper {

	public static void takeExam(List<Student> students, List<Subject> subjects) {
		Student st = StudentWrapper.findStudent(students);
		Subject subj = SubjectWrapper.findSubject(subjects);
		
		int grade = Utility.readInteger("Enter the grade the student received on the subject: " + subj.getName());
		Exam exam = createExam(st.getExams() , st, subj, grade);
		st.getExams().add(exam);
	}

	public static void invalidateExam(List<Student> students, List<Subject> subjects) {
		Student st = StudentWrapper.findStudent(students);
		
		int examId = Utility.readInteger("Enter the id of the exam that you want to invalidate belonging to the student: " + st.getFullName());
		Exam exam = st.getExams().stream().filter(e -> e.getIndex() == examId).findFirst().orElse(null);
		
		if(exam == null)
			System.out.println("Exam with the id: " + examId + " doesn't exist");
		
		else
			st.invalidateExam(exam);	
	}
	
	private static Exam createExam(List<Exam> exams, Student student, Subject subject, int grade) {
		int index = 1;
		for (int i = 1; i < exams.size() + 2; i++) {
			final int temp = i;
			boolean exists = exams.stream().anyMatch(s -> s.getIndex() == temp);
			if (!exists) {
				index = i;
				break;
			}
		}

		return new Exam(index, student, subject, grade);
	}

}
