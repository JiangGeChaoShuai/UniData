package Displays;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class StudentCenterState extends State {
	
	//JComponents
	private JPanel panel,infoPanel;
	private JLabel titleLabel,subTitle,nameLabel,birth,studentNum,timeEnroll,email,major;
	private JButton info,creditButton,selectCourse;
	
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

		addStudentInfoComponents();

		add(panel);
	
		titleLabel = new JLabel("Student Center");
		titleLabel.setBounds(0, 45, 900, 80);
		titleLabel.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 55));
		titleLabel.setForeground(new Color(54,73,88));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(titleLabel);
		
	}

	private void addStudentInfoComponents() {
		// TODO Auto-generated method stub
		
		infoPanel = new JPanel(null);
		infoPanel.setBackground(new Color(201,228,202));
		infoPanel.setBounds(0,0,300,HEIGHT);
		add(infoPanel);
		
		subTitle = new JLabel("Student Info");
		subTitle.setBounds(0,0,300,50);
		subTitle.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 45));
		subTitle.setForeground(new Color(135,187,162));
		subTitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(subTitle);
		
		nameLabel = new JLabel("name");
		nameLabel.setBounds(0,80,300,50);
		nameLabel.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 40));
		nameLabel.setForeground(new Color(135,187,162));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoPanel.add(nameLabel);
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
