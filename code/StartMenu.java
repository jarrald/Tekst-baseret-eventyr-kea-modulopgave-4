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

public class StartMenu extends JFrame implements ActionListener {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, playerNameFieldPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
	JButton startButton, choiceButton1, choiceButton2, choiceButton3, choiceButton4, quitButton;
	JTextArea mainTextArea;
	JTextField playerNameField;
	int playerHP;
	String weapon, playerName;
	boolean quit;

	public static void main(String[] args)
	{
		StartMenu startmenu = new StartMenu();
		startmenu.loadMenu();
	}
	public static void startChoiceHandler(String playerName, StartMenu startmenu){
		startmenu.window.dispose();
		startmenu.dispose();
		ChoiceHandler ch = new ChoiceHandler();
		ch.playGame(playerName);

	}
	public void actionPerformed(ActionEvent e)
	{
		//Enter press on textfield
		
		if(e.getActionCommand().equals("Submit"))
		{
			StartMenu.startChoiceHandler(playerNameField.getText(), this);
		}
		else{
			JButton btn = (JButton)e.getSource();
			//JTextField field = (JTextField)e.getSource();
			if(btn.getText().equals("Quit"))
			{
				window.dispose();
				quit = true;
			}
			else if(btn.getText().equals("Start"))
			{
				startGame();
			}
			else if(btn.getText().equals("Submit"))
			{
				StartMenu.startChoiceHandler(playerNameField.getText(), this);
			}
			else if(e.getActionCommand().equals("Submit")){
				
			}
		}

	}
	public StartMenu()
	{
		quit = false;
	}
	public void loadMenu()
	{
		window = Style.createFrame(800, 600);
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
		startButton = Style.createButton("Start");
		startButton.addActionListener(this);
		/*
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				startGame();
			}
		});
		*/
		titleNamePanel.add(titleNameLabel);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		startButtonPanel.add(startButton);
		quitButton = Style.createButton("Quit");
		startButtonPanel.add(quitButton);
		quitButton.addActionListener(this);
		startButton.requestFocusInWindow();
		/*
		quitButton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event)
					{
						System.exit(0);
					}
				});
		*/

		window.setVisible(true);
	}
	public void createPlayer(String playerName){
		Player player = new Player(playerName);
		window = null;
	}
	public void startGame() {
		startButton.setVisible(false);
		titleNameLabel.setFont(textFont);
		titleNameLabel.setText("Choose a name");
		titleNamePanel.setSize(600, 300);
		playerNameField = new JTextField(20);
		//playerNameField.select(0,0);
		playerNameField.requestFocusInWindow();
		JButton submitButton = Style.createButton("Submit");
		
		titleNamePanel.add(playerNameField);
		titleNamePanel.add(submitButton);
		submitButton.addActionListener(this);
		playerNameField.setActionCommand("Submit");
		playerNameField.addActionListener(this);
		playerNameField.requestFocusInWindow();
		/*
		submitButton.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event)
				{
					playerNameField.setFont(textFont);
					titleNameLabel.setText(playerNameField.getText());
					createPlayer(playerNameField.getText());
				}
		});
		*/
	}
}