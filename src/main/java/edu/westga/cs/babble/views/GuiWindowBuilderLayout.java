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
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;


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
	protected JTextField textFieldAnswer;
	protected JTextField textField;
	protected JList tileList;
	protected JPanel panel;
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
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAnswer.setColumns(10);
		textFieldAnswer.setBounds(32, 108, 334, 19);
		getContentPane().add(textFieldAnswer);
		
		JLabel lblTiles = new JLabel("Tiles");
		lblTiles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTiles.setBounds(32, 21, 45, 13);
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
		
		tileList = new JList<>();
		tileList.setBackground(Color.YELLOW);
		tileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tileList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		tileList.setSelectedIndex(0);
		tileList.setBounds(31, 44, 107, 24);
		getContentPane().add(tileList);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(166, 43, 192, 55);
		getContentPane().add(panel);
	}
}
