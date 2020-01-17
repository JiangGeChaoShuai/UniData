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
import information.StudentInformation;
import information.TeacherInformation;
import interfaces.PanelComponenets;
import readFile.ReadFile;

public class TeacherCenter implements ActionListener, PanelComponenets {

	// JCompnent
	JFrame mainFrame = new JFrame("Teacher Center");
	private JPanel mainPanel, infoPanel, currentCoursePanel, classroomPanel, addCoursePanel, schedulePanel,
			courseListPanel, addedCoursePanel;
	private JLabel titleLabel, subTitle, photo, nameLabel, birthday, teacherNum, email, emailLabel, major,
			scheduleImage, searchLabel, selectCourseLabel, addedCourseLabel;
	private JButton logout, currentCourse, classroomInfo, selectCourse, back1, back2, back3, back4, search, cancel;
	private JTextField searchBar;
	private JScrollPane courseList, selectedCourse, addedCourse;

	// public static ArrayList<ReadFile> courseLibrary; // course cart
	private ArrayList<CourseInformation> courseContainer = new ArrayList<CourseInformation>(); // container for all
																								// filtered courses
	private ArrayList<JButton> courseButtonContainer = new ArrayList<JButton>();

	private ArrayList<CourseButton> allCourses = new ArrayList<CourseButton>();

	// set the frame size
	private int WIDTH = 1200;
	private int HEIGHT = 750;

	// get the info of teacher from the readfile class
	static TeacherInformation thisTeacher;
	private static ReadFile read = new ReadFile();

	// add the JPanel which in the selected course
	static JPanel selectedCoursePanel = new JPanel();

	// run the file reader
	public static void main(String[] args) {

		read.loadInformation();

		TeacherCenter window = new TeacherCenter(ReadFile.teacherAccounts.get(1));

		window.mainFrame.setVisible(true);

	}

	// set the information of the teacher
	public TeacherCenter(TeacherInformation teacherInformation) {

		// temporary for testing

		thisTeacher = teacherInformation;

		initialize();
		mainFrame.setVisible(true);

	}

	// set the frame size and add the jcomponents
	private void initialize() {

		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);

		// run the method that add the JComponents
		addMainJCompents();
		addInfoJCompents();
		addCurrentCourseJComponents();
		addClassroomInfoJComponents();
		addAddCourseJComponents();

		// load the course file
		for (CourseInformation course : ReadFile.courseLibrary) {

			allCourses.add(new CourseButton(course, selectedCoursePanel));
		}

	}

	// set the JComponents on the main panel
	private void addMainJCompents() {

		// add main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(169, 188, 208));
		mainPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		// the title of the panel
		titleLabel = new JLabel("Teacher Center");
		titleLabel.setBounds(0, 40, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 55));
		titleLabel.setForeground(new Color(59,96,100));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(titleLabel, BorderLayout.CENTER);

		// log out button
		logout = new JButton("Log Out");
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(59,96,100));
		logout.setFont(new Font("Aileron", Font.PLAIN, 30));
		logout.setBounds(700, 45, 150, 50);
		logout.addActionListener(this);
		mainPanel.add(logout);

		// the buttons
		currentCourse = new JButton(
				new ImageIcon(new ImageIcon("images/currentCourse2.png").getImage().getScaledInstance(180, 180, 0)));
		currentCourse.setBackground(new Color(59,96,100));
		currentCourse.setBounds(100, 220, 200, 200);
		currentCourse.addActionListener(this);
		mainPanel.add(currentCourse);

		classroomInfo = new JButton(
				new ImageIcon(new ImageIcon("images/classroom.png").getImage().getScaledInstance(180, 180, 0)));
		classroomInfo.setBackground(new Color(59,96,100));
		classroomInfo.setBounds(350, 220, 200, 200);
		classroomInfo.addActionListener(this);
		mainPanel.add(classroomInfo);

		selectCourse = new JButton(
				new ImageIcon(new ImageIcon("images/addCourse2.png").getImage().getScaledInstance(180, 180, 0)));
		selectCourse.setBackground(new Color(59,96,100));
		selectCourse.setBounds(600, 220, 200, 200);
		selectCourse.addActionListener(this);
		mainPanel.add(selectCourse);

		// add this panel to the main frame
		mainFrame.add(mainPanel);
		mainPanel.setVisible(true);

	}

	private void addInfoJCompents() {
		// TODO Auto-generated method stub

		// add info panel
		infoPanel = new JPanel(null);
		infoPanel.setBackground(new Color(216, 219, 226));
		infoPanel.setBounds(0, 0, 300, HEIGHT);

		// set the title of this panel
		subTitle = new JLabel("Teacher Info");
		subTitle.setBounds(0, 0, 300, 50);
		subTitle.setFont(new Font("Aileron", Font.PLAIN, 40));
		subTitle.setForeground(new Color(85, 130, 139));
		subTitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(subTitle);

		// set the photo of teacher
		photo = new JLabel(
				new ImageIcon(new ImageIcon("images/teacher.png").getImage().getScaledInstance(150, 150, 0)));
		photo.setOpaque(true);
		photo.setBounds(75, 65, 150, 150);
		infoPanel.add(photo);

		// set the name label
		nameLabel = new JLabel("Name:" + thisTeacher.getName());
		nameLabel.setBounds(10, 230, 300, 40);
		nameLabel.setFont(new Font("Aileron", Font.PLAIN, 25));
		nameLabel.setForeground(new Color(85, 130, 139));
		infoPanel.add(nameLabel);

		// set the birthday label
		birthday = new JLabel("Birthday:" + thisTeacher.getBirthday());
		birthday.setBounds(10, 280, 300, 40);
		birthday.setFont(new Font("Aileron", Font.PLAIN, 25));
		birthday.setForeground(new Color(85, 130, 139));
		infoPanel.add(birthday);

		// set the email label
		email = new JLabel("Email:");
		email.setBounds(10, 330, 300, 40);
		email.setFont(new Font("Aileron", Font.PLAIN, 25));
		email.setForeground(new Color(85, 130, 139));
		infoPanel.add(email);

		emailLabel = new JLabel(thisTeacher.getEmail());
		emailLabel.setBounds(10, 380, 300, 40);
		emailLabel.setFont(new Font("Aileron", Font.PLAIN, 25));
		emailLabel.setForeground(new Color(85, 130, 139));
		infoPanel.add(emailLabel);

		// set the department label
		major = new JLabel("Major:" + thisTeacher.getDepartment());
		major.setBounds(10, 420, 300, 40);
		major.setFont(new Font("Aileron", Font.PLAIN, 25));
		major.setForeground(new Color(85, 130, 139));
		infoPanel.add(major);

		// set the teacher number
		teacherNum = new JLabel("Teacher #:   " + thisTeacher.getUsername());
		teacherNum.setBounds(10, 650, 300, 40);
		teacherNum.setFont(new Font("Aileron", Font.PLAIN, 25));
		teacherNum.setForeground(new Color(85, 130, 139));
		infoPanel.add(teacherNum);

		// add this panel to the main frame
		mainFrame.add(infoPanel);
	}

	// set the JComponents in the current course panel
	private void addCurrentCourseJComponents() {
		// TODO Auto-generated method stub
		// set the panel of current course
		currentCoursePanel = new JPanel();
		currentCoursePanel.setLayout(null);
		currentCoursePanel.setBackground(new Color(169, 188, 208));
		currentCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		// set the title of current course panel
		titleLabel = new JLabel("Current Course:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(59,96,100));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		currentCoursePanel.add(titleLabel, BorderLayout.CENTER);

		// set the back button on this panel
		back1 = new JButton(new ImageIcon(new ImageIcon("images/back2.png").getImage().getScaledInstance(100, 50, 0)));
		back1.setBackground(new Color(59,96,100));
		back1.setBounds(750, 30, 100, 50);
		back1.addActionListener(this);
		currentCoursePanel.add(back1);

		// add this panel to the main frame
		mainFrame.add(currentCoursePanel);
		currentCoursePanel.setVisible(false);

	}

	// set the JComponents in the classroom panel
	private void addClassroomInfoJComponents() {
		// TODO Auto-generated method stub
		// set the classroom panel
		classroomPanel = new JPanel();
		classroomPanel.setLayout(null);
		classroomPanel.setBackground(new Color(169, 188, 208));
		classroomPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		// set the title of this panel
		titleLabel = new JLabel("Classroom:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(59,96,100));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		classroomPanel.add(titleLabel, BorderLayout.CENTER);

		// set the back button
		back2 = new JButton(new ImageIcon(new ImageIcon("images/back2.png").getImage().getScaledInstance(100, 50, 0)));
		back2.setBackground(new Color(59,96,100));
		back2.setBounds(750, 30, 100, 50);
		back2.addActionListener(this);
		classroomPanel.add(back2);

		// add this panel to the main frame
		mainFrame.add(classroomPanel);
		classroomPanel.setVisible(false);
	}

	// set the JComponents of the add Course panel
	private void addAddCourseJComponents() {
		// TODO Auto-generated method stub
		addCoursePanel = new JPanel();
		addCoursePanel.setLayout(null);
		addCoursePanel.setBackground(new Color(169, 188, 208));
		addCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		// set the title of future course selection panel
		titleLabel = new JLabel("Add Courses :");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(59,96,100));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addCoursePanel.add(titleLabel, BorderLayout.CENTER);

		// set the back button on this panel
		back3 = new JButton(new ImageIcon(new ImageIcon("images/back2.png").getImage().getScaledInstance(100, 50, 0)));
		back3.setBackground(new Color(59,96,100));
		back3.setBounds(750, 30, 100, 50);
		back3.addActionListener(this);
		addCoursePanel.add(back3);

		// add the course search JComponents
		// set the title
		searchLabel = new JLabel("Search Course:");
		searchLabel.setBounds(50, 125, 900, 40);
		searchLabel.setFont(new Font("Aileron", Font.PLAIN, 30));
		searchLabel.setForeground(new Color(59,96,100));
		searchLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addCoursePanel.add(searchLabel, BorderLayout.CENTER);

		// set the text field
		searchBar = new JTextField();
		searchBar.setBounds(50, 180, 350, 40);
		searchBar.setFont(new Font("Aileron", Font.PLAIN, 30));
		addCoursePanel.add(searchBar);

		// set the search button
		search = new JButton(new ImageIcon(new ImageIcon("images/search2.png").getImage().getScaledInstance(35, 35, 0)));
		search.setBounds(410, 180, 40, 40);
		search.setBackground(new Color(59,96,100));
		search.addActionListener(this);
		addCoursePanel.add(search);

		// set the list of courses that the teacher can select
		courseListPanel = new JPanel();
		courseListPanel.setLayout(new BoxLayout(courseListPanel, BoxLayout.Y_AXIS));
		courseListPanel.setBackground(new Color(216, 219, 226));

		courseList = new JScrollPane(courseListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		courseList.setBounds(50, 240, 400, 400);
		addCoursePanel.add(courseList);

		// set the details of courses that teacher already selected
		// set title
		selectCourseLabel = new JLabel("Course Details");
		selectCourseLabel.setBounds(505, 190, 350, 40);
		selectCourseLabel.setFont(new Font("Aileron", Font.PLAIN, 30));
		selectCourseLabel.setForeground(new Color(59,96,100));
		selectCourseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addCoursePanel.add(selectCourseLabel, BorderLayout.CENTER);

		// set info label
		selectedCoursePanel = new JPanel();
		selectedCoursePanel.setBounds(505, 240, 350, 200);
		selectedCoursePanel.setBackground(new Color(216, 219, 226));
		addCoursePanel.add(selectedCoursePanel);

		// add this panel to the main frame
		mainFrame.add(addCoursePanel);
		addCoursePanel.setVisible(false);

		// load the course library file
		for (int i = 0; i < ReadFile.courseLibrary.size(); i++) {
			addCourseToScrollPanel(ReadFile.courseLibrary.get(i));
		}

	}

	// method that searches a course that contains the text entered on the search
	// field
	@Override
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

	// add the course selected to the JScrollPane
	@Override
	public void addCourseToScrollPanel(CourseInformation course) {

		for (CourseButton courseButton : allCourses) {

			if (courseButton.getCourse().getClassCode().equals(course.getClassCode())) {
				courseButtonContainer.add(courseButton.addCourseButton());
				courseListPanel.add(courseButton.addCourseButton());
			}

		}

	}

	// run the actions of buttons
	public void actionPerformed(ActionEvent e) {

		// if user click the logout button
		if (e.getSource() == logout) {
			new LoginFrame();
			mainFrame.dispose();

			// if user click the current course button
		} else if (e.getSource() == currentCourse) {
			// show the current course panel
			SchedulePanel schedules = new SchedulePanel(thisTeacher);
			currentCoursePanel.add(schedules.getPanel());
			mainPanel.setVisible(false);
			currentCoursePanel.setVisible(true);

			// if user click back on this panel
		} else if (e.getSource() == back1) {
			// go back to the main panel
			mainPanel.setVisible(true);
			currentCoursePanel.setVisible(false);

			// if user click the classroom panel
		} else if (e.getSource() == classroomInfo) {
			// go to the classroom panel
			addClassroomInfoJComponents();
			new ClassroomPanel(thisTeacher, classroomPanel);
			mainPanel.setVisible(false);
			classroomPanel.setVisible(true);

			// if user click back on this panel
		} else if (e.getSource() == back2) {
			// go back to the main panel
			mainPanel.setVisible(true);
			classroomPanel.setVisible(false);

			// if user click the select course button
		} else if (e.getSource() == selectCourse) {
			// set the search method
			search();
			// go to the select course panel
			mainPanel.setVisible(false);
			addCoursePanel.setVisible(true);

			// if user click back on this panel
		} else if (e.getSource() == back3) {
			// go back to the main panel
			StudentCenter.selectedCoursePanel.removeAll();
			StudentCenter.selectedCoursePanel.revalidate();
			StudentCenter.selectedCoursePanel.repaint();
			mainPanel.setVisible(true);
			addCoursePanel.setVisible(false);

			// if user click search
		} else if (e.getSource() == search) {// run the search method
			System.out.println("search");
			courseListPanel.removeAll();
			search();
		}

	}

}
