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

// commenting is done

// this class is the panel class for classroom, the class does all the calculation for the entire classroom, list of classroom, and list of students
public class ClassroomPanel implements ActionListener {

	// panel to select the course for the class
	private JPanel selectCoursePanel;
	
	// panel that displays the students
	private JPanel classPanel;

	// panel that everything is on and gets passed around different classes
	private JPanel mainPanel;

	// arraylist of different classes
	private ArrayList<JButton> courseButtonContainer = new ArrayList<JButton>();
	
// the information of the teacher that gets passed
	private TeacherInformation teacher;

	// the button to leave the class panel
	private JButton goBackButton;

	// constructor that initalizes the panel when the button is clicked in teacher's center
	public ClassroomPanel(TeacherInformation teacher, JPanel panel) {

		// copy the information from the teacher class to let it be accessible in all classes
		this.teacher = teacher;
		mainPanel = panel;

		// initalize the panel to display the different classes
		selectCoursePanel = new JPanel();
		selectCoursePanel.setLayout(null);
		selectCoursePanel.setBounds(0, 80, 900, 690);
		selectCoursePanel.setBackground(new Color(169, 188, 208));

		
		// panel that holds the list of classes
		JPanel classroomList = new JPanel();
		classroomList.setLayout(new BoxLayout(classroomList, BoxLayout.Y_AXIS));
		classroomList.setBackground(new Color(216, 219, 226));

		// add the classes into the panel
		for (int i = 0; i < teacher.getCourse().size(); i++) {

			System.out.println("button added" + i);
			courseButtonContainer.add(new JButton(
					teacher.getCourse().get(i).getCourseName() + ":  " + teacher.getCourse().get(i).getCourseCode()));

			// initialize the different buttons for the classes
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

		// put into a scrollpane
		JScrollPane classList = new JScrollPane(classroomList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		classList.setBounds(100, 100, 650, 450);
		
		//add to panel
		selectCoursePanel.add(classList);
		selectCoursePanel.add(classList);
		mainPanel.add(selectCoursePanel);

	}

	
	// method to display the list of students in the class
	private void changeSelectCoursePanel(CourseInformation course) {

		
		// reinitalize the panel so that info from the last run wont be kept
		classPanel = new JPanel();
		classPanel.setLayout(null);
		classPanel.setBounds(0, 80, 900, 690);
		classPanel.setBackground(new Color(169, 188, 208));

		// panel to hold all the different students
		JPanel listOfStudents = new JPanel();
		listOfStudents.setLayout(new BoxLayout(listOfStudents, BoxLayout.Y_AXIS));
		listOfStudents.setBackground(new Color(216, 219, 226));

		// arraylist of JLabels to put the student information
		ArrayList<JLabel> studentInCourse = new ArrayList<JLabel>();
		ArrayList<JLabel> studentMarks = new ArrayList<JLabel>();

		// arraylist of JPanels to put the Jlabels that contains student information
		ArrayList<JPanel> rows = new ArrayList<JPanel>();

		// to add in each student that are in the class
		for (int i = 0; i < course.getStudentInCourse().size(); i++) {

			// add a panel
			rows.add(new JPanel());
			rows.get(i).setLayout(new BoxLayout(rows.get(i), BoxLayout.X_AXIS));
			rows.get(i).setBackground(new Color(85, 130, 139));
			rows.get(i).setMinimumSize(new Dimension(650, 50));
			rows.get(i).setMaximumSize(new Dimension(650, 50));
			rows.get(i).setPreferredSize(new Dimension(650, 50));

			// add in the student name to panel
			String StudentName = course.getStudentInCourse().get(i).getName();
			studentInCourse.add(new JLabel(StudentName));
			studentInCourse.get(i).setFont(new Font("Aileron", Font.PLAIN, 25));
			studentInCourse.get(i).setPreferredSize(new Dimension(300, 50));
			studentInCourse.get(i).setForeground(new Color(255, 255, 255));
			rows.get(i).add(studentInCourse.get(i));

			//make the JLabel stick to the sides of the component
			rows.get(i).add(Box.createHorizontalGlue());


			int mark = 0;
			// scan to read marks of students
			for (int x = 0; x < course.getStudentInCourse().get(i).getCourse().size(); x++) {
				if (course.getStudentInCourse().get(i).getCourse().get(x).getCourseCode()
						.equals(course.getClassCode())) {
					mark = course.getStudentInCourse().get(i).getCourse().get(x).getCourseMark();
					break;
				}

			}

			// add in mark of the students
			String markFormat = String.format("%-10s %-5s\n", "Marks:", mark);
			studentMarks.add(new JLabel(markFormat, SwingConstants.RIGHT));
			studentMarks.get(i).setFont(new Font("Aileron", Font.PLAIN, 25));
			studentMarks.get(i).setPreferredSize(new Dimension(300, 50));
			studentMarks.get(i).setForeground(new Color(255, 255, 255));
			rows.get(i).add(studentMarks.get(i));
			
			// format the row panel and add it to the panel displaying all the student information
			rows.get(i).setBorder(new LineBorder(Color.BLACK, 1));
			listOfStudents.add(rows.get(i));

		}

		// create a scrollpane
		JScrollPane studentList = new JScrollPane(listOfStudents, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		studentList.setBounds(100, 100, 650, 450);

		// add it to the main panel
		classPanel.add(studentList);

		// initialize the button to go back
		goBackButton = new JButton("Go Back To Class");
		goBackButton.setBounds(300, 25, 300, 50);
		goBackButton.addActionListener(this);
		goBackButton.setFont(new Font("Aileron", Font.PLAIN, 30));
		goBackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		goBackButton.setForeground(new Color(255, 255, 255));
		goBackButton.setBackground(new Color(54, 73, 88));
		classPanel.add(goBackButton);

		
		// swap the things on to the panel
		mainPanel.remove(selectCoursePanel);
		mainPanel.add(classPanel);

		//update the panel
		mainPanel.revalidate();
		mainPanel.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// go back to the class selection frame
		if (e.getSource() == goBackButton) {
			mainPanel.add(selectCoursePanel);
			mainPanel.remove(classPanel);
			mainPanel.revalidate();
			mainPanel.repaint();
		}

		// find the course button that was clicked
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
