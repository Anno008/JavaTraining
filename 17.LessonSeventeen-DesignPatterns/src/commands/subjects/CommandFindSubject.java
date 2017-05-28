package commands.subjects;

import java.util.ArrayList;

import commands.Command;
import models.Subject;
import utils.Utility;

public class CommandFindSubject implements Command {
	private ArrayList<Subject> subjects;

	public CommandFindSubject(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void execute() {
		Subject sub = Utility.findSubjectOnIndex(subjects);
		if (sub != null)
			System.out.println(sub);
		else
			System.out.println("Subject doesn't exist.");
	}

	@Override
	public void undo() {
		// Nothing to undo
	}
}
