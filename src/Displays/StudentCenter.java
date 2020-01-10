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
	private JPanel mainPanel, infoPanel,currentCoursePanel,creditPanel,futureCoursePanel,schedulePanel,
					courseListPanel,selectedCoursePanel;
	private JLabel titleLabel, subTitle, photo, nameLabel, birth, studentNum, timeEnroll, email, major,scheduleImage,
					courseName,courseMark;
	private JButton logout, currentCourse, creditInfo, selectCourse,schedule,
					back1,back2,back3,back4,search,addCourse,cancel;
	private JTextField searchBar;
	private JScrollPane courseListScrollpane,selectedCourseScrollpane;
	
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
		addCurrentCourseJComponents();
		addCreditInfoJComponents();
		addFutureCourseJComponents();
		addScheduleJComponents();

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
		currentCourse.setBounds(100, 180, 200, 200);
		currentCourse.addActionListener(this);
		mainPanel.add(currentCourse);

		creditInfo = new JButton(new ImageIcon(new ImageIcon("images/credit.png").getImage().getScaledInstance(180, 180, 0)));
		creditInfo.setBackground(new Color(85, 130, 139));
		creditInfo.setBounds(350, 180, 200, 200);
		creditInfo.addActionListener(this);
		mainPanel.add(creditInfo);

		selectCourse = new JButton(new ImageIcon(new ImageIcon("images/futureCourse.png").getImage().getScaledInstance(180, 180, 0)));
		selectCourse.setBackground(new Color(85, 130, 139));
		selectCourse.setBounds(600, 180, 200, 200);
		selectCourse.addActionListener(this);
		mainPanel.add(selectCourse);
		
		schedule = new JButton(new ImageIcon(new ImageIcon("images/schedule.png").getImage().getScaledInstance(180, 80, 0)));
		schedule.setBackground(new Color(85, 130, 139));
		schedule.setBounds(100, 430, 200, 100);
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
	
	private void addCurrentCourseJComponents() {
		// TODO Auto-generated method stub
		//set the panel of current course
		currentCoursePanel = new JPanel();
		currentCoursePanel.setLayout(null);
		currentCoursePanel.setBackground(new Color(135, 187, 162));
		currentCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		//set the title of current course panel
		titleLabel = new JLabel("Current Course:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		currentCoursePanel.add(titleLabel, BorderLayout.CENTER);

		//set the back button on this panel
		back1 = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back1.setBackground(new Color(85, 130, 139));
		back1.setBounds(750,30,100,50);
		back1.addActionListener(this);
		currentCoursePanel.add(back1);
		
		//add this panel to the main frame
		mainFrame.add(currentCoursePanel);
		currentCoursePanel.setVisible(false);
		
		//add the schedule of this student
		

		
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
		
		back2 = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back2.setBackground(new Color(85, 130, 139));
		back2.setBounds(750,30,100,50);
		back2.addActionListener(this);
		creditPanel.add(back2);
		
		mainFrame.add(creditPanel);
		creditPanel.setVisible(false);
	}

	private void addFutureCourseJComponents() {
		// TODO Auto-generated method stub
		futureCoursePanel = new JPanel();
		futureCoursePanel.setLayout(null);
		futureCoursePanel.setBackground(new Color(135, 187, 162));
		futureCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);
		
		//set the title of future course selection panel
		titleLabel = new JLabel("Future Course Selection:");
		titleLabel.setBounds(0, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		futureCoursePanel.add(titleLabel, BorderLayout.CENTER);
		
		//set the back button on this panel
		back3 = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back3.setBackground(new Color(85, 130, 139));
		back3.setBounds(750,30,100,50);
		back3.addActionListener(this);
		futureCoursePanel.add(back3);
		
		//add this panel to the main frame
		mainFrame.add(futureCoursePanel);
		futureCoursePanel.setVisible(false);
		
		searchBar = new JTextField();
		searchBar.setBounds(50,200,200,40);
		searchBar.setFont(new Font("Aileron", Font.PLAIN, 50));
		futureCoursePanel.add(searchBar);
		
		
	}
	
	private void addScheduleJComponents() {
		
		schedulePanel = new JPanel();
		schedulePanel.setLayout(null);
		schedulePanel.setBackground(new Color(135, 187, 162));
		schedulePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);
		
		scheduleImage = new JLabel(new ImageIcon(new ImageIcon("images/scheduleImage.png").getImage().getScaledInstance(100, 100, 0)));
		scheduleImage.setBackground(new Color(85, 130, 139));
		scheduleImage.setBounds(10,10,100,100);
		schedulePanel.add(scheduleImage);
		
		back4 = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back4.setBackground(new Color(85, 130, 139));
		back4.setBounds(750,30,100,50);
		back4.addActionListener(this);
		schedulePanel.add(back4);
		
		mainFrame.add(schedulePanel);
		schedulePanel.setVisible(false);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logout) {
			new LoginFrame();
		}else if(e.getSource()==currentCourse) {
			mainPanel.setVisible(false);
			currentCoursePanel.setVisible(true);
			
		}else if(e.getSource()==back1){
			mainPanel.setVisible(true);
			currentCoursePanel.setVisible(false);
			
		}else if(e.getSource()==creditInfo) {
			mainPanel.setVisible(false);
			creditPanel.setVisible(true);
			
		}else if(e.getSource()==back2){
			mainPanel.setVisible(true);
			creditPanel.setVisible(false);
			
		}else if(e.getSource()==selectCourse) {
			mainPanel.setVisible(false);
			futureCoursePanel.setVisible(true);
			
		}else if(e.getSource()==back3) {
			mainPanel.setVisible(true);
			futureCoursePanel.setVisible(false);
			
		}else if(e.getSource()==schedule) {
			mainPanel.setVisible(false);
			schedulePanel.setVisible(true);
			
		}else if(e.getSource()==back4) {
			mainPanel.setVisible(true);
			schedulePanel.setVisible(false);
			
		}
		
	}

}
