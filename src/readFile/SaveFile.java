package readFile;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaveFile {

	public static void SaveInformation() {

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

				writer.newLine();

			}

		} catch (Exception e) {// end of try statement
			e.printStackTrace();
		}
		
		

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

				writer.newLine();

			}

		} catch (Exception e) {// end of try statement
			e.printStackTrace();
		}

	}
}
