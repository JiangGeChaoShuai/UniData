package Displays;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import information.TeacherInformation;
import readFile.ReadFile;

public class TeacherCenter extends JFrame implements ActionListener {

	// JCompnent
	private JFrame mainFrame = new JFrame("Teacher Center");
	private JPanel mainPanel, infoPanel, currentCoursePanel, classroomPanel, addCoursePanel, schedulePanel,
			courseListPanel, selectedCoursePanel;
	private JLabel titleLabel, subTitle, photo, nameLabel, birth, teacherNum, email, emailLabel, major, scheduleImage,
			searchLabel, selectCourseLabel;
	private JTextField searchBar;
	private JScrollPane courseList, selectedCourse;
	private JButton logout, currentCourse, classroom, selectCourse, schedule, back1, back2, back3, back4, search;

	private int WIDTH = 1200;
	private int HEIGHT = 750;

	private static ReadFile read = new ReadFile();

	private TeacherInformation thisTeacher;

	public static void main(String[] args) {

		read.loadInformation();

		TeacherCenter window = new TeacherCenter(ReadFile.teacherAccounts.get(1));

		window.mainFrame.setVisible(true);

	}

	public TeacherCenter(TeacherInformation teacherInformation) {

		thisTeacher = teacherInformation;

		initialize();

		mainFrame.setVisible(true);
	}

	private void initialize() {

		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addJCompents();
		addInfoJCompents();
		addCurrentCourseJComponents();
		addClassroomJComponents();
		addaddCourseJComponents();
		addScheduleJComponents();

	}

	private void addJCompents() {

		mainFrame.setLayout(null);

		// add main
		// panel=========================================================================
		mainPanel = new JPanel();

		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(169, 188, 208));
		mainPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Teacher Center");
		titleLabel.setBounds(0, 50, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 55));
		titleLabel.setForeground(new Color(59, 96, 100));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setVisible(true);

		mainPanel.add(titleLabel, BorderLayout.CENTER);
		mainPanel.setVisible(true);

		// log out button
		logout = new JButton("Log Out");
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(59, 96, 100));
		logout.setFont(new Font("Aileron", Font.PLAIN, 30));
		logout.setBounds(700, 45, 150, 50);
		logout.addActionListener(this);
		mainPanel.add(logout);

		// the buttons
		currentCourse = new JButton(
				new ImageIcon(new ImageIcon("images/currentCourse2.png").getImage().getScaledInstance(180, 180, 0)));
		currentCourse.setBackground(new Color(59, 96, 100));
		currentCourse.setBounds(100, 220, 200, 200);
		currentCourse.addActionListener(this);
		mainPanel.add(currentCourse);

		classroom = new JButton(
				new ImageIcon(new ImageIcon("images/classroom.png").getImage().getScaledInstance(180, 180, 0)));
		classroom.setBackground(new Color(59, 96, 100));
		classroom.setBounds(350, 220, 200, 200);
		classroom.addActionListener(this);
		mainPanel.add(classroom);

		selectCourse = new JButton(
				new ImageIcon(new ImageIcon("images/addCourse2.png").getImage().getScaledInstance(180, 180, 0)));
		selectCourse.setBackground(new Color(59, 96, 100));
		selectCourse.setBounds(600, 220, 200, 200);
		selectCourse.addActionListener(this);
		mainPanel.add(selectCourse);

		// set text
		mainFrame.add(mainPanel);

	}

	private void addInfoJCompents() {
		// TODO Auto-generated method stub

		// add info
		// mainPanel============================================================================
		infoPanel = new JPanel(null);
		infoPanel.setBackground(new Color(216, 219, 226));
		infoPanel.setBounds(0, 0, 300, HEIGHT);

		subTitle = new JLabel("Teacher Info");
		subTitle.setBounds(0, 0, 300, 50);
		subTitle.setFont(new Font("Aileron", Font.PLAIN, 40));
		subTitle.setForeground(new Color(59, 96, 100));
		subTitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(subTitle);

		photo = new JLabel(
				new ImageIcon(new ImageIcon("images/teacher.png").getImage().getScaledInstance(150, 150, 0)));
		photo.setOpaque(true);
		photo.setBounds(75, 65, 150, 150);
		infoPanel.add(photo);

		nameLabel = new JLabel("Name:" + thisTeacher.getName());
		nameLabel.setBounds(10, 230, 300, 40);
		nameLabel.setFont(new Font("Aileron", Font.PLAIN, 25));
		nameLabel.setForeground(new Color(85, 130, 139));
		infoPanel.add(nameLabel);

		birth = new JLabel("Birthday:" + thisTeacher.getBirthday());
		birth.setBounds(10, 280, 300, 40);
		birth.setFont(new Font("Aileron", Font.PLAIN, 25));
		birth.setForeground(new Color(85, 130, 139));
		infoPanel.add(birth);

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

		major = new JLabel("Major:" + thisTeacher.getDepartment());
		major.setBounds(10, 420, 300, 40);
		major.setFont(new Font("Aileron", Font.PLAIN, 25));
		major.setForeground(new Color(85, 130, 139));
		infoPanel.add(major);

		teacherNum = new JLabel("Teacher #:   " + thisTeacher.getUsername());
		teacherNum.setBounds(10, 650, 300, 40);
		teacherNum.setFont(new Font("Aileron", Font.PLAIN, 25));
		teacherNum.setForeground(new Color(85, 130, 139));
		infoPanel.add(teacherNum);

		mainFrame.add(infoPanel);
	}

	private void addCurrentCourseJComponents() {
		// TODO Auto-generated method stub
		currentCoursePanel = new JPanel();
		currentCoursePanel.setLayout(null);
		currentCoursePanel.setBackground(new Color(169, 188, 208));
		currentCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Current Course:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		currentCoursePanel.add(titleLabel, BorderLayout.CENTER);

		back1 = new JButton(new ImageIcon(new ImageIcon("images/back2.png").getImage().getScaledInstance(100, 50, 0)));
		back1.setBackground(new Color(85, 130, 139));
		back1.setBounds(750, 30, 100, 50);
		back1.addActionListener(this);
		currentCoursePanel.add(back1);

		mainFrame.add(currentCoursePanel);
		currentCoursePanel.setVisible(false);

	}

	private void addClassroomJComponents() {
		// TODO Auto-generated method stub
		classroomPanel = new JPanel();
		classroomPanel.setLayout(null);
		classroomPanel.setBackground(new Color(169, 188, 208));
		classroomPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Classroom:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		classroomPanel.add(titleLabel, BorderLayout.CENTER);

		back2 = new JButton(new ImageIcon(new ImageIcon("images/back2.png").getImage().getScaledInstance(100, 50, 0)));
		back2.setBackground(new Color(85, 130, 139));
		back2.setBounds(750, 30, 100, 50);
		back2.addActionListener(this);
		classroomPanel.add(back2);

		mainFrame.add(classroomPanel);
		classroomPanel.setVisible(false);
	}

	private void addaddCourseJComponents() {
		// TODO Auto-generated method stub
		addCoursePanel = new JPanel();
		addCoursePanel.setLayout(null);
		addCoursePanel.setBackground(new Color(169, 188, 208));
		addCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Add Courses:");
		titleLabel.setBounds(10, 20, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addCoursePanel.add(titleLabel, BorderLayout.CENTER);

		back3 = new JButton(new ImageIcon(new ImageIcon("images/back2.png").getImage().getScaledInstance(100, 50, 0)));
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

		search = new JButton(
				new ImageIcon(new ImageIcon("images/search2.png").getImage().getScaledInstance(35, 35, 0)));
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

		selectedCoursePanel = new JPanel();
		selectedCoursePanel.setLayout(new BoxLayout(selectedCoursePanel, BoxLayout.Y_AXIS));
		selectedCoursePanel.setBounds(0, 0, WIDTH, HEIGHT);

		selectedCourse = new JScrollPane(selectedCoursePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		selectedCourse.setBounds(480, 300, 380, 300);
		addCoursePanel.add(selectedCourse);

		mainFrame.add(addCoursePanel);
		addCoursePanel.setVisible(false);
	}

	private void addScheduleJComponents() {

		schedulePanel = new JPanel();
		schedulePanel.setLayout(null);
		schedulePanel.setBackground(new Color(169, 188, 208));
		schedulePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		scheduleImage = new JLabel(
				new ImageIcon(new ImageIcon("images/scheduleImage.png").getImage().getScaledInstance(100, 100, 0)));
		scheduleImage.setBackground(new Color(85, 130, 139));
		scheduleImage.setBounds(10, 10, 100, 100);
		schedulePanel.add(scheduleImage);

		back4 = new JButton(new ImageIcon(new ImageIcon("images/back2.png").getImage().getScaledInstance(100, 50, 0)));
		back4.setBackground(new Color(85, 130, 139));
		back4.setBounds(750, 30, 100, 50);
		back4.addActionListener(this);
		schedulePanel.add(back4);

		mainFrame.add(schedulePanel);
		schedulePanel.setVisible(false);

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

		} else if (e.getSource() == classroom) {
			mainPanel.setVisible(false);
			classroomPanel.setVisible(true);

		} else if (e.getSource() == back2) {
			mainPanel.setVisible(true);
			classroomPanel.setVisible(false);

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

		}

	}

}
