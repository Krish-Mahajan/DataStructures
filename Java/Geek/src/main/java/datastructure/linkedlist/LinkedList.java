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
	 * TO check if the current node is the head of the list (Assuming LinkedList has
	 * unique entries)
	 * 
	 * @param n
	 * @return
	 */
	public boolean isHead(Node n) {
		if (n.getData() == this.getHead().getData())
			return true;
		return false;
	} 
	
	public LinkedList createLinkedListArray(double[] data) {
		LinkedList l  = new LinkedList();
		l.setHead(new Node(data[0]));
		Node currL = l.getHead();
		for(int i =1; i <data.length ; i++ ) {
			currL.setNext(new Node(data[i]));
			currL = currL.getNext();
		}
		
		return l;
	}

	/* Linked list Node */
	public class Node {

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
	public void push(double new_data) {
		Node new_node = new Node(new_data);
		new_node.next = this.getHead();
		this.setHead(new_node);
	}

	/**
	 * Add a node next to given node (cannot add new node at the start of
	 * linkedList)
	 * 
	 * @param newNodeData         Data value of new node
	 * @param insertAfterNodeData Data value of given node
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
	 * 
	 * @param data
	 */
	public void deleteNode(double data) {

		// Iterate over the linkList to find the given node to be deleted
		Node currPrev = null;
		Node curr = this.getHead();

		while (curr != null) {
			if (curr.getData() == data) {

				// if curr is head of the linkedList
				if (this.isHead(curr)) {
					this.setHead(curr.getNext());
					break;
				}
				// delete the node and make the new connections
				currPrev.setNext(curr.getNext());
				break;
			}

			currPrev = curr;
			curr = curr.getNext();

		}
		if (curr == null) {
			System.out.println("Key was not found");
		}
	}

	/**
	 * Find size of LinkedList iteratively
	 * 
	 * @return size of LinkedList
	 */
	public int IterativeSize() {
		if (this.getHead() == null) {
			System.out.println("No linkedList found");
			return 0;
		}
		Node curr = this.getHead();
		int size = 0;
		while (curr != null) {
			curr = curr.getNext();
			size += 1;
		}
		return size;
	}

	/**
	 * REMEBER
	 * Find size of LinkedList recursively
	 * @return size of LinkedList.
	 */
	public int RecursiveSize() {
		Node curr = this.getHead();
		int size = this.RecursiveSize(curr);
		return size;
	}

	private int RecursiveSize(Node curr) {
		if (curr == null) {
			return 0;
		}

		return 1 + RecursiveSize(curr.getNext());

	}

	/**
	 * SwapNodes of linkedList
	 * 
	 * @param key1 Key of Node1
	 * @param key2 Key of Node2
	 */

	public void swapNodes(double key1, double key2) {

		if ((Double) key1 == null && (Double) key2 == null) {
			System.out.println("Keys cannot be null");
			return;
		}
		Node currNode = this.getHead();
		Node prevNode = null, key1Node = null, key1PrevNode = null, key2Node = null, key2PrevNode = null;

		while (currNode != null) {

			if (key1 == currNode.getData()) {
				key1PrevNode = prevNode;
				key1Node = currNode;
			}

			if (key2 == currNode.getData()) {
				key2PrevNode = prevNode;
				key2Node = currNode;
			}

			// break the iteration if both the list are found
			if (key1Node != null && key2Node != null)
				break;

			prevNode = currNode;
			currNode = currNode.getNext();
		}

		// check if any of the keyNode is not null
		if (key1Node == null || key2Node == null) {
			System.out.println("One of the key was not found in the LinkedList");
			return;
		}

		// swap the nodes

		if (key1PrevNode != null)
			key1PrevNode.setNext(key2Node);
		else
			this.setHead(key2Node);

		if (key2PrevNode != null)
			key2PrevNode.setNext(key1Node);
		else
			this.setHead(key1Node);

		Node tmp = key1Node.getNext();
		key1Node.setNext(key2Node.getNext());
		key2Node.setNext(tmp);

	}

	/**
	 * REMEMBER
	 * Reverse the LinkList iteratively
	 */
	public void reverseList() {

		Node curr = this.getHead();
		Node next = null;
		Node prev = null;
		while (curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;

		}
		this.setHead(prev);

	}
	
	/**
	 * Reverser the LinkList recursively
	 */
	public void reverseList(Node curr , Node prev) {
		
		if( curr == null)
		{
			this.setHead(prev);
			return;
		}
		else
		{
			Node next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			reverseList(curr, prev);
		}
	}

	/**
	 * Merge two sorted LinkList (My version)
	 */
	public LinkedList mergeTwoSortedLinkList(LinkedList l1, LinkedList l2) {

		// LinkedList l; -- wrong , all local variable must be initialized , not true for class.static or instance variable
		
		// LinkedList  l = null; wrong , here you're only creating a reference which is initialized to null , that reference is yet not
		// attached to an object(something in memory) , because it has not been newed yet.
		
		
		LinkedList l;
		l = new LinkedList();

		// Both the list shouldn't be empty
		if (l1.getHead() == null & l2.getHead() == null) {
			System.out.println("Both the list cannot be empty");
		}

		// if anyone of the list is empty , simply return other
		if (l1.getHead() == null && l2.getHead() != null) {
			l = l2;
			return l;
		}

		if (l1.getHead() != null && l2.getHead() == null) {
			l = l1;
			return l;
		}


		Node currL1 = l1.getHead();
		Node currL2 = l2.getHead();

		
		// set the head of the new LinkedList first	
		if (currL1.getData() <= currL2.getData()) {
			l.setHead(currL1);
			currL1 = currL1.getNext();
		} else {
			l.setHead(currL2);
			currL2 = currL2.getNext();
		}

		Node currL = l.getHead();

		
		// iterate and compare the two list
		while (currL1 != null) {
			double currL1Key = currL1.getData();
			while (currL2 != null) {
				double currL2Key = currL2.getData();
				if (currL2Key <= currL1Key) {
						currL.setNext(currL2);
						currL = currL.getNext();
					}
				 else {
					currL.setNext(currL1);
					currL = currL.getNext();
					break;
				 }
				currL2 = currL2.getNext();
			}
			currL1 = currL1.getNext();

		} 
		
		//L1 finishes first
		if(currL1 == null & currL2 !=null) {
			while(currL2 != null) {
				currL.setNext(currL2);
				currL = currL.getNext();
				currL2 = currL2.getNext();
			}
		}
		
		//L2 finishes first
		if(currL2 == null & currL1 !=null) {
			while(currL1 != null) {
				currL.setNext(currL1);
				currL = currL.getNext();
				currL1 = currL1.getNext();
			}
		}
		

		return l;
	}
	
	/**
	 *  Merge two sorted LinkList (easier solution)
	 */
	
	public LinkedList sortedMerge(LinkedList l1  , LinkedList l2) {
		
		Node headA = l1.getHead();
		Node headB = l2.getHead();
		
		/* a dummy first node to hang the result on */
		Node dummyNode = new Node(0);
		
		/* tail points to the last result node */
		Node currNode = dummyNode;
		while(true) {
			/* if either list runs out,use the other list */
			if(headA == null)
			{
				currNode.setNext(headB);
				break;
			}
			if(headB == null) {
				currNode.setNext(headA);
				break;
			}
			
			/* Compare the data of the two lists , whichever lists
			 * data is smaller , append it into tail and advance the head
			 * to the next node
			 */
			if(headA.getData() <= headB.getData()) {
				currNode.setNext(headA);
				headA = headA.getNext();
			}
			else
			{
				currNode.setNext(headB);
				headB = headB.getNext();
			}
			//Advance the node
			currNode = currNode.getNext();
		} 
		
		LinkedList l = new LinkedList();
		l.setHead(dummyNode.getNext());
		return l;
		
	} 
	/**
	 * REMEMBER
	 * Reverse a LinkList in group of K
	 * @param head
	 * @param k
	 * @return
	 */
	public Node reverseK(Node head,int k) {
         Node curr = head;
         Node next = null;
         Node prev = null;
         
         int count = 0;
         
         while(count < k && curr != null) {
        	 next = curr.getNext();
        	 curr.next = prev;
        	 prev = curr;
        	 curr = next;
        	 count ++;
         }
         
         /**
          * Next is now a pointer to (K+1)th node
          * Recursively call the list, starting from next.
          * And make rest of the list as next of first node
          */
         if( next != null) head.next = reverseK(next ,k);
         
         //prev is now head of the input list
         return prev;
         

         
		  
		
		}


}
