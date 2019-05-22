package _02_simon_says;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;

public class SimonSays extends KeyAdapter {

	HashMap<Integer, String> images = new HashMap<Integer, String>();
	private int points = 0;
	private int imageIndex;
	private int tries = 0;
	private boolean simonSays = false;
	Date timeAtStart;

	// Complete steps 1 - 7 before you test
	// 1. Declare a JFrame variable
	JFrame mainFrame = new JFrame();

	public void run() {
		// 2. Add the four images that match keyboard keys like this:
		// images.put(new Integer(KeyEvent.VK_UP), "up.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "up.jpg");
		images.put(new Integer(KeyEvent.VK_DOWN), "down.jpg");
		images.put(new Integer(KeyEvent.VK_LEFT), "left.jpg");
		images.put(new Integer(KeyEvent.VK_RIGHT), "right.jpg");

		// 3. Use a JOptionPane to tell the user the rules: "Press the matching
		// key when
		// 'Simon says' otherwise press a different key"
		JOptionPane.showMessageDialog(null, "When playing the game please follow the rules listed: \n"
				+ "1.) Do what simon says. If you don't you loose. \n"
				+ "2.) If you hit the wrong button you will loose \n"
				+ "3.) If simon does not say it do not do it \n"
				+ "4.) Press the arrow keys \n"
				+ "5.) If simon didn't say press any other key");

		// 4. Call the showImage method to show an image
		showImage();
	}

	public void keyPressed(KeyEvent e) {
		// 15. Make a points variable to track the score.
		//Done
		// 16. If the keyCode matches the imageIndex and "Simon says"
		if (e.getKeyCode() == imageIndex && simonSays == true) {
			points++;
			speak("Great job. Your score is " + points + ". Onto the next one!");
			mainFrame.dispose();
			showImage();
		} else if (e.getKeyCode() != imageIndex && simonSays == false) {
			speak("Great job. Your score is " + points + ". Onto the next one!");
			points++;
			mainFrame.dispose();
			showImage();
		} else if (simonSays == true && e.getKeyCode() == imageIndex) {
			speak("Simon didn't say. You lost a point.");
			points--;
			mainFrame.dispose();
			showImage();
		} else if (tries > 9) {
			speak("You had 9 tries but you failed. That's sad. you lost a point");
			points--;
			mainFrame.dispose();
			showImage();
		}
		// 17. Increase the value of score

		// 18. Use the speak method to tell the user they were correct

		// 19. If the keyCode doesn't match the imageIndex and "Simon didn't
		// say..."

		// 20. Increase the value of score

		// 21. Use the speak method to tell the user they were correct

		// 22. Increment tries by 1

		// 25. If tries is greater than 9 (or however many you want)...

		// 26. Tell the user their score

		// 27. Exit the program

		// 23. Dispose of the frame

		// 24. Call the showImage method to show a new image
	}

	private void showImage() {
		// 5. Initialize your frame to a new JFrame()

		// 6. Set the frame to visible
		mainFrame.setVisible(true);

		// 7. Uncomment the following line to add a random image to your frame
		// frame.add(getNextRandomImage());
		mainFrame.add(getNextRandomImage());

		// 8. Set the name of your frame
		mainFrame.setTitle("Simon Says!");
		// 9. Pack the frame
		mainFrame.pack();
		// 10. Set the defaultCloseOperation of your from to
		// JFrame.EXIT_ON_CLOSE
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 11. Add a key listener to the frame
		mainFrame.addKeyListener(this);
		// 12. Create a new instance of Random
		Random randomRandom = new Random();
		
		int randomInt = randomRandom.nextInt(2);
		// 13. Use the Random and the speak method to either say
		// "Simon says press this key" or "Press this key"
		if (randomInt == 0) {
			speak("press this key");
			simonSays = false;
		} else if (randomInt == 1) {
			speak("simon says press this key");
			simonSays = true;
		}
		// 14. Above, set the value of simonSays to true/false appropriate
	}

	private Component getNextRandomImage() {
		this.imageIndex = new Random().nextInt(4) + 37;
		return loadImage(images.get(imageIndex));
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
 * BONUS! Add a timer : ~~~ where the code starts running ~~~ timeAtStart =
 * newDate();
 *
 * ~~~ where the code ends ~~~ Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */
