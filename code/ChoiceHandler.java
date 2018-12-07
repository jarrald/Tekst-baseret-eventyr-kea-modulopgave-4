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
	JTextField riddleAnswerTextField;
	Item weapon = new Item("Noob sword", "Bad sword", 10, "weapon", 0);
	Item lantern = new Item("Lantern", "Lights up", 0, "weapon", 0);
	Item key = new Item("Key", "Unlocks a door somewhere", 0, "Consumable", 0);
	Item healthPotion = new Item("Health Potion", "Restores a small amount of health", 0, "Consumable", 10);
	boolean wardrobePotionTaken;
	boolean treasureroomIsLit = false;
	public int playerHP;
	public int damageWithoutWeapon = 5;
	public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton)e.getSource();
		//JTextField field = (JTextField)e.getSource();
		if(btn.getText().equals("North"))
		{
			if(this.player.getPosition().equals("start")){
				this.player.setPosition("entrance");
				updateOptions();
			}
			else if(this.player.getPosition().equals("entrance")){
				this.player.setPosition("foyer");
				updateOptions();
			}
			else if(this.player.getPosition().equals("basement")){
				this.player.setPosition("treasureroom");
				updateOptions();
			}
			else if(btn.getText().equals("Approach")){
				if(this.player.getPosition().equals("treasureroom")){
					this.player.setPosition("riddle");
					updateOptions();
				}
			}
			else if(btn.getText().equals("Ready")){
				if(this.player.getPosition().equals("riddle")){
					this.player.setPosition("riddle2");
					updateOptions();
				}
			}
		}else if(btn.getText().equals("West"))
		{
			if(this.player.getPosition().equals("lantern")){
				this.player.setPosition("start");
				updateOptions();
			}else if(this.player.getPosition().equals("start")){
				this.player.setPosition("well");
				updateOptions();
			}else if(this.player.getPosition().equals("wardrobe")){
				this.player.setPosition("foyer");
				updateOptions();
			}
			else if(this.player.getPosition().equals("foyer")){
				this.player.setPosition("basement");
				updateOptions();
			}
		}else if(btn.getText().equals("Unlock")){
			hideButtons();
			forwardButton.setVisible(true);
			backButton.setVisible(true);
			mainTextArea.setText("You've unlocked and opened the door. There's a dark room in front of you.");

		}else if(btn.getText().equals("East"))
		{


			if(this.player.getPosition().equals("start"))
			{
				this.player.setPosition("lantern");
				updateOptions();
			}
			else if(this.player.getPosition().equals("well"))
			{
				this.player.setPosition("start");
				updateOptions();
			}
			else if(this.player.getPosition().equals("foyer"))
			{
				this.player.setPosition("wardrobe");
				updateOptions();
			}
			else if(this.player.getPosition().equals("basement")){
				this.player.setPosition("foyer");
				updateOptions();
			}


		}else if(btn.getText().equals("Pick up")){
			if(this.player.getPosition().equals("lantern")){
				this.player.getInventory().addItem(lantern);
				toprightButton.setVisible(false);
				mainTextArea.setText("You picked up the lantern");
			}else if(player.getPosition().equals("wardrobe") && !wardrobePotionTaken){
				this.player.getInventory().addItem(healthPotion);
				wardrobePotionTaken = true;
				toprightButton.setVisible(false);
				mainTextArea.setText("You picked up the health potion");
			}


		}else if(btn.getText().equals("South"))
		{
			if(player.getPosition().equals("entrance")){
				this.player.setPosition("start");
				updateOptions();
			}
			else if(player.getPosition().equals("foyer")){
				this.player.setPosition("entrance");
				updateOptions();
			}

		}else if(btn.getText().equals("Inventory"))
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
		if(btn.getText().equals("Look down well")){
			if(this.player.getInventory().getAllItems().contains(key)){
				mainTextArea.setText("There's nothing there");
			}
			else if(this.player.getInventory().getAllItems().contains(lantern)){
				mainTextArea.setText("There's a key at the bottom of the well");
				toprightButton.setVisible(false);
				topleftButton.setVisible(true);
				topleftButton.setText("Fish for key");
			}
			else{
				mainTextArea.setText("It's too dark to see");
			}
		}
		if(btn.getText().equals("Fish for key")){
			this.player.getInventory().addItem(key);
			mainTextArea.setText("You picked up the key.");
			topleftButton.setVisible(false);
		}

	}
	public void updateOptions()
	{
		if(player.getPosition().equals("lantern"))
		{
			hideButtons();
			leftButton.setVisible(true);
			if(this.player.getInventory().getAllItems().contains(lantern))
			{
				mainTextArea.setText("There's nothing here...");
			}
			else{
			mainTextArea.setText("You're next to a lantern. West of you is the end of the road, next to the house.");
			toprightButton.setText("Pick up");
			toprightButton.setVisible(true);
			}

		}
		else if(player.getPosition().equals("start")){
			if(this.player.getInventory().getAllItems().contains(lantern)){
				mainTextArea.setText("You stand in front of a wooden door, to your right is the place you picked the lantern up. To your left is a dark well.");
			}
			else{
				mainTextArea.setText("You stand in front of a wooden door, to your right is a lantern. To your left is a dark well.");

			}
			hideButtons();
			rightButton.setVisible(true);
			leftButton.setVisible(true);
			forwardButton.setVisible(true);
		}
		else if(player.getPosition().equals("well")){
			mainTextArea.setText("There's a bucket at the well, to your east is the place you started.");
			hideButtons();
			toprightButton.setVisible(true);
			rightButton.setVisible(true);
			rightButton.setText("East");
			toprightButton.setText("Look down well");
		}
		else if(player.getPosition().equals("entrance")){
			hideButtons();
			backButton.setVisible(true);
			mainTextArea.setText("There's a locked door in front of you.");
			if(this.player.getInventory().getAllItems().contains(key)){
				toprightButton.setVisible(true);
				toprightButton.setText("Unlock");
			}
		}
		else if(player.getPosition().equals("foyer")){
			mainTextArea.setText("Your lantern lights up the dark foyer of the building. You look around the big entrance hall. To the left is a doorway down some stairs; propably leading to the basement. You can hear faint sounds coming from there. To the north of you is a staircase, but its collapsed from rot. There doesn't seem to be a way up there from this room. To the east is an old wardrobe.");
			hideButtons();
			backButton.setVisible(true);
			leftButton.setVisible(true);
			rightButton.setVisible(true);
		}
		else if(player.getPosition().equals("basement")){
			mainTextArea.setText("The basement is dark and a weird smell lingers. " +
														"You accidentally knocked over a rusty sword on you way down, "+
														"and it now lays at your feet.");
			hideButtons();
			toprightButton.setText("Pick up");
			toprightButton.setVisible(true);
			rightButton.setVisible(true);
			forwardButton.setVisible(true);
		}
		else if(player.getPosition().equals("wardrobe")){
			if(wardrobePotionTaken){
				mainTextArea.setText("You walk up to the wardrobe. There's a message carved into the one of the wardrobe doors. It reads \"DO NOT TRUST HIM\". There's nothing else here.");
				hideButtons();
				leftButton.setVisible(true);
			}else{
			mainTextArea.setText("You walk up to the wardrobe and open it slowly. There's a message carved into the one of the wardrobe doors. It reads \"DO NOT TRUST HIM\". There's a health potion standing on one of the shelves inside the wardrobe.");
			hideButtons();
			toprightButton.setText("Pick up");
			toprightButton.setVisible(true);
			leftButton.setVisible(true);
		}
	}
	else if(player.getPosition().equals("treasureroom")){
		if(!treasureroomIsLit){
			mainTextArea.setText("You enter the room slowly, and stop just past the doorway. It's too dark to see anything.");
			hideButtons();
			backButton.setVisible(true);
			toprightButton.setText("Use lantern");
			toprightButton.setVisible(true);
		} else{
			mainTextArea.setText("The room lights up, and a mysterious figure appears a few meters in front of you. Behind them is a chest with a faint glow.");
			forwardButton.setText("Approach");
			forwardButton.setVisible(true);
		}
	}
	else if(player.getPosition().equals("riddle")){
		mainTextArea.setText("The man greets you. He continues: \"Hello stranger. I have a riddle for you to solve. If you answer correctly you will be awarded with gold and an invaluable artifact; the fabled deathbringer sword. Ready?\"");
		hideButtons();
		forwardButton.setText("Ready");
		forwardButton.setVisible(true);
	}
	else if(player.getPosition().equals("riddle2")){
		mainTextArea.setText("If A implies B and B implies C, and D implies A, and E implies D, what does A imply?");
		hideButtons();
		riddleAnswerTextField = new JTextField(20);
		riddleAnswerTextField.visible(true);
		riddleAnswerTextField.addActionListener(this);
	}
}
	public void hideButtons(){

		topleftButton.setVisible(false);
		leftButton.setVisible(false);
		toprightButton.setVisible(false);
		forwardButton.setVisible(false);
		backButton.setVisible(false);
		rightButton.setVisible(false);
	}

	public void playGame(String playerName) {

		wardrobePotionTaken = false;
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
		backButton.setVisible(false);
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

	public void death() {

	}
}
