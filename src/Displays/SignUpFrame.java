package Displays;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SignUpFrame implements ActionListener {
	
	private static JPanel mainPanel = new JPanel();
	private static JPanel topPanel = new JPanel();
	private static JPanel signUpPanel = new JPanel();
	
	private static JScrollPane scrollPane = new JScrollPane();
	
	private static JButton createAccounts = new JButton("Create Account");
	
	@SuppressWarnings("rawtypes")
	private static 	JComboBox type = new JComboBox();
	
	@SuppressWarnings("rawtypes")
	private static JComboBox majorEntry = new JComboBox();

	private static JTextField usernameEntry = new JTextField("enter username");
	
	private static JPasswordField passwordEntry = new JPasswordField();
	private static JPasswordField confirmPasswordEntry = new JPasswordField();
	
	private static JTextField firstName = new JTextField("first name");
	private static JTextField lastName = new JTextField("last name");
	
	private static JTextField birthdayEntry = new JTextField("enter birthday");
	
	private static JTextField emailEntry = new JTextField("enter email");
	
	
	
	private static JButton goBack = new JButton("return");
	
	public SignUpFrame() {
		
		initalize();
		
		
	}
	

	private void initalize() {
		
		createJComponents();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		topPanel.setLayout(null);
		topPanel.setBackground(new Color(201, 228, 202));
		
		topPanel.setMinimumSize(new Dimension(LoginFrame.width, 100));
		topPanel.setMaximumSize(new Dimension(LoginFrame.width, 100));
		topPanel.setPreferredSize(new Dimension(LoginFrame.width, 100));
		
		goBack.setBounds(25,25,100,50);
		goBack.addActionListener(this);
		
		
		topPanel.add(goBack);
		
		
		JLabel title = new JLabel("SIGN UP", SwingConstants.CENTER);
		title.setFont(new Font("Aileron", Font.PLAIN, 45));
		title.setBounds(LoginFrame.width/2-150, 25, 300, 50);
		title.setForeground(new Color(59,96,100));
		topPanel.add(title);
		
		

		createAccounts.addActionListener(this);
		
		
		
		mainPanel.add(topPanel);
		mainPanel.add(scrollPane);
		
	}
	
	private static void createJComponents() {
		
		
		Font font = new Font("Aileron", Font.PLAIN, 30);
		Font font2 = new Font("Aileron", Font.PLAIN, 15);
		
		Dimension spacing = new Dimension(0,25);
		
		signUpPanel.setLayout(new BoxLayout(signUpPanel, BoxLayout.Y_AXIS));
		signUpPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

		

		
		type.setMinimumSize(new Dimension(300,30));
		type.setMaximumSize(new Dimension(300,30));
		type.setPreferredSize(new Dimension(300,30));
		type.setFont(font2);
		type.setAlignmentX(Component.CENTER_ALIGNMENT);
		type.addItem("teacher");
		type.addItem("Student");
		
		JLabel username = new JLabel("username");
		username.setFont(font);
		username.setForeground(new Color(59,96,100));
		username.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		usernameEntry.setMinimumSize(new Dimension(300,50));
		usernameEntry.setMaximumSize(new Dimension(300,50));
		usernameEntry.setPreferredSize(new Dimension(300,50));
		usernameEntry.setFont(font2);
		

		JLabel password = new JLabel("password");
		password.setFont(font);
		password.setForeground(new Color(59,96,100));
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		passwordEntry.setMinimumSize(new Dimension(300,50));
		passwordEntry.setMaximumSize(new Dimension(300,50));
		passwordEntry.setPreferredSize(new Dimension(300,50));
		passwordEntry.setFont(font2);
		
		JLabel confirmPassword = new JLabel("confirm password");
		confirmPassword.setFont(font);
		confirmPassword.setForeground(new Color(59,96,100));
		confirmPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		confirmPasswordEntry.setMinimumSize(new Dimension(300,50));
		confirmPasswordEntry.setMaximumSize(new Dimension(300,50));
		confirmPasswordEntry.setPreferredSize(new Dimension(300,50));
		confirmPasswordEntry.setFont(font2);
		
		JLabel name = new JLabel("name");
		name.setFont(font);
		name.setForeground(new Color(59,96,100));
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		namePanel.setMinimumSize(new Dimension(300,50));
		namePanel.setMaximumSize(new Dimension(300,50));
		namePanel.setPreferredSize(new Dimension(300,50));
		namePanel.setBackground(new Color(201, 228, 202));
		
		firstName.setMinimumSize(new Dimension(150,50));
		firstName.setMaximumSize(new Dimension(150,50));
		firstName.setPreferredSize(new Dimension(150,50));
		firstName.setFont(font2);
		
		lastName.setMinimumSize(new Dimension(150,50));
		lastName.setMaximumSize(new Dimension(150,50));
		lastName.setPreferredSize(new Dimension(150,50));
		lastName.setFont(font2);
		
		namePanel.add(firstName);
		namePanel.add(Box.createHorizontalGlue());
		namePanel.add(lastName);
		

		JLabel Birthday = new JLabel("Birthday");
		Birthday.setFont(font);
		Birthday.setForeground(new Color(59,96,100));
		Birthday.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		birthdayEntry.setMinimumSize(new Dimension(300,50));
		birthdayEntry.setMaximumSize(new Dimension(300,50));
		birthdayEntry.setPreferredSize(new Dimension(300,50));
		birthdayEntry.setFont(font2);
		
		JLabel email = new JLabel("email");
		email.setFont(font);
		email.setForeground(new Color(59,96,100));
		email.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		emailEntry.setMinimumSize(new Dimension(300,50));
		emailEntry.setMaximumSize(new Dimension(300,50));
		emailEntry.setPreferredSize(new Dimension(300,50));
		emailEntry.setFont(font2);
		
		JLabel major = new JLabel("major");
		major.setFont(font);
		major.setForeground(new Color(59,96,100));
		major.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		majorEntry.setMinimumSize(new Dimension(300,30));
		majorEntry.setMaximumSize(new Dimension(300,30));
		majorEntry.setPreferredSize(new Dimension(300,30));
		majorEntry.setFont(font2);
		majorEntry.setAlignmentX(Component.CENTER_ALIGNMENT);
		majorEntry.addItem("Computer Science");
		majorEntry.addItem("Mathematics");
		
		createAccounts.setMinimumSize(new Dimension(300,50));
		createAccounts.setMaximumSize(new Dimension(300,50));
		createAccounts.setPreferredSize(new Dimension(300,50));
		createAccounts.setFont(new Font("Aileron", Font.PLAIN, 30));
		createAccounts.setAlignmentX(Component.CENTER_ALIGNMENT);
		createAccounts.setForeground(new Color(255,255,255));
		createAccounts.setBackground(new Color(54,73,88));
		
		signUpPanel.add(type);
		signUpPanel.add(Box.createRigidArea(spacing));
		
		signUpPanel.add(username);
		signUpPanel.add(usernameEntry);
		signUpPanel.add(Box.createRigidArea(spacing));
		
		signUpPanel.add(password);
		signUpPanel.add(passwordEntry);
		signUpPanel.add(Box.createRigidArea(spacing));
		
		signUpPanel.add(confirmPassword);
		signUpPanel.add(confirmPasswordEntry);
		signUpPanel.add(Box.createRigidArea(spacing));
		
		signUpPanel.add(name);
		signUpPanel.add(namePanel);
		signUpPanel.add(Box.createRigidArea(spacing));
		
		signUpPanel.add(Birthday);
		signUpPanel.add(birthdayEntry);
		signUpPanel.add(Box.createRigidArea(spacing));
		
		signUpPanel.add(email);
		signUpPanel.add(emailEntry);
		signUpPanel.add(Box.createRigidArea(spacing));
		
		signUpPanel.add(major);
		signUpPanel.add(majorEntry);
		signUpPanel.add(Box.createRigidArea(spacing));
		

		signUpPanel.add(createAccounts);
		signUpPanel.add(Box.createRigidArea(spacing));
		
		signUpPanel.setBackground(new Color(201, 228, 202));
		scrollPane = new JScrollPane(signUpPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	public static JPanel getPanel() {
		
		return mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource() == goBack) {
			mainPanel.removeAll();
			signUpPanel.removeAll();
			LoginFrame.setFrameVisible();
			
		}
		if(e.getSource() == createAccounts) {
			
			
			//add error checking
		}
		
	}
	
}
