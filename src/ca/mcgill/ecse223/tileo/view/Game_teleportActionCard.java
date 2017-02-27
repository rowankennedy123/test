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

public class Game_teleportActionCard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_teleportActionCard frame = new Game_teleportActionCard();
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
	public Game_teleportActionCard() {
		setTitle("TileO Game mode");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseMoveYour = new JLabel("Please move your tile to another location.");
		lblPleaseMoveYour.setBounds(15, 44, 611, 37);
		lblPleaseMoveYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseMoveYour.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 28));
		contentPane.add(lblPleaseMoveYour);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnSave.setBounds(415, 398, 158, 56);
		contentPane.add(btnSave);
		
		JLabel label = new JLabel("PlayerX' Turn");
		label.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 24));
		label.setBounds(15, 0, 144, 46);
		contentPane.add(label);
		
		JButton button = new JButton("CONFIRM");
		button.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		button.setBounds(89, 398, 187, 56);
		contentPane.add(button);
	}

}
