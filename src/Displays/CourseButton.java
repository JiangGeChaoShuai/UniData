package Displays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import information.CourseInfo;
import information.CourseInformation;
import information.TimeOfWeek;
import readFile.ReadFile;
import readFile.SaveFile;

public class CourseButton implements ActionListener {

	private CourseInformation course;
	private JButton selectCourseButton;

	private JButton addCourse;
	private JLabel alreadyHaveCourse = new JLabel("Already Have Course", SwingConstants.CENTER);
	private JPanel panel;

	public CourseButton(CourseInformation course, JPanel panel) {

		this.panel = panel;

		this.course = course;

		selectCourseButton = new JButton(course.getClassName() + "  :" + course.getClassCode());
		selectCourseButton.setMinimumSize(new Dimension(400, 50));
		selectCourseButton.setMaximumSize(new Dimension(400, 50));
		selectCourseButton.setPreferredSize(new Dimension(400, 50));
		selectCourseButton.setForeground(new Color(255, 255, 255));
		selectCourseButton.setBackground(new Color(85, 130, 139));
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
		panel.removeAll();
		Dimension spacing = new Dimension(0, 15);

		Font font = new Font("Aileron", Font.PLAIN, 15);

		JLabel CourseCode = new JLabel("Course Code: " + course.getClassCode());
		CourseCode.setFont(font);
		JLabel CourseName = new JLabel("Course Name: " + course.getClassName());
		CourseName.setFont(font);
		panel.add(CourseCode);
		panel.add(Box.createRigidArea(spacing));
		panel.add(CourseName);
		panel.add(Box.createRigidArea(spacing));
		JLabel[] times = new JLabel[course.getTimes().size()];
		for (int i = 0; i < course.getTimes().size(); i++) {

			String classTime = "time: " + course.getTimes().get(i).getDate() + ", class begins at "
					+ course.getTimes().get(i).getBeginTime() / 100 + " :00 ends "
					+ course.getTimes().get(i).getEndTime() / 100 + " :00";

			times[i] = new JLabel(classTime);
			times[i].setFont(font);
			panel.add(times[i]);
			panel.add(Box.createRigidArea(spacing));

		}

		boolean hasCourse = false;

		try {
			for (CourseInfo courses : StudentCenter.thisStudent.getCourse()) {

				if (courses.getCourseCode().equals(course.getClassCode())) {

					System.out.println("already have course");

					hasCourse = true;
					break;
				}

			}
		} catch (NullPointerException e) {

			for (CourseInfo courses : TeacherCenter.thisTeacher.getCourse()) {

				if (courses.getCourseCode().equals(course.getClassCode())) {

					System.out.println("already have course");

					hasCourse = true;
					break;
				}

			}
		}

		if (!hasCourse) {
			addCourse = new JButton("Add Course");
			addCourse.setPreferredSize(new Dimension(380, 50));
			addCourse.setMaximumSize(new Dimension(380, 50));
			addCourse.setMinimumSize(new Dimension(380, 50));
			addCourse.setFont(new Font("Aileron", Font.PLAIN, 30));
			addCourse.addActionListener(this);
			addCourse.setForeground(new Color(255, 255, 255));
			addCourse.setBackground(new Color(54, 73, 88));

			panel.add(Box.createVerticalGlue());
			panel.add(addCourse);

		} else {

			alreadyHaveCourse.setPreferredSize(new Dimension(380, 50));
			alreadyHaveCourse.setMaximumSize(new Dimension(380, 50));
			alreadyHaveCourse.setMinimumSize(new Dimension(380, 50));
			alreadyHaveCourse.setFont(new Font("Aileron", Font.PLAIN, 30));
			alreadyHaveCourse.setForeground(new Color(255, 255, 255));
			alreadyHaveCourse.setBackground(new Color(54, 73, 88));
			alreadyHaveCourse.setOpaque(true);

			panel.add(Box.createVerticalGlue());
			panel.add(alreadyHaveCourse);
		}

		panel.revalidate();
		panel.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == selectCourseButton) {
			lookAtCourse();

		}
		if (e.getSource() == addCourse) {

			try {// used to find out where to add the information

				String name = StudentCenter.thisStudent.getName();

				StudentCenter.thisStudent.setCourse(course.getClassCode(), course.getClassName(), 0);
				course.addStudent(StudentCenter.thisStudent);
				SaveFile.SaveStudentInformation();
				panel.revalidate();

			} catch (NullPointerException exception) {

				TeacherCenter.thisTeacher.setCourse(course.getClassCode(), course.getClassName());
				course.setTeacher(TeacherCenter.thisTeacher);
				SaveFile.SaveTeacherInformation();
				panel.revalidate();
			}

			panel.remove(addCourse);

			alreadyHaveCourse.setPreferredSize(new Dimension(380, 50));
			alreadyHaveCourse.setMaximumSize(new Dimension(380, 50));
			alreadyHaveCourse.setMinimumSize(new Dimension(380, 50));
			alreadyHaveCourse.setFont(new Font("Aileron", Font.PLAIN, 30));
			alreadyHaveCourse.setForeground(new Color(255, 255, 255));
			alreadyHaveCourse.setBackground(new Color(54, 73, 88));
			alreadyHaveCourse.setOpaque(true);

			panel.add(alreadyHaveCourse);
		}
		SaveFile.saveCourseInformation();

	}

}
