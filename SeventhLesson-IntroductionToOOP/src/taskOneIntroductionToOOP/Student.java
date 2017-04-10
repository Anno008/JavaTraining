package taskOneIntroductionToOOP;

import java.util.ArrayList;
import java.util.List;

public class Student {
	public int Id;
	public String Name;
	public String Surname;
	public int Index;
	public List<Exam> Exams;

	public Student(int id, String name, String surname, int index) {
		Id = id;
		Name = name;
		Surname = surname;
		Index = index;
		Exams = new ArrayList<Exam>();
	}

	public List<Exam> GetPassedExams() {
		return Exams;
	}

	public void PassExam(Subject subject, int grade) {
		Exam exam = new Exam(this, subject, grade);
		Exams.add(exam);
		TaskOneIntroductionToOOP.Exams.add(exam);
	}
	public void InvalidateExam(Exam examToInvalidate) {
		Exams.remove(examToInvalidate);
		TaskOneIntroductionToOOP.Exams.remove(examToInvalidate);
	}

	public void PrintStudentsInformation() {
		String output = "";
		output += "Id: " + Id + ", Index: " + Index + ", Name: " + Name + ", Surname: " + Surname + "\n";

		if (Exams.size() > 0) {
			output += "Passed exams:\n";
			for (Exam exam : Exams)
				output += "\tSubject: " + exam.Subject.Name + " passed with a grade of " + exam.Grade + " which carries " + exam.Subject.ESPB + " ESPB\n";
		}

		System.out.println(output);
	}

	public void GetExamDetails(Criteria criteria) {
		if (Exams.size() == 0) {
			System.out.println("Student: " + Name + " didn't pass any exams.");
			return;
		}

		Result result = getSubjectGradeInfo();
		switch (criteria) {
		case AverageGrade:
			System.out.println("The average grade of student: " + Name + " is: " + result.Average);
			break;
		case HighestGrade:
			System.out.println("The highest grade student " + Name + " has achieved is: " + result.HighestGrade + " in the subject " + result.Name);
			break;
		case LowestGrade:
			System.out.println("The lowest grade student " + Name + " has achieved is: " + result.HighestGrade + " in the subject " + result.Name);
			break;
		}
	}

	private Result getSubjectGradeInfo() {
		int lowestGrade = 100;
		int highestGrade = 0;
		SubjectsEnum subject = null;
		int sum = 0;

		for (Exam exam : Exams) {
			if (lowestGrade > exam.Grade) {
				lowestGrade = exam.Grade;
				subject = exam.Subject.Name;
			}

			if (highestGrade < exam.Grade) {
				highestGrade = exam.Grade;
				subject = exam.Subject.Name;
			}
			sum += exam.Grade;
		}

		int averageGrade = sum / Exams.size();

		return new Result(subject, lowestGrade, highestGrade, averageGrade);
	}

	
}
