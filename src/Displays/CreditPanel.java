package Displays;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import information.StudentInformation;

public class CreditPanel {

	public CreditPanel(StudentInformation student, JPanel panel) {

		JPanel classPanel = new JPanel();
		classPanel.setLayout(null);
		classPanel.setBounds(0, 80, 900, 690);
		classPanel.setBackground(new Color(135, 187, 162));

		JPanel listOfStudents = new JPanel();
		listOfStudents.setLayout(new BoxLayout(listOfStudents, BoxLayout.Y_AXIS));
		listOfStudents.setBackground(new Color(216, 219, 226));

		ArrayList<JLabel> studentInCourse = new ArrayList<JLabel>();
		ArrayList<JLabel> studentMarks = new ArrayList<JLabel>();
		
		ArrayList<JPanel> rows = new ArrayList<JPanel>();

		for (int i = 0; i < student.getCourse().size(); i++) {

			rows.add(new JPanel());
			rows.get(i).setLayout(new BoxLayout(rows.get(i), BoxLayout.X_AXIS));
			rows.get(i).setBackground(new Color(85, 130, 139));
			rows.get(i).setMinimumSize(new Dimension(650, 50));
			rows.get(i).setMaximumSize(new Dimension(650, 50));
			rows.get(i).setPreferredSize(new Dimension(650, 50));
			
			String courseName = student.getCourse().get(i).getCourseName();
			
			studentInCourse.add(new JLabel(courseName));
			studentInCourse.get(i).setFont(new Font("Aileron", Font.PLAIN, 15));
			
			
			studentInCourse.get(i).setPreferredSize(new Dimension(300, 50));
			studentInCourse.get(i).setForeground(new Color(255, 255, 255));

			rows.get(i).add(studentInCourse.get(i));
			
			rows.get(i).add(Box.createHorizontalGlue());
			
			int mark = student.getCourse().get(i).getCourseMark();
				
			String markFormat = String.format("%-10s %-10s\n", "Marks:", mark);
			
			studentMarks.add(new JLabel(markFormat, SwingConstants.RIGHT));
			studentMarks.get(i).setFont(new Font("Aileron", Font.PLAIN, 15));
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

		
		
		panel.add(classPanel);

		panel.revalidate();
		panel.repaint();
		
	}
}
