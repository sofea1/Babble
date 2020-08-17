package edu.westga.cs.babble.views;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.UIManager;

/**
 *All GUI layout located in this class, which inherits from JFrame.
 *Allows WindowBuilder to manipulate this code, but not the manual code entry.
 * 
 * @author Sofiya Anikina
 * @version 08/15/2020
 *
 */
public class GuiWindowBuilderLayout extends JFrame {
	protected JTextField textFieldTiles;
	protected JTextField textFieldAnswer;
	protected JTextField textField;
	protected JList listLetters;
	public GuiWindowBuilderLayout() {
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		JButton btnResetButton = new JButton("Reset");
		btnResetButton.setForeground(Color.BLACK);
		btnResetButton.setBackground(Color.WHITE);
		btnResetButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnResetButton.setBounds(150, 150, 99, 21);
		getContentPane().add(btnResetButton);
		
		JButton btnPlayWord = new JButton("Play Word");
		btnPlayWord.setBackground(Color.WHITE);
		btnPlayWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPlayWord.setBounds(267, 150, 99, 21);
		getContentPane().add(btnPlayWord);
		
		textFieldTiles = new JTextField();
		textFieldTiles.setEditable(false);
		textFieldTiles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTiles.setBounds(32, 56, 334, 19);
		getContentPane().add(textFieldTiles);
		textFieldTiles.setColumns(10);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAnswer.setColumns(10);
		textFieldAnswer.setBounds(32, 108, 334, 19);
		getContentPane().add(textFieldAnswer);
		
		JLabel lblTiles = new JLabel("Tiles");
		lblTiles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTiles.setBounds(32, 33, 45, 13);
		getContentPane().add(lblTiles);
		
		JLabel lblYourWord = new JLabel("Your Word");
		lblYourWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYourWord.setBounds(32, 85, 70, 13);
		getContentPane().add(lblYourWord);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblScore.setBounds(187, 193, 70, 13);
		getContentPane().add(lblScore);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(267, 190, 99, 19);
		getContentPane().add(textField);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBackground(UIManager.getColor("Button.highlight"));
		lblMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessage.setBounds(32, 229, 334, 24);
		getContentPane().add(lblMessage);
		
		listLetters = new JList();
		listLetters.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listLetters.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listLetters.setBounds(32, 53, 320, -13);
		getContentPane().add(listLetters);
	}
}
