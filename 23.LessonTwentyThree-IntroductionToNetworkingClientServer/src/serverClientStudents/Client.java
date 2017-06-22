package serverClientStudents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import util.Utility;

public class Client {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			String option = "";

			do {
				Socket socket = new Socket(address, 9100);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),	true);
				
				option = Utility.readString(getOptions());
				System.out.println(option);
				switch(option){
				case "1":
					out.println("displayAll;");
					for (String s : in.readLine().split(";")) 
						System.out.println(s);
					break;
				case "2":
					out.println("find;" + Utility.readString("Enter the student id."));
					System.out.println(in.readLine());
					break;
				case "3":
					out.println("add;" + Utility.readInteger("Enter the students id.") + ";"+ Utility.readString("Enter the students name.") + ";" + Utility.readString("Enter the students surname."));
					System.out.println(in.readLine());
					break;
				case "4":
					out.println("update;" + Utility.readInteger("Enter the students id.") + ";"+ Utility.readString("Enter the students name.") + ";" + Utility.readString("Enter the students surname."));
					System.out.println(in.readLine());
					break;
				case "5":
					out.println("delete;" + Utility.readInteger("Enter the students id."));
					System.out.println(in.readLine());
					break;
				default:
					System.out.println("Invalid option.");
					break;
				}
				
				out.close();
				in.close();
				socket.close();
			} while (!option.equals("6"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static String getOptions() {
		String output = "";
		output += "1. Get all students. \n";
		output += "2. Find a student. \n";
		output += "3. Add a student. \n";
		output += "4. Update a student.. \n";
		output += "5. Remove a student. \n";
		output += "6. Exit. \n";
		return output;
	}
}
