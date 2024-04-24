import java.io.InputStream;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class BitTree<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  
  /** 
   * The root of the tree 
   */
  BinaryTreeNode<String> root;

  /**
   *  The size of the tree 
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a new tree
   */
  public BitTree(int n) {
    this.size = n;
    this.root = new BinaryTreeNode<String>("");
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public BinaryTreeNode<String> traverse(String code, BinaryTreeNode<String> cur) {
    for(int i = 0; i < code.length(); i++) {
      char comp = code.charAt(i);
      if(comp == '0') {
        if(cur.left == null) {
          cur.left = new BinaryTreeNode<String>("");
          cur = cur.left;
        } else {
          cur = cur.left;
        }
      } else if(comp == '1') {
        if(cur.right == null) {
          cur.right = new BinaryTreeNode<String>("");
          cur = cur.right;
        } else {
          cur = cur.right;
        }
      } else {
        throw new InvalidParameterException();
      }
    }
    return cur;
  }

  public void set(String bits, String value) {
    if(bits.length() != this.size) {
      throw new InvalidParameterException();
    }
    BinaryTreeNode<String> cur = this.root;
    cur = traverse(bits, cur);
    
    cur.value = value;
    return;
  }

  public String get(String bits) {
    if(bits.length() != this.size) {
      throw new InvalidParameterException();
    }
    BinaryTreeNode<String> cur = this.root;
    cur = traverse(bits, cur);
    return cur.value;
  }

  public void dump(PrintWriter pen) {
    dumpHelper(pen, root, "");
  }

  private void dumpHelper(PrintWriter pen, BinaryTreeNode<String> node, String result) {
    pen.flush();
    if (node == null) {
      pen.print("");
    } else if(node.value != "") {
      pen.println(result + "," + node.value);
    } else {
      if ((node.left != null) || (node.right != null)) {
        dumpHelper(pen, node.left, result + "0");
        dumpHelper(pen, node.right, result + "1");
      } // if has children
    } // else
  } // dump

  public void load(InputStream source) {
    Scanner lreader = new Scanner(source);
    String bitMap;
    while(lreader.hasNextLine()) {
      bitMap = lreader.nextLine();
      String[] parsd = bitMap.split(",", 2);
      set(parsd[0], parsd[1]);
    }
    lreader.close();
    return;
  }
}