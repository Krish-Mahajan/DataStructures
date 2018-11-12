package datastructure.linkedlist;

public class LinkedList {

	Node head; 
	
	// Basic Node class
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
		
	}
	
	// Print the linkedList
	public void printList(Node head) {
		Node n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println(" ");
	} 
	
	// Add new node at the front of the linkedList
	public void push(int new_data) {
		
		Node new_node = new Node(new_data);
		new_node.next = this.head;
		this.head = new_node;
	}
	
	public void insertAfter(Node prev_node,int new_data) {
		
	 // check if the given node is not null 
		if(prev_node ==null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		
		Node new_node = new Node(new_data);
		
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	} 
	
	
	public void append(int new_data) {
		
		Node new_node = new Node(new_data);
		
		if(head==null) {
			this.head = new Node(new_data);
			return;
		}
		
		new_node.next = null;
		Node last = this.head;

		while(last.next!=null) {
			last = last.next;
		}
		
		last.next = new_node;
		return;
	}
	
	/* Inserts a new node at front of the list*/
	public void deleteNode(int key) {
		
		// store head node
		Node temp = head;
		Node prev = null;
		
		// if head node itself holds the key to be deleted
		if(temp !=null && temp.data == key) {
			this.head = temp.next;
			return;
		}
		
		// Search for the key to be deleted,keep track of the 
		//previous node as we need to change temp.next
		while(temp!=null && temp.data!=key) {
			prev = temp;
			temp = temp.next;
		}
		
		//If key was not found
		if(temp==null) return;
		
		//Unlink the node from the linked list
		prev.next = temp.next;
	}
	
	
	/* Function counts no. of nodes in LinkedList iteratively
	 */
	public int getCount() {
		Node temp = head;
		int count = 0;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public int getCountRec(Node node) {
		
		//Base case
		if(node==null) {
			return 0;
		}
		
		return 1 + getCountRec(node.next);
		
	} 
	
	public int getCountRec() {
		return getCountRec(this.head);
	}
	
	/*Function to swap nodes in LinkedList 
	 * without swapping data
	 */
	public void swapNodes(int x,int y)
	{
		
		// Nothing to do if x and y are same
		if(x ==y) return;
		
		//Search for x(keep track of prevX and CurrX)
		Node prevX = null, currX = head;
		while(currX!=null && currX.data !=x) {
			prevX = currX;
			currX = currX.next;
		}
		
		//Search for y(keep track of prevY and CurrY)
		Node prevY = null, currY=head;
		while(currY!=null && currY.data != y) {
			prevY =currY;
			currY = currY.next;
		}
		
		//If either x or y is not present, nothing to do
		if(currX == null || currY == null)
			return; 
		
		//If x is not head of linked list
		if(prevX!=null) 
			prevX.next = currY;
		
		else
			head = currY;
		
        //If y is not head of linked list
		if(prevY!=null) 
			prevY.next = currX;
		
		else 
			head = currX;
		
		
		Node temp = currY.next;
		currY.next = currX.next;
		currX.next = temp;
		
		
	}
	
	/* Function to reverse the linked list */
	public Node reverse(Node node) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr !=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
				
		
				
	}
	
	/* Function to merge sorted LinkedList*/
	public Node mergeSortedList(Node head1,Node head2) {
	
		Node new_head1 = null;
		
		// iterate all elements of list 2 in list 1
		while(head2!=null) {
			 this.printList(head1);
			 Node temp = head2;
			 new_head1 = insert_head2(head1, new Node(head2.data));
			 head2 = temp.next;
			 head1 = new_head1;
		}				
		return new_head1;
		
	}
	
	public Node insert_head2(Node head1,Node head2) {
		Node n = head1;
		Node prev = null;
		while(n!=null) {
			if(n.data >= head2.data && n != head1) {
			    head2.next = n;
			    prev.next = head2;
			    break;
			    
			}
			else if(n.data >= head2.data && n == head1) {
				head2.next = n;
			    head1 = head2;
			    break;
			}
			prev = n;	
			n = n.next;
			
			
		}
		if(n == null) {
			prev.next = head2;
		} 
		this.printList(head1);
		return head1;
	}
	 
}
