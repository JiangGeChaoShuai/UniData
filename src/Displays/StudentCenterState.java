package Displays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class StudentCenterState {

	//JCompnent
	private JFrame mainFrame = new JFrame("Student Center");
	private JPanel panel, infoPanel;
	private JLabel titleLabel, subTitle, photo, nameLabel, birth, studentNum, timeEnroll, email, major;
	private JButton logout, currentCourse, creditInfo, selectCourse;

	private int WIDTH = 1200;
	private int HEIGHT = 750;

	public static void main(String[] args) {

		StudentCenterState window = new StudentCenterState();

		window.mainFrame.setVisible(true);

	}

	public StudentCenterState() {

		initialize();
	}

	private void initialize() {

		mainFrame.setSize(WIDTH, HEIGHT);
		addJCompents();
		addInfoJCompents();

	}

	private void addJCompents() {

		mainFrame.setLayout(null);

		// add main
		// panel=========================================================================
		panel = new JPanel();
		panel.setBackground(new Color(135, 187, 162));
		panel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Student Center");
		titleLabel.setBounds(0, 0, 900, 60);
		titleLabel.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 55));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setVisible(true);

		panel.add(titleLabel, BorderLayout.CENTER);
		panel.setVisible(true);
		
		//the buttons
		currentCourse = new JButton("Current Course");
		currentCourse.setForeground(Color.white);
		currentCourse.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		currentCourse.setBackground(new Color(85, 130, 139));
		currentCourse.setBounds(30, 100, 60, 40);
		panel.add(currentCourse);

		creditInfo = new JButton("Credits Info");
		creditInfo.setForeground(Color.white);
		creditInfo.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		creditInfo.setBackground(new Color(85, 130, 139));
		creditInfo.setBounds(30, 180, 60, 40);
		panel.add(creditInfo);

		selectCourse = new JButton("Select future courses");
		selectCourse.setForeground(Color.white);
		selectCourse.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		selectCourse.setBackground(new Color(85, 130, 139));
		selectCourse.setBounds(30, 260, 60, 40);
		panel.add(selectCourse);

		// set text
		mainFrame.add(panel);

	}

	private void addInfoJCompents() {
		// TODO Auto-generated method stub

		// add info
		// panel============================================================================
		infoPanel = new JPanel(null);
		infoPanel.setBackground(new Color(201, 228, 202));
		infoPanel.setBounds(0, 0, 300, HEIGHT);

		subTitle = new JLabel("Student Info");
		subTitle.setBounds(0, 0, 300, 50);
		subTitle.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 45));
		subTitle.setForeground(new Color(85, 130, 139));
		subTitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(subTitle);

		photo = new JLabel(
				new ImageIcon(new ImageIcon("images/student.png").getImage().getScaledInstance(150, 150, 0)));
		photo.setOpaque(true);
		photo.setBounds(75, 65, 150, 150);
		infoPanel.add(photo);

		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10, 230, 300, 40);
		nameLabel.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		nameLabel.setForeground(new Color(85, 130, 139));
		infoPanel.add(nameLabel);

		birth = new JLabel("Birthday:");
		birth.setBounds(10, 290, 300, 40);
		birth.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		birth.setForeground(new Color(85, 130, 139));
		infoPanel.add(birth);

		timeEnroll = new JLabel("Time Enrolled:");
		timeEnroll.setBounds(10, 340, 300, 40);
		timeEnroll.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		timeEnroll.setForeground(new Color(85, 130, 139));
		infoPanel.add(timeEnroll);

		email = new JLabel("Email:");
		email.setBounds(10, 400, 300, 40);
		email.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		email.setForeground(new Color(85, 130, 139));
		infoPanel.add(email);

		major = new JLabel("Major:");
		major.setBounds(10, 460, 300, 40);
		major.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		major.setForeground(new Color(85, 130, 139));
		infoPanel.add(major);

		studentNum = new JLabel("Student #:");
		studentNum.setBounds(10, 650, 300, 40);
		studentNum.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		studentNum.setForeground(new Color(85, 130, 139));
		infoPanel.add(studentNum);

		mainFrame.add(infoPanel);
	}

}
