/**
 * Nodes in a binary tree.
 * @author Sam R
 */
class BinaryTreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value in this node.
   */
  String value;
  
  /**
   * The left subtree.
   */
  BinaryTreeNode left;
  
  /**
   * The right subtree.
   */
  BinaryTreeNode right;
 
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public BinaryTreeNode(String value, BinaryTreeNode left, BinaryTreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  } // BinaryTreeNode(T, BinaryTreeNode, BinaryTreeNode)
  
  public BinaryTreeNode(String value) {
    this(value, null, null);
  } // BinaryTreeNode(T)
} // class BinaryTreeNode<T>
