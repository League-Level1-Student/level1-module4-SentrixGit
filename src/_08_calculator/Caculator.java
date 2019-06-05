package _08_calculator;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Caculator implements ActionListener {
	
	JFrame Frame = new JFrame();
	JTextField firstTextField = new JTextField(15);
	JTextField secondTextField = new JTextField(15);
	JButton addButton = new JButton("+");
	JButton subButton = new JButton("-");
	JButton mutButton = new JButton("x");
	JButton divButton = new JButton("/");
	JLabel answerLabel = new JLabel("null");
	
	public static void main(String[] args) {
		new Caculator().createUI();
	}
	
	void createUI() {
		
		JPanel TextFieldPanel = new JPanel();
		
		// Add the panels to the frame
		Frame.add(TextFieldPanel);
		
		// Add the textFields to the frame
		TextFieldPanel.add(firstTextField);
		TextFieldPanel.add(secondTextField);
		
		//add the buttons to the frame
		TextFieldPanel.add(addButton);
		TextFieldPanel.add(subButton);
		TextFieldPanel.add(mutButton);
		TextFieldPanel.add(divButton);
		
		// Add the label to the frame
		TextFieldPanel.add(answerLabel);
		
		// Add button things
		addButton.addActionListener(this);
		
		// Make the frame visible
		Frame.setVisible(true);
		
		// Set the title of the frame
		Frame.setTitle("Caculator");
		
		Frame.pack();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			answerLabel.setText((Integer.parseInt(firstTextField.getText()) + Integer.parseInt(firstTextField.getText())) + "" );
		} else if (e.getSource() == subButton) {
			answerLabel.setText((Integer.parseInt(firstTextField.getText()) - Integer.parseInt(firstTextField.getText())) + "" );
		} else if (e.getSource() == mutButton) {
			answerLabel.setText((Integer.parseInt(firstTextField.getText()) * Integer.parseInt(firstTextField.getText())) + "" );
		} else if (e.getSource() == divButton) {
			answerLabel.setText((Integer.parseInt(firstTextField.getText()) / Integer.parseInt(firstTextField.getText())) + "" );
		}
	}
}
