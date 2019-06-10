package datastructure.sorting;

import java.lang.reflect.Array;

import org.apache.log4j.Logger;

public class MergeSort<T extends Comparable<T>> {

  static final Logger logger = Logger.getLogger(MergeSort.class.getName());

  private Class<T> clazz;

  public MergeSort(Class<T> clazz) {
    this.clazz = clazz;
  }
  
   
  public void sort(T[] arr, int l, int r) {

    if (l < r) {

      int m = (l + r) / 2;
      sort(arr, l, m);
      sort(arr, m + 1, r);
      merge(arr, l, m, r);
    }
    ;
  }

  private void merge(T[] arr, int l, int m, int r) { 
	  
     logger.info("\nFirst Subsarray ");
	  for(int i = l ; i <= m ; i++) logger.info(arr[i] + " ");
     
     logger.info("\n");
     logger.info("Second Subsarray ");
     for(int i = m + 1 ; i <= r ; i++) logger.info(arr[i] + " ");

     
    // Sizes of temp array to be merged.
    int arr1Size = m - l + 1;
    int arr2Size = r - m;

    T[] temparr1 = this.getArray(arr1Size);
    T[] temparr2 = this.getArray(arr2Size);

    // copy elements of temp array
    for (int i = 0; i < arr1Size ; i++) temparr1[i] = arr[l + i];

    for (int i = 0; i < arr2Size ; i++) temparr2[i] = arr[m +1 + i];

    // Actual merge
    int i = 0, j = 0;

    // Initial index of merged subarray array;
    int k = l;

    // compare each element
    while (i < arr1Size && j < arr2Size) {
      if (temparr1[i].compareTo(temparr2[j]) > 0) {
        arr[k] = temparr2[j];
        k++;
        j++;
      } else {
        arr[k] = temparr1[i];
        k++;
        i++;
      }
    }

    while (j < arr2Size) {
      arr[k] = temparr2[j];
      j++;
      k++;
    }

    while (i < arr1Size) {
      arr[k] = temparr1[i];
      i++;
      k++;
    }
    
    
    logger.info("\n");
    logger.info("Merged array till now ");
    for(int ii = 0 ; ii <= arr.length -1 ; ii++) logger.info(arr[ii] + " ");
  }

  public <T> T[] getArray(int maxsize) {
    @SuppressWarnings("unchecked")
    T[] arr = (T[]) Array.newInstance(this.clazz, maxsize);
    return arr;
  }
  
  
  public static void main(String args[]) {
	  
	  Integer[] arr = { 38,27,43 ,3,9, 82,10};
	  MergeSort<Integer> ms = new MergeSort<Integer>(Integer.class);
	
	  logger.info("unsorted array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
	  logger.info("\n");
	  
	  ms.sort(arr , 0 , arr.length -1);
	  
	  logger.info("\nsorted array is\n"); 
	  for(Integer i : arr) logger.info(i + " ");
  }
}
