package readFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;

import information.CourseInformation;
import information.StudentInformation;
import information.TeacherInformation;
import information.TimeOfWeek;

public class ReadFile {

	public static ArrayList<TeacherInformation> teacherAccounts = new ArrayList<TeacherInformation>();
	public static ArrayList<StudentInformation> studentAccounts = new ArrayList<StudentInformation>();
	public static ArrayList<CourseInformation> courseLibrary = new ArrayList<CourseInformation>();

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

			String courseCode = "";
			String courseName = "";
			int mark = 0;
			String valueType;
			do {// continue scanning while there is a next line
				input.nextLine();
				do {
					valueType = input.next();
					if (valueType.equals("username")) {
						username = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("password")) {
						password = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("name")) {
						name = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("birthday")) {
						birthday = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("dateEnrolled")) {
						dateEnrolled = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("email")) {
						Email = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("major")) {
						major = input.nextLine().replaceFirst(" ", "");
					}
				} while (!valueType.equals("E") && input.hasNext());

				studentAccounts
						.add(new StudentInformation(username, password, name, birthday, Email, dateEnrolled, major));
				
				if(!input.hasNext()) {
					break;
				}
				
				do {
					valueType = input.next();
					if (valueType.equals("course")){
						
						courseCode = input.next();
						mark = input.nextInt();
						courseName = input.nextLine().replaceFirst(" ", "");
						
						studentAccounts.get(studentAccounts.size()-1).setCourse(courseCode, courseName, mark);
						
					}
				} while (!valueType.equals("S") && input.hasNext());

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

				do {
					valueType = input.next();
					if (valueType.equals("username")) {
						username = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("password")) {
						password = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("name")) {
						name = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("birthday")) {
						birthday = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("email")) {
						Email = input.nextLine().replaceFirst(" ", "");
					} else if (valueType.equals("major")) {
						major = input.nextLine().replaceFirst(" ", "");
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

		try {
			Scanner input = new Scanner(new FileReader("Libraries/Course Library.txt"));// try to create a scanner

			String courseCode = "";
			String courseName = "";
			String dayOfWeek = "";
			int beginTime = 0;
			int endTime = 0;
			String studentUsername = "";
			String teacherUsername = "";

			String valueType;
			do {// continue scanning while there is a next line
				input.nextLine();
				do {
					valueType = input.next();
					if (valueType.equals("classCode")) {
						courseCode = input.nextLine().replaceFirst(" ", "");

					} else if (valueType.equals("className")) {
						courseName = input.nextLine().replaceFirst(" ", "");

					} else if (valueType.equals("Teacher")) {

						teacherUsername = input.nextLine().replace(" ", "");

						for (int i = 0; i < teacherAccounts.size(); i++) {
							if (teacherUsername.equals(teacherAccounts.get(i).getUsername())) {
								courseLibrary.add(new CourseInformation(courseCode, courseName, teacherAccounts.get(i)));
								break;
							}
						}

					}

				} while (!valueType.equals("E") && input.hasNext());

				do {
					valueType = input.next();

					if (valueType.equals("time")) {
						dayOfWeek = input.next();
						beginTime = input.nextInt();
						endTime = input.nextInt();
						input.nextLine();



						courseLibrary.get(courseLibrary.size() - 1).addTime(new TimeOfWeek(dayOfWeek, beginTime, endTime));
						

					} else if (valueType.equals("Student")) {

						studentUsername = input.nextLine().replaceFirst(" ", "");

						for (int i = 0; i < studentAccounts.size(); i++) {

							if (studentUsername.equals(studentAccounts.get(i).getUsername())) {

								courseLibrary.get(courseLibrary.size() - 1).addStudent(studentAccounts.get(i));
							}
						}

					}

				} while (input.hasNext() && !valueType.equals("C"));

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
