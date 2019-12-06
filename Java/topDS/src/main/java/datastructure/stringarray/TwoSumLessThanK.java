package datastructure.stringarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumLessThanK {

  public int twoSumLessThanK(int[] A, int K) {

    Arrays.sort(A);
    int sum = -1;

    for (int i = 0; i < A.length - 1; i++) {
      int startIndex = i;
      // A[startIndex] + elementToFind < K
      // elementToFind < K - A[startIndex]
      // elementToFind < Max(K - A[startIndex])
      int elementFound = binarySearch(A, startIndex + 1, A.length - 1, K - A[startIndex], 0);
      if (elementFound!=0 &&  A[startIndex] + elementFound > sum) sum = A[startIndex] + elementFound;
    }
    return sum;
  }

  public int binarySearch(
      int[] A, int startIndex, int endIndex, int elementToSearch, int maxSoFar) {
    if (startIndex <= endIndex) {
      int midIndex = (startIndex + endIndex) / 2;
      if (A[midIndex] == elementToSearch) return Math.min(maxSoFar, A[midIndex]);
      if (A[midIndex] > elementToSearch)
    	  return binarySearch(A ,startIndex,midIndex -1 ,elementToSearch,maxSoFar);
      else if (A[midIndex] < elementToSearch)
    	  return binarySearch(A ,startIndex,midIndex -1 ,elementToSearch,maxSoFar);
    }
    return maxSoFar;
  }
  
  
  public static void main(String[] arr) {
	  
	  TwoSumLessThanK tk = new TwoSumLessThanK();
	  //int [] a = {34,23,1,24,75,33,54,8};
	  int [] a = {10,20,30};
	  int K = 15;
	  tk.twoSumLessThanK(a, K);
	  Map<String, List<String>> ans = new HashMap<>();
	  String key = " ";
	  String s =  " ";
	  ans.put(key, ans.getOrDefault(key, new ArrayList<String>(Arrays.asList(s))).add(s));

  }
}
