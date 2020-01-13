package Displays;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;

import javax.swing.*;

import readFile.ReadFile;
import readFile.SaveFile;
import readFile.StudentInformation;
import readFile.TeacherInformation;

public class SignUpFrame implements ActionListener {

	private static JPanel mainPanel = new JPanel();
	private static JPanel topPanel = new JPanel();
	private static JPanel signUpPanel = new JPanel();

	private static LocalDate currentdate = LocalDate.now();

	private static JScrollPane scrollPane = new JScrollPane();

	private static JButton createAccounts = new JButton("Create Account");

	@SuppressWarnings("rawtypes")
	private static JComboBox type = new JComboBox();

	@SuppressWarnings("rawtypes")
	private static JComboBox majorEntry = new JComboBox();

	private static JComboBox birthdayEntry = new JComboBox();
	private static JComboBox birthMonthEntry = new JComboBox();
	private static JComboBox birthYearEntry = new JComboBox();

	private static JTextField usernameEntry = new JTextField("enter username");

	private static JPasswordField passwordEntry = new JPasswordField();
	private static JPasswordField confirmPasswordEntry = new JPasswordField();

	private static JTextField firstName = new JTextField("first name");
	private static JTextField lastName = new JTextField("last name");

	private static JTextField emailEntry = new JTextField("enter email");

	private static JButton goBack = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));

	public SignUpFrame() {

		initalize();

	}

	private void initalize() {

		createJComponents();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		topPanel.setLayout(null);
		topPanel.setBackground(new Color(135, 187, 162));

		topPanel.setMinimumSize(new Dimension(LoginFrame.width, 100));
		topPanel.setMaximumSize(new Dimension(LoginFrame.width, 100));
		topPanel.setPreferredSize(new Dimension(LoginFrame.width, 100));

		goBack.setBounds(LoginFrame.width-200, 25, 100, 50);
		goBack.addActionListener(this);
		goBack.setFont(new Font("Aileron", Font.PLAIN, 30));
		goBack.setAlignmentX(Component.CENTER_ALIGNMENT);
		goBack.setForeground(new Color(255, 255, 255));
		goBack.setBackground(new Color(54, 73, 88));

		topPanel.add(goBack);

		JLabel title = new JLabel("SIGN UP", SwingConstants.CENTER);
		title.setFont(new Font("Aileron", Font.PLAIN, 45));
		title.setBounds(LoginFrame.width / 2 - 150, 25, 300, 50);
		title.setForeground(new Color(59, 96, 100));
		topPanel.add(title);

		createAccounts.addActionListener(this);

		mainPanel.add(topPanel);
		mainPanel.add(scrollPane);

	}

	@SuppressWarnings("unchecked")
	private static void createJComponents() {

		Font font = new Font("Aileron", Font.PLAIN, 30);
		Font font2 = new Font("Aileron", Font.PLAIN, 15);

		Dimension spacing = new Dimension(0, 25);

		signUpPanel.setLayout(new BoxLayout(signUpPanel, BoxLayout.Y_AXIS));
		signUpPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

		String[] typeOfAccount = {"Student", "Teacher"};
		
		type.setMinimumSize(new Dimension(300, 30));
		type.setMaximumSize(new Dimension(300, 30));
		type.setPreferredSize(new Dimension(300, 30));
		type.setFont(font2);
		type.setAlignmentX(Component.CENTER_ALIGNMENT);
		type.setModel(new DefaultComboBoxModel(typeOfAccount));

		JLabel username = new JLabel("username");
		username.setFont(font);
		username.setForeground(new Color(59, 96, 100));
		username.setAlignmentX(Component.CENTER_ALIGNMENT);

		usernameEntry.setMinimumSize(new Dimension(300, 50));
		usernameEntry.setMaximumSize(new Dimension(300, 50));
		usernameEntry.setPreferredSize(new Dimension(300, 50));
		usernameEntry.setFont(font2);

		JLabel password = new JLabel("password");
		password.setFont(font);
		password.setForeground(new Color(59, 96, 100));
		password.setAlignmentX(Component.CENTER_ALIGNMENT);

		passwordEntry.setMinimumSize(new Dimension(300, 50));
		passwordEntry.setMaximumSize(new Dimension(300, 50));
		passwordEntry.setPreferredSize(new Dimension(300, 50));
		passwordEntry.setFont(font2);

		JLabel confirmPassword = new JLabel("confirm password");
		confirmPassword.setFont(font);
		confirmPassword.setForeground(new Color(59, 96, 100));
		confirmPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

		confirmPasswordEntry.setMinimumSize(new Dimension(300, 50));
		confirmPasswordEntry.setMaximumSize(new Dimension(300, 50));
		confirmPasswordEntry.setPreferredSize(new Dimension(300, 50));
		confirmPasswordEntry.setFont(font2);

		JLabel name = new JLabel("name");
		name.setFont(font);
		name.setForeground(new Color(59, 96, 100));
		name.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		namePanel.setMinimumSize(new Dimension(300, 50));
		namePanel.setMaximumSize(new Dimension(300, 50));
		namePanel.setPreferredSize(new Dimension(300, 50));
		namePanel.setBackground(new Color(201, 228, 202));

		firstName.setMinimumSize(new Dimension(150, 50));
		firstName.setMaximumSize(new Dimension(150, 50));
		firstName.setPreferredSize(new Dimension(150, 50));
		firstName.setFont(font2);

		lastName.setMinimumSize(new Dimension(150, 50));
		lastName.setMaximumSize(new Dimension(150, 50));
		lastName.setPreferredSize(new Dimension(150, 50));
		lastName.setFont(font2);

		namePanel.add(firstName);
		namePanel.add(lastName);

		JLabel Birthday = new JLabel("Birthday");
		Birthday.setFont(font);
		Birthday.setForeground(new Color(59, 96, 100));
		Birthday.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel birthdayPanel = new JPanel();
		birthdayPanel.setLayout(new BoxLayout(birthdayPanel, BoxLayout.X_AXIS));
		birthdayPanel.setMinimumSize(new Dimension(300, 30));
		birthdayPanel.setMaximumSize(new Dimension(300, 30));
		birthdayPanel.setPreferredSize(new Dimension(300, 30));
		birthdayPanel.setBackground(new Color(201, 228, 202));

		birthdayEntry.setMinimumSize(new Dimension(75, 30));
		birthdayEntry.setMaximumSize(new Dimension(75, 30));
		birthdayEntry.setPreferredSize(new Dimension(75, 30));
		birthdayEntry.setFont(font2);

		birthMonthEntry.setMinimumSize(new Dimension(75, 30));
		birthMonthEntry.setMaximumSize(new Dimension(75, 30));
		birthMonthEntry.setPreferredSize(new Dimension(75, 30));
		birthMonthEntry.setFont(font2);

		birthYearEntry.setMinimumSize(new Dimension(150, 30));
		birthYearEntry.setMaximumSize(new Dimension(150, 30));
		birthYearEntry.setPreferredSize(new Dimension(150, 30));
		birthYearEntry.setFont(font2);

		String[] day = new String[32];
		day[0] = "DD";

		for (int i = 1; i < 32; i++) {
			day[i] = String.format("%02d", i);
		}
		birthdayEntry.setModel(new DefaultComboBoxModel(day));

		String[] month = new String[13];
		month[0] = "MM";

		for (int i = 1; i < 13; i++) {
			month[i] = String.format("%02d", i);
		}
		birthMonthEntry.setModel(new DefaultComboBoxModel(month));

		String[] year = new String[101];
		year[0] = "YYYY";

		for (int i = 1; i < 101; i++) {
			year[i] = String.format("%04d", i + 1919);
		}
		birthYearEntry.setModel(new DefaultComboBoxModel(year));

		birthdayPanel.add(birthdayEntry);
		birthdayPanel.add(birthMonthEntry);
		birthdayPanel.add(birthYearEntry);
		birthdayPanel.setVisible(true);

		JLabel email = new JLabel("email");
		email.setFont(font);
		email.setForeground(new Color(59, 96, 100));
		email.setAlignmentX(Component.CENTER_ALIGNMENT);

		emailEntry.setMinimumSize(new Dimension(300, 50));
		emailEntry.setMaximumSize(new Dimension(300, 50));
		emailEntry.setPreferredSize(new Dimension(300, 50));
		emailEntry.setFont(font2);

		JLabel major = new JLabel("major");
		major.setFont(font);
		major.setForeground(new Color(59, 96, 100));
		major.setAlignmentX(Component.CENTER_ALIGNMENT);

		String[] majorTypes = {"Mathematics", "Computer Science"};
		
		majorEntry.setMinimumSize(new Dimension(300, 30));
		majorEntry.setMaximumSize(new Dimension(300, 30));
		majorEntry.setPreferredSize(new Dimension(300, 30));
		majorEntry.setFont(font2);
		majorEntry.setAlignmentX(Component.CENTER_ALIGNMENT);
		majorEntry.setModel(new DefaultComboBoxModel(majorTypes));

		createAccounts.setMinimumSize(new Dimension(300, 50));
		createAccounts.setMaximumSize(new Dimension(300, 50));
		createAccounts.setPreferredSize(new Dimension(300, 50));
		createAccounts.setFont(new Font("Aileron", Font.PLAIN, 30));
		createAccounts.setAlignmentX(Component.CENTER_ALIGNMENT);
		createAccounts.setForeground(new Color(255, 255, 255));
		createAccounts.setBackground(new Color(54, 73, 88));

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
		signUpPanel.add(birthdayPanel);
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

		if (e.getSource() == goBack) {
//			mainPanel.removeAll();
//			signUpPanel.removeAll();
			
			LoginFrame.Frame.remove(mainPanel);
			LoginFrame.setFrameVisible();
		}
		if (e.getSource() == createAccounts) {

			checkValidity();

			// add error checking
		}

	}

	private void checkValidity() {

		String x = (String) type.getSelectedItem();

		if (x.equals("Student")) {

			if (usernameEntry.getText().equals(null)) {

				usernameEntry.setText("enter username");
				JOptionPane.showMessageDialog(signUpPanel, "username can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				System.out.println("abc");
				return;
			}

			if (usernameEntry.getText().equals("enter username")) {

				JOptionPane.showMessageDialog(signUpPanel, "username can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				System.out.println("abcd");
				return;
			}

			for (int i = 0; i < ReadFile.studentAccounts.size(); i++) {

				if (usernameEntry.getText().equals(ReadFile.studentAccounts.get(i).getUsername())) {

					JOptionPane.showMessageDialog(signUpPanel, "username taken!!!", "input error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}

			if (String.valueOf(passwordEntry.getPassword()).equals(null)) {

				JOptionPane.showMessageDialog(signUpPanel, "password can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (String.valueOf(confirmPasswordEntry.getPassword()).equals(null)) {

				JOptionPane.showMessageDialog(signUpPanel, "confirm password can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (!String.valueOf(passwordEntry.getPassword()).equals(String.valueOf(confirmPasswordEntry.getPassword()))) {

				System.out.println(String.valueOf(passwordEntry.getPassword()));
				System.out.println(String.valueOf(confirmPasswordEntry.getPassword()));
				JOptionPane.showMessageDialog(signUpPanel, "password entry and confirm password entry does not equal!!!",
						"input error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (firstName.getText().equals(null)) {

				firstName.setText("first name");
				JOptionPane.showMessageDialog(signUpPanel, "first name entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (firstName.getText().equals("first name")) {

				JOptionPane.showMessageDialog(signUpPanel, "first name entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (lastName.getText().equals(null)) {

				lastName.setText("last name");
				JOptionPane.showMessageDialog(signUpPanel, "last name can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (lastName.getText().equals("last name")) {

				JOptionPane.showMessageDialog(signUpPanel, "last name can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);

				return;
			}

			if (birthdayEntry.getSelectedItem().equals("DD")) {

				JOptionPane.showMessageDialog(signUpPanel, "birthday entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
			
				return;
				}
			
			if (birthMonthEntry.getSelectedItem().equals("MM")) {

				JOptionPane.showMessageDialog(signUpPanel, "birth month entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
			
				return;
				}
			
			if (birthYearEntry.getSelectedItem().equals("YYYY")) {


				JOptionPane.showMessageDialog(signUpPanel, "birth month entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}


			if (emailEntry.getText().equals(null)) {

				emailEntry.setText("enter Email");
				JOptionPane.showMessageDialog(signUpPanel, "email entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (emailEntry.getText().equals("enter Email")) {

				JOptionPane.showMessageDialog(signUpPanel, "email entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			
			String name = firstName.getText().replaceAll(" ", "") + " " + lastName.getText().replaceAll(" ", "");
			String birthday = birthYearEntry.getSelectedItem() + "/" + birthMonthEntry.getSelectedItem() + "/" + birthdayEntry.getSelectedItem();
			String enrollDate = currentdate.getYear() + "/" + String.format("%02d", currentdate.getMonthValue());
			ReadFile.studentAccounts.add(new StudentInformation(usernameEntry.getText(),
					String.valueOf(passwordEntry.getPassword()), name,birthday,emailEntry.getText(), enrollDate, String.valueOf(majorEntry.getSelectedItem())));
		}
		
		
		else if (x.equals("Teacher")) {

			if (usernameEntry.getText().equals(null)) {

				usernameEntry.setText("enter username");
				JOptionPane.showMessageDialog(signUpPanel, "username can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (usernameEntry.getText().equals("enter username")) {

				JOptionPane.showMessageDialog(signUpPanel, "username can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			for (int i = 0; i < ReadFile.teacherAccounts.size(); i++) {

				if (usernameEntry.getText().equals(ReadFile.teacherAccounts.get(i).getUsername())) {

					JOptionPane.showMessageDialog(signUpPanel, "username taken!!!", "input error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}

			if (String.valueOf(passwordEntry.getPassword()).equals(null)) {

				JOptionPane.showMessageDialog(signUpPanel, "password can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (String.valueOf(confirmPasswordEntry.getPassword()).equals(null)) {

				JOptionPane.showMessageDialog(signUpPanel, "confirm password can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (!String.valueOf(passwordEntry.getPassword()).equals(String.valueOf(confirmPasswordEntry.getPassword()))) {

				System.out.println(String.valueOf(passwordEntry.getPassword()));
				System.out.println(String.valueOf(confirmPasswordEntry.getPassword()));
				JOptionPane.showMessageDialog(signUpPanel, "password entry and confirm password entry does not equal!!!",
						"input error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (firstName.getText().equals(null)) {

				firstName.setText("first name");
				JOptionPane.showMessageDialog(signUpPanel, "first name entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (firstName.getText().equals("first name")) {

				JOptionPane.showMessageDialog(signUpPanel, "first name entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (lastName.getText().equals(null)) {

				lastName.setText("last name");
				JOptionPane.showMessageDialog(signUpPanel, "last name can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (lastName.getText().equals("last name")) {

				JOptionPane.showMessageDialog(signUpPanel, "last name can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);

				return;
			}

			if (birthdayEntry.getSelectedItem().equals("DD")) {

				JOptionPane.showMessageDialog(signUpPanel, "birthday entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
			
				return;
				}
			
			if (birthMonthEntry.getSelectedItem().equals("MM")) {

				JOptionPane.showMessageDialog(signUpPanel, "birth month entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
			
				return;
				}
			
			if (birthYearEntry.getSelectedItem().equals("YYYY")) {


				JOptionPane.showMessageDialog(signUpPanel, "birth month entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}


			if (emailEntry.getText().equals(null)) {

				emailEntry.setText("enter Email");
				JOptionPane.showMessageDialog(signUpPanel, "email entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (emailEntry.getText().equals("enter Email")) {

				JOptionPane.showMessageDialog(signUpPanel, "email entry can not be empty!!!", "input error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			
			String name = firstName.getText().replaceAll(" ", "") + " " + lastName.getText().replaceAll(" ", "");
			String birthday = birthYearEntry.getSelectedItem() + "/" + birthMonthEntry.getSelectedItem() + "/" + birthdayEntry.getSelectedItem();

			ReadFile.teacherAccounts.add(new TeacherInformation(usernameEntry.getText(),
					String.valueOf(passwordEntry.getPassword()), name, birthday, emailEntry.getText(),  String.valueOf(majorEntry.getSelectedItem())));
		
		}
		SaveFile.SaveInformation();
		JOptionPane.showMessageDialog(signUpPanel, "account created!!!");
	}

	
}
