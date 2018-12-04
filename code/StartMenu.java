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
	JPanel titlePanel, startButtonPanel, quitButtonPanel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
	JButton startButton, quitButton;
	JTextArea mainTextArea;
	TitleScreenHandler tsHandler = new TitleScreenHandler();

	public static void main(String[] args)
	{
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
	    titleNameLabel = new JLabel("PLACEHOLDER");
	    titleNameLabel.setForeground(Color.white);
	    titleNameLabel.setFont(titleFont);

	    startButtonPanel = new JPanel();
	    startButtonPanel.setBounds(300, 400, 200, 50);
	    startButtonPanel.setBackground(Color.black);

	    //creating start button and making it clickable
	    startButton = new JButton("START");
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