import java.io.PrintWriter;

public class BrailleASCII {
  public static void main(String[] args) throws Exception {
    BrailleASCIITables tables = new BrailleASCIITables();
    PrintWriter pen = new PrintWriter(System.out);
    if(args[0].equals("braille") || args[0].equals("Braille")) {
      for(int i = 0; i < args[1].length(); i++) {
        String toPrint = tables.toBraille(args[1].charAt(i));
        pen.print(toPrint);
      }
      pen.flush();
    } else if(args[0].equals("ASCII") || args[0].equals("ascii")) {
      convert(args[0], args[1], pen, tables);
    } else if(args[0].equals("unicode") || args[0].equals("Unicode")) {
      convert(args[0], args[1], pen, tables);
    } else {
      throw new Exception("Invalid conversion code");
    }
  }

  /**
   * 
   * @param code
   * @param parse
   * @param pen
   * @param tables
   * Converts a string of bits to their corresponding characters and prints them
   */
  public static void convert(String code, String parse, PrintWriter pen, BrailleASCIITables tables) {
    int i = 0;
    String toPrint;
    while(i < parse.length()) {
      if(code.equals("ASCII") || code.equals("ascii")) {
        toPrint = tables.toASCII(parse.substring(i, i+5)); //5 is not a magic number, it is the number of bits forward we have to move to get a braille value of six bits.
        i += tables.brailleToASCII.getSize();
      } else {
        toPrint = tables.toUnicode(parse.substring(i, i+5)); //5 is not a magic number, it is the number of bits forward we have to move to get a braille value of six bits.
        i += tables.brailleToUnicode.getSize();
      }
      pen.print(toPrint);
    }
    pen.flush();
  }
}
