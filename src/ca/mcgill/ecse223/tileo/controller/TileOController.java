package ca.mcgill.ecse223.tileo.controller;

import java.util.List;

import javax.swing.JButton;

import ca.mcgill.ecse223.tileo.application.*;
import ca.mcgill.ecse223.tileo.model.ActionCard;
import ca.mcgill.ecse223.tileo.model.ActionTile;
import ca.mcgill.ecse223.tileo.model.ConnectTilesActionCard;
import ca.mcgill.ecse223.tileo.model.Connection;
import ca.mcgill.ecse223.tileo.model.Deck;
import ca.mcgill.ecse223.tileo.model.Die;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Game.Mode;
import ca.mcgill.ecse223.tileo.model.LoseTurnActionCard;
import ca.mcgill.ecse223.tileo.model.NormalTile;
import ca.mcgill.ecse223.tileo.model.Player;
import ca.mcgill.ecse223.tileo.model.RemoveConnectionActionCard;
import ca.mcgill.ecse223.tileo.model.RollDieActionCard;
import ca.mcgill.ecse223.tileo.model.TeleportActionCard;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;
import ca.mcgill.ecse223.tileo.model.WinTile;
import ca.mcgill.ecse223.tileo.persistence.PersistenceObjectStream;

public class TileOController {
	
	public TileOController() {
		
	}
	public void CreateAGame(TileO tileO) {
		tileO.addGame(new Game(0, tileO));
		tileO.setCurrentGame(tileO.getGame(tileO.numberOfGames()-1));
	}
	public void CreateATile(int x,int y) {
		
	}
	public Tile addNormalTile(int i, int j, Game currentgame) {
		Tile temp = new NormalTile(i, j, currentgame);
		currentgame.addTile(temp);		
		return temp;
	}
	public void addActionTile(int i, int j, Game currentgame) {
		
		currentgame.addTile(new ActionTile(i, j, currentgame, 0));
		
	}
	public void addHiddenTile(int i, int j,Game currentgame) {
		currentgame.addTile(new WinTile(i, j, currentgame));
		
	}
	
	
	
	
	
	public void setcards(JButton instructionsbuttons[],Game current) throws InvalidInputException {
		int connecttile = 0;
		int loseturn = 0;
		int remove = 0;
		int rollagain = 0;
		int teleport = 0;
		for (int i = 0; i < instructionsbuttons.length; i++) {
			current.getDeck().addCard(instructionsbuttons[i].getText());
			switch (instructionsbuttons[i].getText()) {
			case "Connect Tiles":
				connecttile++;
			case "Lose Turn":
				loseturn++;
			case "Remove Tile":
				remove++;
			case "Teleport":
				teleport++;	
			case "Roll Again":
				rollagain++;
			default:
				break;
		}
		}
		if (connecttile>7) {
			throw new InvalidInputException("too many Connect Tile Cards");
		}if (loseturn>7) {
			throw new InvalidInputException("too many Lose Turn Cards");
		}if (remove>6) {
			throw new InvalidInputException("too many Remove Tile Cards");
		}if (rollagain>6) {
			throw new InvalidInputException("too many Roll Again Cards");
		}if (teleport>6) {
			throw new InvalidInputException("too many Teleport Cards");
		}
		
	}
	
	
	
	public void startGame(Game selectedGame) throws InvalidInputException {
		TileO tileO = TileOApplication.getTileO();
		tileO.setCurrentGame(selectedGame);
		if (!selectedGame.getDeck().hasCards()) {
			throw new InvalidInputException("No Action Cards");
		} else if (!selectedGame.hasWinTile()) {
			throw new InvalidInputException("No Win Tile");
		}
		
		for(Player player : selectedGame.getPlayers()) {
			if (!player.hasStartingTile()) {
				throw new InvalidInputException("No Starting Tile");
			}
		}
		Deck deck = selectedGame.getDeck();
		deck.shuffle();
		
		for (Tile tile : selectedGame.getTiles()) {
			tile.setHasBeenVisited(false);
		}
		
		for (Player player : selectedGame.getPlayers()) {
			Tile startingTile = player.getStartingTile();
			player.setCurrentTile(startingTile);
			startingTile.setHasBeenVisited(true);
		}
		
		selectedGame.setCurrentPlayer(selectedGame.getPlayers().get(0));
		
		selectedGame.setCurrentConnectionPieces(Game.SpareConnectionPieces);
		
		selectedGame.setMode(Game.Mode.GAME);
	}

	public void land(Tile tile) throws InvalidInputException{
		TileO tileO = TileOApplication.getTileO();
		Game currentGame=tileO.getCurrentGame();
		ArrayList<E> tiles =currentGame.getTiles();
		if(tiles.contains(tile)){
			tile.land();
		}else{
			throw new InvalidInputException("Tile does not exist in currentGame");
		}	
	}
	
	public List<Tile> playRollDieActionCard() throws InvalidInputException{
		TileO tileO = TileOApplication.getTileO();
		Game currentGame=tileO.getCurrentGame();
		Deck deck = currentGame.getDeck();
		ActionCard currentCard = deck.getCurrentCard();
		if(currentCard instanceof RollDieActionCard){
			List<Tile> tiles = currentCard.play();
		}else{
			throw new InvalidInputException("Current card is not a RollDieActionCard");
		}
		if(Deck.indexOfCard(currentCard)==(Deck.numberOfCards()-1)){
			deck.shuffle();
			deck.setCurrentCard(getCard(0));
		}else{
			deck.setCurrentCard(deck.getCard(deck.indexOfCard(currentCard)+1));
		}
		currentGame.setMode(Mode.GAME);
	}
	
	public List<Tile> rollDie () {
		TileO tileO = Main.getTileO();
		Game currentGame = tileO.getCurrentGame();
		Die die = currentGame.getDie();
		int rolledNum = die.roll();
		Player currentPlayer = currentGame.getCurrentPlayer();
		return currentPlayer.getPossibleMoves(rolledNum);
	}
	public void setcards(String instructions[]) {
		for (int i = 0; i < instructions.length; i++) {
			
		}
		
	}
public void playConnectTilesActionCard(Tile tile1, Tile tile2) throws InvalidInputException{
		
		    TileO tileO = Main.getTileO();
			Game currentGame=tileO.getCurrentGame();
			Deck deck = currentGame.getDeck();
			Player currentPlayer=currentGame.getCurrentPlayer();
		    //check:1.tile1,tile2 exist 2.they are adjacent 3.currentConnectionPieces greater than 0   
			//validation 1 and 2 can't figure out now 
			if(currentGame.getCurrentConnectionPieces()>0){
			 ActionCard currentCard=currentGame.getDeck().getCurrentCard();
			 if(currentCard instanceof ConnectTilesActionCard) {
				 ConnectTilesActionCard currentConnectCard=(ConnectTilesActionCard)currentCard;
				 currentConnectCard.play(tile1,tile2); 
				 //check
		    if(currentPlayer.getNumber()==currentGame.numberOfPlayers())
		    	currentGame.setCurrentPlayer(currentGame.getPlayer(1));
		    else
			    currentGame.setCurrentPlayer(currentGame.getPlayer(currentGame.indexOfPlayer(currentPlayer)+1));
			     //check
		    if(deck.indexOfCard(deck.getCurrentCard())==deck.maximumNumberOfCards()){
		       deck.shuffle();
		       deck.setCurrentCard(deck.getCard(1));
		    }
		    else{
			   deck.setCurrentCard(deck.getCard(deck.indexOfCard(currentCard)+1));
		    }
			currentGame.setMode(Mode.GAME);
		      }
			}
	 }
	
	
	 public void playRemoveConnectionActionCard(Connection connection) throws InvalidInputException{
		    TileO tileO = Main.getTileO();
			Game currentGame=tileO.getCurrentGame();
			Deck deck = currentGame.getDeck();
			Player currentPlayer=currentGame.getCurrentPlayer();
			//check if connection exists
			//can't figure out now
		 //if(){
			 ActionCard currentCard=currentGame.getDeck().getCurrentCard();
			 if(currentCard instanceof RemoveConnectionActionCard) {
				 RemoveConnectionActionCard currentRemoveConnectionCard=(RemoveConnectionActionCard)currentCard;
				 currentRemoveConnectionCard.play(connection);
			    
				         //check
				    if(currentPlayer.getNumber()==currentGame.numberOfPlayers())
				    	currentGame.setCurrentPlayer(currentGame.getPlayer(1));
				    else
					    currentGame.setCurrentPlayer(currentGame.getPlayer(currentGame.indexOfPlayer(currentPlayer)+1));
					     //check
				    if(deck.indexOfCard(deck.getCurrentCard())==deck.maximumNumberOfCards()){
				       deck.shuffle();
				       deck.setCurrentCard(deck.getCard(1));
				    }
				    else{
					   deck.setCurrentCard(deck.getCard(deck.indexOfCard(currentCard)+1));
				    }
					currentGame.setMode(Mode.GAME);
		     }
		// }
	 }
	 
	 
	 
	 public void playTeleportActionCard(Tile tile) throws InvalidInputException{
		    TileO tileO = Main.getTileO();
			Game currentGame=tileO.getCurrentGame();
			Deck deck = currentGame.getDeck();
			Player currentPlayer=currentGame.getCurrentPlayer();
			//check 1.if tile exists   2.tile is not currentTile
			//can't figure out now
		 //if(){
			 ActionCard currentCard=currentGame.getDeck().getCurrentCard();
		     //check
	         if(deck.indexOfCard(deck.getCurrentCard())==deck.maximumNumberOfCards()){
	            deck.shuffle();
	            deck.setCurrentCard(deck.getCard(1));
	          }
	         else{
		       deck.setCurrentCard(deck.getCard(deck.indexOfCard(currentCard)+1));
	          }
			 
			 if(currentCard instanceof TeleportActionCard) {
				 TeleportActionCard currentTeleportCard=(TeleportActionCard)currentCard;
				 currentTeleportCard.play(tile);
			 }
	    //}
     }
	

}


