package Displays;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ClassroomPanel {

	private static JPanel mainPanel = new JPanel();

	public ClassroomPanel() {

		initialize();
	}

	private void initialize() {

		mainPanel.setLayout(new FlowLayout());
		
		createTopPanel();
		createMemberList();
		createInfoPanel();

	}

	private void createTopPanel() {

		JPanel panelOnTop = new JPanel();

		panelOnTop.setLayout(null);
		panelOnTop.setPreferredSize(new Dimension(LoginFrame.width, 100));
		
		panelOnTop.setBackground(new Color(10, 27, 189));
		
		mainPanel.add(panelOnTop);

	}

	private void createMemberList() {

		JPanel memberList = new JPanel();

		memberList.setLayout(null);
		memberList.setPreferredSize(new Dimension(370, LoginFrame.height-130));
		memberList.setBackground(new Color(27, 189, 10));
		
		mainPanel.add(memberList);

	}

	private void createInfoPanel() {

		JPanel infoPanel = new JPanel();

		infoPanel.setLayout(null);
		infoPanel.setPreferredSize(new Dimension(LoginFrame.width-400, LoginFrame.height-130));
		infoPanel.setBackground(new Color(189, 10, 27));
		
		mainPanel.add(infoPanel);
	}

	public JPanel returnJPanel() {

		mainPanel.setVisible(true);
		return mainPanel;
	}
}
