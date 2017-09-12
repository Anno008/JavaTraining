package studentsMavenSpring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studentsMavenSpring.model.Subject;
import studentsMavenSpring.service.SubjectService;
import studentsMavenSpring.utility.Utility;

@Component
public class SubjectView {

	@Autowired
	private SubjectService subjectService;

	public void start() {
		int option = 0;
		displayMenu();
		option = Utility.readInteger("Enter the desired option");

		switch (option) {
		case 1:
			displaySubjects();
			break;
		case 2:
			findSubject();
			break;
		case 3:
			createSubject();
			break;
		case 4:
			updateSubject();
			break;
		case 5:
			deleteSubject();
			break;
		}
	}

	private void deleteSubject() {
		int id = Utility.readInteger("Enter the id of the subject you want to delete:");
		
		subjectService.delete(id);
		
	}

	private void updateSubject() {
		int id = Utility.readInteger("Enter the id of the subject you want to update");
		String name = Utility.readString("Enter the subjects name");
		int espb = Utility.readInteger("Enter how many espb point the subject carries:");

		subjectService.save(new Subject(id, name, espb));
	}

	private void createSubject() {
		int id = Utility.readInteger("Enter the id of the subject");
		String name = Utility.readString("Enter the subjects name");
		int espb = Utility.readInteger("Enter how many espb point the subject carries:");

		subjectService.save(new Subject(id, name, espb));
	}

	private void findSubject() {
		int id = Utility.readInteger("Enter the id of the subject you want to find:");
		Subject sub = subjectService.find(id);
		System.out.println(sub == null ? "Subject with an id with: " + id + " doesn't exist" : sub);
	}

	private void displaySubjects() {
		for (Subject sub : subjectService.findAll())
			System.out.println(sub);
	}

	private void displayMenu() {
		System.out.println("1. Display subjects");
		System.out.println("2. Find subject");
		System.out.println("3. Create subject");
		System.out.println("4. Update subject");
		System.out.println("5. Delete subject\n");
	}
}
