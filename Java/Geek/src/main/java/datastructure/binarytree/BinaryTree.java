package datastructure.binarytree;

import org.apache.log4j.Logger;

/**
 * Implementation of Binary Tree
 * 
 * @author krish.mahajan@gmail.com
 *
 */
public class BinaryTree<T extends Comparable<T>> {

	final static Logger logger = Logger.getLogger(BinaryTree.class.getName());

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

	public Node<T> getRoot() throws RootNotSetException{
		if( this.root == null) throw new RootNotSetException();
		return this.root;
	}
	
	
	/**
	 * inorderTraversal for binaryTree
	 * @param tree
	 */
	public void inorderTraversal(BinaryTree<T> tree) throws RootNotSetException{
		if(tree.getRoot() == null) throw new RootNotSetException();
		this.inorderTraversalNode(tree.getRoot());
	}
	/**
	 * Helper method for inorder Traversal of binary Tree
	 * @param n
	 */
	public void inorderTraversalNode(Node<T> n)
	{
		if(n == null) return;
		this.inorderTraversalNode(n.getLeftChild());
		System.out.print(n.getKey() + " ");
		this.inorderTraversalNode(n.getRightChild());
		return;
	}
	
	/**
	 * Preorder Traversal for Binary Tree
	 */
	public void preorderTraversal(BinaryTree<T> tree) throws RootNotSetException{
		if(tree.getRoot() == null) throw new RootNotSetException();
		this.preorderTraversalNode(tree.getRoot());
	
	}

	private void preorderTraversalNode(Node<T> n)
	{
		if(n == null) return;	
		System.out.print(n.getKey() + " ");
		this.preorderTraversalNode(n.getLeftChild()); 
		this.preorderTraversalNode(n.getRightChild());
		return;		
	}
	
	
	/**
	 * postorder Traversal for Binary Tree
	 */
	public void postorderTraversal(BinaryTree<T> tree) throws RootNotSetException{
		if(tree.getRoot() == null) throw new RootNotSetException();
		this.postorderTraversalNode(tree.getRoot());

	}

	private void postorderTraversalNode(Node<T> n)
	{
		if(n == null) return;
		this.postorderTraversalNode(n.getLeftChild()); 
		this.postorderTraversalNode(n.getRightChild());
		System.out.print(n.getKey() + " ");	
		return;
		
	}
}

/**
 * Node class to store nodes of a Binary Tree
 * 
 * @author krish.mahajan@ibm.com
 *
 */

class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

	private T key;
	private Node<T> leftChild, rightChild;

	public Node(T item) {
		key = item;
		leftChild = rightChild = null;
	}

	public T getKey() {
		return this.key;
	}

	public Node<T> getLeftChild() {
		return this.leftChild;
	}

	public Node<T> getRightChild() {
		return this.rightChild;
	}

	public void setLeftChild(T leftChild) {
		this.leftChild = new Node<T>(leftChild);
	}

	public void setRightChild(T rightChild) {
		this.rightChild = new Node<T>(rightChild);
	}

	public int compareTo(Node<T> o) {
		return this.getKey().compareTo(o.getKey());
	}

}