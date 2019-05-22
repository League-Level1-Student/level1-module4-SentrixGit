package _05_typing_tutor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class TypingTutor implements KeyListener {
	
	public static void main(String[] args) {
		new TypingTutor().createUI();
	}
	
	void createUI() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JTextField inputBox = new JTextField(50);
		panel.add(inputBox);
		inputBox.addKeyListener(this);
		frame.pack();
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
