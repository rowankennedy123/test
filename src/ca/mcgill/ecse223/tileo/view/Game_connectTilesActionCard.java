package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Insets;

public class Game_connectTilesActionCard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_connectTilesActionCard frame = new Game_connectTilesActionCard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game_connectTilesActionCard() {
		setTitle("TileO Game mode");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseConnectTwo = new JLabel("Please connect two adjacent tiles.");
		lblPleaseConnectTwo.setBounds(15, 35, 614, 41);
		lblPleaseConnectTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseConnectTwo.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 28));
		contentPane.add(lblPleaseConnectTwo);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(368, 410, 189, 59);
		btnSave.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnSave.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		contentPane.add(btnSave);
		
		JLabel label = new JLabel("PlayerX' Turn");
		label.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 24));
		label.setBounds(15, 0, 144, 46);
		contentPane.add(label);
		
		JButton button = new JButton("CONFIRM");
		button.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		button.setBounds(103, 410, 187, 56);
		contentPane.add(button);
	}

}
