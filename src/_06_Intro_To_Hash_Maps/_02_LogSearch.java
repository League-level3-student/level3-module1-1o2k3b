package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class _02_LogSearch implements ActionListener {
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     *
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */

	HashMap<Integer, String> id = new HashMap<Integer, String>();
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JButton button1 = new JButton();
JButton button2 = new JButton();
JButton button3 = new JButton();


public void GuiSetup() {
	frame.setVisible(true);
	frame.setSize(600, 200);
	frame.add(panel);
	
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);
	panel.setLayout(null);
	
	button1.setBounds(10, 25, 180, 100);
	button1.setText("register an id here.");
	button1.addActionListener(this);
	
	button2.setBounds(200, 25, 180, 100);
	button2.setText("check registration here.");
	button2.addActionListener(this);
	
	button3.setBounds(400, 25, 190, 100);
	button3.setText("view the id database here.");
	button3.addActionListener(this);
}

public static void main(String[] args) {
	_02_LogSearch a = new _02_LogSearch();
	a.GuiSetup();
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == button1) {
		String ID = JOptionPane.showInputDialog("what's your id number");
		int x = Integer.parseInt(ID);
		String name = JOptionPane.showInputDialog("now enter your name");
		
		id.put(x, name);
		
		
	}
	if(e.getSource() == button2) {
	String check = JOptionPane.showInputDialog("enter an id number");
	int y = Integer.parseInt(check);
	String name = id.get(y);
	if(name != null) {
    JOptionPane.showMessageDialog(null, "hello " + id.get(y) + " you are indeed in our database");
	} else {
		JOptionPane.showMessageDialog(null, "your id doesn't match a name in our database.");
	}
	}
	if(e.getSource() == button3) {
		
		String x = "";

		for(int i:id.keySet()) {
			x+="ID: " + i + " Name: " + id.get(i) + "\n";
			

		}
		JOptionPane.showMessageDialog(null, x);
	}
}







}
