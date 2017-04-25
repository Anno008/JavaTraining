package introductionToOopPartTwo;

import java.util.ArrayList;
import java.util.List;

public class Management {
	// fields
	static{
		students = getStartupStudents();
		subjects = getStartupSubjects();
	}
	
	private static List<Student> students;
	private static List<Subject> subjects;

	// initialization methods
	private static List<Student> getStartupStudents() {
		List<Student> returnList = new ArrayList<Student>();
		returnList.add(new Student("Jhony", "Weed", 1));
		returnList.add(new Student("Optimus", "Prime", 2));
		returnList.add(new Student("Lara", "Croft", 3));
		returnList.add(new Student("Mory", "Sorry", 4));
		return returnList;
	}
	
	private static List<Subject> getStartupSubjects() {
		List<Subject> returnList = new ArrayList<Subject>();
		returnList.add(new Subject(SubjectsEnum.Art));
		returnList.add(new Subject(SubjectsEnum.Management));
		returnList.add(new Subject(SubjectsEnum.Math));
		returnList.add(new Subject(SubjectsEnum.History));
		return returnList;
	}
	
	// Student related methods
	public static void displayInformationAboutStudents(){
		students.forEach(s -> s.printInformation());
		System.out.println();
	}
	
	public static void findStudent(){
		int index = UtilityMethods.askForInteger("Enter the index of the student.");
		if(index == 0) return;
		Student st = findAStudentBasedOnIndex(index);
		if (st==null)
			System.out.println("There doesn't exist a student with an index of: " + index);
		else
			st.printInformation();
	}
	
	public static void addStudent(){
		Student newStudent = createStudent();
		students.add(newStudent);
		System.out.println("Student: " + newStudent.getName() + " " + newStudent.getSurname() + " created");
	}
	
	public static void updateStudent(){
		Student s = findAStudentBasedOnIndex(UtilityMethods.askForInteger("Enter the index of the student."));
		updateStudent(s);
		System.out.println("Student updated.");
		s.printInformation();
	}
	
	public static void deleteStudent(){
		Student sDel = findAStudentBasedOnIndex(UtilityMethods.askForInteger("Enter the index of the student."));
		students.remove(sDel);
		System.out.println("Student deleted. ");
	}
	
	// Subject related methods
	public static void displayInformationAboutSubjects() {
		subjects.forEach(s -> s.printInformation());
		System.out.println();
	}
	
	public static void findSubject(){
		int id = UtilityMethods.askForInteger("Enter the Id of the Subject.");
		Subject sub = findSubjectBasedOnId(id);
		if (sub==null)
			System.out.println("There doesn't exist a subject with an id of: " + id);
		else
			sub.printInformation();
	}
	public static void createNewSubject(){
		Subject newSubject = createSubject();
		subjects.add(newSubject);
		System.out.println("Subject: " + newSubject.getName() + " created");
	}
	
	public static void updateSubject(){
		Subject updateSub = findSubjectBasedOnId(UtilityMethods.askForInteger("Enter the id of the subject."));
		updateSubject(updateSub);
		System.out.println("Subject updated.");
		updateSub.printInformation();
	}
	public static void deleteSubject(){
		Subject subDel = findSubjectBasedOnId(UtilityMethods.askForInteger("Enter the index of the student."));
		subjects.remove(subDel);
		System.out.println("Subject deleted. ");
	}
	
	// option 11
	public static void takeAnExam(){
		int stindex = UtilityMethods.askForInteger("Enter the index of the student.");
		if(stindex == 0) return;
		Student stu = findAStudentBasedOnIndex(stindex);
		if (stu==null){
			System.out.println("There doesn't exist a student with an index of: " + stindex);
			return;			
		}
		
		int subId = UtilityMethods.askForInteger("Enter the Id of the Subject.");
		Subject subj = findSubjectBasedOnId(subId);
		if (subj==null){
			System.out.println("There doesn't exist a subject with an id of: " + subId);
			return;
		}
		
		System.out.println("Enter the grade that student: " + stu.getName() + " has achieved on the exam: " + subj.getName());
		int grade = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		stu.TakeAnExam(subj, grade);
		System.out.println("Finished");
	}
	
	// private methods
	private static void updateSubject(Subject updateSub) {
		System.out.println("Enter the subject name.");
		String name = UtilityMethods.ReadInput();
		
		System.out.println("Enter the ESPB points that it carries.");
		int espb = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		
		updateSub.setName(name);
		updateSub.setEspb(espb);
	}

	private static Subject createSubject() {
		System.out.println("Enter the subject name.");
		String name = UtilityMethods.ReadInput();
		
		System.out.println("Enter the ESPB points that it carries.");
		int espb = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		
		return new Subject(name, espb);
	}

	private static Subject findSubjectBasedOnId(int id) {
		return subjects.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
	}


	private static void updateStudent(Student s) {
		System.out.println("Enter the students name.");
		String name = UtilityMethods.ReadInput();
		
		System.out.println("Enter the students surname.");
		String surname = UtilityMethods.ReadInput();
		
		System.out.println("Enter the students index.");
		int index = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		
		s.setName(name);
		s.setSurname(surname);
		s.setIndex(index);
	}

	private static Student createStudent() {
		System.out.println("Enter the students name.");
		String name = UtilityMethods.ReadInput();
		
		System.out.println("Enter the students surname.");
		String surname = UtilityMethods.ReadInput();
		
		System.out.println("Enter the students index.");
		int index = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		
		return new Student(name, surname, index);
	}

	private static Student findAStudentBasedOnIndex(int index) {
		return students.stream().filter(s -> s.getIndex() == index).findFirst().orElse(null);
	}
}
