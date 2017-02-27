/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

// line 76 "../../../../../TileOPersistence.ump"
// line 74 "../../../../../TileO.ump"
public class ConnectTilesActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConnectTilesActionCard(String aInstructions, Deck aDeck)
  {
    super(aInstructions, aDeck);
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
  public void play(Tile tile1,Tile tile2){
	  //waiting for the 4th feature in design mode
	  //TileOController.connectTiles(tile1,tile2);
  }
    
  // line 79 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = -1409832774467836L ;

	@Override
	public Mode getActionCardGameMode() {
		return Mode.GAME_CONNECTTILESACTIONCARD;
	}

  
}
