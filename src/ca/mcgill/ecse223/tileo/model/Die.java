/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse223.tileo.model;
import java.io.Serializable;
import java.util.Random;

// line 100 "../../../../../TileOPersistence.ump"
// line 90 "../../../../../TileO.ump"
public class Die implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Die Associations
  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Die(Game aGame)
  {
    if (aGame == null || aGame.getDie() != null)
    {
      throw new RuntimeException("Unable to create Die due to aGame");
    }
    game = aGame;
  }

  public Die(int aCurrentConnectionPiecesForGame, Deck aDeckForGame, TileO aTileOForGame)
  {
    game = new Game(aCurrentConnectionPiecesForGame, aDeckForGame, this, aTileOForGame);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Game getGame()
  {
    return game;
  }

  public void delete()
  {
    Game existingGame = game;
    game = null;
    if (existingGame != null)
    {
      existingGame.delete();
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 103 ../../../../../TileOPersistence.ump
  private static final long serialVersionUID = -98743452L ;

  //------------------------
  // DEVELOPER CODE - added methods
  //------------------------
  private final Random random = new Random();
  public int roll() {
	  return random.nextInt(6) + 1;
  }
 
}