package Displays;

/*
 * Name: John Li
 * Date: 2020/01/17
 * Course: ICS4U1-01 Mr.Fernandes
 * Title: Uni-Data Course Application
 * Description: This class will load a log in frame of this program. User can choose their status is teacher or student. Then they can 
 * 				enter their username and password, if correct, they can log in to their personal center which fetch their status. 
 * 				If it's a new user, he can click the sign up button, then he can enter his personal information in the text field follow the 
 * 				reminder. when complete, click creak account button and then his personal account will be created and log in to his personal
 * 				center. 
 * Features: Error checking for sign up frame, 
 * 			error checking for course selection frame for students and teachers, 
 * 			it checks for time differences, 
 * 			warning when the wrong username or password is entered,
 * 			the data are saved automatically and are visible and usable the moment it is changed
 * Major Skills: JComponents, buffer reader, scanner, hierarchy, interface, stacking different JPanels on top of 
 * 					each other to create desired look 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import readFile.ReadFile;
import readFile.SaveFile;

import Displays.StudentCenter;
// commenting is done

// the class that gets ran at the beginning
public class LoginFrame implements ActionListener {

	// dimension for frame
	public final static int width = 1200;
	public final static int height = 750;

	// frame that holds everything
	public static JFrame Frame = new JFrame("Log in page");

	// buttons for going to other frames
	private JButton login = new JButton("LOGIN");
	private JButton signup = new JButton("SIGN UP");

	// entries that user have to type into
	private JTextField usernameEntry = new JTextField();
	private JPasswordField passwordEntry = new JPasswordField();

	// read the file
	private ReadFile read = new ReadFile();

	// the beginning panel
	private static JPanel inputPanel = new JPanel();

	// constructor that creates the sign up panel
	private static SignUpFrame signUp = new SignUpFrame();

	// combo box to choose type of user
	@SuppressWarnings("rawtypes")
	private JComboBox TeacherOrStudents = new JComboBox();

	// launcher
	public static void main(String[] args) {
		LoginFrame window = new LoginFrame();
		window.Frame.setVisible(true);
		new LoginFrame();

	}

	// constructor of the panel
	public LoginFrame() {
		read.loadInformation();
		initialize();
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// set the size of frame
	private void initialize() {
		Frame.setSize(width, height);
		createLayout();

	}

	// create the layout for this panel
	private void createLayout() {

		// the fonts and color for frame
		Color TextColor = new Color(54, 73, 88);
		Font font = new Font("Aileron", Font.PLAIN, 30);

		// set the layout to null
		Frame.setLayout(null);

		// add in the login panel
		inputPanel.setBounds(0, 0, width, height);
		inputPanel.setLayout(null);
		inputPanel.setBackground(new Color(201, 228, 202));
		Frame.add(inputPanel);

		// add in title of panel
		JLabel title = new JLabel("LOG IN", SwingConstants.CENTER);
		title.setBounds(Frame.getWidth() / 2 - 150, 50, 300, 50);
		title.setVisible(true);
		title.setForeground(TextColor);
		title.setFont(font);
		inputPanel.add(title);

		// add in combo box
		TeacherOrStudents.setBounds(Frame.getWidth() / 2 - 150, 125, 300, 35);
		TeacherOrStudents.setFont(font);
		TeacherOrStudents.addItem("Teacher");
		TeacherOrStudents.addItem("Student");
		inputPanel.add(TeacherOrStudents);

		// add in username title
		JLabel username = new JLabel("username", SwingConstants.CENTER);
		username.setBounds(Frame.getWidth() / 2 - 150, 200, 300, 50);
		username.setVisible(true);
		username.setFont(font);
		username.setForeground(TextColor);
		inputPanel.add(username);

		// add in the entry for username
		usernameEntry.setBounds(Frame.getWidth() / 2 - 150, 250, 300, 50);
		usernameEntry.setVisible(true);
		inputPanel.add(usernameEntry);

		// add in the password title
		JLabel password = new JLabel("password", SwingConstants.CENTER);
		password.setBounds(Frame.getWidth() / 2 - 150, 325, 300, 50);
		password.setVisible(true);
		password.setForeground(TextColor);
		password.setFont(font);
		inputPanel.add(password);

		// add in the password entry
		passwordEntry.setBounds(Frame.getWidth() / 2 - 150, 375, 300, 50);
		passwordEntry.setVisible(true);
		inputPanel.add(passwordEntry);

		// button to log in
		login.setBounds(Frame.getWidth() / 2 - 150, 475, 300, 50);
		login.setVisible(true);
		login.addActionListener(this);
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(TextColor);
		login.setFont(font);
		inputPanel.add(login);

		// button to sign up
		signup.setBounds(Frame.getWidth() / 2 - 150, 535, 300, 50);
		signup.setVisible(true);
		signup.addActionListener(this);
		signup.setBackground(TextColor);
		signup.setForeground(new Color(255, 255, 255));
		signup.setFont(font);
		inputPanel.add(signup);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// check the password and username the user has entered matches
		if (e.getSource() == login) {

			checkPassword();
		}
		// redirect to panel that allows sign up
		if (e.getSource() == signup) {
			signUp.getPanel().setVisible(true);
			Frame.setLayout(new BorderLayout());
			Frame.getContentPane().add(signUp.getPanel(), BorderLayout.CENTER);
			Frame.getContentPane().add(signUp.getPanel());
			inputPanel.setVisible(false);
		}
	}

	// method that checks the username and password entry
	private void checkPassword() {

		// String to know which arraylist to check from
		String x = (String) TeacherOrStudents.getSelectedItem();
		// for students
		if (x.equals("Student")) {
			// convert the encrypted password to string
			String temp = String.valueOf(passwordEntry.getPassword());

			// the part where the password gets checked
			for (int i = 0; i < ReadFile.studentAccounts.size(); i++) {

				if (ReadFile.studentAccounts.get(i).getUsername().equals(usernameEntry.getText())) {

					if (ReadFile.studentAccounts.get(i).getPasswords().equals(temp)) {
						new StudentCenter(ReadFile.studentAccounts.get(i));
						usernameEntry.setText("");
						passwordEntry.setText("");
						Frame.setVisible(false);

						// stop checking
						return;
					}
				}

			}
		}
		// for teachers
		if (x.equals("Teacher")) {
			// convert the encrypted password to string
			String temp = String.valueOf(passwordEntry.getPassword());

			// the part where the password gets checked
			for (int i = 0; i < ReadFile.teacherAccounts.size(); i++) {

				if (ReadFile.teacherAccounts.get(i).getUsername().equals(usernameEntry.getText())) {

					if (ReadFile.teacherAccounts.get(i).getPasswords().equals(temp)) {

						new TeacherCenter(ReadFile.teacherAccounts.get(i));
						usernameEntry.setText("");
						passwordEntry.setText("");
						Frame.setVisible(false);

						// stop checking
						return;
					}
				}

			}

		}

	}

	// method to make frame visible again from another frame
	public static void setFrameVisible() {

		inputPanel.setVisible(true);

	}

}
