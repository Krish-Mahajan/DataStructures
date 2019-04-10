package datastructure.linkedlist;

/**
 * @author krish.mahajan@gmail.com
 *
 */
public class LinkedList {

	private Node head; // head of list

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	/**
	 * TO check if the current node is the head of the list (Assuming LinkedList has unique entries)
	 * @param n
	 * @return
	 */
	public boolean isHead(Node n) {
		if(n.getData() == this.getHead().getData()) return true;
		return false;
	}

	/* Linked list Node */
	class Node {

		private double data;
		private Node next;

		// Constructor to create a new node
		// Next is by default initialized
		Node(double d) {
			this.data = d;
		}

		public double getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	public void printList() {
		Node start = this.getHead();
		while (start != null) {
			System.out.print(start.getData());
			start = start.getNext();
			System.out.print(" ");
		}
	}

	/**
	 * Add a new node at the start of LinkedList
	 * 
	 * @param new_data
	 */
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = this.getHead();
		this.setHead(new_node);
	}

	/**
	 * Add a node next to given node (cannot add new node at the start of linkedList)
	 * @param newNodeData   Data value of new node
	 * @param insertAfterNodeData  Data value of given node
	 */
	public void insertAfter(double newNodeData, double insertAfterNodeData) {
		// create the new_node
		Node new_node = new Node(newNodeData);

		// search the existing node with given data value starting at head of the
		// LinkedList
		Node curr = this.getHead();
		Node currNext = curr.next;

		// iterate over the linkedList till the node is found or end of the LinkedList
		// is reached
		while (curr != null) {
			if (curr.getData() == insertAfterNodeData) {
				break;
			}

			curr = currNext;
			currNext = curr.getNext();
		}
		if (curr == null) {
			System.out.print("LinkedList has no Node with the value :" + insertAfterNodeData);
		} else {
			curr.setNext(new_node);
			new_node.setNext(currNext);
		}

	}
	/**
	 * Delete a node in LinkedList with given data value
	 * @param data
	 */
	public void deleteNode(double data) {
		
		
		//Iterate over the linkList to find the given node to be deleted
		Node currPrev = null;
		Node curr = this.getHead();
		
		
		while(curr != null) {
			if(curr.getData()== data) {
				
				//if curr is head of the linkedList
				if(this.isHead(curr)) {
					this.setHead(curr.getNext());
					break;
				}
				//delete the node and make the new connections
				 currPrev.setNext(curr.getNext());
				 break;
			}
			
			currPrev = curr;
			curr = curr.getNext();
		
		}
		if(curr == null) {
			System.out.println("Key was not found");
		}
	} 
	
	
	/**
	 * Find size of LinkedList iteratively
	 * @return size of LinkedList
	 */
	public int IterativeSize() {
		if(this.getHead() == null) {
			System.out.println("No linkedList found");
			return 0;
		}
		Node curr = this.getHead();
		int size = 0;
		while(curr!=null) {
			curr = curr.getNext();
			size +=1;
		}
		return size;
	}
	/**
	 * Find size of LinkedList recursively
	 * @return size of LinkedList.
	 */
	public int RecursiveSize() {
		Node curr = this.getHead();
		int size = this.RecursiveSize(curr, 0);
		return size;
	}

	private int RecursiveSize(Node curr, int size) {
		if(curr == null) {
			return  size;
		}
		
		return RecursiveSize(curr.getNext(), size +1);
		
	}
}
