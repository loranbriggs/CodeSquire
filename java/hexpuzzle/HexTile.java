public class HexTile {
  private int[] edges = new int[6];

  public HexTile(int[] e) {
    if ( e.length != 6 )
      throw new IllegalArgumentException("Hex Tile must have 6 entries");
    java.util.Set<Integer> set = new java.util.HashSet<Integer>();
    for ( int i = 0; i < e.length; i++ ) {
      if ( e[i] > 6 && e[i] < 1 )
        throw new IllegalArgumentException("Hex Tile must only contain integers 1 - 6");
      else if ( !set.add(e[i]) )
        throw new IllegalArgumentException("Hex Tile cannont repeate integers");
      else
        edges[i] = e[i];
    }
  }

  public void rotateClockwise() {
    int temp = edges[5];
    for ( int i = edges.length - 1; i > 0; i-- ) {
      edges[i] = edges[i-1];
    }
    edges[0] = temp;
  }

  public void rotateCounterClockwise() {
    int temp = edges[0];
    for ( int i = 0; i < edges.length - 1; i++ ) {
      edges[i] = edges[i+1];
    }
    edges[5] = temp;
  }

  public int getIndex(int i) {
    return edges[i];
  }

  public int[] getEdges() {
    return edges;
  }

  public String toString() {
    java.lang.StringBuilder output = new java.lang.StringBuilder();
    for ( int i = 0; i < edges.length; i++ ) {
      output.append( edges[i] + " " );
    }
    return output.toString();
  }
}
