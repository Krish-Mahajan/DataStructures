package datastructure.hashing;

import java.util.HashSet;

public class PairSum {
	
	public static void findPairs(int[] arr, int sum) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0;i < arr.length ; i++) {
			int temp = sum - arr[i];
			if(temp >=0 && hs.contains(temp)) {
				System.out.println("The pair with sum " + sum + " in the given array is :(" + arr[i] + "," + temp +")");
			    return;
			}
			hs.add(arr[i]);
		}
		System.out.println("The pair with sum " + sum + " in  the given array  is not present");
	}
	
	
	public static void main(String args[]) {
		int[] nums = {1 , 5, 7, 9, 10};
		int sum = 21;
		findPairs(nums, sum);
	}
}
