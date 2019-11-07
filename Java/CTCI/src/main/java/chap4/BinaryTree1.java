package chap4;

public class BinaryTree1<T extends Comparable<T>> { 

	private Node<T> root;
	
	public BinaryTree1() {
		this.root = null;
	}
	
	public BinaryTree1(T rootKey) {
		this.root = new Node<T>(rootKey);
	} 
	
	public void setRoot(T rootKey) {
		this.root = new Node<T>(rootKey);
	} 
	
	public Node<T> getRootNode(){
		return this.root;
	}
	
	


class Node<T extends Comparable<T>> implements Comparable<Node<T>>{

    private T key;
    private Node<T> leftChild , rightChild ;
    
    public Node(T  key) {
    	this.key = key;
    	leftChild = rightChild = null;
    }  
    
    public T getNodeKey() {
    	return this.key; 
    } 
    
    public Node<T> getLeftChildNode(){
    	return this.leftChild;
    } 
    
    public Node<T> getRightChildNode(){
    	return this.rightChild;
    } 
	
    public void setLeftChildNode(T key) {
    	this.leftChild = new Node<T>(key);
    } 
    
    public void setRightChildNode(T key) {
    	this.rightChild = new Node<T>(key);
    }
	
	public int compareTo(Node<T> n) {
		return this.getNodeKey().compareTo(n.getNodeKey());
  }


} 


}