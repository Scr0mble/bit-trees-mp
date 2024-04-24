public class BrailleASCIITables {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  BitTree<String> brailleToASCII;
  BitTree<String> ASCIIToBraille;
  BitTree<String> brailleToUnicode;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public BrailleASCIITables() {
    this.brailleToASCII = new BitTree<String>(6);
    this.ASCIIToBraille = new BitTree<String>(8);
    this.brailleToUnicode = new BitTree<String>(6);
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
