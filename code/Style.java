import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Style{
	static Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	static Font buttonFont = new Font("Times New Roman", Font.PLAIN, 20);
	static Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
	static Font uifont = new Font("Times New Roman", Font.PLAIN, 25);
	public static JButton createButton(String name)
	{
		JButton btn = new JButton(name);
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		setColor(btn);
		btn.setFont(buttonFont);
		//btn.setSize(150, 150);
		return btn;
	}
	public static JPanel createPanel(int posX, int posY, int width, int height){
		JPanel panel = new JPanel();
		panel.setBounds(posX, posY, width, height);
		panel.setBackground(Color.black);
		return panel;
	}
	public static JLabel createUILabel(String text){
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setFont(uifont);
		label.setBackground(Color.black);
		label.setForeground(Color.white);
		return label;
	}
	public static JPanel createTopUI(String playerName)
	{
		JPanel topUIPanel = new JPanel();
		topUIPanel.setBounds(50, 0, 1000, 100);
		topUIPanel.setBackground(Color.black);
		topUIPanel.setLayout(new GridLayout(1, 3));
		JButton inventoryButton = Style.createButton("Inventory");
    	inventoryButton.setFont(uifont);

    	JLabel weaponLabel = new JLabel("Damage: 42", SwingConstants.CENTER);
    	weaponLabel.setFont(uifont);
    	weaponLabel.setBackground(Color.black);
    	weaponLabel.setForeground(Color.white);

    	JLabel playerinfoLabel = new JLabel(playerName + " HP: 100", SwingConstants.CENTER);
    	playerinfoLabel.setFont(uifont);
    	playerinfoLabel.setBackground(Color.black);
    	playerinfoLabel.setForeground(Color.white);

    	topUIPanel.add(inventoryButton);
    	topUIPanel.add(weaponLabel);
    	topUIPanel.add(playerinfoLabel);

    	return topUIPanel;
	}
	public static JFrame createFrame(int width, int height){
		JFrame window = new JFrame();
		window.setSize(width, height);
		window.setLocationRelativeTo(null);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		return window;
	}
	public static void setColor(JButton btn){
		btn.setForeground(Color.white);
		btn.setBackground(Color.black);
	}
	public static void setColor(JTextArea txtfld){
		txtfld.setForeground(Color.white);
		txtfld.setBackground(Color.black);
	}
}
