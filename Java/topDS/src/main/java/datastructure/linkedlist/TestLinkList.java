package datastructure.linkedlist;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestLinkList {
	
	

	// test LinkList representation
	@Test
	public void testLinkListRepresentation() {
         LinkList<Integer> ll = new LinkList<>();
         List<Integer> c = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         ll.createLinkListFromCollection(c);
         
         ll.printLinkList();
	}
	
	@Test
	public void testLinkListSize() {
        LinkList<Integer> ll = new LinkList<>();
        List<Integer> c = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
        ll.createLinkListFromCollection(c);
        
        System.out.println(ll.LinkListSize(ll.head));
	}
	
	@Test
	public void testLinkListReversal() {
        LinkList<Integer> ll = new LinkList<>();
        List<Integer> c = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
        ll.createLinkListFromCollection(c);
        System.out.println("Current LinkList is : ");
        ll.printLinkList();
        System.out.println(" ");
        System.out.println("Reverse LinkList is : ");
        ll.reverseList(ll.head, ll.head.next,null);
        ll.printLinkList();
	}
	
	
	@Test
	public void testLinkListReversalKgroup() {
        LinkList<Integer> ll = new LinkList<>();
        List<Integer> c = Arrays.asList(9,8,7,6,5,4,3,2,1);
        ll.createLinkListFromCollection(c);
        System.out.println("Current LinkList is : ");
        ll.printLinkList();
        System.out.println(" ");
        System.out.println("Reverse LinkList is : ");
        ll.head = ll.reverseListKGroup(ll.head, 3);
        ll.printLinkList();
	}
	
		
	
}
