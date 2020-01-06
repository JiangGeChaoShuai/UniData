import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginFrame {

	private JFrame inputFrame = new JFrame();

	public static void main(String[] args) {

		LoginFrame window = new LoginFrame();

		window.inputFrame.setVisible(true);

	}

	public LoginFrame() {

		initialize();
	}

	private void initialize() {

		inputFrame.setSize(1000, 600);
		createLayout();

	}

	private void createLayout() {

		inputFrame.setLayout(new GridLayout(4, 1));

		JPanel titlePanel = new JPanel();

		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("Login Frame");

		title.setPreferredSize(new Dimension(200, 100));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setVisible(true);

		titlePanel.add(title, BorderLayout.CENTER);
		titlePanel.setVisible(true);

		JPanel usernamePanel = new JPanel();
		usernamePanel.setLayout(new GridLayout(2, 1));
		usernamePanel.setBorder(BorderFactory.createEmptyBorder(0, usernamePanel.getWidth() / 2 - 200, 0,
				usernamePanel.getWidth() / 2 - 200));

		JLabel usernameTitle = new JLabel("USERNAME");
		usernameTitle.setVisible(true);
		usernameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

		JTextField username = new JTextField(20);
		username.setVisible(true);
		username.setAlignmentX(Component.CENTER_ALIGNMENT);

		username.setOpaque(true);
		username.setPreferredSize(new Dimension(400, 50));

		// set text
		username.setFont(new Font("Serif", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		usernamePanel.add(usernameTitle);
		usernamePanel.add(username);
		usernamePanel.setVisible(true);

		JPanel password = new JPanel();

		JPanel buttons = new JPanel();

		inputFrame.add(titlePanel);
		inputFrame.add(usernamePanel);
		inputFrame.add(password);
		inputFrame.add(buttons);

	}

}
