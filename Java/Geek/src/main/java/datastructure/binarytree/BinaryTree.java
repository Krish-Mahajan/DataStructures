package datastructure.binarytree;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Implementation of Binary Tree
 *
 * @author krish.mahajan@gmail.com
 */
public class BinaryTree<T extends Comparable<T>> {

  static final Logger logger = Logger.getLogger(BinaryTree.class.getName());

  private Node<T> root;

  public BinaryTree(T key) {
    this.root = new Node<T>(key);
  }

  public BinaryTree() {
    this.root = null;
  }

  public void setRoot(T key) {
    this.root = new Node<T>(key);
  }

  public Node<T> getRoot() throws RootNotSetException {
    if (this.root == null) throw new RootNotSetException();
    return this.root;
  }

  /**
   * inorderTraversal for binaryTree
   *
   * @param tree
   */
  public void inorderTraversal(BinaryTree<T> tree) throws RootNotSetException {
    if (tree.getRoot() == null) throw new RootNotSetException();
    this.inorderTraversalNode(tree.getRoot());
  }

  /**
   * Helper method for inorder Traversal of binary Tree
   *
   * @param n
   */
  public void inorderTraversalNode(Node<T> n) {
    if (n == null) return;
    this.inorderTraversalNode(n.getLeftChild());
    System.out.print(n.getKey() + " ");
    this.inorderTraversalNode(n.getRightChild());
    return;
  }

  /** Preorder Traversal for Binary Tree */
  public void preorderTraversal(BinaryTree<T> tree) throws RootNotSetException {
    if (tree.getRoot() == null) throw new RootNotSetException();
    this.preorderTraversalNode(tree.getRoot());
  }

  private void preorderTraversalNode(Node<T> n) {
    if (n == null) return;
    System.out.print(n.getKey() + " ");
    this.preorderTraversalNode(n.getLeftChild());
    this.preorderTraversalNode(n.getRightChild());
    return;
  }

  /** postorder Traversal for Binary Tree */
  public void postorderTraversal(BinaryTree<T> tree) throws RootNotSetException {
    if (tree.getRoot() == null) throw new RootNotSetException();
    this.postorderTraversalNode(tree.getRoot());
  }

  private void postorderTraversalNode(Node<T> n) {
    if (n == null) return;
    this.postorderTraversalNode(n.getLeftChild());
    this.postorderTraversalNode(n.getRightChild());
    System.out.print(n.getKey() + " ");
    return;
  }

  /**
   * Insertion of element in BinarySearchTree
   *
   * @param key
   */
  public void insert(T key) {
    try {
      this.insertHelp(this.getRoot(), key);
    } catch (RootNotSetException e) {
      this.setRoot(key);
      logger.info("Initialized Root of the tree");
      logger.info("\n");
    }
  }

  public void insertHelp(Node<T> n, T key) {

    if (n.getKey().compareTo(key) < 0) {
      if (n.getRightChild() != null) insertHelp(n.getRightChild(), key);
      else {
        n.setRightChild(key);
        return;
      }

    } else if (n.getKey().compareTo(key) == 0) {
      logger.info("Duplicate Key");
      return;
    } else {
      if (n.getLeftChild() != null) insertHelp(n.getLeftChild(), key);
      else {
        n.setLeftChild(key);
        return;
      }
    }
  }

  /**
   * Create Binary Search Tree from Array elements
   *
   * @param elements
   */
  public void insertFromArray(T[] elements) {
    for (int i = 0; i < elements.length; i++) {
      this.insert(elements[i]);
    }
  }

  /** Search for a element in Binary Search Tree */
  public boolean searchBST(T key) {

    try {
      return this.searchBSTHelper(this.getRoot(), key);
    } catch (RootNotSetException e) {
      logger.debug("Tree Empty");
      e.printStackTrace();
      return false;
    }
  }

  private boolean searchBSTHelper(Node<T> node, T key) {

    if (node == null) return false;

    if (node.getKey().compareTo(key) == 0) return true;

    if (node.getKey().compareTo(key) < 0) return this.searchBSTHelper(node.getRightChild(), key);
    else if (node.getKey().compareTo(key) > 0)
      return this.searchBSTHelper(node.getLeftChild(), key);

    return false;
  }

  /**
   * REMEMBER Check if the given Binary Tree is Binary Search Tree
   *
   * @return
   */
  public boolean checkIfBST() {
    try {
      return checkIfBST_helper(this.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    } catch (RootNotSetException e) {
      logger.debug("Tree list is empty");
      return false;
    }
  }

  private boolean checkIfBST_helper(Node<T> node, int minValue, int maxValue) {

    if (node == null) return true;

    int node_key = (Integer) node.getKey();

    if (node_key < minValue || node_key > maxValue) return false;

    return (checkIfBST_helper(node.getLeftChild(), minValue, (Integer) node.getKey())
        && checkIfBST_helper(node.getRightChild(), (Integer) node.getKey(), maxValue));
  }

  /**
   * Find inorder successor of a node in Binary Tree
   *
   * @param n
   * @return
   */
  public Node<T> inorderSuccessor(Node<T> n) {
    if (n.getRightChild() != null) {
      return this.iterateDown(n.getRightChild());
    } else {
      return this.iterateUp(n.getParent(), n.getKey());
    }
  }

  private Node<T> iterateUp(Node<T> n, T KEY) {
    if (n.getParent() != null && n.getKey().compareTo(KEY) < 0)
      return iterateUp(n.getParent(), KEY);
    else return n;
  }

  public Node<T> iterateDown(Node<T> n) {
    if (n.getLeftChild() != null) return iterateDown(n.getLeftChild());
    else return n;
  }

  /**
   * Function to delete a node from Binary Search Tree
   *
   * @param n : The node to be deleted.
   */
  public void deleteNode(Node<T> n) {
    try {
      if (this.getRoot() != null) {
        // if the node is a leaf
        if (n.getRightChild() == null && n.getLeftChild() == null) {
          if (n.getKey().compareTo(n.getParent().getKey()) <= 0) n.getParent().setLeftChild(null);
          else n.getParent().setRightChild(null);
        }

        // if both the nodes are not null
        else if (n.getRightChild() != null && n.getLeftChild() != null) {
          Node<T> inorder_successor = this.inorderSuccessor(n);
          T tmp_key = inorder_successor.getKey();
          if (inorder_successor.getKey().compareTo(inorder_successor.getParent().getKey()) <= 0)
            inorder_successor.getParent().setLeftChild(null);
          else inorder_successor.getParent().setRightChild(null);

          n.setKey(tmp_key);
        }

        // Node to be deleted has only one child
        else if (n.getLeftChild() != null || n.getRightChild() != null) {

          Node<T> node_tmp_parent = n.getParent();
          T node_tmp_key = n.getKey();

          if (n.getKey().compareTo(n.getParent().getKey()) <= 0) n.getParent().setLeftChild(null);
          else n.getParent().setRightChild(null);

          node_tmp_parent.setKey(node_tmp_key);
        }
      }
    } catch (RootNotSetException e) {
      logger.debug("TREE EMPTY");
      e.printStackTrace();
    }
  }

  /**
   * Helper function to print binary tree vertically using preorder traversal
   *
   * @param root
   * @param hd
   * @param m
   */
  private void getVerticalOrder_help(Node<T> root, int hd, TreeMap<Integer, Vector<Node<T>>> m) {

    if (root == null) return;

    Vector<Node<T>> get = m.get(hd);

    if (get == null) {
      get = new Vector<Node<T>>();
      get.add(root);
    } 
    else get.add(root);
    
    m.put(hd, get);

    getVerticalOrder_help(root.getLeftChild(), hd - 1, m);

    getVerticalOrder_help(root.getRightChild(), hd + 1, m);
  }

  /**
   * Public function to print Binary Tree Vertically
   *
   * @throws RootNotSetException
   */
  public void getVerticalOrder() throws RootNotSetException {

    TreeMap<Integer, Vector<Node<T>>> tm = new TreeMap<Integer, Vector<Node<T>>>();
    getVerticalOrder_help(this.getRoot(), 0, tm);

    for (Entry<Integer, Vector<Node<T>>> entry : tm.entrySet()) {

      for (Node<T> v : entry.getValue()) {
        System.out.print(v.getKey() + " ");
      }
      System.out.println("\n");
    }
  }
  
  /**
   * REMEMBER
   * Create Binary Search Tree from Sorted Array
   * https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
   * @param arr
   */
  public void sortedArrayToBalancedBST(T[] arr) {
   
	  this.sortedArrayToBalancedBST_help(arr ,0 , arr.length -1);
	
  }
  
  
  private void sortedArrayToBalancedBST_help(T[] arr, int start , int end) {
	  if(start > end) return; 
	  int mid = (start + end)/2;
	  this.insert(arr[mid]);
	  sortedArrayToBalancedBST_help(arr,  start ,mid -1);
	  sortedArrayToBalancedBST_help(arr, mid+1,end);
	  
	  
  }
}

/**
 * Node class to store nodes of a Binary Tree
 *
 * @author krish.mahajan@ibm.com
 */
class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

  private T key;
  private Node<T> leftChild, rightChild, parent;

  public Node(T item) {
    key = item;
    parent = leftChild = rightChild = null;
  }

  public T getKey() {
    return this.key;
  }

  public void setKey(T key) {
    this.key = key;
  }

  public Node<T> getLeftChild() {
    return this.leftChild;
  }

  public Node<T> getRightChild() {
    return this.rightChild;
  }

  public Node<T> getParent() {
    return this.parent;
  }

  public void setLeftChild(T leftChild) {
    if (leftChild != null) {
      this.leftChild = new Node<T>(leftChild);
      this.leftChild.parent = this;
    } else this.leftChild = null;
  }

  public void setRightChild(T rightChild) {

    if (rightChild != null) {
      this.rightChild = new Node<T>(rightChild);
      this.rightChild.parent = this;
    } else this.rightChild = null;
  }

  public int compareTo(Node<T> o) {
    return this.getKey().compareTo(o.getKey());
  }
}
