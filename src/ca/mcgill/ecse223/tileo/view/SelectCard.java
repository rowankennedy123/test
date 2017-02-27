package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.TileOController;
import ca.mcgill.ecse223.tileo.model.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;

public class SelectCard extends JFrame {

	private JPanel contentPane;
	private String names[];
	private JLabel str[] = new JLabel[32];
	private JButton status[] = new JButton[32];
	private int dy = 25;
	private String ActionType[] = {"","Connect Tiles","Lose Turn","Remove Tile","Teleport","Roll Again"};
	private int Currentcards[] = {0,0,0,0,0,0};
	private JLabel lblConnect;
	private JLabel lblLoseTurn;
	private JLabel lblRemoveConnection;
	private JLabel lblRollAgain;
	private JLabel lblTeleport;
	/**
	 * Create the frame.
	 */
	public SelectCard(Game currentgame) {
		setnames();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Done and Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					TileOController controller = new TileOController();
					controller.setcards(status,currentgame);
					dispose();
					
				} catch (Exception e2) {
					Exceptions frame = new Exceptions(e2.getMessage());
					frame.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 24));
		btnNewButton.setBounds(285, 442, 189, 34);
		contentPane.add(btnNewButton);
		
		lblConnect = new JLabel("Connect Tile: 0/7");
		lblConnect.setBounds(10, 407, 116, 24);
		contentPane.add(lblConnect);
		
		lblLoseTurn = new JLabel("Lose Turn: 0/7");
		lblLoseTurn.setBounds(140, 407, 116, 24);
		contentPane.add(lblLoseTurn);
		
		lblRemoveConnection = new JLabel("Remove Connection: 0/6");
		lblRemoveConnection.setBounds(244, 407, 162, 24);
		contentPane.add(lblRemoveConnection);
		
		lblRollAgain = new JLabel("Roll Again: 0/6");
		lblRollAgain.setBounds(140, 450, 116, 24);
		contentPane.add(lblRollAgain);
		
		lblTeleport = new JLabel("Teleport: 0/6");
		lblTeleport.setBounds(10, 450, 116, 24);
		contentPane.add(lblTeleport);
		update();
		for (int i = 0; i < 16; i++) {
			str[i] = new JLabel(names[i]);
			str[i].setBounds(25, 11+i*dy, 60, 14);
			contentPane.add(str[i]);
			
			status[i] = new JButton(ActionType[0]);
			status[i].setBounds(75, 7+i*dy, 150, 23);
			status[i].setActionCommand(""+(char)i+0);
			status[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					switchstate(e.getActionCommand());					
				}
			});
			contentPane.add(status[i]);
			
			str[i+16] = new JLabel(names[i+16]);
			str[i+16].setBounds(250, 11+(i)*dy, 60, 14);
			str[i+16].setText(names[i+16]);
			contentPane.add(str[i+16]);
			
			status[i+16] = new JButton(ActionType[0]);
			status[i+16].setBounds(305, 7+(i)*dy, 150, 23);
			status[i+16].setActionCommand(""+(char)(i+16)+0);
			status[i+16].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					switchstate(e.getActionCommand());					
				}
			});
			contentPane.add(status[i+16]);
		}
	}
	private void switchstate(String actioncommand) {
		char command[] = actioncommand.toCharArray();
		int index = (int)command[0];
		int current = (int)command[1]-(int)'0';
		Currentcards[current]--;
		current++;
		
		if (current==6) {
			status[index].setText(ActionType[0]);
			status[index].setActionCommand(""+command[0]+0);
		} else {
			status[index].setText(ActionType[current]);
			status[index].setActionCommand(""+command[0]+current);
			Currentcards[current]++;
		}
		update();
	}
	public void setnames() {
		names = new String[32];
		for (int i = 0; i < names.length; i++) {
			names[i] = "Card : "+String.valueOf(i+1);
		}		
	}
	private void update() {
		lblConnect.setText("Connect Tile: "+Currentcards[1]+"/7");
		lblLoseTurn.setText("Lose Turn: "+Currentcards[2]+"/7");
		lblRemoveConnection.setText("Remove Connection :"+Currentcards[3]+"/6");
		lblTeleport.setText("Teleport :"+Currentcards[4]+"/6");
		lblRollAgain.setText("Roll Again"+Currentcards[5]+"/6");
	}
}
