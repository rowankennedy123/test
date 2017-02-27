/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.*;

// line 46 "../../../../../TileOPersistence.ump"
// line 52 "../../../../../TileO.ump"
public class WinTile extends Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WinTile(int aX, int aY, Game aGame)
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
  
  // line 49 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = -7403802774454467836L ;

	@Override
	public void land(Tile tile) {
		TileO tileO = Main.getTileO();
		Game currentGame = tileO.getCurrentGame();
		tile.setHasBeenVisited(true);
		currentGame.setMode(Mode.GAME_WON);
	}

  
}