import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout;

public class StartMenu {
	
	JFrame gameFrame;
	Container con;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	JTextArea mainTextArea;
	public static void main(String[] args)
	{
		JButton startButton, quitButton;
		JPanel titlePanel, startButtonPanel, quitButtonPanel;

		//creating window/frame of program
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
	    titleNameLabel = new JLabel("The haunted house");
	    titleNameLabel.setForeground(Color.white);
	    titleNameLabel.setFont(titleFont);

	    startButtonPanel = new JPanel();
	    startButtonPanel.setBounds(300, 400, 200, 50);
	    startButtonPanel.setBackground(Color.black);

	    //creating start button and making it clickable
	    startButton = new JButton("Start game");
	    startButton.setBackground(Color.black);
	    startButton.setOpaque(true);
	    startButton.setBorderPainted(false);
	    startButton.setForeground(Color.white);
	    startButton.setFont(buttonFont);
	    startButton.addActionListener(tsHandler);

	    titleNamePanel.add(titleNameLabel);
	    con.add(titleNamePanel);
	    con.add(startButtonPanel);
	    startButtonPanel.add(startButton);

	    window.setVisible(true);
	}
	public ChoiceHandler _;

	public static void startGame() {
		titleNamePanel.setVisible(false);
		startButton.setVisible(false);
		JTextField playerNameField;
		JButton submitPlayerName;
		JPanel playerNameFieldPanel;
		playerNameFieldPanel.add(playerNameField);
		playerNameFieldPanel.add(submitPlayerName);
		playerNameFieldPanel.setBounds(100, 100, 600, 250);
		playerNameFieldPanel.setBackground(Color.black);
		
		con.add(playerNameField);
	}

	private Player createPlayer(String name) {
		throw new UnsupportedOperationException();
	}
	public class TitleScreenHandler implements ActionListener
  	{
	    public void actionPerformed(ActionEvent event)
	    {
	      startGame();
	    }
	}
}