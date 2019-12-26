package datastructure.array;

public class MaxProduct {
	
    public int maxProduct(int[] nums) {        
    
    int[] memo = new int[nums.length];
    memo[0] = nums[0];
    int maxProduct = memo[0];
    
    for(int i=1 ; i< nums.length ;i++){
        
        if(i< nums.length -1)
            if( nums[i+1] < 0) memo[i] = Math.abs(nums[i]) > Math.abs(nums[i]*memo[i-1]) ? nums[i] : nums[i]*memo[i-1];
        if(memo[i]==0) memo[i] = Math.max(nums[i],nums[i]*memo[i-1]);
        if(memo[i] > maxProduct) maxProduct = memo[i];
    }
    
    return maxProduct;
        }
    
    public static void main(String[] args) {
    	
    	MaxProduct mp = new MaxProduct();
    	int[] nums = {2,-5,-2,-4,3};
    	System.out.println(mp.maxProduct(nums));
    	
    	}
    }

