package datastructure.array;

import java.util.Collection;

import org.apache.log4j.Logger;

public class ArrayMain<T extends Comparable<T>> {
	
	static final Logger logger = Logger.getLogger(ArrayMain.class.getName());
	
	
	private int compareTo(T key1, T key2) {
		return key1.compareTo(key2);
	}
	
	//Function to implement search operation on unsorted array
	public boolean findElement(T[] arr,T key) {
        boolean found = false;
		for(int i = 0; i < arr.length ; i++) {
    	if(arr[i].compareTo(key) == 0) {
    		found = true;
    		break;
    	}
    }
		return found;
		
	}
	
	/**
	 * REMEMBER
	 * Function to search in sorted array using BinarySearch
	 * @param arr
	 * @param key
	 * @return
	 */
	public boolean binarySearch(T[] arr, T key) {
		
		return binarySearch_util(arr , key ,0,arr.length - 1);
		
	}
	
	private boolean binarySearch_util(T[] arr, T key ,int startIndex, int endIndex) {
		
		if(startIndex > endIndex) return false;
		
		int midIndex = (startIndex + endIndex) /2;
		if(arr[midIndex].compareTo(key) == 0 ) return true;
		else if(key.compareTo(arr[midIndex]) > 0) return binarySearch_util(arr, key, midIndex+1,endIndex);
		else return binarySearch_util(arr, key, startIndex, midIndex - 1);
		
	}
	
    /**
     * REMEMBEr
     * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
     * @param a
     */
	public void maxSubArraySum(int a[]) {
		int max_sum_so_far =  0;
		int sum_so_far = 0;
		int start = 0;
		int end = 0;
		int s = 0;
		for( int i = 0;i < a.length;i++) {
			sum_so_far += a[i];
			if(sum_so_far > max_sum_so_far) {
				max_sum_so_far = sum_so_far;
				start = s;
				end = i;
			}
			if(sum_so_far < 0) {
				s = s + 1;
				sum_so_far = 0 ;
			}
		}
		System.out.println("Maximum contiguous sum is " 
                + max_sum_so_far); 
		System.out.println("Starting index " + start); 
		System.out.println("Ending index " + end); 
		
		
	}
	
	


public static void main(String args[]) {

	Integer arr[] = { 12,34,10 , 6 , 40 };
	ArrayMain<Integer> a = new ArrayMain<Integer>(); 
	boolean found = a.findElement(arr, 6);
	logger.info("Element 6 present in array: " + found);
	logger.info("\n");
	
	
	Integer arr2[] = { 5 ,6, 7, 8,9,10 };
	ArrayMain<Integer> a2 = new ArrayMain<Integer>(); 
	boolean found2 = a.binarySearch(arr2, 3);
	logger.info("Element 3 present in array2: " + found2);
	logger.info("\n");
	
	
}


}