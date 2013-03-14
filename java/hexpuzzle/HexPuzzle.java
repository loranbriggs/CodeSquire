//import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HexPuzzle extends JApplet {

  // GUI Objects
  JLabel     jlPrompt = new JLabel("<html>Each tile is a set of six integers from" 
    + " one to six nonrepeating. Please enter them as a string seperated by"
    + " spaces. EG '1 2 3 4 5 6'</html>");
  JLabel[]   tileLabels = new JLabel[7];
  JTextField[]   tileInputs = new JTextField[7];
  JButton    jbSolve= new JButton("Solve");
  JLabel     labelErrors = new JLabel();
  JTextArea  textAreaOutput = new JTextArea(20,20);

  HexPanel hexagons = new HexPanel();

  public HexPuzzle() {

    // create tile labels and inputs
    for ( int i = 0; i < tileLabels.length; i++ ) {
      tileLabels[i] = new JLabel("Tile " + (i+1) + ":");
    }
    tileInputs[0] = new JTextField("1 6 4 2 5 3");
    tileInputs[1] = new JTextField("1 6 5 4 3 2");
    tileInputs[2] = new JTextField("1 4 6 2 3 5");
    tileInputs[3] = new JTextField("1 6 5 3 2 4");
    tileInputs[4] = new JTextField("1 4 3 6 5 2");
    tileInputs[5] = new JTextField("1 2 3 4 5 6");
    tileInputs[6] = new JTextField("1 6 2 4 5 3");

    // Panels
    JPanel northPanel = new JPanel(new BorderLayout());
    northPanel.add(jlPrompt, BorderLayout.NORTH);
    JPanel inputsPanel = new JPanel(new GridLayout(7,2));
    for ( int i = 0; i < tileLabels.length; i++ ) {
      inputsPanel.add(tileLabels[i]);
      inputsPanel.add(tileInputs[i]);
    }
    northPanel.add(inputsPanel, BorderLayout.CENTER);
    northPanel.add(jbSolve, BorderLayout.SOUTH);

    JPanel centerPanel = new JPanel(new BorderLayout());
    centerPanel.add(labelErrors, BorderLayout.NORTH);
    labelErrors.setForeground(Color.RED);
    centerPanel.add(textAreaOutput, BorderLayout.CENTER);
    centerPanel.add(hexagons, BorderLayout.CENTER);

    // Add panels to frame
    add(northPanel, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);

    // Register Listeners
    jbSolve.addActionListener( new SolveListener() );
  }

  // Define Listeners
  private class SolveListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      labelErrors.setText("");
      try {
        HexBoard board = new HexBoard(getInputs());
        if (board.Solve()) {
          hexagons.setArray(board);
          repaint();
        }
        else
          labelErrors.setText("unsolvable");
      } catch (NumberFormatException ex2) {
        labelErrors.setText(ex2.getMessage());
      } catch (IllegalArgumentException ex) {
        labelErrors.setText(ex.getMessage());
      }
    }
  }

  // Define Methods
  private HexTile[] getInputs() throws IllegalArgumentException {
    HexTile[] tiles = new HexTile[7];
    for ( int i = 0; i < tiles.length; i++ ) {
      String[] edgesStrings = tileInputs[i].getText().split(" ");
      int[] edges = new int[edgesStrings.length];
      for ( int j = 0; j < edgesStrings.length; j++ ) {
        try {
          edges[j] = Integer.parseInt(edgesStrings[j]);
        } catch (NumberFormatException e) {
          throw new NumberFormatException("Input not an integer");
        }
      }
      tiles[i] = new HexTile(edges);
    }
    return tiles;
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    HexPuzzle applet = new HexPuzzle();
    frame.add(applet);
    frame.setTitle("Hex Puzzle");
    frame.setSize(350, 650);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
