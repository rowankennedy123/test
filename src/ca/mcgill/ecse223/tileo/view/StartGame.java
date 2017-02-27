package ca.mcgill.ecse223.tileo.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.TileOController;
import ca.mcgill.ecse223.tileo.model.ActionTile;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Player;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;



public class StartGame extends JFrame{
	
	private JPanel frame;

	private JButton board[][] = new JButton[15][13];
	private TileOController controller = new TileOController();
	
	/**
	 * Create the application.
	 * @param game 
	 */
	public StartGame(Game game) {
		try {
			controller.startGame(game);
			setBounds(100, 100, 450, 300);
			initialize(game);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Game game) {
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLayout(null);
		setContentPane(frame);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnTakePlayersTurn = new JButton("Take Player " + game.getCurrentPlayer().getNumber() + "'s Turn");
		btnTakePlayersTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You rolled and your possible final spots are shown with X's!");
				List<Tile> tiles = controller.rollDie();
				
				for (Tile tile : tiles) {
					int x = tile.getX();
					int y = tile.getY();
					board[x][y].setText("X");
				}
			}
		});
		btnTakePlayersTurn.setBounds(226, 573, 241, 46);
		frame.add(btnTakePlayersTurn);
		
		List<Player> players = game.getPlayers();
		
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			Tile startTile = player.getStartingTile();
			int x = startTile.getX();
			int y = startTile.getY();
			board[x][y] = new JButton("P" + i);
			board[x][y].setBounds(10+x*40, 10+y*40, 30, 30);
			board[x][y].setMargin(new Insets(0, 0, 0, 0));
			frame.add(board[x][y]);
		}
		
		for (Tile tile : game.getTiles()) {
			int x = tile.getX();
			int y = tile.getY();
			if (!board[x][y].isEnabled()) {
				String text = "";
				if (tile instanceof ActionTile) {
					ActionTile actionTile = (ActionTile) tile;
					text = "x^" + actionTile.getInactivityPeriod();
				}
				board[x][y] = new JButton(text);
				board[x][y].setBounds(10+x*40, 10+y*40, 30, 30);
				board[x][y].setMargin(new Insets(0, 0, 0, 0));
				frame.add(board[x][y]);
			}
		}
		
		for (int i = 0; i < board.length; i++) {//horizontal
			for (int j = 0; j < board[0].length; j++) {//vertical
				board[i][j] = new JButton();
				board[i][j].setBounds(10+i*40, 10+j*40, 30, 30);
				board[i][j].setMargin(new Insets(0, 0, 0, 0));
			}
		}
	}
}
