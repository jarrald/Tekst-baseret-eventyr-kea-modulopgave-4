import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.Dimension;

public class StartMenu {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, playerNameFieldPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
	JButton startButton, choiceButton1, choiceButton2, choiceButton3, choiceButton4;
	JTextArea mainTextArea;
	JTextField playerNameField;
	int playerHP;
	String weapon;

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	public static void main(String[] args)
	{
		new StartMenu();

	}
	public StartMenu()
	{
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();

		//creating a panel with a label on it (which will act as game title)
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Text adventure");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 50);
		startButtonPanel.setBackground(Color.black);
		startButton = createButton("Start");
		startButton.addActionListener(tsHandler);

		titleNamePanel.add(titleNameLabel);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		startButtonPanel.add(startButton);

		//quitButton = new JButton("Quit");


		window.setVisible(true);
	}
	public JButton createButton(String name)
	{
		JButton btn = new JButton(name);
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		btn.setForeground(Color.white);
		btn.setBackground(Color.black);
		btn.setFont(buttonFont);
		return btn;
	}



	public void startGame() {
		startButton.setVisible(false);
		titleNameLabel.setFont(textFont);
		titleNameLabel.setText("Choose a name");
		titleNamePanel.setSize(600, 300);
		playerNameField = new JTextField(20);
		JButton submitPlayerName = new JButton("submit");
		SubmitName submitNamehandler = new SubmitName();
		submitPlayerName.addActionListener(submitNamehandler);
		titleNamePanel.add(playerNameField);
		titleNamePanel.add(submitPlayerName);
		
	}

	public void createPlayer(String name) {
		titleNameLabel.setText("Name choosen: " + name);
	}
	public class SubmitName implements ActionListener
	{
			public void actionPerformed(ActionEvent event)
			{
				playerNameField.setFont(textFont);
				createPlayer(playerNameField.getText());
			}
	}
	public class TitleScreenHandler implements ActionListener
	{
			public void actionPerformed(ActionEvent event)
			{
				startGame();
			}
	}
}