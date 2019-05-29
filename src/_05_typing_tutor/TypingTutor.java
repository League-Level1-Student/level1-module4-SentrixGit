package _05_typing_tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class TypingTutor implements KeyListener {
	char currentLetter;
	JLabel textLabel;
	JPanel panel;
	
	public static void main(String[] args) {
		new TypingTutor().createUI();
	}
	
	void createUI() {
		currentLetter = generateRandomLetter();
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		panel = new JPanel();
		frame.add(panel);
		
		textLabel = new JLabel(currentLetter + " ");
		
		textLabel.setFont(textLabel.getFont().deriveFont(28.0f));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		
		frame.addKeyListener(this);
		
		panel.add(textLabel);
		//inputBox.addKeyListener(this);
		frame.pack();
	}
	
	char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}

	public void keyTyped(KeyEvent e) {
		if (currentLetter == e.getKeyChar()) {
			currentLetter = generateRandomLetter();
			textLabel.setText(currentLetter + "");
			System.out.println(e.getKeyChar());
			panel.setBackground(Color.green);
		} else { 
			System.out.println(e.getKeyChar());
			panel.setBackground(Color.red);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
