import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout;

import java.util.ArrayList;
public class ChoiceHandler {
	private Player player;
	private ArrayList<Encounter> randomEncounters;
	private int progression;
  JFrame window;
  Container con;
  JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
  JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
  Font uifont = new Font("Times New Roman", Font.PLAIN, 25);
  Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
  Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
  JButton startButton, choiceButton1, choiceButton2, choiceButton3, choiceButton4;
  JTextArea mainTextArea;

  int playerHP;
  String weapon;
  JPanel topUIPanel;
  JLabel playerinfoLabel;
  JButton inventoryButton;
	public void intro() {
		
	}

	public void walk(String direction) {
		
	}

	public void openInventory() {
		
	}

	public void choiceHandler(Player player) {
		
	}

	public void playGame(String playerName) {
		Item startWeapon = new Item("Noob sword", "Bad sword", 10, "weapon", 0);
		this.player = new Player(playerName);

		window = new JFrame();
		window.setSize(1100, 650);
		//window.setLocation(0, 0);
		window.setLocationRelativeTo(null);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();

		


		con.add(Style.createTopUI(playerName));
		window.setVisible(true);
	}

	public void randomEncounter() {
		
	}

	public void death() {
		
	}

	public ArrayList<Encounter> getRandomEncounters() {
		return new ArrayList<Encounter>();
	}

	public void setRandomEncounters(ArrayList<Encounter> randomEncounters) {
		
	}

	public void generateRandomEncounters() {
		
	}

	public int getProgression() {
		return this.progression;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}
}