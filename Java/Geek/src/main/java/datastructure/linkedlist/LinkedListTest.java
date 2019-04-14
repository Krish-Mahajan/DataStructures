package datastructure.linkedlist;

import datastructure.linkedlist.LinkedList.Node;


/**
 * Test Class for LinkedList
 * @author krish.mahajan@gamil.com
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {
		
		
		//setting the linkedlist
		LinkedList linkedList = new LinkedList();
		
		Node listHead = linkedList.new Node(0);
		Node second = linkedList.new Node(1);
		Node third = linkedList.new Node(2);
		Node fourth = linkedList.new Node(3);
	   
		linkedList.setHead(listHead);
		linkedList.getHead().setNext(second);
		second.setNext(third);
		third.setNext(fourth); 
		
		//iterating the linkedlist
		System.out.print("Original LinkedList " );
		linkedList.printList();
		System.out.println(" ");
		
		int size =linkedList.IterativeSize();
		System.out.print("Original LinkedList size iteratively: " + size);	
		System.out.println(" ");
		
		size = linkedList.RecursiveSize();
		System.out.print("Original LinkedList size recursively: " + size);
		System.out.println(" ");
		
		
		//Adding new element at the start
		System.out.print("New LinkedList after addition at the start ");
		linkedList.push(-1);
		linkedList.printList();
		System.out.println(" "); 
		 size =linkedList.IterativeSize();
		System.out.print("Original LinkedList size iteratively: " + size);	
		System.out.println(" ");
		
		size = linkedList.RecursiveSize();
		System.out.print("Original LinkedList size recursively: " + size);
		System.out.println(" ");
		
		//Adding new element  in between 1 & 2
		System.out.print("New LinkedList after addition in between ");
		linkedList.insertAfter(0.5, 1);
		linkedList.printList();
		System.out.println(" "); 
		 size =linkedList.IterativeSize();
		System.out.print("Original LinkedList size iteratively ");	
		System.out.println(" ");
		
		size = linkedList.RecursiveSize();
		System.out.print("Original LinkedList size recursively: " + size);
		System.out.println(" ");
		
		
		
		//Adding new element at the last position
		System.out.print("New LinkedList New LinkedList after addition at last position: ");
		linkedList.insertAfter(3.5, 3);
		linkedList.printList();
		System.out.println(" "); 
		 size =linkedList.IterativeSize();
		System.out.print("Original LinkedList size iteratively: " + size);	
		System.out.println(" ");
		
		size = linkedList.RecursiveSize();
		System.out.print("Original LinkedList size recursively: " + size);
		System.out.println(" ");
		
		
		//Adding new element in between -1 & 0
		System.out.print("New LinkedList after addition in between ");
		linkedList.insertAfter(-0.5, -1);
		linkedList.printList();
		System.out.println(" "); 
		 size =linkedList.IterativeSize();
		System.out.print("Original LinkedList size iteratively ");	
		System.out.println(" ");
		
		size = linkedList.RecursiveSize();
		System.out.print("Original LinkedList size recursively: ");
		System.out.println(" ");
		
		
		// Deleting a element in the LinkedList
		System.out.print("New LinkedList after deletion in between: ") ;
		linkedList.deleteNode(2.0);
		linkedList.printList();
		System.out.println(" ");  
		 size =linkedList.IterativeSize();
		System.out.print("Original LinkedList size iteratively: " + size);	
		System.out.println(" ");
		
		size = linkedList.RecursiveSize();
		System.out.print("Original LinkedList size recursively: " + size);
		System.out.println(" ");
		
		
		
		// Deleting a element at front of the LinkedList
		System.out.print("New LinkedList after deletion at the beginning: " );
		linkedList.deleteNode(-1.0);
		linkedList.printList();
		System.out.println(" ");  
		 size =linkedList.IterativeSize();
		System.out.print("Original LinkedList size iteratively: " + size);	
		System.out.println(" ");
		
		size = linkedList.RecursiveSize();
		System.out.print("Original LinkedList size recursively: " + size);
		System.out.println(" ");
		
		
		// Deleting a element at the last position of the LinkedList
		System.out.print("New LinkedList after deletion at the last position: ");
		linkedList.deleteNode(3.5);
		linkedList.printList();
		System.out.println(" "); 
		 size =linkedList.IterativeSize();
		System.out.print("Original LinkedList size iteratively: " + size);	
		System.out.println(" ");
		
		size = linkedList.RecursiveSize();
		System.out.print("Original LinkedList size recursively: " + size);
		System.out.println(" ");
		
		//swapNode
		linkedList.swapNodes(0.0, 0.5);
		System.out.print(" LinkedList after swapping the nodes  (0.0, 0.5): ");
		linkedList.printList();
		System.out.println(" ");
		
		
		linkedList.swapNodes(0.0, 3.0);
		System.out.print(" LinkedList after swapping the nodes (0.0, 3.0): ");
		linkedList.printList();
		System.out.println(" ");
		
		
		linkedList.swapNodes(-0.5, 0.0);
		System.out.print(" LinkedList after swapping the nodes (-0.5, 0.0): ");
		linkedList.printList();
		System.out.println(" ");
		
		linkedList.reverseList();
		System.out.print(" LinkedList after reversal: ");
		linkedList.printList();
		System.out.println(" "); 
		
		
		// Merge sortedLinkList
		double[] data1 = {-20,-4, -2 , 5 ,15};
		LinkedList l1 = linkedList.createLinkedListArray(data1);
		System.out.print(" LinkedList L1 after creation from array: ");
		l1.printList(); 
		System.out.println(" "); 
		
		double[] data2 = {2,3,20,25};
		LinkedList l2 = linkedList.createLinkedListArray(data2);
		System.out.print(" LinkedList L2 after creation from array: ");
		l2.printList(); 
		System.out.println(" "); 
		
		
//		LinkedList l = linkedList.mergeTwoSortedLinkList(l1, l2);
//		System.out.print(" LinkedList L after merging with L1 & L2: ");
//		l.printList(); 
//		System.out.println(" "); 
		
		LinkedList ll = linkedList.sortedMerge(l1, l2);
		System.out.print(" LinkedList LL after sort merging with L1 & L2: ");
		ll.printList(); 
		System.out.println(" "); 
		
	}
}
