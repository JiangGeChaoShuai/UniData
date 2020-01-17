package launcher;

/*
 * Name: Eva Chen & John Li
 * Date: 2020/1/17
 * Course code: ICS4U1-01 Mr.Fernandes
 * Title: Uni-Data Course Application
 * Description: The Uni-data Course application is a project designed to be used by both students 
 * 				and teachers to organize their everyday courses and schedules, it has the function to 
 * 				add in new courses and keep in track the student’s marks and have it displayed in their credit. 
 * 				The application includes the function to remember course selected, the students in a course, 
 * 				the marks for the different classes are all remembered by the application. The teacher has
 * 				the ability to see the students in their different courses.
				Students can see their own course marks in a list in the credit panel. 
				Login allows student or teacher to be seperate, and makes sure that private information are only 
				accessible to the ones who have the password.
 * Features: Error checking for sign up frame, 
			error checking for course selection frame for students and teachers, 
			it checks for time differences, warning when the wrong username or password is entered,
			the data are saved automatically and are visible and usable the moment it is changed

 * Major Skills: JComponents, buffer reader, scanner, hierarchy, interface, 
 * 				stacking different JPanels on top of each other to create desired look 
 */

import Displays.LoginFrame;


// launcher
public class Main {

	public static void main(String[] args) {
		LoginFrame window = new LoginFrame();
		window.Frame.setVisible(true);
		new LoginFrame();

	}
	
}
