package ca.mcgill.ecse223.tileo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.application.Main;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.TileO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class PlayModeOpen extends JFrame{

	private JPanel frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public PlayModeOpen() {
		setTitle("TileO Game mode");
		setBounds(100, 100, 450, 300);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setLayout(null);
		setContentPane(frame);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 66, 314, 186);
		frame.add(scrollPane);
		
		TileO tileO = Main.getTileO();
		final List<Game> games = tileO.getGames();
		int numGames = games.size();
		String[] gameNames = new String[numGames];
		
		for (int i = 0; i < numGames; i++) {
			gameNames[i] = "Game " + i;
		}
		
		JList<?> list = new JList<Object>(gameNames);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList<?> list = (JList<?>)e.getSource();
		        if (e.getClickCount() == 2) {
		             // Double-click detected
		            int index = list.locationToIndex(e.getPoint());
		            dispose();
		            @SuppressWarnings("unused")
					StartGame startGame = new StartGame(games.get(index));
		            startGame.setVisible(true);
		        } 
			}
		});
	

		scrollPane.setViewportView(list);
		
		JLabel lblRecentGames = new JLabel("Recent Game Designs");
		lblRecentGames.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecentGames.setBounds(68, 6, 314, 47);
		frame.add(lblRecentGames);
	
		
	
		
		

	}
}
