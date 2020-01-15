package Displays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import information.CourseInformation;
import readFile.ReadFile;

public class CourseButton implements ActionListener {

	private CourseInformation course;
	private JButton selectCourseButton;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

	
}
