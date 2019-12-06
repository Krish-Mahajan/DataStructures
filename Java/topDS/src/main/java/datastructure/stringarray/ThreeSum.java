package datastructure.stringarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	
	  public List<List<Integer>> threeSum(int[] nums) {
	        
	        List<List<Integer>> result = new ArrayList<>();
	        Set<Integer> set = new HashSet<>();
	        
	        for(int i= 0; i < nums.length ;i++){
	            set.add(nums[i]);
	            for(int j=0 ;j< nums.length && j !=i;j++){
	                 set.add(nums[j]);
	                int complement = 0 - nums[i] -nums[j];
	                if (set.contains(complement)){
	                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],complement)));
	                    }
	               
	            }
	            
	        }
	                               
	             return result;   
	                
	            }
	  
	  
	  
	  public static void main(String[] args) {
		  int[] sums = {-1,0,1,2,-1,-4};
		  ThreeSum s = new ThreeSum();
		  s.threeSum(sums);
		  
	  }
}
