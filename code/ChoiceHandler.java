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
  JPanel controlsPanel, titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
  JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
  Font uifont = new Font("Times New Roman", Font.PLAIN, 25);
  Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
  Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
  JButton startButton, backButton, forwardButton, leftButton, rightButton, button1, button3;
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

		Item weapon = new Item("Noob sword", "Bad sword", 10, "weapon", 0);
		Item lantern = new Item("Lantern", "Lights up", 0, "weapon", 0);
		Item key = new Item("Key", "Unlocks a door somewhere", 0, "Consumable", 0);
		Item healthPotion = new Item("Health Potion", "Restores a small amount of health", 0, "Consumable", 10);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(weapon);
		items.add(lantern);
		items.add(key);
		items.add(healthPotion);
		Inventory inventory = new Inventory();
		inventory.setAllItems(items);

		this.player = new Player(playerName);

		window = new JFrame();
		window.setSize(1100, 650);
		window.setLocationRelativeTo(null);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();


		con.add(Style.createTopUI(playerName));
		controlsPanel = new JPanel();
		controlsPanel.setBounds(350, 470, 400, 130);
		controlsPanel.setBackground(Color.black);
		JButton button1 = Style.createButton("");
		forwardButton = Style.createButton("Forward");
		JButton button3 = Style.createButton("");
		leftButton = Style.createButton("Left");
		rightButton = Style.createButton("Right");
		backButton = Style.createButton("Back");
		controlsPanel.setLayout(new GridLayout(2,3));
		controlsPanel.add(button1);
		controlsPanel.add(forwardButton);
		controlsPanel.add(button3);
		controlsPanel.add(leftButton);
		controlsPanel.add(rightButton);
		controlsPanel.add(backButton);

		con.add(controlsPanel);

		mainTextArea = new JTextArea();
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 450, 450, 200);
		mainTextPanel.setBackground(Color.red);
		con.add(mainTextPanel);


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