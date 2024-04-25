import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BrailleASCIITables {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  BitTree brailleToASCII;
  BitTree ASCIIToBraille;
  BitTree brailleToUnicode;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public BrailleASCIITables() {
    this.brailleToASCII = new BitTree(6);
    try {
      brailleToASCII.load(new FileInputStream("BrailleToASCII.txt"));
    } catch (FileNotFoundException e) {
      System.exit(0);
    }
    this.ASCIIToBraille = new BitTree(8);
    try {
      ASCIIToBraille.load(new FileInputStream("ASCIIToBraille.txt"));
    } catch (FileNotFoundException e) {
      System.exit(0);
    }
    this.brailleToUnicode = new BitTree(6);
    try {
      brailleToUnicode.load(new FileInputStream("BrailleToUnicode.txt"));
    } catch (FileNotFoundException e) {
      System.exit(0);
    }
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public String toBraille(char letter) {
    String bitVal = Integer.toBinaryString((int) letter);
    return ASCIIToBraille.get(bitVal);
  }

  public String toASCII(String bits) {
    return brailleToASCII.get(bits);
  }

  public String toUnicode(String bits) {
    String uniVal = brailleToUnicode.get(bits);
    int uniHex = Integer.parseInt(uniVal, 16);
    String uniChar = "" + ((char) uniHex);
    return uniChar;
  }
}
