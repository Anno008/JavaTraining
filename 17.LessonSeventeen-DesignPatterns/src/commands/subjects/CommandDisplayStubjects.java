package commands.subjects;

import java.util.ArrayList;

import commands.Command;
import models.Subject;

public class CommandDisplayStubjects implements Command {
	private ArrayList<Subject> subjects;

	public CommandDisplayStubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void execute() {
		for (Subject subject : subjects)
			System.out.println(subject);
	}

	@Override
	public void undo() {
		// Nothing to undo
	}
}
