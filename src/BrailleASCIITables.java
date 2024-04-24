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
  }
}
