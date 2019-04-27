package datastructure.linkedlist;

import org.apache.log4j.Logger;

import datastructure.linkedlist.LinkedList.Node;


/**
 * Test Class for LinkedList
 * @author krish.mahajan@gamil.com
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {
		
		final Logger logger = Logger.getLogger(LinkedListTest.class.getName());	
		
		//setting the linkedlist
		LinkedList<Double> linkedList = new LinkedList<Double>();
		
		LinkedList<Double>.Node<Double> listHead = linkedList.new Node<Double>(0.0);
		LinkedList<Double>.Node<Double> second = linkedList.new Node<Double>(1.0);
		LinkedList<Double>.Node<Double> third = linkedList.new Node<Double>(2.0);
		LinkedList<Double>.Node<Double> fourth = linkedList.new Node<Double>(3.0);
	   
		linkedList.setHead(listHead);
		linkedList.getHead().setNext(second);
		second.setNext(third);
		third.setNext(fourth); 
		
		//iterating the linkedlist
		logger.info("Original LinkedList " );
		linkedList.printList();
		logger.info("\n");
		
		int size =linkedList.IterativeSize();
		logger.info("Original LinkedList size iteratively: " + size);	
		logger.info("\n");
		
		size = linkedList.RecursiveSize();
		logger.info("Original LinkedList size recursively: " + size);
		logger.info("\n");
		
		
		//Adding new element at the start
		logger.info("New LinkedList after addition at the start ");
		linkedList.push(-1.0);
		linkedList.printList();
		logger.info("\n"); 
		 size =linkedList.IterativeSize();
		logger.info("Original LinkedList size iteratively: " + size);	
		logger.info("\n");
		
		size = linkedList.RecursiveSize();
		logger.info("Original LinkedList size recursively: " + size);
		logger.info("\n");
		
		//Adding new element  in between 1 & 2
		logger.info("New LinkedList after addition in between ");
		linkedList.insertAfter(0.5, 1.0);
		linkedList.printList();
		logger.info("\n"); 
		 size =linkedList.IterativeSize();
		logger.info("Original LinkedList size iteratively: " + size);	
		logger.info("\n");
		
		size = linkedList.RecursiveSize();
		logger.info("Original LinkedList size recursively: " + size);
		logger.info("\n");
		
		
		
		//Adding new element at the last position
		logger.info("New LinkedList New LinkedList after addition at last position: ");
		linkedList.insertAfter(3.5, 3.0);
		linkedList.printList();
		logger.info("\n"); 
		 size =linkedList.IterativeSize();
		logger.info("Original LinkedList size iteratively: " + size);	
		logger.info("\n");
		
		size = linkedList.RecursiveSize();
		logger.info("Original LinkedList size recursively: " + size);
		logger.info("\n");
		
		
		//Adding new element in between -1 & 0
		logger.info("New LinkedList after addition in between ");
		linkedList.insertAfter(-0.5, -1.0);
		linkedList.printList();
		logger.info("\n"); 
		 size =linkedList.IterativeSize();
		logger.info("Original LinkedList size iteratively ");	
		logger.info("\n");
		
		size = linkedList.RecursiveSize();
		logger.info("Original LinkedList size recursively: ");
		logger.info("\n");
		
		
		// Deleting a element in the LinkedList
		logger.info("New LinkedList after deletion in between: ") ;
		linkedList.deleteNode(2.0);
		linkedList.printList();
		logger.info("\n");  
		 size =linkedList.IterativeSize();
		logger.info("Original LinkedList size iteratively: " + size);	
		logger.info("\n");
		
		size = linkedList.RecursiveSize();
		logger.info("Original LinkedList size recursively: " + size);
		logger.info("\n");
		
		
		
		// Deleting a element at front of the LinkedList
		logger.info("New LinkedList after deletion at the beginning: " );
		linkedList.deleteNode(-1.0);
		linkedList.printList();
		logger.info("\n");  
		 size =linkedList.IterativeSize();
		logger.info("Original LinkedList size iteratively: " + size);	
		logger.info("\n");
		
		size = linkedList.RecursiveSize();
		logger.info("Original LinkedList size recursively: " + size);
		logger.info("\n");
		
		
		// Deleting a element at the last position of the LinkedList
		logger.info("New LinkedList after deletion at the last position: ");
		linkedList.deleteNode(3.5);
		linkedList.printList();
		logger.info("\n"); 
		 size =linkedList.IterativeSize();
		logger.info("Original LinkedList size iteratively: " + size);	
		logger.info("\n");
		
		size = linkedList.RecursiveSize();
		logger.info("Original LinkedList size recursively: " + size);
		logger.info(" ");
		
		//swapNode
		linkedList.swapNodes(0.0, 0.5);
		logger.info("LinkedList after swapping the nodes  (0.0, 0.5): ");
		linkedList.printList();
		logger.info("\n");
		
		
		linkedList.swapNodes(0.0, 3.0);
		logger.info("LinkedList after swapping the nodes (0.0, 3.0): ");
		linkedList.printList();
		logger.info("\n");
		
		
		linkedList.swapNodes(-0.5, 0.0);
		logger.info("LinkedList after swapping the nodes (-0.5, 0.0): ");
		linkedList.printList();
		logger.info("\n");
		
//		linkedList.reverseList();
//		logger.info(" LinkedList after reversal iteratively: ");
//		linkedList.printList();
//		logger.info("\n"); 
		
		
		Node prev = null;
		linkedList.reverseList(linkedList.getHead(), prev);
		logger.info("LinkedList after reversal recursively: ");
		linkedList.printList();
		logger.info("\n"); 
		
		
		// Merge sortedLinkList
		Double[] data1 = {-20.0,-4.0, -2.0 , 5.0 ,15.0};
		LinkedList<Double> l1 = linkedList.createLinkedListArray(data1);
		logger.info("LinkedList L1 after creation from array: ");
		l1.printList(); 
		logger.info("\n"); 
		
		Double[] data2 = {2.0,3.0,20.0,25.0};
		LinkedList<Double> l2 = linkedList.createLinkedListArray(data2);
		logger.info("LinkedList L2 after creation from array: ");
		l2.printList(); 
		logger.info("\n"); 
		
		
//		LinkedList<Double> l = linkedList.mergeTwoSortedLinkList(l1, l2);
//		logger.info(" LinkedList L after merging with L1 & L2: ");
//		l.printList(); 
//		logger.info("\n"); 
		
		LinkedList<Double> ll = linkedList.sortedMerge(l1, l2);
		logger.info("LinkedList LL after sort merging with L1 & L2: ");
		ll.printList(); 
		logger.info("\n"); 
		
	}
}
