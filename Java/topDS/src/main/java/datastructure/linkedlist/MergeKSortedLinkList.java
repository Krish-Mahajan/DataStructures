package datastructure.linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLinkList {
	
	
	
	  //Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	
	 private static class Point implements Comparable<Point>{
	        ListNode node;
	        int rowIndex;
	        Point(ListNode node, int rowIndex){
	            this.node = node;
	            this.rowIndex = rowIndex;
	        }
	        
	        public int compareTo(Point p2){
	            if(this.node.val > p2.node.val) return 1;
	            else if (this.node.val < p2.node.val) return -1;
	            else return 0;
	        }
	        
	    }
	    public ListNode mergeKLists(ListNode[] lists) {
	       
	        ListNode FirstNode = null;
	        ListNode currentNode = null;
	        
	        //Add elements to pq
	        PriorityQueue<Point> pq = new PriorityQueue<Point>();
	        for(int i=0;i<lists.length;i++){
	            Point p = new Point(lists[i],i);
	            pq.add(p);
	        }
	        
	        while(!pq.isEmpty()){
	            Point p = pq.remove();
	            if(p.node.next!=null) {
	                pq.add(new Point(p.node.next,p.rowIndex));
	            }
	            if(FirstNode ==null) {
	                FirstNode = p.node;
	                currentNode = p.node;
	            }
	            currentNode.next = p.node;
	            currentNode = p.node;
	            
	        }
	        
	        return FirstNode;
	        
	    }
	
	 public static void main(String[] arr) {
		 
		 
		ListNode[][] arr1 = new ListNode[1][];
		System.out.println(arr1);
		// MergeKSortedLinkList l = new MergeKSortedLinkList();
		 
		 
	 }
	
	
	
	
	
}
