package Displays;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import information.CourseInformation;
import information.StudentInformation;
import information.TeacherInformation;
import readFile.ReadFile;

public class SchedulePanel {

	private JPanel panel = new JPanel();

	private Color[] color = new Color[5];

	public SchedulePanel(StudentInformation student) {
		
		panel.setBounds(100, 150, 650, 450);
		panel.setBackground(new Color(201, 228, 202));
		
		color[0] = new Color(128, 128, 0);
		color[1] = new Color(0, 255, 0);
		color[2] = new Color(0, 128, 0);
		color[3] = new Color(0, 255, 255);
		color[4] = new Color(247, 220, 111);

		GridBagLayout gbl = new GridBagLayout();

		panel.setLayout(gbl);

		GridBagConstraints gbc = new GridBagConstraints();

		gbl.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;

		panel.add(createLabel("Monday"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 0;

		panel.add(createLabel("Tuesday"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 3;
		gbc.gridy = 0;

		panel.add(createLabel("Wednesday"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 4;
		gbc.gridy = 0;

		panel.add(createLabel("Thursday"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 5;
		gbc.gridy = 0;

		panel.add(createLabel("Friday"), gbc);




		for (int i = 0; i < 14; i++) {

			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = i + 1;
			
			
			

			panel.add(createLabel((i + 8) + ":00"), gbc);

			
		}

		for (int i = 0; i < student.getCourse().size(); i++) {

			for (CourseInformation course : ReadFile.courseLibrary) {

				if (course.getClassCode().equals(student.getCourse().get(i).getCourseCode())) {

					for (int x = 0; x < course.getTimes().size(); x++) {

						
						System.out.println("courseTime: " + course.getTimes().size());
						int beginTime = course.getTimes().get(x).getBeginTime() / 100;
						int endTime = course.getTimes().get(x).getEndTime()/100;

						gbc.fill = GridBagConstraints.BOTH;

						if (course.getTimes().get(x).getDate().equals("Monday")) {

							gbc.gridx = 1;
						}

						else if (course.getTimes().get(x).getDate().equals("Tuesday")) {

							gbc.gridx = 2;
						}

						else if (course.getTimes().get(x).getDate().equals("Wednesday")) {

							gbc.gridx = 3;
						}

						else if (course.getTimes().get(x).getDate().equals("Thursday")) {

							gbc.gridx = 4;
						}

						else if (course.getTimes().get(x).getDate().equals("Friday")) {

							gbc.gridx = 5;
						}

						gbc.gridy = beginTime - 7;
						
						gbc.gridheight = (endTime - beginTime);
						System.out.println("gridHeight:  " + (endTime - beginTime));
						
						panel.add(addCourseIntoSchedule(course.getClassCode(), color[i%5]), gbc);
					}

				}

			}

		}

	}
	public SchedulePanel(TeacherInformation Teacher) {

		panel.setBounds(100, 150, 650, 450);
		panel.setBackground(new Color(201, 228, 202));
		
		color[0] = new Color(128, 128, 0);
		color[1] = new Color(0, 255, 0);
		color[2] = new Color(0, 128, 0);
		color[3] = new Color(0, 255, 255);
		color[4] = new Color(247, 220, 111);

		GridBagLayout gbl = new GridBagLayout();

		panel.setLayout(gbl);

		GridBagConstraints gbc = new GridBagConstraints();

		gbl.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;

		panel.add(createLabel("Monday"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 0;

		panel.add(createLabel("Tuesday"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 3;
		gbc.gridy = 0;

		panel.add(createLabel("Wednesday"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 4;
		gbc.gridy = 0;

		panel.add(createLabel("Thursday"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 5;
		gbc.gridy = 0;

		panel.add(createLabel("Friday"), gbc);




		for (int i = 0; i < 14; i++) {

			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = i + 1;
			
			
			

			panel.add(createLabel((i + 8) + ":00"), gbc);

			
		}

		for (int i = 0; i < Teacher.getCourse().size(); i++) {

			for (CourseInformation course : ReadFile.courseLibrary) {

				if (course.getClassCode().equals(Teacher.getCourse().get(i).getCourseCode())) {

					for (int x = 0; x < course.getTimes().size(); x++) {

						
						System.out.println("courseTime: " + course.getTimes().size());
						int beginTime = course.getTimes().get(x).getBeginTime() / 100;
						int endTime = course.getTimes().get(x).getEndTime()/100;

						gbc.fill = GridBagConstraints.BOTH;

						if (course.getTimes().get(x).getDate().equals("Monday")) {

							gbc.gridx = 1;
						}

						else if (course.getTimes().get(x).getDate().equals("Tuesday")) {

							gbc.gridx = 2;
						}

						else if (course.getTimes().get(x).getDate().equals("Wednesday")) {

							gbc.gridx = 3;
						}

						else if (course.getTimes().get(x).getDate().equals("Thursday")) {

							gbc.gridx = 4;
						}

						else if (course.getTimes().get(x).getDate().equals("Friday")) {

							gbc.gridx = 5;
						}

						gbc.gridy = beginTime - 7;
						
						gbc.gridheight = (endTime - beginTime);
						System.out.println("gridHeight:  " + (endTime - beginTime));
						
						panel.add(addCourseIntoSchedule(course.getClassCode(), color[i%5]), gbc);
					}

				}

			}

		}

	}
	

	private JLabel createLabel(String name) {

		JLabel label = new JLabel(name, SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setBackground(new Color(85, 130, 139));
		label.setFont(new Font("Aileron", Font.PLAIN, 24));
		label.setOpaque(true);

		label.setBorder(new LineBorder(Color.BLACK, 1));
		
		return label;
	}

	private JLabel addCourseIntoSchedule(String name, Color background) {

		JLabel label = new JLabel(name, SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setBackground(background);
		label.setFont(new Font("Aileron", Font.PLAIN, 18));
		label.setOpaque(true);

		label.setBorder(new LineBorder(Color.BLACK,1));
		return label;
	}

	public JPanel getPanel() {
		return panel;
	}

}
