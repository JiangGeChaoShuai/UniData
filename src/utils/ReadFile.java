package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

	public static ArrayList<StudentInformation> teacherAccounts = new ArrayList<StudentInformation>();
	public static ArrayList<AccountInformation> studentAccounts = new ArrayList<AccountInformation>();

	public void loadPassword() {// method to scan file

		try {
			Scanner input = new Scanner(new FileReader("Libraries/Student Library.txt"));// try to create a scanner

			String username;
			String password;
			String name;
			String birthday;
			String dateEnrolled;
			String Email;
			String major;
			
			do {// continue scanning while there is a next line
				input.nextLine();
				username = input.nextLine();
				password = input.nextLine();
				name = input.nextLine();
				birthday = input.nextLine();
				dateEnrolled = input.nextLine();
				Email = input.nextLine();
				major = input.nextLine();
				input.nextLine();
				
				
				System.out.print(username);
				System.out.println(","+ password);
				System.out.println(name);
				System.out.println(birthday);
				System.out.println(dateEnrolled);
				System.out.println(Email);
				System.out.println(major);
				System.out.println();
				


				studentAccounts.add(new StudentInformation(username, password, name, birthday, Email, dateEnrolled, major));
				

			} while (input.hasNext());// check if the file has ended

			input.close();// close the scanner

		} catch (FileNotFoundException e) {// end of try statement
			// TODO Auto-generated catch block
			System.out.println("file not found");
		}

		try {
			Scanner input = new Scanner(new FileReader("Accounts/teachers"));// try to create a scanner

			String temporary;
			String temp;

			do {// continue scanning while there is a next line

				temporary = input.next();
				temp = input.next();
				

				//teacherAccounts.add(new AccountInformation(temporary, temp));

			} while (input.hasNextLine());// check if the file has ended
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
