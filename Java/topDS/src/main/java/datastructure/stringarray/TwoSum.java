package datastructure.stringarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
        if(nums!=null && nums.length > 1){
        for(int i=0;i<nums.length;i++){
            for(int j=i ; j< nums.length;j++){
                if(nums[i] + nums[j] == target) {
                    int[] result = new int[] {i,j};
                    return result;
                }
            }
        }
        } 
        return null;
    }
    
    
    public int[] twoSum2(int[] nums,int target) {
    	Map<Integer, Integer> memo = new HashMap<>();
    	for(int i=0 ; i < nums.length;i++) {
    		Integer complement = target - nums[i];
    		if(memo.containsKey(complement)) {
    			return new int[] {memo.get(complement),i}; 
    		}
    		memo.put(nums[i],i);
    	}
    	
    	return null;
    }
    
    
    public static void main(String[] args) {
    	
    	TwoSum o = new TwoSum();
    	int[] nums = new int[] {3,2,4};
    	int target = 6;
    	 List<List<Integer>> result = new ArrayList<List<Integer>>();
    	 List<List<Integer>> result1 = new ArrayList<>();
    	System.out.println(o.twoSum(nums, target ));
    }
	
	
	
}
