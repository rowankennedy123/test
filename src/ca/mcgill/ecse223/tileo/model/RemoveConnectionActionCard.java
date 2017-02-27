/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;

// line 82 "../../../../../TileOPersistence.ump"
// line 78 "../../../../../TileO.ump"
public class RemoveConnectionActionCard extends ActionCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RemoveConnectionActionCard(String aInstructions, Deck aDeck)
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
  public void play(Connection connection){
	//waiting for the 5th feature in design mode
	 // TileOController.removeConnection(connection);
  }
  
  
  // line 85 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = -74454467836L ;

	@Override
	public Mode getActionCardGameMode() {
		return Mode.GAME_REMOVECONNECTIONACTIONCARD;
	}

  
}
