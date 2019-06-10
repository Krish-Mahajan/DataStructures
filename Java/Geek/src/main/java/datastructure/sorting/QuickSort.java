package datastructure.sorting;

import org.apache.log4j.Logger;

public class QuickSort<T extends Comparable<T>> {
	
	
	static final Logger logger = Logger.getLogger(QuickSort.class.getName());
	
	
	public void sort(T[] arr , int low ,int high) {
		
		if(low < high) {
			
			int pivot_index = partition(arr , low , high);
			sort(arr , low , pivot_index - 1);
			sort(arr , pivot_index + 1 , high);
		}
	}

  private int partition(T[] arr, int low, int high) {
     
	 int i = low - 1 ;
     
     T pivot = arr[high];
     
     for(int j = low ; j< high ; j++) {
    	 if(arr[j].compareTo(pivot) <= 0) {
    		 i++;
             swap(arr,i,j);
    	 }
     }
      swap(arr, i+1 , high);
	  return i + 1;
  }
  
  private void swap(T[] arr ,int i , int j ) {
		 T temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
  }
  
  
  public static void main(String[] args) {
	  
	  Integer[] arr = { 38,27,43 ,3,9, 82,10};
	  QuickSort<Integer> qs = new QuickSort<Integer>();
	
	  logger.info("unsorted array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
	  logger.info("\n");
	  
	  qs.sort(arr , 0 , arr.length -1 );
	  
	  logger.info("\nsorted array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
  }
  
  
}
