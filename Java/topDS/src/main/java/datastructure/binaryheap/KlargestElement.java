package datastructure.binaryheap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KlargestElement { 
	
	
	public void Klargest(int arr[] ,int n ,int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k,Collections.reverseOrder());
		
		//build MaxHeap 0(n)
		for(int i = 0; i < n;i++) queue.add(arr[i]);
		
		//Extract K max element 0(klogn)
		for(int i=0;i<k;i++) System.out.println(queue.remove());
				
	} 
	
	
	public static void main(String[] args) {
		
		int arr[] = { 1, 23, 12, 9, 30, 2, 50 };
		KlargestElement heap = new KlargestElement();
		heap.Klargest(arr,arr.length, 3);
	}
	
	
	
	
	
	
}
