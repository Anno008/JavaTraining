package serverClientStudents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static ArrayList<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {
		students.add(new Student(1, "Jhon", "Kor"));
		students.add(new Student(2, "Wendy", "Swon"));
		students.add(new Student(3, "Bob", "Tailor"));

		ServerSocket server;
		try {
			server = new ServerSocket(9100);
			System.out.println("Server started.");
			
			while(true){
				Socket socket = server.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
	
				String request = in.readLine();
				String response = "";
				
				System.out.println(request);
				String option = request.split(";")[0];
				switch (option) {
				case "displayAll":
					response = getAllStudents();
					break;
				case "find":
					response = findStudent(request);
					break;
				case "add":
					response = createStudent(request);
					break;
				case "update":
					response = updateStudent(request);
					break;
				case "delete":
					response = deleteStudent(request);
					break;
				default:
					System.out.println("User entered and un supported option: " + option);
					response = "Invalid option";
					break;
				}
				
				out.println(response);
				System.out.println("Request handled");
				in.close();
				out.close();
				socket.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static String deleteStudent(String request) {
		String output = "Student with the id of: " + request.split(";")[1] + "doesn't exist.";
		Student st = null;
		for (Student student : students) {
			if(student.getId() == Integer.parseInt(request.split(";")[1])){
				st = student;
				break;
			}
		}
		
		if(st== null)
			return output;
		
		students.remove(st);
		return "Student with an id of " + st.getId() + " deleted";
	}

	private static String updateStudent(String request) {
		String output = "Student with the id of: " + request.split(";")[1] + "doesn't exist.";
		Student st = null;
		for (Student student : students) {
			if(student.getId() == Integer.parseInt(request.split(";")[1])){
				st = student;
				break;
			}
		}
		
		if(st== null)
			return output;
		
		st.updateStudent(request.split(";")[2], request.split(";")[3]);
		return st.toString();
	}

	private static String createStudent(String request) {
		Student st = new Student(Integer.parseInt(request.split(";")[1]), request.split(";")[2], request.split(";")[3]);
		students.add(st);
		return "Student created!;" + st;
	}

	private static String findStudent(String request) {
		String output = "Student with the id of: " + request.split(";")[1] + "doesn't exist.";
		for (Student student : students) {
			if(student.getId() == Integer.parseInt(request.split(";")[1])){
				output = student.toString();
				break;
			}
		}
		return output;
	}

	private static String getAllStudents() {
		String response = "";
		for (Student student : students) {
			response += student + ";";
		}
		return response;
	}
}
