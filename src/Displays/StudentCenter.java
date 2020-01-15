package Displays;

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
import readFile.ReadFile;

public class StudentCenter implements ActionListener {

	// JCompnent
	private JFrame mainFrame = new JFrame("Student Center");
	private JPanel mainPanel, infoPanel, currentCoursePanel, creditPanel, addCoursePanel, schedulePanel,
			courseListPanel, selectedCourseListPanel;
	private JLabel titleLabel, subTitle, photo, nameLabel, birth, studentNum, timeEnroll, email, major, scheduleImage,
			searchLabel, selectCourseLabel, courseName, courseMark;
	private JButton logout, currentCourse, creditInfo, selectCourse, back1, back2, back3, back4, search, addCourse,
			cancel;
	private JTextField searchBar;
	private JTable schedule;
	private JScrollPane courseList, selectedCourse;

	private DefaultTableModel model = null;

	// public static ArrayList<ReadFile> courseLibrary; // course cart
	private ArrayList<CourseInformation> courseStorage; // container for all existing courses
	private ArrayList<CourseInformation> courseContainer = new ArrayList<CourseInformation>(); // container for all
																								// filtered courses
	private ArrayList<JButton> courseButtonContainer = new ArrayList<JButton>();
	private ArrayList<JButton> courseButtonCart;

	private ArrayList<CourseButton> allCourses = new ArrayList<CourseButton>();

	private int WIDTH = 1200;
	private int HEIGHT = 750;
	
	private ReadFile read = new ReadFile();

	public static void main(String[] args) {


		StudentCenter window = new StudentCenter();

		
		ReadFile read = new ReadFile();
		read.loadInformation();
		window.mainFrame.setVisible(true);

	}

	public StudentCenter() {

		// temporary for testing
		
		read.loadInformation();

		initialize();
		mainFrame.setVisible(true);

	}

	private void initialize() {

		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		addMainJCompents();
		addInfoJCompents();
		addCurrentCourseJComponents();
		addCreditInfoJComponents();
		addaddCourseJComponents();

		for (CourseInformation course : ReadFile.courseLibrary) {

			allCourses.add(new CourseButton(course));
		}

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

//		schedule = new JButton(
//				new ImageIcon(new ImageIcon("images/schedule.png").getImage().getScaledInstance(180, 80, 0)));
//		schedule.setBackground(new Color(85, 130, 139));
//		schedule.setBounds(100, 430, 200, 100);
//		schedule.addActionListener(this);
//		mainPanel.add(schedule);

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
		subTitle.setForeground(new Color(59, 96, 100));
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
		currentCoursePanel.add(tablePanel);

//		schedule = new JTable(null);
//		String[][] datas ={ 
//				{"Time", "Monday", "Tuseday", "Wednesday", "Thursday", "Friday" } ,
//				{"4","5","6"}
//		};
//		String[] titles = { "Time", "Monday", "Tuseday", "Wednesday", "Thursday", "Friday" };
//		model = new DefaultTableModel(datas, titles);
//		schedule = new JTable(model);
//		schedule.setBounds(100, 150, 600, 300);
//		schedule.setVisible(true);
//		tablePanel.add(schedule);

		String[] columnNames = { "Time", "Monday", "Tuseday", "Wednesday", "Thursday", "Friday" };
		Object[][] data = { { "8:40 - 11:40:", "Kathy", "Smith", "Snowboarding" },
				{ "13:00 - 16:00", "John", "Doe", "Rowing" }, { "14:00 - 17:00", "Sue", "Black", "Knitting" },
				{ "16:00 - 19:00", "Jane", "White", "Speed reading" }, };

		schedule = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(schedule);
		schedule.setFillsViewportHeight(true);

		TableColumn column = null;
		for (int i = 0; i < 5; i++) {
			column = schedule.getColumnModel().getColumn(i);
			if (i == 2) {
				column.setPreferredWidth(100); // third column is bigger
			} else {
				column.setPreferredWidth(50);
			}
		}

	}

	private void addCreditInfoJComponents() {
		// TODO Auto-generated method stub
		creditPanel = new JPanel();
		creditPanel.setLayout(null);
		creditPanel.setBackground(new Color(135, 187, 162));
		creditPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Credit:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		creditPanel.add(titleLabel, BorderLayout.CENTER);

		back2 = new JButton(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(100, 50, 0)));
		back2.setBackground(new Color(85, 130, 139));
		back2.setBounds(750, 30, 100, 50);
		back2.addActionListener(this);
		creditPanel.add(back2);

		mainFrame.add(creditPanel);
		creditPanel.setVisible(false);
	}

	private void addaddCourseJComponents() {
		// TODO Auto-generated method stub
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
		courseListPanel.setBounds(0, 0, WIDTH, HEIGHT);

		courseList = new JScrollPane(courseListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		courseList.setBounds(50, 240, 400, 400);
		addCoursePanel.add(courseList);

		// set the list of courses that student already selected
		selectCourseLabel = new JLabel("Selected Course");
		selectCourseLabel.setBounds(480, 250, 380, 40);
		selectCourseLabel.setFont(new Font("Aileron", Font.PLAIN, 30));
		selectCourseLabel.setForeground(new Color(54, 73, 88));
		selectCourseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addCoursePanel.add(selectCourseLabel, BorderLayout.CENTER);

		selectedCourseListPanel = new JPanel();
		selectedCourseListPanel.setLayout(new BoxLayout(selectedCourseListPanel, BoxLayout.X_AXIS));
		// selectedCourseListPanel.setBounds(0, 0, WIDTH, HEIGHT);

		selectedCourse = new JScrollPane(selectedCourseListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		selectedCourse.setBounds(480, 300, 380, 300);
		addCoursePanel.add(selectedCourse);

		// add this panel to the main frame
		mainFrame.add(addCoursePanel);
		addCoursePanel.setVisible(false);
		
		for(int i = 0; i<ReadFile.courseLibrary.size(); i++) {
			addCourseToScrollPanel(ReadFile.courseLibrary.get(i));
		}
		

	}

	// method that searches a course that contains the text entered on the search
	// field
	private void search() {

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


			for(CourseInformation course : ReadFile.courseLibrary ) {
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

	private void addCourseToScrollPanel(CourseInformation course) {

		System.out.println(ReadFile.courseLibrary.size());
		for (CourseButton courseButton : allCourses) {

			if (courseButton.getCourse().getClassCode().equals(course.getClassCode())) {
				courseButtonContainer.add(courseButton.addCourseButton());
				courseListPanel.add(courseButton.addCourseButton());
			}

		}

	}
	


	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == logout) {
			new LoginFrame();
		} else if (e.getSource() == currentCourse) {
			mainPanel.setVisible(false);
			currentCoursePanel.setVisible(true);

		} else if (e.getSource() == back1) {
			mainPanel.setVisible(true);
			currentCoursePanel.setVisible(false);

		} else if (e.getSource() == creditInfo) {
			mainPanel.setVisible(false);
			creditPanel.setVisible(true);

		} else if (e.getSource() == back2) {
			mainPanel.setVisible(true);
			creditPanel.setVisible(false);

		} else if (e.getSource() == selectCourse) {
			mainPanel.setVisible(false);
			addCoursePanel.setVisible(true);

		} else if (e.getSource() == back3) {
			mainPanel.setVisible(true);
			addCoursePanel.setVisible(false);

		} else if (e.getSource() == schedule) {
			mainPanel.setVisible(false);
			schedulePanel.setVisible(true);

		} else if (e.getSource() == back4) {
			mainPanel.setVisible(true);
			schedulePanel.setVisible(false);

		} else if (e.getSource() == search) {
			System.out.println("search");
			courseListPanel.removeAll();
			search();
		}

	}

}
