package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game_removeConnectionActionCard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_removeConnectionActionCard frame = new Game_removeConnectionActionCard();
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
	public Game_removeConnectionActionCard() {
		setTitle("TileO Game mode");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseRemoveConnection = new JLabel("please remove a connection piece.  ");
		lblPleaseRemoveConnection.setBounds(15, 40, 620, 31);
		lblPleaseRemoveConnection.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseRemoveConnection.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 29));
		contentPane.add(lblPleaseRemoveConnection);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(387, 411, 172, 56);
		btnSave.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 32));
		contentPane.add(btnSave);
		
		JLabel lblSpareConnection = new JLabel("Number of spare connection:");
		lblSpareConnection.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 22));
		lblSpareConnection.setBounds(284, 3, 293, 42);
		contentPane.add(lblSpareConnection);
		
		JLabel label = new JLabel("PlayerX' Turn");
		label.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 24));
		label.setBounds(15, 0, 144, 46);
		contentPane.add(label);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnConfirm.setBounds(68, 411, 187, 56);
		contentPane.add(btnConfirm);
	}
}
