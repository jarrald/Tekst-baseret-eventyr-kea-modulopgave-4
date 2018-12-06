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
			goForward();
		}

		if(btn.getText().equals("Left"))
		{
			rightButton.setVisible(false);
		}

		if(btn.getText().equals("Right"))
		{
			leftButton.setVisible(false);
		}

		if(btn.getText().equals("Back"))
		{
			forwardButton.setVisible(false);
		}
		if(btn.getText().equals("Inventory"))
		{
			if(inventoryPanel.isVisible()){
				inventoryPanel.setVisible(false);
				inventoryPanel.removeAll();
				mainTextPanel.setVisible(true);
			}
			else{
				inventoryPanel.setVisible(true);
				mainTextPanel.setVisible(false);
				for(Item item : player.getInventory().getAllItems()){
					JLabel itemNameLabel = Style.createUILabel(item.getName());
					inventoryPanel.add(itemNameLabel);
					JLabel itemDesc = Style.createUILabel(item.getDescription());
					itemDesc.setFont(textFont);
					inventoryPanel.add(itemDesc);
				}
				for(Item item : player.getInventory().getAllItems()){
					
				}
				
				/*
				inventoryPanel.validate();
				inventoryPanel.repaint();
				*/
			}
		}
	}


	private Player player;
	private ArrayList<Encounter> randomEncounters;
	private int progression;
	JFrame window;
	Container con;
	JPanel controlsPanel, titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, topUIPanel, inventoryPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, damageLabel, playerinfoLabel;
	Font uifont = new Font("Times New Roman", Font.PLAIN, 25);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
	JButton startButton, backButton, forwardButton, leftButton, rightButton, button1, button3, inventoryButton, topleft, topright;
	JTextArea mainTextArea;

	public int playerHP;
	String weapon;
	public int damageWithoutWeapon = 5;

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
		this.player.setInventory(inventory);

		window = Style.createFrame(1100, 650);
		con = window.getContentPane();
		
		topUIPanel = Style.createPanel(50, 0, 1000, 100);
		topUIPanel.setLayout(new GridLayout(1, 3));

		damageLabel = Style.createUILabel("Damage "+this.damageWithoutWeapon);
		playerinfoLabel = Style.createUILabel(this.player.getName()+" HP: "+this.player.getHealth());
		inventoryButton = Style.createButton("Inventory");
		inventoryButton.setFont(uifont);

		topUIPanel.add(playerinfoLabel);
		topUIPanel.add(damageLabel);
		topUIPanel.add(inventoryButton);
		inventoryButton.addActionListener(this);


		inventoryPanel = Style.createPanel(200, 100, 700, 350);
		inventoryPanel.setVisible(false);
		inventoryPanel.setLayout(new GridLayout(10, 1));


		con.add(topUIPanel);
		createControls();
		con.add(controlsPanel);

		mainTextArea = new JTextArea("Eventyret: Du har i flere år, sommer og vinter,"+
			" vandret rundt i verden. Du har kun det tøj, du går i, en vandrestav, en rygsæk og nogle ganske få penge. "+
			"Sensommerdagen er ved at gå på hæld. Solen går snart ned, men du er tæt på landsbyen, hvor nogle af dine venner "+
			"bor. Her regner du med at få en hyggelig aften og en god nats søvn, før du fortsætter din rejse. Ganske rigtigt."+
			" Efter en varm velkomst, et hyggeligt (og meget lækkert) måltid sætter I jer til rette i stuen. Dine venner vil"+
			" jo gerne høre nyt fra den store verden og hvad du selv har oplevet. Det er langsomt blevet mørkere og i "+
			"skæret af lyset fra en tændt pejs, bliver du overtalt til at fortælle om dengang, at du løste gåden om Det"+
			" forbandede hus. Du fortæller, hvordan du stod foran døren ind til huset. En egetræsdør, er lukket, og ...");
		mainTextPanel = Style.createPanel(200,100,700,350);


		mainTextArea.setBounds(200, 100, 700, 350);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(Style.textFont);
		mainTextArea.setEditable(false);
		con.add(inventoryPanel);
		con.add(mainTextPanel);
		mainTextPanel.add(mainTextArea);


		window.setVisible(true);
	}
	public void createControls(){
		controlsPanel = Style.createPanel(350, 470, 400, 130);
		topleft = Style.createButton("");
		forwardButton = Style.createButton("Forward");
		topright = Style.createButton("");
		leftButton = Style.createButton("Left");
		backButton = Style.createButton("Back");
		rightButton = Style.createButton("Right");
		controlsPanel.setLayout(new GridLayout(2,3));

		JButton buttonArr[] = {topleft, forwardButton, topright, leftButton, backButton, rightButton};
		for (JButton button : buttonArr ) {
			controlsPanel.add(button);
			if(!button.getText().equals(""))
				button.addActionListener(this);
		}
	}
	public void randomEncounter() {

	}

	public void death() {

	}

	public void goForward() {
		leftButton.setVisible(false);
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
