/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.*;

// line 34 "../../../../../TileOPersistence.ump"
// line 41 "../../../../../TileO.ump"
public class ActionTile extends Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ActionTile Attributes
  private int inactivityPeriod;
  private int turnsUntilActive;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ActionTile(int aX, int aY, Game aGame, int aInactivityPeriod)
  {
    super(aX, aY, aGame);
    inactivityPeriod = aInactivityPeriod;
    turnsUntilActive = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTurnsUntilActive(int aTurnsUntilActive)
  {
    boolean wasSet = false;
    turnsUntilActive = aTurnsUntilActive;
    wasSet = true;
    return wasSet;
  }

  public int getInactivityPeriod()
  {
    return inactivityPeriod;
  }

  public int getTurnsUntilActive()
  {
    return turnsUntilActive;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "inactivityPeriod" + ":" + getInactivityPeriod()+ "," +
            "turnsUntilActive" + ":" + getTurnsUntilActive()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 37 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = 2045406856025012133L ;

  @Override
  public void land(Tile tile){
	  TileO tileO = Main.getTileO();
	  Game currentGame=tileO.getCurrentGame();
	  Player currentPlayer = currentGame.getCurrentPlayer();
	  currentPlayer.setCurrentTile(tile);
	  tile.setHasBeenVisited(true);
	  Deck deck = currentGame.getDeck();
	  if(hasCurrentCard()){
		  ActionCard currentCard = Deck.getCurrentCard();
	  }else{
		  Deck.setCurrentCard(getCard(0));
		  ActionCard currentCard = Deck.getCurrentCard();
	  }
	  Mode mode = currentCard.getActionCardGameMode();
	  currentGame.setMode(mode);
  }

  
}