import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame implements ActionListener {

	private JFrame inputFrame = new JFrame();
	
	private JButton login = new JButton("login");
	private JButton signup = new JButton("sign up");

	public static void main(String[] args) {

		LoginFrame window = new LoginFrame();

		window.inputFrame.setVisible(true);

	}

	public LoginFrame() {

		initialize();
	}

	private void initialize() {

		inputFrame.setSize(1200, 750);
		createLayout();

	}

	private void createLayout() {

		inputFrame.setLayout(null);

		JLabel title = new JLabel("Login Frame",SwingConstants.CENTER);
		title.setBounds(inputFrame.getWidth()/2-150, 50, 300, 50);
		title.setVisible(true);
		inputFrame.add(title);
		
		
		
		JComboBox TeacherOrStudents = new JComboBox();
		TeacherOrStudents.setBounds(inputFrame.getWidth()/2-150, 100, 300, 25);
		TeacherOrStudents.addItem("Teacher");
		TeacherOrStudents.addItem("Student");
		
		inputFrame.add(TeacherOrStudents);
		
		
		
		JLabel username = new JLabel("username", SwingConstants.CENTER);
		username.setBounds(inputFrame.getWidth()/2-150, 150, 300, 50);
		username.setVisible(true);
		inputFrame.add(username);
		
		JTextField usernameEntry = new JTextField();
		usernameEntry.setBounds(inputFrame.getWidth()/2-150, 225, 300, 50);
		usernameEntry.setVisible(true);
		inputFrame.add(usernameEntry);
		
		JLabel password = new JLabel("password", SwingConstants.CENTER);
		password.setBounds(inputFrame.getWidth()/2-150, 300, 300, 50);
		password.setVisible(true);
		inputFrame.add(password);
		
		
		JPasswordField passwordEntry = new JPasswordField();
		passwordEntry.setBounds(inputFrame.getWidth()/2-150, 375, 300, 50);
		passwordEntry.setVisible(true);
		inputFrame.add(passwordEntry);
		
		
		
		
		login.setBounds(inputFrame.getWidth()/2-150,500,100,50);
		login.setVisible(true);
		login.addActionListener(this);
		inputFrame.add(login);
		
		
		signup.setBounds(inputFrame.getWidth()/2+50, 500,100,50);
		signup.setVisible(true);
		signup.addActionListener(this);
		inputFrame.add(signup);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == login){
			
		}
		if (e.getSource() == signup) {
			
		}
	}

}
