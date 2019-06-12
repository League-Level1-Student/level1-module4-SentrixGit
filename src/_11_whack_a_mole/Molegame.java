package _11_whack_a_mole;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

public class Molegame implements MouseListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	
	int wacks = 0;
	
	public static void main(String[] args) {
		new Molegame().createUI();
	}
	
	void createUI() {
		int moleLocation = new Random().nextInt(26);
		
		frame.add(panel);
		
		button1.setText("Mole");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button1.addMouseListener(this);
		
		for (int i = 0; i < moleLocation; i++) {
			JButton noneButton = new JButton();
			
			panel.add(noneButton);
		}
		
		panel.add(button1);
		
		for (int i = moleLocation; i < 26; i++) {
			JButton noneButton = new JButton();
			
			panel.add(noneButton);
		}
		
		frame.setSize(300, 350);
		
		frame.setVisible(true);
	}
	
	void speak(String words) {
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == button1) {
			speak("yeet");
			frame.dispose();
			createUI();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
