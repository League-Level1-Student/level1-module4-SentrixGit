package _12_slot_machine;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.*;

public class yay {
	JFrame frame = new JFrame();

	public static void main(String[] args) {
		new yay().createUI();
	}
	
	void createUI() {
		
		for (int i = 0; i < 4; i++) {
			int random = new Random().nextInt(3);
			
			if (random == 1) {
				try {
					frame.add(createLabelImage("turtle.png"));
					JOptionPane.showMessageDialog(null, "Yay u ded it");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (random == 2) {
				try {
					frame.add(createLabelImage("robot.jpg"));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (random == 3) {
				try {
					frame.add(createLabelImage("patatoe.png"));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
    
}
