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

// commenting done
// class for adding in credit for student credit panel
public class CreditPanel {

	// constructor class for the credits the student has
	public CreditPanel(StudentInformation student, JPanel panel) {

		//  panel that holds everything
		JPanel classPanel = new JPanel();
		classPanel.setLayout(null);
		classPanel.setBounds(0, 80, 900, 690);
		classPanel.setBackground(new Color(135, 187, 162));

		// panel that contains the student info
		JPanel listOfCredit = new JPanel();
		listOfCredit.setLayout(new BoxLayout(listOfCredit, BoxLayout.Y_AXIS));
		listOfCredit.setBackground(new Color(216, 219, 226));

		// arraylist of JLabel for student info
		ArrayList<JLabel> studentInCourse = new ArrayList<JLabel>();
		ArrayList<JLabel> studentMarks = new ArrayList<JLabel>();
		
		// arraylist of panel to hold Jlabel
		ArrayList<JPanel> rows = new ArrayList<JPanel>();

		// add the info into the list of teacher
		for (int i = 0; i < student.getCourse().size(); i++) {

			
			// create a new row
			rows.add(new JPanel());
			rows.get(i).setLayout(new BoxLayout(rows.get(i), BoxLayout.X_AXIS));
			rows.get(i).setBackground(new Color(85, 130, 139));
			rows.get(i).setMinimumSize(new Dimension(650, 50));
			rows.get(i).setMaximumSize(new Dimension(650, 50));
			rows.get(i).setPreferredSize(new Dimension(650, 50));
			
			// label to hold course name
			String courseName = student.getCourse().get(i).getCourseName();
			studentInCourse.add(new JLabel(courseName));
			studentInCourse.get(i).setFont(new Font("Aileron", Font.PLAIN, 15));
			studentInCourse.get(i).setPreferredSize(new Dimension(300, 50));
			studentInCourse.get(i).setForeground(new Color(255, 255, 255));
			rows.get(i).add(studentInCourse.get(i));
			
			// make each Jlabel to go to the sides
			rows.get(i).add(Box.createHorizontalGlue());
			
			// label to hold the marks
			int mark = student.getCourse().get(i).getCourseMark();	
			String markFormat = String.format("%-10s %-10s\n", "Marks:", mark);
			studentMarks.add(new JLabel(markFormat, SwingConstants.RIGHT));
			studentMarks.get(i).setFont(new Font("Aileron", Font.PLAIN, 15));
			studentMarks.get(i).setPreferredSize(new Dimension(300, 50));
			studentMarks.get(i).setForeground(new Color(255, 255, 255));
			rows.get(i).add(studentMarks.get(i));
			
			// add in the row panel to main panel and add border for appearance
			rows.get(i).setBorder(new LineBorder(Color.BLACK, 1));
			listOfCredit.add(rows.get(i));
			

		}
		
		// add in scroll bar
		JScrollPane CreditList = new JScrollPane(listOfCredit, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		CreditList.setBounds(100, 150, 650, 450);
		classPanel.add(CreditList);

		// add to panel that gets passed
		panel.add(classPanel);

		// update the panel
		panel.revalidate();
		panel.repaint();
		
	}
}
