package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordReader {

	private ArrayList<StoredPasswords> teacherAccounts = new ArrayList<StoredPasswords>();
	private ArrayList<StoredPasswords> studentAccounts = new ArrayList<StoredPasswords>();

	public void loadPassword() {// method to scan file

		try {
			Scanner input = new Scanner(new FileReader("Accounts/students"));// try to create a scanner

			String temporary;
			String temp;

			do {// continue scanning while there is a next line

				temporary = input.next();
				temp = input.next();
				input.nextLine();

				studentAccounts.add(new StoredPasswords(temporary, temp));

			} while (input.hasNextLine());// check if the file has ended

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
				input.nextLine();

				teacherAccounts.add(new StoredPasswords(temporary, temp));

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
