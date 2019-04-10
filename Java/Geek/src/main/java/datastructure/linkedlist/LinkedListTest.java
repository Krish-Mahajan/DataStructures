package datastructure.linkedlist;

import datastructure.linkedlist.LinkedList.Node;

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
		
	}
}
