package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Displays.StudentCenterState;
import utils.PasswordReader;

public class LoginFrame implements ActionListener {

	private JFrame inputFrame = new JFrame();

	private JButton login = new JButton("login");
	private JButton signup = new JButton("sign up");

	private JTextField usernameEntry = new JTextField();
	private JPasswordField passwordEntry = new JPasswordField();

	private PasswordReader checkPassword = new PasswordReader();

	@SuppressWarnings("rawtypes")
	private JComboBox TeacherOrStudents = new JComboBox();

	public static void main(String[] args) {

		LoginFrame window = new LoginFrame();
		
		
		window.inputFrame.setVisible(true);

	}

	public LoginFrame() {
		checkPassword.loadPassword();
		initialize();
	}

	private void initialize() {

		inputFrame.setSize(1200, 750);
		createLayout();

	}

	private void createLayout() {

		inputFrame.setLayout(null);

		JLabel title = new JLabel("Login Frame", SwingConstants.CENTER);
		title.setBounds(inputFrame.getWidth() / 2 - 150, 50, 300, 50);
		title.setVisible(true);
		inputFrame.add(title);

		TeacherOrStudents.setBounds(inputFrame.getWidth() / 2 - 150, 100, 300, 25);
		TeacherOrStudents.addItem("Teacher");
		TeacherOrStudents.addItem("Student");

		inputFrame.add(TeacherOrStudents);

		JLabel username = new JLabel("username", SwingConstants.CENTER);
		username.setBounds(inputFrame.getWidth() / 2 - 150, 175, 300, 50);
		username.setVisible(true);
		inputFrame.add(username);

		usernameEntry.setBounds(inputFrame.getWidth() / 2 - 150, 225, 300, 50);
		usernameEntry.setVisible(true);
		inputFrame.add(usernameEntry);

		JLabel password = new JLabel("password", SwingConstants.CENTER);
		password.setBounds(inputFrame.getWidth() / 2 - 150, 325, 300, 50);
		password.setVisible(true);
		inputFrame.add(password);

		passwordEntry.setBounds(inputFrame.getWidth() / 2 - 150, 375, 300, 50);
		passwordEntry.setVisible(true);
		inputFrame.add(passwordEntry);

		login.setBounds(inputFrame.getWidth() / 2 - 150, 500, 100, 50);
		login.setVisible(true);
		login.addActionListener(this);
		inputFrame.add(login);

		signup.setBounds(inputFrame.getWidth() / 2 + 50, 500, 100, 50);
		signup.setVisible(true);
		signup.addActionListener(this);
		inputFrame.add(signup);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login) {
			checkPassword();
		}
		if (e.getSource() == signup) {

		}
	}

	private void checkPassword() {
		System.out.println("as");
		String x = (String) TeacherOrStudents.getSelectedItem();
		if (x.equals("Student")) {
			String temp = String.valueOf(passwordEntry.getPassword());
			
			System.out.println(usernameEntry.getText());
			System.out.println(temp);
			
			if (checkPassword.checkStudentPasswords(usernameEntry.getText(), temp)) {
				System.out.println("asd");
				new StudentCenterState();
				return;
			}
			System.out.println("invalid username or password");

		}
		if (x.equals("Teacher")) {

		}

	}

}
