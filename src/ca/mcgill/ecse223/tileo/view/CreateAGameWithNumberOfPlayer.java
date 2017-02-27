package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ca.mcgill.ecse223.tileo.application.Main;
import ca.mcgill.ecse223.tileo.controller.TileOController;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.TileO;;

public class CreateAGameWithNumberOfPlayer extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CreateAGameWithNumberOfPlayer() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblSelectNumberOf = new JLabel("Select number of players :");
		lblSelectNumberOf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSelectNumberOf.setBounds(23, 40, 310, 53);
		contentPane.add(lblSelectNumberOf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(318, 62, 77, 20);
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 36));
		btnNewButton.setBounds(23, 172, 115, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNext = new JButton("Create");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileOController controller = new TileOController();
				controller.CreateAGame(Main.getTileO());
				for (int i = 0; i < Integer.parseInt(comboBox.getSelectedItem().toString()); i++) {
					Main.getTileO().getCurrentGame().addPlayer(i);
				}
				
				GameBoardDesign gameboard = new GameBoardDesign(Main.getTileO().getCurrentGame());
				
				dispose();				
				gameboard.setVisible(true);
			}
		});
		btnNext.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 36));
		btnNext.setBounds(272, 172, 127, 53);
		contentPane.add(btnNext);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 36));
		btnLoad.setBounds(147, 172, 115, 53);
		contentPane.add(btnLoad);
	}
}
