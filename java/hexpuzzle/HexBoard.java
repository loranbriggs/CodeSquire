public class HexBoard {
  private HexTile[] intialTiles = new HexTile[7];
  private HexTile[] finalTiles  = new HexTile[7];

  HexBoard(HexTile[] tiles) {
    if ( tiles.length == 7 ) {
      for ( int i = 0; i < tiles.length; i++ ) {
        intialTiles[i] = tiles[i];
      }
    } else {
      throw new IllegalArgumentException("Hex board must have 7 tiles");
    }
  }

  private boolean placeTile( HexTile tile, int index ) {
    if ( index == 0 ) {
      finalTiles[index] = tile;
      return true;
    } else {
      finalTiles[index] = tile;
      for ( int i = 0; i < 7; i++ ) {
        if ( fits() )
          return true;
        tile.rotateClockwise();
        finalTiles[index] = tile;
      }
      removeTile(index);
      return false;
    }
  }

  private void removeTile(int index) {
    finalTiles[index]= null;
  }

  private void removeAllTiles() {
    finalTiles = new HexTile[7];
  }

  private boolean fits() {
    if ( finalTiles[6] != null ) {
      if ( finalTiles[6].getIndex(1) != finalTiles[1].getIndex(4) )
        return false;
      if ( finalTiles[6].getIndex(2) != finalTiles[0].getIndex(5) )
        return false;
      if ( finalTiles[6].getIndex(3) != finalTiles[5].getIndex(0) )
        return false;
    }
    if ( finalTiles[5] != null ) {
      if ( finalTiles[5].getIndex(1) != finalTiles[0].getIndex(4) )
        return false;
      if ( finalTiles[5].getIndex(2) != finalTiles[4].getIndex(5) )
        return false;
    }
    if ( finalTiles[4] != null ) {
      if ( finalTiles[4].getIndex(0) != finalTiles[0].getIndex(3) )
        return false;
      if ( finalTiles[4].getIndex(1) != finalTiles[3].getIndex(4) )
        return false;
    }
    if ( finalTiles[3] != null ) {
      if ( finalTiles[3].getIndex(5) != finalTiles[0].getIndex(2) )
        return false;
      if ( finalTiles[3].getIndex(0) != finalTiles[2].getIndex(3) )
        return false;
    }
    if ( finalTiles[2] != null ) {
      if ( finalTiles[2].getIndex(4) != finalTiles[0].getIndex(1) )
        return false;
      if ( finalTiles[2].getIndex(5) != finalTiles[1].getIndex(2) )
        return false;
    }
    if ( finalTiles[1] != null ) {
      if ( finalTiles[1].getIndex(3) != finalTiles[0].getIndex(0) )
        return false;
    }
    return true;
  }

  public boolean Solve() {
    int intialTilesIndex = 0;
    int finalTilesIndex  = 0;
    int fails            = 0;
    int startAt          = 0;

    while( finalTilesIndex < 7 ) {
      //System.out.println( "finalTilesIndex is " + finalTilesIndex );
      if ( placeTile( intialTiles[intialTilesIndex % 7], finalTilesIndex ) ) {
        intialTilesIndex++;
        finalTilesIndex++;
        fails = 0;
      } else if ( finalTilesIndex + fails < 8 ) {
        fails++;
        intialTilesIndex++;
        placeTile( intialTiles[intialTilesIndex % 7], finalTilesIndex );
      } else if ( startAt < 8 ) {
        intialTilesIndex = ++startAt;
        finalTilesIndex  = 0;
        removeAllTiles();
        fails = 0;
      } else {
        return false;
      }
    }
    return true;
  }

  public void Print() {
    for ( int i = 0; i < finalTiles.length; i++ ) {
      System.out.println( finalTiles[i].toString() );
    }
  }

  public String toString() {
    java.lang.StringBuilder output = new java.lang.StringBuilder();
    for ( int i = 0; i < finalTiles.length; i++ ) {
      output.append( finalTiles[i].toString() );
      output.append("\n");
    }
    return output.toString();
  }

  public int[][] Array() {
    int[][] array = new int[7][6];
    for ( int i = 0; i < finalTiles.length; i++ ) {
      for ( int j = 0; j < finalTiles[i].getEdges().length; j++ ) {
        array[i][j] = finalTiles[i].getIndex(j);
      }
    }
    return array;
  }
}
