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

// commenting done
// this is for the button that would add the course to the schedule of the student or teacher
public class CourseButton implements ActionListener {

	// the information that gets sent to this frame
	private CourseInformation course;

	// panel is required because the class does not know where to display the
	// information
	private JPanel panel;

	// button that gets added to the panel
	private JButton selectCourseButton;

	// button or JLabel that gets displayed depending on if the course has conflicts
	// with other courses or is already in the schedule
	private JButton addCourse;
	private JLabel alreadyHaveCourse = new JLabel("Already Have Course", SwingConstants.CENTER);

	// constructor that creates the button for opening courses
	public CourseButton(CourseInformation course, JPanel panel) {

		// pass the information in to this class so that the class can be used by
		// different classes without issue
		this.panel = panel;
		this.course = course;

		// create the add course button
		selectCourseButton = new JButton(course.getClassName() + ":     " + course.getClassCode());
		selectCourseButton.setMinimumSize(new Dimension(400, 50));
		selectCourseButton.setMaximumSize(new Dimension(400, 50));
		selectCourseButton.setPreferredSize(new Dimension(400, 50));
		selectCourseButton.setForeground(new Color(255, 255, 255));
		selectCourseButton.setBackground(new Color(85, 130, 139));
		selectCourseButton.setFont(new Font("Aileron", Font.PLAIN, 18));
		selectCourseButton.setVisible(true);
		selectCourseButton.addActionListener(this);

	}

	// return the button so that it can be added to the list of courses in either
	// Student center or teacher center
	public JButton addCourseButton() {
		return selectCourseButton;

	}

	// return the course information so that the student center can check which one
	// will get added
	public CourseInformation getCourse() {
		return course;

	}

	// add in the information to the panel of courses
	private void lookAtCourse() {
		// remove everything so that new info can be added
		panel.removeAll();

		// spacing between each line of info
		Dimension spacing = new Dimension(0, 15);

		// font for info
		Font font = new Font("Aileron", Font.PLAIN, 15);

		// labels to be added in
		JLabel CourseCode = new JLabel("Course Code: " + course.getClassCode());
		CourseCode.setFont(font);
		JLabel CourseName = new JLabel("Course Name: " + course.getClassName());
		CourseName.setFont(font);

		// add in the label
		panel.add(CourseCode);
		panel.add(Box.createRigidArea(spacing));
		panel.add(CourseName);
		panel.add(Box.createRigidArea(spacing));

		// Array of time labels
		JLabel[] times = new JLabel[course.getTimes().size()];

		// add in the time labels
		for (int i = 0; i < course.getTimes().size(); i++) {

			String classTime = "time: " + course.getTimes().get(i).getDate() + ", class begins at "
					+ course.getTimes().get(i).getBeginTime() / 100 + " :00 ends "
					+ course.getTimes().get(i).getEndTime() / 100 + " :00";

			times[i] = new JLabel(classTime);
			times[i].setFont(font);
			panel.add(times[i]);
			panel.add(Box.createRigidArea(spacing));

		}

		// boolean to see if their is a conflict with the course added
		// or if it has already been chosen
		boolean hasCourse = false;

		// try catch to error check, in case of students not being initalized
		try {
			
			// check the array of students courses to find if it contains the course already
			for (CourseInfo courses : StudentCenter.thisStudent.getCourse()) {

				if (courses.getCourseCode().equals(course.getClassCode())) {

					System.out.println("already have course");

					alreadyHaveCourse.setText("Already Have Course");
					hasCourse = true;
					break;
				}

				//check the time of other courses of the student to see if their is a conflict
				for (CourseInfo x : StudentCenter.thisStudent.getCourse()) {

					for (CourseInformation courseTimeChecker : ReadFile.courseLibrary) {

						if (x.getCourseCode().equals(courseTimeChecker.getClassCode())) {
							if (!courseTimeChecker.getClassCode().equals(course.getClassCode())) {

								if (!course.checkCourseTime(courseTimeChecker)) {
									alreadyHaveCourse.setText(" Conflict with " + courseTimeChecker.getClassCode());
									hasCourse = true;
								}
							}
						}
					}
				}

			}

			// if student is not initalized, it means that teacher is so we can therefore
			// run the code for teacher if the student's code was unable to run
		} catch (NullPointerException e) {

			// the same code the checks for the student's schedule conflict, except it checks for the teacher
			for (CourseInfo courses : TeacherCenter.thisTeacher.getCourse()) {

				if (courses.getCourseCode().equals(course.getClassCode())) {

					System.out.println("already have course");

					hasCourse = true;
					break;
				}

			}

			for (CourseInfo x : TeacherCenter.thisTeacher.getCourse()) {

				for (CourseInformation courseTimeChecker : ReadFile.courseLibrary) {

					if (x.getCourseCode().equals(courseTimeChecker.getClassCode())) {
						if (!courseTimeChecker.getClassCode().equals(course.getClassCode())) {

							if (!course.checkCourseTime(courseTimeChecker)) {
								alreadyHaveCourse.setText(" Conflict with " + courseTimeChecker.getClassCode());
								hasCourse = true;
							}
						}
					}
				}

			}

		}

		// if there is no conflict, display button
		if (!hasCourse) {
			addCourse = new JButton("Add Course");
			addCourse.setPreferredSize(new Dimension(380, 50));
			addCourse.setMaximumSize(new Dimension(380, 50));
			addCourse.setMinimumSize(new Dimension(380, 50));
			addCourse.setFont(new Font("Aileron", Font.PLAIN, 25));
			addCourse.addActionListener(this);
			addCourse.setForeground(new Color(255, 255, 255));
			addCourse.setBackground(new Color(54, 73, 88));

			panel.add(Box.createVerticalGlue());
			panel.add(addCourse);

		// else display JLabel with text of conflict
		} else {

			alreadyHaveCourse.setPreferredSize(new Dimension(380, 50));
			alreadyHaveCourse.setMaximumSize(new Dimension(380, 50));
			alreadyHaveCourse.setMinimumSize(new Dimension(380, 50));
			alreadyHaveCourse.setFont(new Font("Aileron", Font.PLAIN, 25));
			alreadyHaveCourse.setForeground(new Color(255, 255, 255));
			alreadyHaveCourse.setBackground(new Color(54, 73, 88));
			alreadyHaveCourse.setOpaque(true);

			panel.add(Box.createVerticalGlue());
			panel.add(alreadyHaveCourse);
			
		}

		// update panel
		panel.revalidate();
		panel.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// button that displays teh course
		if (e.getSource() == selectCourseButton) {
			lookAtCourse();

		}
		// button that adds the course in
		if (e.getSource() == addCourse) {

			try {// used to find out where to add the information

				// update and save the student arraylist
				StudentCenter.thisStudent.setCourse(course.getClassCode(), course.getClassName(), 0);
				course.addStudent(StudentCenter.thisStudent);
				SaveFile.SaveStudentInformation();

			} catch (NullPointerException exception) {

				// update and save the teacher arraylist
				TeacherCenter.thisTeacher.setCourse(course.getClassCode(), course.getClassName());
				course.setTeacher(TeacherCenter.thisTeacher);
				SaveFile.SaveTeacherInformation();
			}

			panel.remove(addCourse);

			// update the button
			alreadyHaveCourse.setPreferredSize(new Dimension(380, 50));
			alreadyHaveCourse.setMaximumSize(new Dimension(380, 50));
			alreadyHaveCourse.setMinimumSize(new Dimension(380, 50));
			alreadyHaveCourse.setFont(new Font("Aileron", Font.PLAIN, 30));
			alreadyHaveCourse.setForeground(new Color(255, 255, 255));
			alreadyHaveCourse.setBackground(new Color(54, 73, 88));
			alreadyHaveCourse.setOpaque(true);

			// override the button
			panel.add(alreadyHaveCourse);
			panel.revalidate();
			panel.repaint();
			// save the information
			SaveFile.saveCourseInformation();

		}


	}

}