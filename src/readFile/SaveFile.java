package readFile;

import java.io.BufferedWriter;
import java.io.FileWriter;

// saves the information in the specific format that can be read by file reader
public class SaveFile {

	//to store student information
	public static void SaveStudentInformation() {

		//string thats get written
		String lineToWrite = "";
		
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Libraries/Student Library.txt"))) {

			for (int i = 0; i < ReadFile.studentAccounts.size(); i++) {

				lineToWrite = "S";
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "username " + ReadFile.studentAccounts.get(i).getUsername();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "password " + ReadFile.studentAccounts.get(i).getPasswords();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "name " + ReadFile.studentAccounts.get(i).getName();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "birthday " + ReadFile.studentAccounts.get(i).getBirthday();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "dateEnrolled " + ReadFile.studentAccounts.get(i).getDateEnrolled();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "email " + ReadFile.studentAccounts.get(i).getEmail();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "major " + ReadFile.studentAccounts.get(i).getDepartment();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "E";
				writer.write(lineToWrite);
				writer.newLine();

				for (int x = 0; x < ReadFile.studentAccounts.get(i).getCourse().size(); x++) {

					String courseCode = ReadFile.studentAccounts.get(i).getCourse().get(x).getCourseCode();
					String courseName = ReadFile.studentAccounts.get(i).getCourse().get(x).getCourseName();
					int mark = ReadFile.studentAccounts.get(i).getCourse().get(x).getCourseMark();
					lineToWrite = "course " + courseCode + " " + mark + " " + courseName;
					writer.write(lineToWrite);
					writer.newLine();
				}

				writer.newLine();

			}

		} catch (Exception e) {// end of try statement
			e.printStackTrace();
		}

	}

	//to store teacher information
	public static void SaveTeacherInformation() {

		String lineToWrite = "";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Libraries/Teacher Library.txt"))) {

			for (int i = 0; i < ReadFile.teacherAccounts.size(); i++) {

				lineToWrite = "T";
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "username " + ReadFile.teacherAccounts.get(i).getUsername();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "password " + ReadFile.teacherAccounts.get(i).getPasswords();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "name " + ReadFile.teacherAccounts.get(i).getName();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "birthday " + ReadFile.teacherAccounts.get(i).getBirthday();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "email " + ReadFile.teacherAccounts.get(i).getEmail();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "major " + ReadFile.teacherAccounts.get(i).getDepartment();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "E";
				writer.write(lineToWrite);
				writer.newLine();

				
				for (int x = 0; x < ReadFile.teacherAccounts.get(i).getCourse().size(); x++) {

					String courseCode = ReadFile.teacherAccounts.get(i).getCourse().get(x).getCourseCode();
					String courseName = ReadFile.teacherAccounts.get(i).getCourse().get(x).getCourseName();

					lineToWrite = "course " + courseCode + " " + courseName;
					writer.write(lineToWrite);
					writer.newLine();
				}		
				writer.newLine();
			}

		} catch (Exception e) {// end of try statement
			e.printStackTrace();
		}

	}

	//to store course information
	public static void saveCourseInformation() {

		String lineToWrite = "";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Libraries/Course Library.txt"))) {

			for (int i = 0; i < ReadFile.courseLibrary.size(); i++) {

				lineToWrite = "C";
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "className " + ReadFile.courseLibrary.get(i).getClassName();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "classCode " + ReadFile.courseLibrary.get(i).getClassCode();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "Teacher " + ReadFile.courseLibrary.get(i).getTeacher().getUsername();
				writer.write(lineToWrite);
				writer.newLine();

				lineToWrite = "E";
				writer.write(lineToWrite);
				writer.newLine();

				for (int x = 0; x < ReadFile.courseLibrary.get(i).getTimes().size(); x++) {
					String date = ReadFile.courseLibrary.get(i).getTimes().get(x).getDate();
					int beginTime = ReadFile.courseLibrary.get(i).getTimes().get(x).getBeginTime();
					int endTime = ReadFile.courseLibrary.get(i).getTimes().get(x).getEndTime();

					lineToWrite = "time " + date + " " + beginTime + " " + endTime;
					writer.write(lineToWrite);
					writer.newLine();

				}

				for (int x = 0; x < ReadFile.courseLibrary.get(i).getStudentInCourse().size(); x++) {
					String username = ReadFile.courseLibrary.get(i).getStudentInCourse().get(x).getUsername();

					lineToWrite = "Student " + username;
					writer.write(lineToWrite);
					writer.newLine();






				}

				writer.newLine();

			}

		} catch (Exception e) {// end of try statement
			e.printStackTrace();
		}

	}
}
