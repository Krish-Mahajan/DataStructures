package datastructure.binaryheap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Ksortedarray { 
	
	public int[] ksort(int[] arr, int k) {
		
		//Add first K element to a PriorityQueue
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0 ; i<k+1;i++) {
			pq.add(arr[i]);
		}
		
		
		int index = 0;
		
		//Add remaining elements to the queue
		for(int i= k+1;i<arr.length ;i++) {
			arr[index] = pq.remove();
			index++;
			pq.add(arr[i]);
		}
		
		//Add remaining elements to queue
		Iterator<Integer> it = pq.iterator();
		
		while(it.hasNext()) {
			arr[index++] = pq.remove();
		}
		
		
		return arr;
		
	} 
	
	
	public static void main(String[] arr) {
		
		int[] array = new int[] {2,6,3,12,56,8};
		Ksortedarray kar = new Ksortedarray();
		System.out.println(kar.ksort(array, 3));
	}
	
	
	
}
