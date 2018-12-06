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
	JButton startButton, backButton, forwardButton, leftButton, rightButton, button1, button3, inventoryButton, topleftButton, toprightButton;
	JTextArea mainTextArea;
	Item weapon = new Item("Noob sword", "Bad sword", 10, "weapon", 0);
	Item lantern = new Item("Lantern", "Lights up", 0, "weapon", 0);
	Item key = new Item("Key", "Unlocks a door somewhere", 0, "Consumable", 0);
	Item healthPotion = new Item("Health Potion", "Restores a small amount of health", 0, "Consumable", 10);
	public int playerHP;
	public int damageWithoutWeapon = 5;
	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton)e.getSource();
		//JTextField field = (JTextField)e.getSource();
		if(btn.getText().equals("North"))
		{
			goForward();
		}

		if(btn.getText().equals("West"))
		{
			if(this.player.getPosition().equals("lantern")){
				this.player.setPosition("start");
				updateOptions();
			}
		}

		if(btn.getText().equals("East"))
		{

			
			if(this.player.getPosition().equals("start"))
			{
				this.player.setPosition("lantern");
				updateOptions();
			}
		}
		if(btn.getText().equals("Pick up")){
			if(this.player.getPosition().equals("lantern")){
				this.player.getInventory().addItem(lantern);
				toprightButton.setVisible(false);
				mainTextArea.setText("You picked up the lantern");
			}
		}
		if(btn.getText().equals("South"))
		{
			
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
			}
		}
	}
	public void updateOptions()
	{
		if(player.getPosition().equals("lantern"))
		{
			if(this.player.getInventory().getAllItems().contains(lantern))
			{
				mainTextArea.setText("There's nothing here...");
			}
			else{
			mainTextArea.setText("You're next to a lantern. West of you is the end of the road, next to the house.");
			toprightButton.setText("Pick up");
			}
			rightButton.setVisible(false);
			backButton.setVisible(false);
			forwardButton.setVisible(false);
		}
		else if(player.getPosition().equals("start")){
			if(this.player.getInventory().getAllItems().contains(lantern)){
				mainTextArea.setText("You stand in front of a wooden door, to your right is the place you picked the lantern up.\n"+
			"To your left is a dark well.");
			}
			else{
				mainTextArea.setText("You stand in front of a wooden door, to your right is a lantern.\n"+
			"To your left is a dark well.");

			}
			rightButton.setVisible(true);
			leftButton.setVisible(true);
			forwardButton.setVisible(true);
			backButton.setVisible(true);
		}
	}



	public void intro() {

	}

	public void walk(String direction) {

	}

	public void openInventory() {

	}

	public void choiceHandler(Player player) {

	}

	public void playGame(String playerName) {

		
		ArrayList<Item> items = new ArrayList<Item>();
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

		mainTextArea = new JTextArea("You stand in front of a wooden door, to your right is a lantern.\n"+
			"To your left is a dark well.");
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
		topleftButton = Style.createButton("");
		forwardButton = Style.createButton("North");
		toprightButton = Style.createButton("");
		leftButton = Style.createButton("West");
		backButton = Style.createButton("South");
		rightButton = Style.createButton("East");
		controlsPanel.setLayout(new GridLayout(2,3));

		JButton buttonArr[] = {topleftButton, forwardButton, toprightButton, leftButton, backButton, rightButton};
		for (JButton button : buttonArr ) {
			controlsPanel.add(button);
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
