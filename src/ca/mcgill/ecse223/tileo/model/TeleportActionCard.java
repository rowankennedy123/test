/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

// line 88 "../../../../../TileOPersistence.ump"
// line 82 "../../../../../TileO.ump"
public class TeleportActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TeleportActionCard(String aInstructions, Deck aDeck)
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
  
  
  public void play(Tile tile){
	//waiting for the 3rd feature in play mode
	 //TileOController.land(tile);
  }
  
  
  // line 91 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = -27334454436L ;

	@Override
	public Mode getActionCardGameMode() {
		return Mode.GAME_TELEPORTACTIONCARD;
	}

  
}
