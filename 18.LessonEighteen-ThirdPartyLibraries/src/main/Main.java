package main;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.Exam;
import models.Student;
import models.Subject;

public class Main {

	public static void main(String[] args) {
		Student st1 = new Student(1, "Jhony", "Jack");
		Student st2 = new Student(2, "Wendy", "Marvel");
		Student st3 = new Student(3, "Dymond", "Tnt");

		Subject s1 = new Subject(1, "Math", 10);
		Subject s2 = new Subject(2, "Art", 9);
		Subject s3 = new Subject(3, "Management", 8);
		Subject s4 = new Subject(4, "History", 7);

		st1.takeExam(new Exam(1, st1, s1, 10));
		st1.takeExam(new Exam(2, st1, s2, 7));
		st1.takeExam(new Exam(3, st1, s3, 9));

		st2.takeExam(new Exam(4, st2, s3, 10));
		st2.takeExam(new Exam(5, st2, s4, 10));

		st3.takeExam(new Exam(6, st3, s2, 6));

		ArrayList<Student> students = new ArrayList<Student>();
		students.add(st1);
		students.add(st2);
		students.add(st3);

		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Students");

		int rowNumber = 0;

		Row row = sheet.createRow(rowNumber++);

		Cell cell = row.createCell(0);
		cell.setCellValue("Id");

		cell = row.createCell(1);
		cell.setCellValue("Name");

		cell = row.createCell(2);
		cell.setCellValue("Surname");

		for (Student st : students) {
			row = sheet.createRow(rowNumber++);

			cell = row.createCell(0);
			cell.setCellValue(st.getId());

			cell = row.createCell(1);
			cell.setCellValue(st.getName());

			cell = row.createCell(2);
			cell.setCellValue(st.getSurname());

		}

		try {
			FileOutputStream fileOut = new FileOutputStream("data/students.xlsx");
			wb.write(fileOut);;
			fileOut.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
