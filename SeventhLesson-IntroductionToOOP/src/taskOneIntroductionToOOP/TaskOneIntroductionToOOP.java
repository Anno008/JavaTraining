package taskOneIntroductionToOOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskOneIntroductionToOOP {
	public static List<Exam> Exams = new ArrayList<Exam>();
	
	public static void main(String[] args) {
		List<Student> students = getStudentsList();
		
		Student pera = students.stream().filter(s -> s.Id == 1).findFirst().get();
		List<Exam> perasExamList = pera.GetPassedExams();
		pera.PassExam(new Subject(SubjectsEnum.Math), 5);
		pera.PassExam(new Subject(SubjectsEnum.Physics), 6);
		
		pera.PrintStudentsInformation();
		pera.GetExamDetails(Criteria.HighestGrade);
		pera.GetExamDetails(Criteria.LowestGrade);
		pera.GetExamDetails(Criteria.AverageGrade);
		
		System.out.println("-----------------------");
		
		Student ivana = students.stream().filter(s -> s.Id == 3).findFirst().get();
		ivana.PassExam(new Subject(SubjectsEnum.Math), 7);
		ivana.PassExam(new Subject(SubjectsEnum.Economics), 4);
		ivana.PassExam(new Subject(SubjectsEnum.History), 9);
		ivana.PassExam(new Subject(SubjectsEnum.Finance), 2);
		
		ivana.PrintStudentsInformation();
		Exam examToInvalidate = Exams.stream().filter(e -> e.Subject.Name == SubjectsEnum.Finance).findFirst().get();
		ivana.InvalidateExam(examToInvalidate);
		
		ivana.InvalidateExam(new Exam(ivana, new Subject(SubjectsEnum.Art), 0));
		ivana.PrintStudentsInformation();
		
		System.out.println();
		printAllstudentsThatPassedSubject(SubjectsEnum.Math);
	}

	
	
	private static void printAllstudentsThatPassedSubject(SubjectsEnum subject){
		List<Exam> filteredExamList = Exams.stream().filter(e -> e.Subject.Name == subject).collect(Collectors.toList());
		for (Exam exam : filteredExamList) {
			System.out.println(exam.Student.Name + " passed the exam from: " + subject + " with a grade of: " + exam.Grade);
		}
	}
	
	private static List<Student> getStudentsList() {
		return Arrays.asList(
				new Student(1, "Pera", "Peric",2351), 
				new Student(2, "Mika", "Mikic",5423),
				new Student(3, "Ivana", "Ivanovic",2341),
				new Student(4, "Zeljko", "Zeljkovic",4331),
				new Student(5, "Tamara", "Tamaric",1325));
	}
}
