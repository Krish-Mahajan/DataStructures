package datastructure.linkedlist;

import java.util.List;

import datastructure.graph.CriticalRouterNetwork;

public class LinkList<T extends Comparable<T>> { 
	
	
	public Node<T> head;
	

	
	void setHead(Node<T> head) {
		if(head !=null) {
			this.head = head;
			}
	}
	
	
	// Add new node at start of the linkList and create a doubly connection
	void push(T data) {
		
		//if no head is set
		if(this.head == null) {
			  this.head = new Node<>(data);
		 }
		else {
		Node<T> node = new Node<>(data);
		node.next = this.head;
		this.head.previous = node;
		this.setHead(node);
		}
	 }
	
	
	 /**
	   * Add a node next to given node (cannot add new node at the start of linkedList)
	   *
	   * @param newNodeData Data value of new node
	   * @param insertAfterNodeData Data value of given node
	   */
	  public void insertAfter(T newNodeData, T insertAfterNodeData) {
	    // create the new_node
	    Node<T> new_node = new Node<T>(newNodeData);

	    // search the existing node with given data value starting at head of the
	    // LinkedList
	    Node<T> curr = this.head;
	    Node<T> currNext = curr.next;

	    // iterate over the linkedList till the node is found or end of the LinkedList
	    // is reached
	    while (curr != null) {
	      if (curr.data.equals(insertAfterNodeData)) {
	        break;
	      }

	      curr = currNext;
	      currNext = curr.next;
	    }
	    if (curr == null) {
	      System.out.println("LinkedList has no Node with the value :" + insertAfterNodeData);
	    } else {
	      curr.setNext(new_node);
	      new_node.previous = curr;
	      new_node.setNext(currNext);
	      currNext.setPrevious(new_node);
	    }
	  } 
	  
	  
	  // Delete a node in LinkList with given value
	  public void deleteNode(T data) {
		  Node<T> curr = this.head;
		  Node<T> currPrev = this.head;
		  
		  while(curr !=null) {
			  if(curr.data.compareTo(data)==0) break;
			  curr = curr.next;
			  currPrev = curr;
		  }
		  
		  if(curr.data.compareTo(this.head.data)==0) {
			  this.setHead(curr.next);
			  curr.next.previous = currPrev;
		  }
		  
		  //Assuming no previous connection
		  else if(curr.data.compareTo(this.head.data)==0 && curr !=null) {
			  currPrev.next = curr.next;
			  curr.next.previous = currPrev;
		  }
		  
		  else {
			  System.out.println("Node with given data value is not found");
		  }
		  
	  }
	  
	  //Find size of LinkList recursively
	  public int LinkListSize(Node<T> node) {
		  if(node == null) return 0;
		  else return 1 + LinkListSize(node.next);
		  
	  }
	  
	  
	  //reverse LinkList recursively
	  public void reverseList(Node<T> curr, Node<T> currNext,Node<T> currPrev) {
		  if(currNext != null) {
			  
			  Node<T> node = currNext.next;
			  
			  //change the links
			  curr.next = currPrev;
			  currNext.next = curr;
			  
			  //move one farther
			  currPrev = curr;
			  curr = currNext;
			  currNext = node;
			  
			  this.setHead(curr);
			  this.reverseList(curr, currNext,currPrev);
		  }
	  }
	  
	  
	  //reverse LinkList recursively
	  /**
	   * REMEMBER Reverse a LinkList in group of K
	   *
	   * @param head
	   * @param k
	   * @return
	   */
	  public Node<T> reverseListKGroup(Node<T> head, int k) {
	
		Node<T> prev = null;
	    Node<T> curr = head;
	    Node<T> next = null;
	    

	    int count = 0;

	    while (count < k && curr != null) {
	      next = curr.next;
	      curr.next = prev;
	      prev = curr;
	      curr = next;
	      count++;
	    }

	    /**
	     * Next is now a pointer to (K+1)th node Recursively call the list, starting from next. And make
	     * rest of the list as next of first node
	     */
	    if (curr != null) {
	    	head.next = reverseListKGroup(curr, k);

	    }
	    

	    // prev is now head of the input list
	    return prev;
	  }
	
	  /**
	   * Create LinkList from List
	   * @author krish.mahajan@ibm.com
	   *
	   * @param <T>
	   */
	  public void createLinkListFromCollection(List<T> list) {
		  for(T data : list) {  
		  this.push(data);
		  }
	  }
	  
	  //Print LinkList
	  public void printLinkList() {
		  if(this.head != null) {
			  Node<T> curr = this.head;
			  while(curr!=null) {
				  System.out.print(curr.data + " ");
				  curr = curr.next;
			  }
		  }
	  }
	  
	  
	  
	  
	
	
	
	static class Node<T extends Comparable<T>>{
		
		private T data;
		public Node next;
		public Node previous;
		
		Node(T data) {
			this.data = data;
		}
		
		void setNext(Node node) {
			this.next = node;
		}
		
		void setPrevious(Node node) {
			this.previous = node;
		}
	}
}
