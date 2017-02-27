package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.TileOController;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Tile;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GameBoardDesign extends JFrame {

	private JPanel contentPane;
	private JButton board[][] = new JButton[15][13];
	private String status[] = {"X","N","A","W","P1","P2","P3","P4"};
	private int nplayers;
	private TileOController controller;
	private Game currentgame;
	/**
	 * Create the frame.
	 */
	public GameBoardDesign(Game game) {
		setTitle("TileO Design mode");
		currentgame = game;
		controller = new TileOController();
		nplayers = game.numberOfPlayers();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					saveboard();
					dispose();
					SelectCard frame = new SelectCard(game);
					frame.setVisible(true);
				} catch (Exception e2) {
					Exceptions frame = new Exceptions(e2.getMessage());
					frame.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 36));
		btnNewButton.setBounds(456, 545, 136, 61);
		contentPane.add(btnNewButton);
		
		JLabel lblXNo = new JLabel("X : No Tile     N : Normal Tile     A : Action Tile");
		lblXNo.setBounds(25, 545, 420, 34);
		contentPane.add(lblXNo);
		
		JLabel lblWHidden = new JLabel("W : Hidden Tile or Win Tile    P1-4 : Player Starting Tile");
		lblWHidden.setBounds(25, 574, 420, 34);
		contentPane.add(lblWHidden);
		
		
		for (int i = 0; i < board.length; i++) {//horizontal
			for (int j = 0; j < board[0].length; j++) {//vertical
				board[i][j] = new JButton(status[0]);
				board[i][j].setBounds(10+i*40, 10+j*40, 30, 30);
				board[i][j].setActionCommand(""+(char)i+(char)j+0);
				board[i][j].setMargin(new Insets(0, 0, 0, 0));
				board[i][j].addActionListener(new ActionListener() {
					
					
					public void actionPerformed(ActionEvent e) {
						switchstate(e.getActionCommand());
						
					}
				});
				
				contentPane.add(board[i][j]);
			}
		}
		
		
	}
	public void saveboard() {
		boolean wintile = false;
		boolean p1set = false;
		boolean p2set = false;
		boolean p3set = false;
		boolean p4set = false;
		boolean hidden = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				switch (board[i][j].getText()) {
				case "X":
					break;
				case "N":
					controller.addNormalTile(i, j,currentgame);
					break;
				case "A":
					controller.addActionTile(i, j,currentgame);
					break;
				case "W":
					
					if (hidden) {
						throw new IllegalArgumentException("too many Hidden Tiles");
					}else {
						controller.addHiddenTile(i, j,currentgame);
					}
					break;
				case "P1":
					Tile p1 = controller.addNormalTile(i, j,currentgame);
					if (p1set) {
						throw new IllegalArgumentException("too many starting tiles for p1");
					}else {
						p1set = true;
					}
					currentgame.getPlayer(0).setStartingTile(p1);
					break;
				case "P2":
					if (p2set) {
						throw new IllegalArgumentException("too many starting tiles for p2");
					}else {
						p2set = true;
					}
					Tile p2 = controller.addNormalTile(i, j,currentgame);
					currentgame.getPlayer(1).setStartingTile(p2);
					break;
				case "P3":
					if (p3set) {
						throw new IllegalArgumentException("too many starting tiles for p3");
					}else {
						p3set = true;
					}
					Tile p3 = controller.addNormalTile(i, j,currentgame);
					currentgame.getPlayer(2).setStartingTile(p3);
					break;
				case "P4":
					if (p4set) {
						throw new IllegalArgumentException("too many starting tiles for p4");
					}else {
						p4set = true;
					}
					Tile p4 = controller.addNormalTile(i, j,currentgame);
					currentgame.getPlayer(3).setStartingTile(p4);
					break;
					
				default:
					break;
				}
			}
		}
		int c = 3;
		c++;
	}
	
	private void switchstate(String actioncommand) {
		char command[] = actioncommand.toCharArray();
		int x = (int)command[0];
		int y = (int)command[1];
		int current = command[2]-47;
		if (current-1==(3+nplayers)) {
			board[x][y].setText(status[0]);
			board[x][y].setActionCommand(""+command[0]+command[1]+0);			
		} else {
			board[x][y].setText(status[current]);
			board[x][y].setActionCommand(""+command[0]+command[1]+current);
		}
		repaint();
	}
}
