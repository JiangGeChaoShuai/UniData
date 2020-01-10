package Displays;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Displays.StudentCenter;
import utils.ReadFile;

public class LoginFrame implements ActionListener {
	
	private final int width = 1200;
	private final int height = 750;

	
	public JFrame Frame = new JFrame();

	private JButton login = new JButton("login");
	private JButton signup = new JButton("sign up");

	private JTextField usernameEntry = new JTextField();
	private JPasswordField passwordEntry = new JPasswordField();

	private ReadFile checkPassword = new ReadFile();

	private JPanel inputPanel = new JPanel();
	
	@SuppressWarnings("rawtypes")
	private JComboBox TeacherOrStudents = new JComboBox();

	public static void main(String[] args) {

		LoginFrame window = new LoginFrame();
		
		
		window.Frame.setVisible(true);

	}

	public LoginFrame() {
		checkPassword.loadPassword();
		initialize();
	}

	private void initialize() {

		Frame.setSize(1200, 750);
		createLayout();

	}

	private void createLayout() {

		Frame.setLayout(null);

		inputPanel.setBounds(0,0,width, height);
		inputPanel.setLayout(null);
		
		Frame.add(inputPanel);
		
		JLabel title = new JLabel("Login Frame", SwingConstants.CENTER);
		title.setBounds(Frame.getWidth() / 2 - 150, 50, 300, 50);
		title.setVisible(true);
		inputPanel.add(title);

		TeacherOrStudents.setBounds(Frame.getWidth() / 2 - 150, 100, 300, 25);
		TeacherOrStudents.addItem("Teacher");
		TeacherOrStudents.addItem("Student");

		inputPanel.add(TeacherOrStudents);

		JLabel username = new JLabel("username", SwingConstants.CENTER);
		username.setBounds(Frame.getWidth() / 2 - 150, 175, 300, 50);
		username.setVisible(true);
		inputPanel.add(username);

		usernameEntry.setBounds(Frame.getWidth() / 2 - 150, 225, 300, 50);
		usernameEntry.setVisible(true);
		inputPanel.add(usernameEntry);

		JLabel password = new JLabel("password", SwingConstants.CENTER);
		password.setBounds(Frame.getWidth() / 2 - 150, 325, 300, 50);
		password.setVisible(true);
		inputPanel.add(password);

		passwordEntry.setBounds(Frame.getWidth() / 2 - 150, 375, 300, 50);
		passwordEntry.setVisible(true);
		inputPanel.add(passwordEntry);

		login.setBounds(Frame.getWidth() / 2 - 150, 500, 100, 50);
		login.setVisible(true);
		login.addActionListener(this);
		inputPanel.add(login);

		signup.setBounds(Frame.getWidth() / 2 + 50, 500, 100, 50);
		signup.setVisible(true);
		signup.addActionListener(this);
		inputPanel.add(signup);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login) {
			checkPassword();
		}
		if (e.getSource() == signup) {

			inputPanel.setVisible(false);
			
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
				new StudentCenter();

				
				System.out.println("asd");
				return;
			}
			System.out.println("invalid username or password");

		}
		if (x.equals("Teacher")) {

			String temp = String.valueOf(passwordEntry.getPassword());
			
			System.out.println(usernameEntry.getText());
			System.out.println(temp);
			
			if (checkPassword.checkTeacherPasswords(usernameEntry.getText(), temp)) {
				System.out.println("asd");
				new StudentCenter();
				System.out.println("asd");
				return;
			}
			System.out.println("invalid username or password");
		}

	}

}
