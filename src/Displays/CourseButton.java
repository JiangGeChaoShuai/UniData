package Displays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

import information.CourseInformation;
import information.TimeOfWeek;
import readFile.ReadFile;

public class CourseButton implements ActionListener {

	private CourseInformation course;
	private JButton selectCourseButton;

	private JButton addCourse;

	public CourseButton(CourseInformation course) {

		this.course = course;

		selectCourseButton = new JButton(course.getClassName() + "  :" + course.getClassCode());
		selectCourseButton.setPreferredSize(new Dimension(200, 50));
		selectCourseButton.setForeground(new Color(255, 255, 255));
		selectCourseButton.setBackground(new Color(54, 73, 88));
		selectCourseButton.setFont(new Font("Aileron", Font.PLAIN, 18));
		selectCourseButton.setVisible(true);
		selectCourseButton.addActionListener(this);

	}

	public JButton addCourseButton() {
		return selectCourseButton;

	}

	public CourseInformation getCourse() {
		return course;

	}

	private void lookAtCourse() {
		StudentCenter.selectedCourseListPanel.removeAll();
		Dimension spacing = new Dimension(0, 15);

		Font font = new Font("Aileron", Font.PLAIN, 15);
		
		
		JLabel CourseCode = new JLabel("Course Code: " + course.getClassCode());
		CourseCode.setFont(font);
		JLabel CourseName = new JLabel("Course Name: " + course.getClassName());
		CourseName.setFont(font);
		StudentCenter.selectedCourseListPanel.add(CourseCode);
		StudentCenter.selectedCourseListPanel.add(Box.createRigidArea(spacing));
		StudentCenter.selectedCourseListPanel.add(CourseName);
		StudentCenter.selectedCourseListPanel.add(Box.createRigidArea(spacing));
		JLabel[] times = new JLabel[course.getTimes().size()];
		for (int i = 0; i < course.getTimes().size(); i++) {

			String classTime = "time: " + course.getTimes().get(i).getDate() + ", class begins at "
					+ course.getTimes().get(i).getBeginTime() / 100 + " :00 ends "
					+ course.getTimes().get(i).getEndTime() / 100 + " :00";
			
			times[i] = new JLabel(classTime);
			times[i].setFont(font);
			StudentCenter.selectedCourseListPanel.add(times[i]);
			StudentCenter.selectedCourseListPanel.add(Box.createRigidArea(spacing));

		}

		StudentCenter.mainFrame.revalidate();
		StudentCenter.mainFrame.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == selectCourseButton) {
			lookAtCourse();

		}
		if (e.getSource() == addCourse) {

		}
	}

}
