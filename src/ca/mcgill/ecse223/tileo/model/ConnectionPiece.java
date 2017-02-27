package ca.mcgill.ecse223.tileo.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/


import java.util.*;

// line 8 "umple.ump"
// line 52 "umple.ump"
public class ConnectionPiece
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConnectionPiece Associations
  private List<Tile> tiles;
  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConnectionPiece(Game aGame)
  {
    tiles = new ArrayList<Tile>();
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create connectionPiece due to game");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Tile getTile(int index)
  {
    Tile aTile = tiles.get(index);
    return aTile;
  }

  public List<Tile> getTiles()
  {
    List<Tile> newTiles = Collections.unmodifiableList(tiles);
    return newTiles;
  }

  public int numberOfTiles()
  {
    int number = tiles.size();
    return number;
  }

  public boolean hasTiles()
  {
    boolean has = tiles.size() > 0;
    return has;
  }

  public int indexOfTile(Tile aTile)
  {
    int index = tiles.indexOf(aTile);
    return index;
  }

  public Game getGame()
  {
    return game;
  }

  public boolean isNumberOfTilesValid()
  {
    boolean isValid = numberOfTiles() >= minimumNumberOfTiles() && numberOfTiles() <= maximumNumberOfTiles();
    return isValid;
  }

  public static int requiredNumberOfTiles()
  {
    return 2;
  }

  public static int minimumNumberOfTiles()
  {
    return 2;
  }

  public static int maximumNumberOfTiles()
  {
    return 2;
  }

  public boolean addTile(Tile aTile)
  {
    boolean wasAdded = false;
    if (tiles.contains(aTile)) { return false; }
    if (numberOfTiles() >= maximumNumberOfTiles())
    {
      return wasAdded;
    }

    tiles.add(aTile);
    if (aTile.indexOfConnectionPiece(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTile.addConnectionPiece(this);
      if (!wasAdded)
      {
        tiles.remove(aTile);
      }
    }
    return wasAdded;
  }

  public boolean removeTile(Tile aTile)
  {
    boolean wasRemoved = false;
    if (!tiles.contains(aTile))
    {
      return wasRemoved;
    }

    if (numberOfTiles() <= minimumNumberOfTiles())
    {
      return wasRemoved;
    }

    int oldIndex = tiles.indexOf(aTile);
    tiles.remove(oldIndex);
    if (aTile.indexOfConnectionPiece(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTile.removeConnectionPiece(this);
      if (!wasRemoved)
      {
        tiles.add(oldIndex,aTile);
      }
    }
    return wasRemoved;
  }

  public boolean setGame(Game aGame)
  {
    boolean wasSet = false;
    //Must provide game to connectionPiece
    if (aGame == null)
    {
      return wasSet;
    }

    //game already at maximum (32)
    if (aGame.numberOfConnectionPieces() >= Game.maximumNumberOfConnectionPieces())
    {
      return wasSet;
    }
    
    Game existingGame = game;
    game = aGame;
    if (existingGame != null && !existingGame.equals(aGame))
    {
      boolean didRemove = existingGame.removeConnectionPiece(this);
      if (!didRemove)
      {
        game = existingGame;
        return wasSet;
      }
    }
    game.addConnectionPiece(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Tile> copyOfTiles = new ArrayList<Tile>(tiles);
    tiles.clear();
    for(Tile aTile : copyOfTiles)
    {
      aTile.removeConnectionPiece(this);
    }
    Game placeholderGame = game;
    this.game = null;
    placeholderGame.removeConnectionPiece(this);
  }

}