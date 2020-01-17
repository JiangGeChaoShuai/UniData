package launcher;

/*
 * Name: Eva Chen & John Li
 * Date: 2020/1/17
 * Course code: ICS4U1-01 Mr.Fernandes
 * Title: Uni-Data Course Application
 * Description: 
 * Features: schedule, course selection, 
 * Major Skills: JComponents, buffer reader, scanner, hierarchy, interface, stacking different JPanels on top of each other to create desired look 
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
