<<<<<<< HEAD
public class BrailleASCII {
  
=======
import java.io.PrintWriter;

public class BrailleASCII {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out);
    BitTree<String> test = new BitTree<String>(6);
    test.set("100000", "A");
    test.set("100100", "C");
    test.set("101100", "M");
    test.dump(pen);
  }
>>>>>>> 001ae1d97f3536b95e7fc305f938b47315cf9360
}
