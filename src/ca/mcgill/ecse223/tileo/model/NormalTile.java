/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.*;

// line 40 "../../../../../TileOPersistence.ump"
// line 48 "../../../../../TileO.ump"
public class NormalTile extends Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NormalTile(int aX, int aY, Game aGame)
  {
    super(aX, aY, aGame);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 43 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = -7403802774454467836L ;

	@Override
  public void land(Tile tile){
	  TileO tileO = Main.getTileO();
	  Game currentGame=tileO.getCurrentGame();
	  Player currentPlayer = currentGame.getCurrentPlayer();
	  currentPlayer.setCurrentTile(tile);
	  boolean wasSet = false;
	  //if currentPlayer is last player
	  //assumes players will be numbered starting from 0
	  if(currenGame.indexOfPlayer(currentPlayer)==(currentGame.numberOfPlayers()-1){
		  firstplayer is player
		  wasSet = setCurrentPlayer(currentGame.getPlayer(currentGame.indexOfPlayer(0));
	  }else{
		  wasSet = setCurrentPlayer(currentGame.getPlayer(currentGame.indexOfPlayer(currentPlayer)+1));
	  }
	  if(wasSet==false){
		  throw new InvalidInputException();
	  }
	  tile.setHasBeenVisited(true);
	  currentGame.setMode(Mode.GAME);
  }

  
}