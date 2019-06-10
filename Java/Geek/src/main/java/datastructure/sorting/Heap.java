package datastructure.sorting;

import org.apache.log4j.Logger;

import datastructure.exceptions.EmptyArrayException;
import datastructure.exceptions.UnknownHeapException;

public class Heap<T extends Comparable<T>> {
	
	
	 static final Logger logger = Logger.getLogger(Heap.class.getName()); 
	
	private T[] heapArray;
	
	private final String HEAP_TYPE; 
	
	public Heap(T[] arr , String heapType) throws EmptyArrayException, UnknownHeapException {
		this.heapArray = arr;
		this.HEAP_TYPE = heapType;
		this.buildHeap();
	}
	
	
	public void buildHeap() throws EmptyArrayException, UnknownHeapException {
		
		if(this.heapArray == null) throw new EmptyArrayException();	
		
		int n = this.heapArray.length;
		if(this.HEAP_TYPE.equals("MinHeap")){
			for(int i = n/2 - 1; i >=0 ; i-- ) {
				this.minHeapify(this.heapArray , n ,i);
			}
		}
		
		else if( this.HEAP_TYPE.equals("MaxHeap")){
			for(int i =n/2 -1 ; i >=0 ; i--) {
				this.maxHeapify(i);
			}
		}
		
		else {
			throw new UnknownHeapException();
		}
		
	}
	
	
	
	
	private void minHeapify(T[] arr ,int arr_len , int parentIndex) {
		
		int smallIndex = parentIndex;
		int leftChildIndex = 2*parentIndex + 1;
		int rightChildIndex = 2*parentIndex + 2;
		
	    if(leftChildIndex < arr_len && (arr[leftChildIndex].compareTo(arr[smallIndex]) < 0)) 
	    	smallIndex = leftChildIndex;
	    
	    if(rightChildIndex < arr_len && (arr[rightChildIndex].compareTo(arr[smallIndex]) < 0))
	    	smallIndex = rightChildIndex;
	    
	    
	    if(smallIndex != parentIndex) {
	    	T parent = this.heapArray[parentIndex];
	    	this.heapArray[parentIndex] = this.heapArray[smallIndex];
	    	this.heapArray[smallIndex] = parent;
	    	this.minHeapify(arr, arr_len, smallIndex);
	    }
		
	    return;
	} 
	
	



  public void maxHeapify(int index) {
		
		
	}
 
  public static void main(String args[]) throws EmptyArrayException, UnknownHeapException {
	  
	  Integer[] arr = { 4 , 10 , 3, 5 ,1 }; 
	  
	  logger.info("unsorted array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
	  logger.info("\n");
	  
	  Heap<Integer> heap = new Heap<Integer>(arr, "MinHeap");
	  

	  
	  
	  
	  logger.info("min Heapified array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
	  
  }


}
