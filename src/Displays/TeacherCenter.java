package Displays;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TeacherCenter extends JFrame implements ActionListener {

	// JCompnent
	private JFrame mainFrame = new JFrame("Teacher Center");
	private JPanel mainPanel, infoPanel, currentCoursePanel, classroomPanel, futureCoursePanel;
	private JLabel titleLabel, subTitle, photo, nameLabel, birth, teacherNum, email, major;
	private JButton logout, currentCourse, classroom, selectCourse, schedule;

	private int WIDTH = 1200;
	private int HEIGHT = 750;

	public static void main(String[] args) {

		TeacherCenter window = new TeacherCenter();

		window.mainFrame.setVisible(true);

	}

	public TeacherCenter() {

		initialize();
	}

	private void initialize() {

		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addJCompents();
		addInfoJCompents();
		addCurrentCourse();
		addClassroomJComponents();
		addFutureCourse();

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
		logout.setBackground(new Color(85, 130, 139));
		logout.setFont(new Font("Aileron", Font.PLAIN, 30));
		logout.setBounds(700, 45, 150, 50);
		logout.addActionListener(this);
		mainPanel.add(logout);

		// the buttons
		currentCourse = new JButton(
				new ImageIcon(new ImageIcon("images/currentCourse2.png").getImage().getScaledInstance(180, 180, 0)));
		currentCourse.setBackground(new Color(59, 96, 100));
		currentCourse.setBounds(100, 180, 200, 200);
		currentCourse.addActionListener(this);
		mainPanel.add(currentCourse);

		classroom = new JButton(
				new ImageIcon(new ImageIcon("images/classroom.png").getImage().getScaledInstance(180, 180, 0)));
		classroom.setBackground(new Color(59, 96, 100));
		classroom.setBounds(350, 180, 200, 200);
		classroom.addActionListener(this);
		mainPanel.add(classroom);

		selectCourse = new JButton(
				new ImageIcon(new ImageIcon("images/futureCourse2.png").getImage().getScaledInstance(180, 180, 0)));
		selectCourse.setBackground(new Color(59, 96, 100));
		selectCourse.setBounds(600, 180, 200, 200);
		selectCourse.addActionListener(this);
		mainPanel.add(selectCourse);

		schedule = new JButton(
				new ImageIcon(new ImageIcon("images/schedule2.png").getImage().getScaledInstance(180, 80, 0)));
		schedule.setBackground(new Color(59, 96, 100));
		schedule.setBounds(100, 430, 200, 100);
		schedule.addActionListener(this);
		mainPanel.add(schedule);

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

		email = new JLabel("Email:");
		email.setBounds(10, 340, 300, 40);
		email.setFont(new Font("Aileron", Font.PLAIN, 25));
		email.setForeground(new Color(85, 130, 139));
		infoPanel.add(email);

		major = new JLabel("Major:");
		major.setBounds(10, 400, 300, 40);
		major.setFont(new Font("Aileron", Font.PLAIN, 25));
		major.setForeground(new Color(85, 130, 139));
		infoPanel.add(major);

		teacherNum = new JLabel("Teacher #:");
		teacherNum.setBounds(10, 650, 300, 40);
		teacherNum.setFont(new Font("Aileron", Font.PLAIN, 25));
		teacherNum.setForeground(new Color(85, 130, 139));
		infoPanel.add(teacherNum);

		mainFrame.add(infoPanel);
	}

	private void addCurrentCourse() {
		// TODO Auto-generated method stub
		currentCoursePanel = new JPanel();
		currentCoursePanel.setLayout(null);
		currentCoursePanel.setBackground(new Color(135, 187, 162));
		currentCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Current Course:");
		titleLabel.setBounds(0, 50, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		currentCoursePanel.add(titleLabel, BorderLayout.CENTER);

		mainFrame.add(currentCoursePanel);
		currentCoursePanel.setVisible(false);

	}

	private void addClassroomJComponents() {
		// TODO Auto-generated method stub
		classroomPanel = new JPanel();
		classroomPanel.setLayout(null);
		classroomPanel.setBackground(new Color(135, 187, 162));
		classroomPanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Credit:");
		titleLabel.setBounds(0, 50, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		classroomPanel.add(titleLabel, BorderLayout.CENTER);

		mainFrame.add(classroomPanel);
		classroomPanel.setVisible(false);
	}

	private void addFutureCourse() {
		// TODO Auto-generated method stub
		futureCoursePanel = new JPanel();
		futureCoursePanel.setLayout(null);
		futureCoursePanel.setBackground(new Color(135, 187, 162));
		futureCoursePanel.setBounds(300, 0, WIDTH - 300, HEIGHT);

		titleLabel = new JLabel("Future Course Selection:");
		titleLabel.setBounds(0, 50, 900, 60);
		titleLabel.setFont(new Font("Aileron", Font.PLAIN, 50));
		titleLabel.setForeground(new Color(54, 73, 88));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		futureCoursePanel.add(titleLabel, BorderLayout.CENTER);

		mainFrame.add(futureCoursePanel);
		futureCoursePanel.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == currentCourse) {
			mainPanel.setVisible(false);
			currentCoursePanel.setVisible(true);

		} else if (e.getSource() == classroom) {
			mainPanel.setVisible(false);
			classroomPanel.setVisible(true);

		} else if (e.getSource() == selectCourse) {
			mainPanel.setVisible(false);
			futureCoursePanel.setVisible(true);
		}

	}

}
