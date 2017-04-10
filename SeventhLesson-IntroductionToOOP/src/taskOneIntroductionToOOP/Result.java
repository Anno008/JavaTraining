package taskOneIntroductionToOOP;

public class Result {
	public SubjectsEnum Name;
	public int LowestGrade;
	public int HighestGrade;
	public int Average;
	
	
	public Result(SubjectsEnum name, int lowestGrade, int highestGrade, int average){
		Name = name;
		LowestGrade = lowestGrade;
		HighestGrade = highestGrade;
		Average = average;
	}
	public Result(){
		
	}
}
