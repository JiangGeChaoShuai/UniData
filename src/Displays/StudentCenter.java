package Displays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class StudentCenter implements ActionListener {

	//JCompnent
	private JFrame mainFrame = new JFrame("Student Center");
	private JPanel mainPanel, infoPanel,currentCoursePanel,creditPanel,futureCoursePanel;
	private JLabel titleLabel, subTitle, photo, nameLabel, birth, studentNum, timeEnroll, email, major;
	private JButton logout, currentCourse, creditInfo, selectCourse,schedule,back;
	
	private int WIDTH = 1200;
	private int HEIGHT = 750;

	public static void main(String[] args) {

		StudentCenter window = new StudentCenter();

		window.mainFrame.setVisible(true);

	}

	public StudentCenter() {

		initialize();
	}

	private void initialize() {

		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		addMainJCompents();
		addInfoJCompents();
		addCurrentCourse();
		addCreditInfoJComponents();
		addFutureCourse();

	}

	private void addMainJCompents() {

		// add main
		// panel=========================================================================
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(135, 187, 162));
		mainPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Student Center");
		titleLabel.setBounds(0, 40, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 55));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(titleLabel, BorderLayout.CENTER);
		
		// log out button
		logout = new JButton("Log Out");
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(85, 130, 139));
		logout.setFont(new Font("Aileron", Font.PLAIN, 30));
		logout.setBounds(700, 45, 150, 50);
		logout.addActionListener(this);
		mainPanel.add(logout);
		
		//the buttons
		currentCourse = new JButton(new ImageIcon(new ImageIcon("images/currentCourse.png").getImage().getScaledInstance(180, 180, 0)));
		currentCourse.setBackground(new Color(85, 130, 139));
		currentCourse.setBounds(100, 200, 200, 200);
		currentCourse.addActionListener(this);
		mainPanel.add(currentCourse);

		creditInfo = new JButton(new ImageIcon(new ImageIcon("images/credit.png").getImage().getScaledInstance(180, 180, 0)));
		creditInfo.setBackground(new Color(85, 130, 139));
		creditInfo.setBounds(350, 200, 200, 200);
		creditInfo.addActionListener(this);
		mainPanel.add(creditInfo);

		selectCourse = new JButton(new ImageIcon(new ImageIcon("images/futureCourse.png").getImage().getScaledInstance(180, 180, 0)));
		selectCourse.setBackground(new Color(85, 130, 139));
		selectCourse.setBounds(600, 200, 200, 200);
		selectCourse.addActionListener(this);
		mainPanel.add(selectCourse);
		
		schedule = new JButton(new ImageIcon(new ImageIcon("images/schedule.png").getImage().getScaledInstance(180, 80, 0)));
		schedule.setBackground(new Color(85, 130, 139));
		schedule.setBounds(100, 450, 200, 100);
		schedule.addActionListener(this);
		mainPanel.add(schedule);

		// set text
		mainFrame.add(mainPanel);
		mainPanel.setVisible(true);

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
		subTitle.setFont(new Font("Aileron", Font.PLAIN, 40));
		subTitle.setForeground(new Color(59,96,100));
		subTitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(subTitle);

		photo = new JLabel(
				new ImageIcon(new ImageIcon("images/student.png").getImage().getScaledInstance(150, 150, 0)));
		photo.setOpaque(true);
		photo.setBounds(75, 65, 150, 150);
		infoPanel.add(photo);

		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10, 230, 300, 40);
		nameLabel.setFont(new Font("Aileron", Font.PLAIN, 25));
		nameLabel.setForeground(new Color(85, 130, 139));
		infoPanel.add(nameLabel);

		birth = new JLabel("Birthday:");
		birth.setBounds(10, 290, 300, 40);
		birth.setFont(new Font("Aileron", Font.PLAIN, 25));
		birth.setForeground(new Color(85, 130, 139));
		infoPanel.add(birth);

		timeEnroll = new JLabel("Time Enrolled:");
		timeEnroll.setBounds(10, 340, 300, 40);
		timeEnroll.setFont(new Font("Aileron", Font.PLAIN, 25));
		timeEnroll.setForeground(new Color(85, 130, 139));
		infoPanel.add(timeEnroll);

		email = new JLabel("Email:");
		email.setBounds(10, 400, 300, 40);
		email.setFont(new Font("Aileron", Font.PLAIN, 25));
		email.setForeground(new Color(85, 130, 139));
		infoPanel.add(email);

		major = new JLabel("Major:");
		major.setBounds(10, 460, 300, 40);
		major.setFont(new Font("Aileron", Font.PLAIN, 25));
		major.setForeground(new Color(85, 130, 139));
		infoPanel.add(major);

		studentNum = new JLabel("Student #:");
		studentNum.setBounds(10, 650, 300, 40);
		studentNum.setFont(new Font("Aileron", Font.PLAIN, 25));
		studentNum.setForeground(new Color(85, 130, 139));
		infoPanel.add(studentNum);

		mainFrame.add(infoPanel);
	}
	
	private void addCurrentCourse() {
		// TODO Auto-generated method stub
		currentCoursePanel = new JPanel();
		currentCoursePanel.setLayout(null);
		currentCoursePanel.setBackground(new Color(135, 187, 162));
		currentCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Current Course:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		currentCoursePanel.add(titleLabel, BorderLayout.CENTER);
		
		back = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back.setBackground(new Color(85, 130, 139));
		back.setBounds(750,30,100,50);
		back.addActionListener(this);
		currentCoursePanel.add(back);
		
		mainFrame.add(currentCoursePanel);
		currentCoursePanel.setVisible(false);
		
	}

	private void addCreditInfoJComponents() {
		// TODO Auto-generated method stub
		creditPanel = new JPanel();
		creditPanel.setLayout(null);
		creditPanel.setBackground(new Color(135, 187, 162));
		creditPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);
		
		titleLabel = new JLabel("Credit:");
		titleLabel.setBounds(0, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		creditPanel.add(titleLabel, BorderLayout.CENTER);
		
		back = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back.setBackground(new Color(85, 130, 139));
		back.setBounds(750,30,100,50);
		back.addActionListener(this);
		currentCoursePanel.add(back);
		
		mainFrame.add(creditPanel);
		creditPanel.setVisible(false);
	}

	private void addFutureCourse() {
		// TODO Auto-generated method stub
		futureCoursePanel = new JPanel();
		futureCoursePanel.setLayout(null);
		futureCoursePanel.setBackground(new Color(135, 187, 162));
		futureCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);
		

		titleLabel = new JLabel("Future Course Selection:");
		titleLabel.setBounds(0, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		futureCoursePanel.add(titleLabel, BorderLayout.CENTER);
		
		back = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back.setBackground(new Color(85, 130, 139));
		back.setBounds(750,30,100,50);
		back.addActionListener(this);
		currentCoursePanel.add(back);
		
		mainFrame.add(futureCoursePanel);
		futureCoursePanel.setVisible(false);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logout) {
			new LoginFrame();
		}else if(e.getSource()==back){
			mainPanel.setVisible(true);
			
			currentCoursePanel.setVisible(false);
			creditPanel.setVisible(false);
			futureCoursePanel.setVisible(false);
			
		}else if(e.getSource()==currentCourse) {
			mainPanel.setVisible(false);
			currentCoursePanel.setVisible(true);
			
		}else if(e.getSource()==creditInfo) {
			mainPanel.setVisible(false);
			creditPanel.setVisible(true);
			
		}else if(e.getSource()==selectCourse) {
			mainPanel.setVisible(false);
			futureCoursePanel.setVisible(true);
		}
		
	}

}
