import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Style{
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	static Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 16);
	public static JButton createButton(String name)
	{
		JButton btn = new JButton(name);
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		btn.setForeground(Color.white);
		btn.setBackground(Color.black);
		btn.setFont(buttonFont);
		return btn;
	}
}