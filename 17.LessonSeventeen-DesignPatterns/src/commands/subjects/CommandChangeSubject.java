package commands.subjects;

import java.util.ArrayList;

import commands.Command;
import models.Subject;
import utils.Utility;

public class CommandChangeSubject implements Command {
	private ArrayList<Subject> subjects;
	private Subject oldSubject;

	public CommandChangeSubject(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void execute() {
		Subject newSubject = Utility.findSubjectOnIndex(subjects);
		if (newSubject != null) {
			String name = Utility.readString("Enter the name of the subject.");
			int espb = Utility.readInteger("Enter how much espb points the subject carries.");

			oldSubject = newSubject.cloneSubject(newSubject);

			newSubject.setName(name);
			newSubject.setEspb(espb);
		} else
			System.out.println("Subject doesn't exist.");
	}

	@Override
	public void undo() {
		for (Subject subject : subjects)
			if (subject.getId() == oldSubject.getId())
				subject = oldSubject;

	}
}
