//importing all the shit we need
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

public class Game
{
  JFrame window;
  Container con;
  JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
  JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
  Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
  Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
  Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
  JButton startButton, choiceButton1, choiceButton2, choiceButton3, choiceButton4;
  JTextArea mainTextArea;

  int playerHP;
  String weapon;

  TitleScreenHandler tsHandler = new TitleScreenHandler();

  public static void main(String[] args)
  {
    new Game();
  }

  public Game()
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

  public void createGameScreen()
  {
    titleNamePanel.setVisible(false);
    startButtonPanel.setVisible(false);

    mainTextPanel = new JPanel();
    mainTextPanel.setBounds(100, 100, 600, 250);
    mainTextPanel.setBackground(Color.black);

    mainTextArea = new JTextArea("You wake up in a dark room. Your vision is slurred and your eyes are having a hard time adjusting to the darkness. As you get up, your hand slides across the back of your head. It hurts just above the neck, and you feel a wet sensation on your hand. The smell is unmistakably blood.");
    mainTextArea.setBounds(100, 100, 600, 250);
    mainTextArea.setBackground(Color.black);
    mainTextArea.setForeground(Color.white);
    mainTextArea.setFont(textFont);
    mainTextArea.setLineWrap(true);
    mainTextPanel.add(mainTextArea);

    choiceButtonPanel = new JPanel();
    choiceButtonPanel.setBounds(250, 350, 300, 150);
    choiceButtonPanel.setBackground(Color.black);
    choiceButtonPanel.setLayout(new GridLayout(4,1));

    choiceButton1 = new JButton("1:");
    choiceButton1.setBackground(Color.blue);
    choiceButton1.setForeground(Color.white);
    choiceButton1.setOpaque(true);
    choiceButton1.setBorderPainted(false);
    choiceButton1.setFont(buttonFont);
    choiceButtonPanel.add(choiceButton1);
    choiceButton2 = new JButton("2:");
    choiceButton2.setBackground(Color.black);
    choiceButton2.setForeground(Color.white);
    choiceButton2.setOpaque(true);
    choiceButton2.setBorderPainted(false);
    choiceButton2.setFont(buttonFont);
    choiceButtonPanel.add(choiceButton2);
    choiceButton3 = new JButton("3:");
    choiceButton3.setBackground(Color.black);
    choiceButton3.setForeground(Color.white);
    choiceButton3.setOpaque(true);
    choiceButton3.setBorderPainted(false);
    choiceButton3.setFont(buttonFont);
    choiceButtonPanel.add(choiceButton3);
    choiceButton4 = new JButton("4:");
    choiceButton4.setBackground(Color.black);
    choiceButton4.setForeground(Color.white);
    choiceButton4.setOpaque(true);
    choiceButton4.setBorderPainted(false);
    choiceButton4.setFont(buttonFont);
    choiceButtonPanel.add(choiceButton4);

    playerPanel = new JPanel();
    playerPanel.setBounds(100, 15, 600, 50);
    playerPanel.setBackground(Color.black);
    playerPanel.setLayout(new GridLayout(1,4));

    hpLabel = new JLabel("HP:");
    hpLabel.setFont(buttonFont);
    hpLabel.setForeground(Color.white);
    playerPanel.add(hpLabel);
    hpLabelNumber = new JLabel();
    hpLabelNumber.setFont(buttonFont);
    hpLabelNumber.setForeground(Color.white);
    playerPanel.add(hpLabelNumber);
    weaponLabel = new JLabel("Weapon:");
    weaponLabel.setFont(buttonFont);
    weaponLabel.setForeground(Color.white);
    playerPanel.add(weaponLabel);
    weaponLabelName = new JLabel();
    weaponLabelName.setFont(buttonFont);
    weaponLabelName.setForeground(Color.white);
    playerPanel.add(weaponLabelName);


    //adds mainTextPanel & choiceButtonPanel to the container, making them visible.
    con.add(mainTextPanel);
    con.add(choiceButtonPanel);
    con.add(playerPanel);

    playerSetup();

  }
  public void playerSetup()
  {
    playerHP = 100;
    weapon = "Fists";
    weaponLabelName.setText(weapon);
    hpLabelNumber.setText("" + playerHP);


  }

  public class TitleScreenHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      createGameScreen();
    }
  }
}
