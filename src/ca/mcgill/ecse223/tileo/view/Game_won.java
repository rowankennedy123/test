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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game_won extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_won frame = new Game_won();
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
	public Game_won() {
		setTitle("TileO Game mode");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackToMain = new JButton("BACK TO MAIN PAGE");
		btnBackToMain.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 22));
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBackToMain.setBounds(173, 441, 299, 29);
		contentPane.add(btnBackToMain);
		
		JLabel lblPlayerx = new JLabel("");
		lblPlayerx.setBounds(5, 5, 575, 0);
		lblPlayerx.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		lblPlayerx.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPlayerx);
		
		JLabel lblCongratulationsPlayerx = new JLabel("Congratulations PlayerX! You win!!");
		lblCongratulationsPlayerx.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		lblCongratulationsPlayerx.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongratulationsPlayerx.setBounds(54, 110, 483, 122);
		contentPane.add(lblCongratulationsPlayerx);
	}

}
