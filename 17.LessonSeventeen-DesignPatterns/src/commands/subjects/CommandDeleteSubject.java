package commands.subjects;

import java.util.ArrayList;

import commands.Command;
import models.Subject;
import utils.Utility;

public class CommandDeleteSubject implements Command {
	private ArrayList<Subject> subjects;
	private Subject sub;

	public CommandDeleteSubject(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void execute() {
		sub = Utility.findSubjectOnIndex(subjects);
		if (sub != null)
			subjects.remove(sub);
	}

	@Override
	public void undo() {
		subjects.add(sub);
	}
}
