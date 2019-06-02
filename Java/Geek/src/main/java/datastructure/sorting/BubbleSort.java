package datastructure.sorting;

import org.apache.log4j.Logger;

public class BubbleSort<T extends Comparable<T>> {

	 static final Logger logger = Logger.getLogger(BubbleSort.class.getName()); 
	
  public void sort(T[] arr) {
    boolean swap = true;
    while (swap) {
      swap = false;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i].compareTo(arr[i + 1]) > 0) { 
          logger.info("Swapping " + arr[i] + " and " + arr[i+1] + "\n");
          T tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;
          swap = true;
        }
      }
    }
  }
  
  
  public static void main(String args[]) {
	  
	  Integer[] arr = { 5 , 1, 4, 2 ,8 };
	  BubbleSort<Integer> bb = new BubbleSort<Integer>();
	  
	  logger.info("unsorted array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
	  logger.info("\n");
	  
	  bb.sort(arr);
	  
	  logger.info("\nsorted array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
	  
  }
}
