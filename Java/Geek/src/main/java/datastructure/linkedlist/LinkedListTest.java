package datastructure.linkedlist;

import datastructure.linkedlist.LinkedList.Node;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        LinkedList list1 = new LinkedList(); 
        list1.head = new Node(4); 
        list1.head.next = new Node(15); 
        list1.head.next.next = new Node(20); 
        list1.head.next.next.next = new Node(84); 
        
        LinkedList list2 = new LinkedList(); 
        list2.head = new Node(3); 
        list2.head.next = new Node(16); 
        list2.head.next.next = new Node(21); 
        list2.head.next.next.next = new Node(80); 
          
        System.out.println("Given 1st Linked list"); 
        list1.printList(list1.head); 
        
        System.out.println("Given 2nd Linked list"); 
        list2.printList(list2.head); 
       
        System.out.println("Merging the given linkedList");

        Node new_head = list1.sortedMerge(list1.head, list2.head);
        //returning dummy it again
        list1.head = new_head;
        list1.printList(list1.head);
	}

}
