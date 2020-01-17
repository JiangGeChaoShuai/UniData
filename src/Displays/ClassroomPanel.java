package Displays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import information.CourseInfo;
import information.CourseInformation;
import information.StudentInformation;
import information.TeacherInformation;
import readFile.ReadFile;

public class ClassroomPanel implements ActionListener {

	private JPanel selectCoursePanel;
	private JPanel classPanel;

	private JPanel mainPanel;

	private ArrayList<JButton> courseButtonContainer = new ArrayList<JButton>();

	private TeacherInformation teacher;

	private JButton goBackButton;
	
	public ClassroomPanel(TeacherInformation teacher, JPanel panel) {

		this.teacher = teacher;
		mainPanel = panel;

		selectCoursePanel = new JPanel();
		selectCoursePanel.setLayout(null);
		selectCoursePanel.setBounds(0, 80, 900, 690);
		selectCoursePanel.setBackground(new Color(169, 188, 208));

		JPanel classroomList = new JPanel();
		classroomList.setLayout(new BoxLayout(classroomList, BoxLayout.Y_AXIS));
		classroomList.setBackground(new Color(216, 219, 226));

		for (int i = 0; i < teacher.getCourse().size(); i++) {

			System.out.println("button added" + i);
			courseButtonContainer.add(new JButton(
					teacher.getCourse().get(i).getCourseName() + ":  " + teacher.getCourse().get(i).getCourseCode()));

			courseButtonContainer.get(i).setMinimumSize(new Dimension(650, 50));
			courseButtonContainer.get(i).setMaximumSize(new Dimension(650, 50));
			courseButtonContainer.get(i).setPreferredSize(new Dimension(650, 50));
			courseButtonContainer.get(i).setForeground(new Color(255, 255, 255));
			courseButtonContainer.get(i).setBackground(new Color(85, 130, 139));
			courseButtonContainer.get(i).setFont(new Font("Aileron", Font.PLAIN, 18));
			courseButtonContainer.get(i).setVisible(true);
			courseButtonContainer.get(i).addActionListener(this);

			classroomList.add(courseButtonContainer.get(i));

		}

		JScrollPane classList = new JScrollPane(classroomList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		classList.setBounds(100, 100, 650, 450);
		selectCoursePanel.add(classList);

		selectCoursePanel.add(classList);
		mainPanel.add(selectCoursePanel);

	}

	private void changeSelectCoursePanel(CourseInformation course) {

		classPanel = new JPanel();
		classPanel.setLayout(null);
		classPanel.setBounds(0, 80, 900, 690);
		classPanel.setBackground(new Color(169, 188, 208));

		JPanel listOfStudents = new JPanel();
		listOfStudents.setLayout(new BoxLayout(listOfStudents, BoxLayout.Y_AXIS));
		listOfStudents.setBackground(new Color(216, 219, 226));

		ArrayList<JLabel> studentInCourse = new ArrayList<JLabel>();
		ArrayList<JLabel> studentMarks = new ArrayList<JLabel>();
		
		ArrayList<JPanel> rows = new ArrayList<JPanel>();

		for (int i = 0; i < course.getStudentInCourse().size(); i++) {

			rows.add(new JPanel());
			rows.get(i).setLayout(new BoxLayout(rows.get(i), BoxLayout.X_AXIS));
			rows.get(i).setBackground(new Color(85, 130, 139));
			rows.get(i).setMinimumSize(new Dimension(650, 50));
			rows.get(i).setMaximumSize(new Dimension(650, 50));
			rows.get(i).setPreferredSize(new Dimension(650, 50));
			
			String StudentName = course.getStudentInCourse().get(i).getName();
			
			studentInCourse.add(new JLabel(StudentName));
			studentInCourse.get(i).setFont(new Font("Aileron", Font.PLAIN, 25));
			
			studentInCourse.get(i).setPreferredSize(new Dimension(300, 50));
			studentInCourse.get(i).setForeground(new Color(255, 255, 255));

			rows.get(i).add(studentInCourse.get(i));
			
			rows.get(i).add(Box.createHorizontalGlue());
			
			int mark = 0;
			for (int x = 0; x < course.getStudentInCourse().get(i).getCourse().size(); x++) {
				if (course.getStudentInCourse().get(i).getCourse().get(x).getCourseCode()
						.equals(course.getClassCode())) {
					mark = course.getStudentInCourse().get(i).getCourse().get(x).getCourseMark();
					break;
				}

			}
			
			String markFormat = String.format("%-10s %-5s\n", "Marks:", mark);
			
			studentMarks.add(new JLabel(markFormat, SwingConstants.RIGHT));
			studentMarks.get(i).setFont(new Font("Aileron", Font.PLAIN, 25));
			studentMarks.get(i).setPreferredSize(new Dimension(300, 50));
			studentMarks.get(i).setForeground(new Color(255, 255, 255));

			rows.get(i).add(studentMarks.get(i));
			rows.get(i).setBorder(new LineBorder(Color.BLACK, 1));
			listOfStudents.add(rows.get(i));

		}

		JScrollPane studentList = new JScrollPane(listOfStudents, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		studentList.setBounds(100, 100, 650, 450);

		classPanel.add(studentList);

		goBackButton = new JButton("Go Back To Class");
		goBackButton.setBounds(300, 25, 300, 50);
		goBackButton.addActionListener(this);
		goBackButton.setFont(new Font("Aileron", Font.PLAIN, 30));
		goBackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		goBackButton.setForeground(new Color(255, 255, 255));
		goBackButton.setBackground(new Color(54, 73, 88));
		
		classPanel.add(goBackButton);
		
		
		mainPanel.remove(selectCoursePanel);
		
		mainPanel.add(classPanel);

		mainPanel.revalidate();
		mainPanel.repaint();


		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == goBackButton) {
			mainPanel.add(selectCoursePanel);
			mainPanel.remove(classPanel);
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		
		for (int i = 0; i < courseButtonContainer.size(); i++) {

			if (e.getSource() == courseButtonContainer.get(i)) {

				for (CourseInformation course : ReadFile.courseLibrary) {

					if (course.getClassCode().equals(teacher.getCourse().get(i).getCourseCode())) {

						changeSelectCoursePanel(course);

					}
				}

			}

		}

	}

}
