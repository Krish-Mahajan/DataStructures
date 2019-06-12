package datastructure.sorting;

import java.lang.reflect.Array;

import org.apache.log4j.Logger;

import datastructure.exceptions.EmptyArrayException;
import datastructure.exceptions.UnknownHeapException;

public class Heap<T extends Comparable<T>> {
	
	
	 static final Logger logger = Logger.getLogger(Heap.class.getName()); 
	
	private T[] heapArray;
	
	private final String HEAP_TYPE; 
	
	  private Class<T> clazz;
	
	public Heap(T[] arr , String heapType , Class<T> clazz) throws EmptyArrayException, UnknownHeapException {
		this.heapArray = arr;
		this.HEAP_TYPE = heapType;
		this.clazz = clazz;
		this.buildHeap();
	}
	

	 /**
	  * Function to build heap from an array
	  * @throws EmptyArrayException
	  * @throws UnknownHeapException
	  */
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
	
	/**
	 * Sort will sort the minHeap
	 */
	private T[] sort() {
	
		T[] new_arr = this.getArray(this.heapArray.length);
		int i = this.heapArray.length -1 ;
		int arr_len = this.heapArray.length ;
		while(i >= 0) {
		T element = this.heapArray[0];
		new_arr[new_arr.length -1 - i] = element;
		T last_element = this.heapArray[arr_len - 1];
		this.heapArray[0] = last_element;
		minHeapify(this.heapArray, arr_len, 0);
		arr_len --;
		i-- ;
		}
		return new_arr;
	}
	
	



  public void maxHeapify(int index) {
		
		
	} 
  
  public <T> T[] getArray(int maxsize) {
	    @SuppressWarnings("unchecked")
	    T[] arr = (T[]) Array.newInstance(this.clazz, maxsize);
	    return arr;
	  }
 
  public static void main(String args[]) throws EmptyArrayException, UnknownHeapException {
	  
	  Integer[] arr = { 58 , 40 , 50 , 31 , 3 , 40 }; 
	  
	  logger.info("unsorted array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
	  logger.info("\n");
	  
	  Heap<Integer> heap = new Heap<Integer>(arr, "MinHeap" , Integer.class);  
	  
	  
	  logger.info("min Heapified array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
	  logger.info("\n");
	  
	  logger.info("sorted array is\n"); 
	  Integer[] sorted_arr = heap.sort();
	  for(Integer i : sorted_arr) logger.info(i + " ");
	  logger.info("\n");
	  
	  
	  
  }


}
