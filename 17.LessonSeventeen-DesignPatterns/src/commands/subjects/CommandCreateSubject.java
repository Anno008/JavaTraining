package commands.subjects;

import java.util.ArrayList;

import commands.Command;
import models.Subject;
import utils.Utility;

public class CommandCreateSubject implements Command {
	private ArrayList<Subject> subjects;
	private Subject newSubject;

	public CommandCreateSubject(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void execute() {
		String name = Utility.readString("Enter the name of the subject.");
		int espb = Utility.readInteger("Enter how much espb points the subject carries.");

		newSubject = new Subject(subjects.size() + 1, name, espb);
		subjects.add(newSubject);
	}

	@Override
	public void undo() {
		subjects.remove(newSubject);
	}
}
