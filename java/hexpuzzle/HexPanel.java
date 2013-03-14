import java.awt.*;
import javax.swing.JPanel;

public class HexPanel extends JPanel {
  private int[][] hexArray = new int[7][6];

  public void setArray( HexBoard board ) {
    this.hexArray = board.Array();
  }

  @Override
  protected void paintComponent(Graphics Hexagons) {
    super.paintComponent(Hexagons);
    int panelWidth = getWidth();
    int panelHeight = getHeight();
    int centerX = panelWidth/2;
    int centerY = panelHeight/2;
    final int radius = 50;
    int[] centerXs = new int[] {
      centerX,
      centerX,
      (int)(centerX + 2*radius*Math.cos(Math.toRadians(30))),
      (int)(centerX + 2*radius*Math.cos(Math.toRadians(30))),
      centerX,
      (int)(centerX - 2*radius*Math.cos(Math.toRadians(30))),
      (int)(centerX - 2*radius*Math.cos(Math.toRadians(30))),
    };
    int[] centerYs = new int[] {
      centerY,
      (int)(centerY - 2*radius),
      (int)(centerY - 2*radius*Math.sin(Math.toRadians(30))),
      (int)(centerY + 2*radius*Math.sin(Math.toRadians(30))),
      (int)(centerY + 2*radius),
      (int)(centerY + 2*radius*Math.sin(Math.toRadians(30))),
      (int)(centerY - 2*radius*Math.sin(Math.toRadians(30))),
    };
    int[] edgePosX = new int[] {
      0,
      (int)(0.6*radius*Math.cos(Math.toRadians(30))),
      (int)(0.7*radius*Math.cos(Math.toRadians(30))),
      0,
      (int)(-0.8*radius*Math.cos(Math.toRadians(30))),
      (int)(-0.8*radius*Math.cos(Math.toRadians(30))),
    };
    int[] edgePosY = new int[] {
      (int)(-0.6*radius),
      (int)(-0.7*radius*Math.sin(Math.toRadians(30))),
      (int)(0.8*radius*Math.sin(Math.toRadians(30))),
      (int)(0.8*radius),
      (int)(0.8*radius*Math.sin(Math.toRadians(30))),
      (int)(-0.7*radius*Math.sin(Math.toRadians(30))),
    };


    Polygon[] tiles = new Polygon[7];
    for ( int i = 0; i < 7; i++ ) {
      tiles[i] = new Polygon();
      for ( int j = 0; j < 6; j++ ) {
        tiles[i].addPoint(
          (int)( centerXs[i] + 50*Math.cos( j*2*Math.PI/6 ) ),
          (int)( centerYs[i] + 50*Math.sin( j*2*Math.PI/6 ) )
        );
      }
      Hexagons.drawPolygon(tiles[i]);
      for ( int k = 0; k < 6; k++ ) {
        switch (hexArray[i][k]) {
          case 1:
            Hexagons.setColor(Color.BLUE);
            break;
          case 2:
            Hexagons.setColor(Color.RED);
            break;
          case 3:
            Hexagons.setColor(Color.PINK);
            break;
          case 4:
            Hexagons.setColor(Color.GREEN);
            break;
          case 5:
            Hexagons.setColor(Color.CYAN);
            break;
          case 6:
            Hexagons.setColor(Color.ORANGE);
            break;
          default:
            Hexagons.setColor(Color.BLACK);
        }
        Hexagons.drawString(
          String.valueOf(hexArray[i][k]),
          centerXs[i] + edgePosX[k],
          centerYs[i] + edgePosY[k]
        );
        Hexagons.setColor(Color.BLACK);
      }
    }
  }
}
