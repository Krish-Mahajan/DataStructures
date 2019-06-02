package datastructure.sorting;

import org.apache.log4j.Logger;

public class InsertionSort<T extends Comparable<T>> {
	
	static final Logger logger = Logger.getLogger(InsertionSort.class.getName()); 
	
	public void sort(T[] arr) {
		for(int i = 1 ; i < arr.length ; i++) { 
			T key = arr[i];
			int j = i -1;
			while( j >= 0 && (arr[j].compareTo(key) > 0)) {
				   arr[j+1] = arr[j];
				   j--;						 
				}
			arr[j+1] = key;
			}
	
	}
	
	public static void main(String[] args) {
		
		  
		  
		  Integer[] arr = { 12,11,13,5 , 6};
		  InsertionSort<Integer> is = new InsertionSort<Integer>();
		
		  logger.info("unsorted array is\n"); 
		  for(Integer i : arr) logger.info(i + " ");
		  logger.info("\n");
		  
		  is.sort(arr);
		  
		  logger.info("\nsorted array is\n"); 
		  for(Integer i : arr) logger.info(i + " ");
	}
}
