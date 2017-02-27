package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomePage extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblWelcomeToTileo = new JLabel("Welcome To Tile-O");
		lblWelcomeToTileo.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 45));
		lblWelcomeToTileo.setBounds(23, 36, 414, 49);
		contentPane.add(lblWelcomeToTileo);
		
		JButton btnNewButton = new JButton("Play Mode\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PlayModeOpen pmo = new PlayModeOpen();
				pmo.setVisible(true);
			}
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(23, 121, 171, 64);
		contentPane.add(btnNewButton);
		
		JButton btnDesignMode = new JButton("Design Mode\r\n");
		btnDesignMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				CreateAGameWithNumberOfPlayer createagame = new CreateAGameWithNumberOfPlayer();
				createagame.setVisible(true);
			}
		});
		btnDesignMode.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDesignMode.setBounds(237, 121, 171, 64);
		contentPane.add(btnDesignMode);
	}

}
