package datastructure.sorting;

import java.lang.reflect.Array;

import org.apache.log4j.Logger;

import datastructure.exceptions.EmptyArrayException;
import datastructure.exceptions.UnknownHeapException;

public class CountingSort<T extends Comparable<T>> {
	
	
	static final Logger logger = Logger.getLogger(CountingSort.class.getName()); 
	
	private T[] orig_arr;	
	private int[] count_arr;
	private T[] sorted_arr;
	private Class<T> clazz;
	private int range;
	
	public CountingSort(T[] orig_arr , Class<T> clazz , int range) {
		this.orig_arr = orig_arr;
		this.clazz = clazz;
		this.range = range;
	}
	
	public T[] sort() {
		
		// initialize range_arr
		count_arr = new int[this.range];		
		for(int i = 0 ; i < this.range ; i++) count_arr[i] = 0;
		
		//update range_arr with count;
		for(T t : orig_arr) count_arr[(int) t] = count_arr[(int) t] + 1;
			
				
		// modify count_arr with previous sum;
		for(int i=1 ; i< count_arr.length ; i++) count_arr[i] = count_arr[i] + count_arr[i - 1]; 
		
		
		//initialize sorted arr;
		sorted_arr = this.getArray(this.orig_arr.length);
	    for(T t : orig_arr) {
	    	int cnt = count_arr[(int) t];
	    	sorted_arr[cnt -1] = t;
	    	count_arr[(int) t] = count_arr[(int) t] - 1;
	    }
		
		
		return sorted_arr;
	} 
	
	
	private T[] getArray(int maxsize) {
		    @SuppressWarnings("unchecked")
		    T[] arr = (T[]) Array.newInstance(this.clazz, maxsize);
		    return arr;
		  }
	 
	
	  public static void main(String args[]) throws EmptyArrayException, UnknownHeapException {
		  
		  Integer[] arr = { 1 , 4 , 1 , 2 , 7 , 5 , 2 }; 
		   
		  logger.info("unsorted array is\n"); 
		  for(Integer i : arr) logger.info(i + " ");
		  logger.info("\n");
		  
		  CountingSort<Integer> cs = new CountingSort<Integer>(arr , Integer.class,10);  
		  
		
		  
		  logger.info("sorted array is\n"); 
		  Integer[] sorted_arr = cs.sort();
		  for(Integer i : sorted_arr) logger.info(i + " ");
		  logger.info("\n");
		  

	  }
	
}
