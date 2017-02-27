package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class Game_loseTurnActionCard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_loseTurnActionCard frame = new Game_loseTurnActionCard();
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
	public Game_loseTurnActionCard() {
		setTitle("TileO Game mode");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnContinue.setBounds(73, 400, 187, 56);
		contentPane.add(btnContinue);
		
		JButton button = new JButton("SAVE");
		button.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		button.setBounds(416, 400, 144, 56);
		contentPane.add(button);
		
		JLabel lblUnfortunatelyYouHave = new JLabel("Unfortunately, You have lost your turn.");
		lblUnfortunatelyYouHave.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 26));
		lblUnfortunatelyYouHave.setBounds(99, 42, 481, 47);
		contentPane.add(lblUnfortunatelyYouHave);
		
		JLabel lblPlayerTurn = new JLabel("PlayerX' Turn");
		lblPlayerTurn.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 24));
		lblPlayerTurn.setBounds(15, 0, 144, 46);
		contentPane.add(lblPlayerTurn);
	}
}
