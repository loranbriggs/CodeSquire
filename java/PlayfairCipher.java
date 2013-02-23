import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PlayfairCipher extends JApplet {

  String helpText =
    "This encoder uses the Playfair Cipher method to encode and decode " +
    "messages. To use simply, type text in the left window and press 'encode'." +
    " The encoded message will appear in the window to the right. To decode " +
    "simply paste an encoded message into the right window and press 'decode'." +
    " The secret key is the pharse used to change the encoder method. Make sure " +
    "to use the same key when encoding / decoding the same message.";

  // String variables
  String decodedString = "Computers Are Fun?";
  String encodedString = "Type message to decode here";
  String secretKey     = "Cryptogaphy Is Fun.";
  StringBuilder key    = new StringBuilder("blank");
  // Constants
  private final char[] characters =
    {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
     'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
     'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
     'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
     'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
     't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
     '2', '3', '4', '5', '6', '7', '8', '9', ' ',
     '\'', '(', ')', '*', '+', ',', '-', '.', '/',
     ':', ';', '<', '=', '>', '[', ']', '^', '?' };
  final String characterSet = new String(characters);

  // GUI objects
  JTextArea jtaDecode = new JTextArea(9,15);
  JTextArea jtaEncode = new JTextArea(9,15);
  JTextField jtfSecret = new JTextField(25);

  JButton jbEncode = new JButton("Encode");
  JButton jbDecode = new JButton("Decode");
  JButton jbClear  = new JButton("Clear");
  JButton jbHelp   = new JButton("Help");
  JButton jbHide   = new JButton("Hide");

  // help frame
  JFrame helpFrame = new JFrame();
  JTextArea jtaHelp = new JTextArea(20,20);
  JLabel author = new JLabel("Created by Loran Briggs");

  public PlayfairCipher() {

    // pannels
    JPanel decodePanel = new JPanel();
    decodePanel.add(jtaDecode);
    jtaDecode.setText(decodedString);
    jtaDecode.setWrapStyleWord(true);
    jtaDecode.setLineWrap(true);
    decodePanel.setBorder( new TitledBorder("Decoded Message") );

    JPanel encodePanel = new JPanel();
    encodePanel.add(jtaEncode);
    jtaEncode.setText(encodedString);
    jtaEncode.setWrapStyleWord(true);
    jtaEncode.setLineWrap(true);
    encodePanel.setBorder( new TitledBorder("Encoded Message") );

    JPanel secretPanel = new JPanel();
    secretPanel.add(jtfSecret);
    jtfSecret.setText(secretKey);
    secretPanel.setBorder( new TitledBorder("Secret Key") );

    JPanel mainPanel = new JPanel();
    mainPanel.add(decodePanel);
    mainPanel.add(encodePanel);
    mainPanel.add(secretPanel);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(jbEncode);
    buttonPanel.add(jbDecode);
    buttonPanel.add(jbClear);
    buttonPanel.add(jbHelp);

    // add panels to frame
    add(mainPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    // add to help frame
    helpFrame.add(author, BorderLayout.NORTH);
    author.setHorizontalAlignment(SwingConstants.RIGHT);
    helpFrame.add(jtaHelp, BorderLayout.CENTER);
    helpFrame.add(jbHide, BorderLayout.SOUTH);
    helpFrame.setTitle("Help");
    helpFrame.setSize(480, 320);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension windowSize = helpFrame.getSize();
    int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
    int windowY = Math.max(0, (screenSize.height + windowSize.height) / 2);
    helpFrame.setLocation(windowX,windowY);
    //helpFrame.setLocationRelativeTo(null); // Center the frame
    jtaHelp.setText(helpText);
    jtaHelp.setBorder( new TitledBorder("Help") );
    jtaHelp.setWrapStyleWord(true);
    jtaHelp.setLineWrap(true);
    jtaHelp.setEditable(false);

    // Register listeners
    jbEncode.addActionListener( new ButtonListener() );
    jbDecode.addActionListener( new ButtonListener() );
    jbClear.addActionListener( new ButtonListener() );
    jbHelp.addActionListener( new ButtonListener() );
    jbHide.addActionListener( new ButtonListener() );

  }

  // Define listeners
  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == jbEncode)
        Encode();
      else if (e.getSource() == jbDecode)
        Decode();
      else if (e.getSource() == jbClear)
        Clear();
      else if (e.getSource() == jbHide)
        helpFrame.setVisible(false);
      else if (e.getSource() == jbHelp) {
        helpFrame.setVisible(true);
      }
    }
  }


  // Define Methods
  private void Encode() {
    fillKey();
    decodedString = dealWithEnd( jtaDecode.getText() );
    try {
      encodedString = encodeDecode( decodedString, true );
      jtaEncode.setText(encodedString);
    }
    catch (IllegalArgumentException ex) {
      jtaEncode.setText(ex.getMessage());
    }
  }

  private void Decode() {
    fillKey();
    encodedString = dealWithEnd( jtaEncode.getText() );
    try {
      decodedString = encodeDecode( encodedString, false );
      jtaDecode.setText(decodedString);
    }
    catch (IllegalArgumentException ex) {
      jtaDecode.setText(ex.getMessage());
    }
  }

  private void Clear() {
    jtaEncode.setText("");
    jtaDecode.setText("");
  }

  private void fillKey() {
    key.setLength(0); // StringBuilder
    secretKey = jtfSecret.getText(); // String
    for ( int i = 0; i < secretKey.length(); i++ ) {
      boolean flag = true;
      for ( int j = 0; j < key.length(); j++ ) {
        if ( secretKey.charAt(i) == key.charAt(j) )
          flag = false;
      }
      if (flag)
        key.append(secretKey.charAt(i));
    }
    for ( int i = 0; i < characterSet.length(); i++ ) {
      boolean flag = true;
      for ( int j = 0; j < key.length(); j++ ) {
        if ( characterSet.charAt(i) == key.charAt(j) )
          flag = false;
      }
      if (flag)
        key.append(characterSet.charAt(i));
    }
  }

  private String dealWithEnd(String s) {
    if ( s.length() % 2 == 0 )
      return s;
    else {
      if ( s.charAt( s.length() - 1 ) == ' ' )
        return ( s.substring(0, s.length() - 1) );
      else
        return ( s + ' ' );
    }
  }

  private String encodeDecode(String inputString, boolean encode) throws IllegalArgumentException {
    StringBuilder outputString = new StringBuilder();
    for ( int i = 0; i < inputString.length(); i+=2 ) {
      char i1 = inputString.charAt(i);
      char i2 = inputString.charAt(i+1);
      char o1 = ' ';
      char o2 = ' ';
      int index1 = key.toString().indexOf(i1);
      int index2 = key.toString().indexOf(i2);
      if ( index1 == index2 ) {
        throw new IllegalArgumentException(
          "Two consecutive characters can not be identical if their positions" +
          " are odd then even, i.e. the word 'letter'" );
      } else if ( (index1 % 9 != index2 % 9) && (index1 / 9 != index2 / 9) ) {
        o1 = key.charAt( index1/9*9 + index2 % 9 );
        o2 = key.charAt( index2/9*9 + index1 % 9 );
      } else if ( index1 / 9 == index2 / 9 ) {
        if (encode) {
          if ( index1 % 9 < 8 )
            o1 = key.charAt( index1 + 1 );
          else
            o1 = key.charAt( index1 - 8 );
          if ( index2 % 9 < 8 )
            o2 = key.charAt( index2 + 1 );
          else
            o2 = key.charAt( index2 - 8 );
        } else {
          if ( index1 % 9 > 0 )
            o1 = key.charAt( index1 - 1 );
          else
            o1 = key.charAt( index1 + 8 );
          if ( index2 % 9 > 0 )
            o2 = key.charAt( index2 - 1 );
          else
            o2 = key.charAt( index2 + 8 );
        }
      } else if ( index1 % 9 == index2 % 9 ) {
        if (encode) {
          if ( index1 / 9 < 8 )
            o1 = key.charAt( index1 + 9 );
          else
            o1 = key.charAt( index1 % 9 );
          if ( index2 / 9 < 8 )
            o2 = key.charAt( index2 + 9 );
          else
            o2 = key.charAt( index2 % 9 );
        } else {
          if ( index1 / 9 > 0 )
            o1 = key.charAt( index1 - 9 );
          else
            o1 = key.charAt( index1 + 72 );
          if ( index2 / 9 > 0 )
            o2 = key.charAt( index2 - 9 );
          else
            o2 = key.charAt( index2 + 72 );
        }
      }
      outputString.append(o1);
      outputString.append(o2);
    }
    return outputString.toString();
  }

  // Main
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    PlayfairCipher applet = new PlayfairCipher();
    frame.add(applet);
    frame.setSize(480, 320);
    frame.setTitle("Playfair's Cipher");
    //frame.setLocationRelativeTo(null); // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension windowSize = frame.getSize();
    int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
    int windowY = Math.max(0, (screenSize.height - windowSize.height) / 3);
    frame.setLocation(windowX,windowY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

}
