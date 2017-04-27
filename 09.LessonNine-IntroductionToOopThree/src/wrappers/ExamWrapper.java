package wrappers;

import java.util.List;

import models.*;
import util.ObjectDecorator;
import util.Utility;

public class ExamWrapper {

	public static String takeExam(List<Student> students, List<Subject> subjects) {
		Student st = StudentWrapper.findStudent(students);
		ObjectDecorator<Subject> subj = SubjectWrapper.findSubject(subjects);
		
		if(st != null && subj.getObj() != null){
			int grade = Utility.readInteger("Enter the grade the student received on the subject: " + subj.getObj().getName());
			Exam exam = createExam(st.getExams(), st, subj.getObj(), grade);
			
			for (Exam e : st.getExams())
				if (e.getSubject().getName().equals(exam.getSubject().getName())) {
					return "Student: " + st.getFullName() + " has already taken the exam: " + exam.getSubject().getName() + " and has received a grade of: " + e.getGrade() + "\n";
				}
			
			st.takeExam(exam);
		}
		return "Exam taken.";
	}

	public static String invalidateExam(List<Student> students, List<Subject> subjects) {
		Student st = StudentWrapper.findStudent(students);
		
		int examId = Utility.readInteger("Enter the id of the exam that you want to invalidate belonging to the student: " + st.getFullName());
		Exam exam = st.getExams().stream().filter(e -> e.getIndex() == examId).findFirst().orElse(null);
		
		if(exam == null)
			return "Exam with the id: " + examId + " doesn't exist";
		
		else{
			st.invalidateExam(exam);
			return "invalidated exam of subject: " + exam.getSubject().getName() + " from student: " + st.getFullName();
		}
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
