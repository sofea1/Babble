package edu.westga.cs.babble.views;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;



/**
 *All GUI layout located in this class, which inherits from JFrame.
 *Allows WindowBuilder to manipulate this code, but not the manual code entry.
 * 
 * @author Sofiya Anikina
 * @version 08/15/2020
 *
 */
public class GuiWindowBuilderLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	protected JButton btnReset;
	protected JButton btnPlayWord;
	protected JTextField textFieldScore;
	protected JTextField textFieldMessage;
	protected JTextField textFieldAnswer;
	public GuiWindowBuilderLayout() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		JLabel lblTiles = new JLabel("Tiles");
		lblTiles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTiles.setBounds(26, 20, 45, 13);
		getContentPane().add(lblTiles);
		
		JLabel lblYourWord = new JLabel("Your Word");
		lblYourWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblYourWord.setBounds(30, 89, 70, 13);
		getContentPane().add(lblYourWord);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblScore.setBounds(54, 208, 70, 13);
		getContentPane().add(lblScore);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 43, 202, 29);
		getContentPane().add(panel);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReset.setBounds(26, 163, 91, 24);
		getContentPane().add(btnReset);
		
		btnPlayWord = new JButton("Play Word");
		btnPlayWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPlayWord.setBounds(131, 163, 91, 24);
		getContentPane().add(btnPlayWord);
		
		textFieldScore = new JTextField();
		textFieldScore.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldScore.setBounds(131, 205, 91, 19);
		getContentPane().add(textFieldScore);
		textFieldScore.setColumns(4);
		
		textFieldMessage = new JTextField();
		textFieldMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldMessage.setBounds(20, 234, 202, 19);
		getContentPane().add(textFieldMessage);
		textFieldMessage.setColumns(3);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setBackground(Color.WHITE);
		textFieldAnswer.setEditable(false);
		textFieldAnswer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAnswer.setBounds(26, 112, 196, 24);
		getContentPane().add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
	}
}
