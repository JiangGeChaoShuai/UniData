package Displays;

/*
 * Name: Eva Chen 
 * Date: 2020/1/17
 * Course code: ICS4U1-01 Mr.Fernandes
 * Title: Uni-Data Course Application
 * Description: This class sets a gui frame for the student's personal study center. It will get the student # from the login frame and 
 *  			load information of this student, then show them on the info panel. On the main panel there are three buttons, which are 
 *  			current course, credit and  
 * Features: schedule, course selection, 
 * Major Skills: JComponents, buffer reader, scanner, hierarchy, interface, stacking different JPanels on top of each other to create desired look 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import information.CourseInformation;
import information.StudentInformation;
import interfaces.PanelComponenets;
import readFile.ReadFile;

public class StudentCenter implements ActionListener, PanelComponenets {

	// JCompnent
	JFrame mainFrame = new JFrame("Student Center");
	private JPanel mainPanel, infoPanel, currentCoursePanel, creditPanel, addCoursePanel, schedulePanel,
			courseListPanel, addedCoursePanel;
	private JLabel titleLabel, subTitle, photo, nameLabel, birth, studentNum, timeEnroll, email, emailLabel, major,
			scheduleImage, searchLabel, selectCourseLabel, addedCourseLabel, courseName, courseMark;
	private JButton logout, currentCourse, creditInfo, selectCourse, back1, back2, back3, back4, search, addToCourse,
			cancel;
	private JTextField searchBar;
	private JTable schedule;
	private JScrollPane courseList, selectedCourse, addedCourse;
	// set the the selected course panel
	static JPanel selectedCoursePanel = new JPanel();

	// public static ArrayList<ReadFile> courseLibrary; // course cart
	private ArrayList<CourseInformation> courseContainer = new ArrayList<CourseInformation>(); // container for all
																								// filtered courses
	private ArrayList<JButton> courseButtonContainer = new ArrayList<JButton>();

	private ArrayList<CourseButton> allCourses = new ArrayList<CourseButton>();

	// set the frame size
	private int WIDTH = 1200;
	private int HEIGHT = 750;

	// stores the student info
	static StudentInformation thisStudent;

	// read file for testing purpose
	private static ReadFile read = new ReadFile();

	// for testing
	public static void main(String[] args) {

		read.loadInformation();

		StudentCenter window = new StudentCenter(ReadFile.studentAccounts.get(1));

		window.mainFrame.setVisible(true);

	}

	// constructor of class
	public StudentCenter(StudentInformation studentInformation) {

		thisStudent = studentInformation;

		initialize();
		mainFrame.setVisible(true);

	}

	// Initialize all the panels
	private void initialize() {

		//set the main frame 
		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		
		//run the methods which set the other panels
		addMainJCompents();
		addInfoJCompents();
		addCurrentCourseJComponents();
		addCreditInfoJComponents();
		addAddCourseJComponents();

		for (CourseInformation course : ReadFile.courseLibrary) {

			allCourses.add(new CourseButton(course, selectedCoursePanel));
		}

	}

	//add the JComponents on the main panel
	private void addMainJCompents() {

		// add main
		// panel=========================================================================
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(135, 187, 162));
		mainPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		//title of this panel
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

		// the buttons
		currentCourse = new JButton(
				new ImageIcon(new ImageIcon("images/currentCourse.png").getImage().getScaledInstance(180, 180, 0)));
		currentCourse.setBackground(new Color(85, 130, 139));
		currentCourse.setBounds(100, 220, 200, 200);
		currentCourse.addActionListener(this);
		mainPanel.add(currentCourse);

		creditInfo = new JButton(
				new ImageIcon(new ImageIcon("images/credit.png").getImage().getScaledInstance(180, 180, 0)));
		creditInfo.setBackground(new Color(85, 130, 139));
		creditInfo.setBounds(350, 220, 200, 200);
		creditInfo.addActionListener(this);
		mainPanel.add(creditInfo);

		selectCourse = new JButton(
				new ImageIcon(new ImageIcon("images/addCourse.png").getImage().getScaledInstance(180, 180, 0)));
		selectCourse.setBackground(new Color(85, 130, 139));
		selectCourse.setBounds(600, 220, 200, 200);
		selectCourse.addActionListener(this);
		mainPanel.add(selectCourse);

		// set text
		mainFrame.add(mainPanel);
		mainPanel.setVisible(true);

	}

	// set the JComponents on the student info panel
	private void addInfoJCompents() {

		// add info
		// panel============================================================================
		infoPanel = new JPanel(null);
		infoPanel.setBackground(new Color(201, 228, 202));
		infoPanel.setBounds(0, 0, 300, HEIGHT);

		//set the title of this panel
		subTitle = new JLabel("Student Info");
		subTitle.setBounds(0, 0, 300, 50);
		subTitle.setFont(new Font("Aileron", Font.PLAIN, 40));
		subTitle.setForeground(new Color(59, 96, 100));
		subTitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(subTitle);

		//set the photo of the student
		photo = new JLabel(
				new ImageIcon(new ImageIcon("images/student.png").getImage().getScaledInstance(150, 150, 0)));
		photo.setOpaque(true);
		photo.setBounds(75, 65, 150, 150);
		infoPanel.add(photo);

		//set the name 
		nameLabel = new JLabel("Name:" + thisStudent.getName());
		nameLabel.setBounds(10, 230, 300, 40);
		nameLabel.setFont(new Font("Aileron", Font.PLAIN, 25));
		nameLabel.setForeground(new Color(85, 130, 139));
		infoPanel.add(nameLabel);

		//set the birthday
		birth = new JLabel("Birthday:" + thisStudent.getBirthday());
		birth.setBounds(10, 280, 300, 40);
		birth.setFont(new Font("Aileron", Font.PLAIN, 25));
		birth.setForeground(new Color(85, 130, 139));
		infoPanel.add(birth);

		//set the time enroll
		timeEnroll = new JLabel("Time Enrolled:" + thisStudent.getDateEnrolled());
		timeEnroll.setBounds(10, 330, 300, 40);
		timeEnroll.setFont(new Font("Aileron", Font.PLAIN, 25));
		timeEnroll.setForeground(new Color(85, 130, 139));
		infoPanel.add(timeEnroll);

		//set the email
		email = new JLabel("Email:");
		email.setBounds(10, 380, 300, 40);
		email.setFont(new Font("Aileron", Font.PLAIN, 25));
		email.setForeground(new Color(85, 130, 139));
		infoPanel.add(email);
		
		emailLabel = new JLabel(thisStudent.getEmail());
		emailLabel.setBounds(10, 420, 300, 40);
		emailLabel.setFont(new Font("Aileron", Font.PLAIN, 25));
		emailLabel.setForeground(new Color(85, 130, 139));
		infoPanel.add(emailLabel);

		//set the department of the student
		major = new JLabel("Major:" + thisStudent.getDepartment());
		major.setBounds(10, 470, 300, 40);
		major.setFont(new Font("Aileron", Font.PLAIN, 25));
		major.setForeground(new Color(85, 130, 139));
		infoPanel.add(major);

		//set the student number
		studentNum = new JLabel("Student #:   " + thisStudent.getUsername());
		studentNum.setBounds(10, 650, 300, 40);
		studentNum.setFont(new Font("Aileron", Font.PLAIN, 25));
		studentNum.setForeground(new Color(85, 130, 139));
		infoPanel.add(studentNum);

		//add this panel to the main frame
		mainFrame.add(infoPanel);
	}

	//set the JComponents on the current course panel
	private void addCurrentCourseJComponents() {
		// TODO Auto-generated method stub
		// set the panel of current course
		currentCoursePanel = new JPanel();
		currentCoursePanel.setLayout(null);
		currentCoursePanel.setBackground(new Color(135, 187, 162));
		currentCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		// set the title of current course panel
		titleLabel = new JLabel("Current Course:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		currentCoursePanel.add(titleLabel, BorderLayout.CENTER);

		// set the back button on this panel
		back1 = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back1.setBackground(new Color(85, 130, 139));
		back1.setBounds(750, 30, 100, 50);
		back1.addActionListener(this);
		currentCoursePanel.add(back1);

		// add this panel to the main frame
		mainFrame.add(currentCoursePanel);
		currentCoursePanel.setVisible(false);

		// add the course of this student
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(100, 150, 650, 350);
		tablePanel.setBackground(new Color(201, 228, 202));
		// currentCoursePanel.add(tablePanel);

	}

	// for credit info panel
	private void addCreditInfoJComponents() {

		//set the panel size
		creditPanel = new JPanel();
		creditPanel.setLayout(null);
		creditPanel.setBackground(new Color(135, 187, 162));
		creditPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		//set the title of this panel
		titleLabel = new JLabel("Credit:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		creditPanel.add(titleLabel, BorderLayout.CENTER);

		//set the back button
		back2 = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back2.setBackground(new Color(85, 130, 139));
		back2.setBounds(750, 30, 100, 50);
		back2.addActionListener(this);
		creditPanel.add(back2);

		//import the credit information panel
		new CreditPanel(thisStudent, creditPanel);

		//add this panel to the main frame
		mainFrame.add(creditPanel);
		creditPanel.setVisible(false);
	}

	//add the JComponents of the add course panel
	private void addAddCourseJComponents() {

		//set the panel
		addCoursePanel = new JPanel();
		addCoursePanel.setLayout(null);
		addCoursePanel.setBackground(new Color(135, 187, 162));
		addCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		// set the title of future course selection panel
		titleLabel = new JLabel("Add Courses :");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addCoursePanel.add(titleLabel, BorderLayout.CENTER);

		// set the back button on this panel
		back3 = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back3.setBackground(new Color(85, 130, 139));
		back3.setBounds(750, 30, 100, 50);
		back3.addActionListener(this);
		addCoursePanel.add(back3);

		// add the course search JComponents
		searchLabel = new JLabel("Search Course:");
		searchLabel.setBounds(50, 125, 900, 40);
		searchLabel.setFont(new Font("Aileron", Font.PLAIN, 30));
		searchLabel.setForeground(new Color(54, 73, 88));
		searchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addCoursePanel.add(searchLabel, BorderLayout.CENTER);

		searchBar = new JTextField();
		searchBar.setBounds(50, 180, 350, 40);
		searchBar.setFont(new Font("Aileron", Font.PLAIN, 30));
		addCoursePanel.add(searchBar);

		search = new JButton(new ImageIcon(new ImageIcon("images/search.png").getImage().getScaledInstance(35, 35, 0)));
		search.setBounds(410, 180, 40, 40);
		search.setBackground(new Color(85, 130, 139));
		search.addActionListener(this);
		addCoursePanel.add(search);

		// set the list of courses that the student can select
		courseListPanel = new JPanel();
		courseListPanel.setLayout(new BoxLayout(courseListPanel, BoxLayout.Y_AXIS));
		courseListPanel.setBackground(new Color(201, 228, 202));

		courseList = new JScrollPane(courseListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		courseList.setBounds(50, 240, 400, 400);
		addCoursePanel.add(courseList);

		// set the list of courses that student already selected
		selectCourseLabel = new JLabel("Course Details");
		selectCourseLabel.setBounds(480, 190, 350, 40);
		selectCourseLabel.setFont(new Font("Aileron", Font.PLAIN, 30));
		selectCourseLabel.setForeground(new Color(54, 73, 88));
		selectCourseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addCoursePanel.add(selectCourseLabel, BorderLayout.CENTER);

		selectedCoursePanel = new JPanel();
		selectedCoursePanel.setLayout(new BoxLayout(selectedCoursePanel, BoxLayout.Y_AXIS));
		selectedCoursePanel.setBounds(480, 240, 350, 200);
		selectedCoursePanel.setBackground(new Color(201, 228, 202));
		addCoursePanel.add(selectedCoursePanel);

		// add this panel to the main frame
		mainFrame.add(addCoursePanel);
		addCoursePanel.setVisible(false);

		for (int i = 0; i < ReadFile.courseLibrary.size(); i++) {
			addCourseToScrollPanel(ReadFile.courseLibrary.get(i));
		}

	}

	// method that searches a course that contains the text entered on the search
	// field
	public void search() {

		System.out.println("abc");

		// makes sure that there are text on the text field to search
		if (searchBar.getText().length() > 0) {

			// temporary array to store the filtered courses
			ArrayList<CourseInformation> searchedCourseContainer = new ArrayList<CourseInformation>();

			// remove all the buttons from the course list panel and clear
			// courseButtonContainer
			for (JButton courseButton : courseButtonContainer) {

				courseListPanel.remove(courseButton);

			}

			courseButtonContainer.clear();

			// search through the storage to see if any courses contains the text on the
			// search field
			for (CourseInformation course : ReadFile.courseLibrary) {
				if (course.getClassName().toLowerCase().contains(searchBar.getText().toLowerCase())) {

					searchedCourseContainer.add(course);

				} else if (course.getClassCode().toLowerCase().contains(searchBar.getText().toLowerCase())) {

					searchedCourseContainer.add(course);

				}

			}

			// update the course container to the filtered one
			courseContainer = searchedCourseContainer;

			// add the filters buttons back to the course panel
			for (CourseInformation course : courseContainer) {

				addCourseToScrollPanel(course);

			}

			// update the screen to display changes
			courseList.revalidate();
			courseList.repaint();

		} else {

			// remove all the current courses in the course panel
			for (JButton courseButton : courseButtonContainer) {

				courseListPanel.remove(courseButton);

			}

			courseButtonContainer.clear();

			// if the user clears the search, then display all the courses

			for (CourseInformation course : ReadFile.courseLibrary) {
				courseContainer.add(new CourseInformation(course));
			}

			// add the filters buttons back to the course panel
			for (CourseInformation course : courseContainer) {

				addCourseToScrollPanel(course);

			}

			// update the screen to display changes
			courseContainer.clear();
			courseList.revalidate();
			courseList.repaint();

		}

	}

	// add the different course buttons in,
	public void addCourseToScrollPanel(CourseInformation course) {

		System.out.println(ReadFile.courseLibrary.size());
		for (CourseButton courseButton : allCourses) {

			if (courseButton.getCourse().getClassCode().equals(course.getClassCode())) {
				courseButtonContainer.add(courseButton.addCourseButton());
				courseListPanel.add(courseButton.addCourseButton());
			}

		}

	}

	//set the action of the buttons
	public void actionPerformed(ActionEvent e) {

		// button to log out
		if (e.getSource() == logout) {
			new LoginFrame();
			mainFrame.dispose();

		// button to get to schedule panel
		} else if (e.getSource() == currentCourse) {

			SchedulePanel schedules = new SchedulePanel(thisStudent);
			currentCoursePanel.add(schedules.getPanel());
			mainPanel.setVisible(false);
			currentCoursePanel.setVisible(true);
			
			//button to go back to the main panel
		} else if (e.getSource() == back1) {
			mainPanel.setVisible(true);
			currentCoursePanel.setVisible(false);

			//button to go to the credit panel
		} else if (e.getSource() == creditInfo) {
			mainPanel.setVisible(false);
			creditPanel.setVisible(true);

			//button to go back to the main panel
		} else if (e.getSource() == back2) {
			mainPanel.setVisible(true);
			creditPanel.setVisible(false);

			//button to go to the add course panel
		} else if (e.getSource() == selectCourse) {
			search();
			mainPanel.setVisible(false);
			addCoursePanel.setVisible(true);

			//button to go back to the main panel
		} else if (e.getSource() == back3) {
			StudentCenter.selectedCoursePanel.removeAll();
			StudentCenter.selectedCoursePanel.revalidate();
			StudentCenter.selectedCoursePanel.repaint();
			mainPanel.setVisible(true);
			addCoursePanel.setVisible(false);
			
			//button to run the search method
		} else if (e.getSource() == search) {
			System.out.println("search");
			courseListPanel.removeAll();
			search();
		}

	}

}
