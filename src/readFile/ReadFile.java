package readFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

	public static ArrayList<TeacherInformation> teacherAccounts = new ArrayList<TeacherInformation>();
	public static ArrayList<StudentInformation> studentAccounts = new ArrayList<StudentInformation>();

	public void loadInformation() {// method to scan file

		try {
			Scanner input = new Scanner(new FileReader("Libraries/Student Library.txt"));// try to create a scanner

			String username = "";
			String password = "";
			String name = "";
			String birthday = "";
			String dateEnrolled = "";
			String Email = "";
			String major = "";

			String valueType;
			do {// continue scanning while there is a next line
				input.nextLine();
				do {
					valueType = input.next();
					if (valueType.equals("username")) {
						username = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("password")) {
						password = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("name")) {
						name = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("birthday")) {
						birthday = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("dateEnrolled")) {
						dateEnrolled = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("email")) {
						Email = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("major")) {
						major = input.nextLine().replaceFirst(" ", "");;
					}
				} while (!valueType.equals("S")&& input.hasNext());

				studentAccounts.add(new StudentInformation(username, password, name, birthday, Email, dateEnrolled, major));

				System.out.println("Student");
				System.out.println(username);
				System.out.println(password);
				System.out.println(name);
				System.out.println(birthday);
				System.out.println(Email);
				System.out.println(dateEnrolled);
				System.out.println(major);
				System.out.println();
				
			} while (input.hasNext());// check if the file has ended

			input.close();// close the scanner

		} catch (FileNotFoundException e) {// end of try statement
			// TODO Auto-generated catch block
			System.out.println("file not found");
		}

		
		// read file for teacher
		try {
			Scanner input = new Scanner(new FileReader("Libraries/Teacher Library.txt"));// try to create a scanner

			String username = "";
			String password = "";
			String name = "";
			String birthday = "";
			String Email = "";
			String major = "";

			String valueType;
			do {// continue scanning while there is a next line
				input.nextLine();
				do {
					valueType = input.next();
					if (valueType.equals("username")) {
						username = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("password")) {
						password = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("name")) {
						name = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("birthday")) {
						birthday = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("email")) {
						Email = input.nextLine().replaceFirst(" ", "");;
					} else if (valueType.equals("major")) {
						major = input.nextLine().replaceFirst(" ", "");;
					}
				} while (!valueType.equals("T") && input.hasNext());

				teacherAccounts.add(new TeacherInformation(username, password, name, birthday, Email, major));

				System.out.println("teacher");
				System.out.println(username);
				System.out.println(password);
				System.out.println(name);
				System.out.println(birthday);
				System.out.println(Email);
				System.out.println(major);
				System.out.println();
				
				
			} while (input.hasNext());// check if the file has ended
			
			
			

			input.close();// close the scanner

		} catch (FileNotFoundException e) {// end of try statement
			// TODO Auto-generated catch block
			System.out.println("file not found");
		}

	}

	public boolean checkTeacherPasswords(String username, String passwords) {

		for (int i = 0; i < teacherAccounts.size(); i++) {

			if (teacherAccounts.get(i).getUsername().equals(username)) {

				if (teacherAccounts.get(i).getPasswords().equals(passwords)) {
					return true;
				}
				return false;
			}

		}
		return false;

	}

	public boolean checkStudentPasswords(String username, String passwords) {

		for (int i = 0; i < studentAccounts.size(); i++) {

			if (studentAccounts.get(i).getUsername().equals(username)) {

				if (studentAccounts.get(i).getPasswords().equals(passwords)) {
					return true;
				}
				return false;
			}

		}
		return false;

	}

}
