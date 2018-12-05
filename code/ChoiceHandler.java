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


public class ChoiceHandler extends JFrame implements ActionListener {
	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton)e.getSource();
		//JTextField field = (JTextField)e.getSource();
		if(btn.getText().equals("Forward"))
		{
			backButton.setVisible(false);
		}

		if(btn.getText().equals("Left"))
		{
			rightButton.setVisible(false);
		}

		if(btn.getText().equals("Right"))
		{
			leftButton.setVisible(false);
		}

		if(btn.getText().equals("Backwards"))
		{
			forwardButton.setVisible(false);
		}
	}


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
		forwardButton.addActionListener(this);
		JButton button3 = Style.createButton("");
		leftButton = Style.createButton("Left");
		leftButton.addActionListener(this);
		rightButton = Style.createButton("Right");
		rightButton.addActionListener(this);
		backButton = Style.createButton("Back");
		backButton.addActionListener(this);
		controlsPanel.setLayout(new GridLayout(2,3));
		controlsPanel.add(button1);
		controlsPanel.add(forwardButton);
		controlsPanel.add(button3);
		controlsPanel.add(leftButton);
		controlsPanel.add(rightButton);
		controlsPanel.add(backButton);

		con.add(controlsPanel);

		mainTextArea = new JTextArea("Eventyret: Du har i flere år, sommer og vinter, vandret rundt i verden. Du har kun det tøj, du går i, en vandrestav, en rygsæk og nogle ganske få penge.  Sensommerdagen er ved at gå på hæld. Solen går snart ned, men du er tæt på landsbyen, hvor nogle af dine venner bor. Her regner du med at få en hyggelig aften og en god nats søvn, før du fortsætter din rejse. Ganske rigtigt. Efter en varm velkomst, et hyggeligt (og meget lækkert) måltid sætter I jer til rette i stuen. Dine venner vil jo gerne høre nyt fra den store verden og hvad du selv har oplevet. Det er langsomt blevet mørkere og i skæret af lyset fra en tændt pejs, bliver du overtalt til at fortælle om dengang, at du løste gåden om Det forbandede hus. Du fortæller, hvordan du stod foran døren ind til huset. En egetræsdør, er lukket, og ...");
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(200, 100, 700, 350);
		mainTextPanel.setBackground(Color.black);
		mainTextArea.setBounds(200, 100, 700, 350);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(Style.textFont);
		con.add(mainTextPanel);
		mainTextPanel.add(mainTextArea);


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
