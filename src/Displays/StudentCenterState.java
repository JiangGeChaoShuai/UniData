package Displays;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class StudentCenterState extends State {
	
	//JComponents
	private JPanel panel,infoPanel;
	private JLabel titleLabel,subTitle,nameLabel,birth,studentNum,timeEnroll,email,major;
	private JButton logout,currentCourse,creditInfo,selectCourse;
	
	//other fields and variables
	
	
	@Override
	public void init() {
		
	}

	@Override
	public void addJComponents() {
		// TODO Auto-generated method stub
		
		panel = new JPanel(null);
		panel.setBackground(new Color(135,187,162));
		panel.setBounds(300, 0, WIDTH, HEIGHT);
		add(panel);
		
		addStudentInfoComponents();
		
		titleLabel = new JLabel("Student Center");
		titleLabel.setBounds(0, 35, WIDTH-300, 60);
		titleLabel.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 55));
		titleLabel.setForeground(new Color(54,73,88));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(titleLabel);
		
		currentCourse = new JButton("Current Course");
		currentCourse.setForeground(Color.white);
		currentCourse.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		currentCourse.setBackground(new Color(85,130,139));
		currentCourse.setBounds(30,100,60,40);
		currentCourse.addActionListener(this);
		panel.add(currentCourse);
		
		creditInfo = new JButton("Credits Info");
		creditInfo.setForeground(Color.white);
		creditInfo.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		creditInfo.setBackground(new Color(85,130,139));
		creditInfo.setBounds(30,180,60,40);
		creditInfo.addActionListener(this);
		panel.add(creditInfo);
		
		selectCourse = new JButton("Select future courses");
		selectCourse.setForeground(Color.white);
		selectCourse.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 35));
		selectCourse.setBackground(new Color(85,130,139));
		selectCourse.setBounds(30,260,60,40);
		selectCourse.addActionListener(this);
		panel.add(selectCourse);
		
		
		
	}

	private void addStudentInfoComponents() {
		// TODO Auto-generated method stub
		
		infoPanel = new JPanel(null);
		infoPanel.setBackground(new Color(201,228,202));
		infoPanel.setBounds(0,0,300,HEIGHT);
		
		subTitle = new JLabel("Student Info");
		subTitle.setBounds(0,0,300,50);
		subTitle.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 45));
		subTitle.setForeground(new Color(135,187,162));
		subTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(subTitle);
		
		nameLabel = new JLabel("name");
		nameLabel.setBounds(0,80,300,50);
		nameLabel.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 40));
		nameLabel.setForeground(new Color(135,187,162));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(nameLabel);
		
		add(infoPanel);		
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
