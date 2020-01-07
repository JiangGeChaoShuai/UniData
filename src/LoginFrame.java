import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginFrame {

	private JFrame inputFrame = new JFrame();

	public static void main(String[] args) {

		LoginFrame window = new LoginFrame();

		window.inputFrame.setVisible(true);

	}

	public LoginFrame() {

		initialize();
	}

	private void initialize() {

		inputFrame.setSize(1280, 800);
		createLayout();

	}

	private void createLayout() {

		inputFrame.setLayout(null);

		JLabel title = new JLabel("Login Frame",SwingConstants.CENTER);
		title.setBounds(inputFrame.getWidth()/2-150, 50, 300, 50);
		title.setVisible(true);
		inputFrame.add(title);
		
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
		
		
		
		
		
	}

}
