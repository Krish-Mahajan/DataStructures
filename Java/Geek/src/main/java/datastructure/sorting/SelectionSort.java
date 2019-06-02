
package datastructure.sorting;

import org.apache.log4j.Logger;



public class SelectionSort<T extends Comparable<T>> {

 

 static final Logger logger = Logger.getLogger(SelectionSort.class.getName()); 
  
 
 public void sort(T[] arr) {
   
	  for(int i=0; i < arr.length  ; i++) {
		  int temp_ind = i;
		  T min = arr[i];
		  for(int j = i+1 ;j < arr.length  ; j++) {
			  if( min.compareTo(arr[j]) > 0) {
				  min = arr[j];
				  temp_ind = j;
			  }
		  }
		  T temp = arr[i];
		  arr[i] = min;
		  arr[temp_ind] = temp;
		  
	  }
	  
  }

  public static void main(String[] args) {
     Integer[] arr = {99, -4 , -5, 80, 100};
     SelectionSort<Integer> ss = new SelectionSort<Integer>();
     
     logger.info("Unsorted Array is " ); 
     for(Integer i : arr) {
    	 logger.info(i + " ");
     }
     
     ss.sort(arr);
     logger.info("\n");
     logger.info("sorted Array is " );
     for(Integer i : arr) {
    	 logger.info(i + " ");
     }
     
  }
}
