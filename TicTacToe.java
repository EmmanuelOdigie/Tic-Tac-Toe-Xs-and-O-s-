package JavaTicTacToeGame; // project made in eclipse

//  imported classes //
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// public class created, inherits JFrame, implements works like inheritance for an interface
public class TicTacToe extends JFrame implements ActionListener {
	private JButton[][] buttons = new JButton[3][3]; // setting up 2d array object button, set to 3 rows 3 columns
	private boolean playerXTurn = true; //Variable playerXTurn made, playerXTurn begins play 
	
	public TicTacToe() {
		setTitle("Tic Tac Toe"); // names the GUI
		setSize(600,600); // length, width
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// close the window when user press the x button
		setLayout(new GridLayout(3, 3)); //set row and column lay out 3 by 3
		
		initializeButtons(); // set up the area to be tapped
		setVisible(true);// when clicked it will show shape
	}
	
// creates rows and columns in the Jframe, each square acts as a button
	private void initializeButtons() {
		for(int row = 0; row<3; row=row+1) {
			for(int column = 0; column<3; column=column+1) {
				buttons[row][column]= new JButton(""); // creates an empty button
				buttons[row][column].setFont(new Font("Ariel", Font.BOLD, 80)); // set font for the button
				buttons[row][column].setBackground(Color.WHITE); // set background to white
				buttons[row][column].setFocusPainted(false); // does not display a ring around the charchters in the button
				buttons[row][column].addActionListener(this); // 
				add(buttons[row][column]);
				
			}
		}
	}
	
	// method created for the actionPerformed when the actionlistener detects a button pressed
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource(); 
		
		if(clicked.getText().equals("")) {
			if(playerXTurn) { //if statement made, playerXTurn is true, playerX goes first 
				clicked.setText("X"); // stores character x
				clicked.setForeground(Color.red); // set the foreground colour to red for character x 
			}else {
				clicked.setText("O"); // if playerXTurn is false, stores character
				clicked.setForeground(Color.BLUE); // set foreround colour blue for O
			}
			playerXTurn = !playerXTurn; // when playerXTurn is true, then playXTurn is false
			checkForWin(); // method created
		}
	}
	
	private void checkForWin() { // method created
		for(int row = 0; row<3; row=row+1) { // for loop for the rows created
			if(checkRowOrColumn(buttons[row][0], buttons[row][1], buttons[row][2])) { // checks all three rows
				showWinMessage(); // show win message method created
			}
		}
		for(int column = 0; column<3; column=column+1) { // for loop for the column created
			if(checkRowOrColumn(buttons[column][0], buttons[column][1], buttons[column][2])) {// check all three columns
				showWinMessage(); // show win message method created
			}
		}
		if(checkRowOrColumn(buttons[0][0], buttons[1][1], buttons[2][2])) {// if the x or o matches the rows and columns set up in this case
			// number starts from 0 in this as 0=1
			showWinMessage(); // show win message method created
		}
		if(checkRowOrColumn(buttons[0][2], buttons[1][1], buttons[2][0])) {// if x or o match 1'st row, 3'rd column and 2nd row, 2nd column, and 3rd row 1st column
			// number starts from 0 in this as 0=1
			showWinMessage(); // show win message method created
		}
		if(isBoardFull()) {// if statement created for the board being full
			showDrawMessage();// showDrawMessage method created
		}
	}
	private boolean checkRowOrColumn(JButton b1, JButton b2, JButton b3) {
		return !b1.getText().equals("") && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText());
	}
	
	private void showWinMessage() { //(String winner)  // runs the method
		JOptionPane.showMessageDialog(null, "Winner!"); // display a small box window if playerX wins stating Winner
		resetBoard(); // created method to reset the game
	}
	
	private void showDrawMessage() { // runs the method
		JOptionPane.showMessageDialog(null, "Draw!"); // display a small window if its a draw stating draw
		resetBoard(); // created method to reset the game
	}
	
	private void resetBoard() {// method that recreates the board
		for(int row = 0; row<3; row=row+1) { // nested for loop created
			for(int column = 0; column<3; column=column+1) {
				buttons[row][column].setText("");// clears the characters in rows and columns
				
				//buttons[row][column].setForeground(Color.black);
				
			}
		}
		playerXTurn = true; // starts player again with beginning with X
	}
	private boolean isBoardFull() {
		for(int row = 0; row<3; row=row+1) {
			for(int column = 0; column<3; column=column+1) {
				//buttons[row][column].setText("");// clears the characters in rows and columns
				if(buttons[row][column].getText().equals("")) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {// reads,runs & executes
		new TicTacToe(); // runs class
	}
}