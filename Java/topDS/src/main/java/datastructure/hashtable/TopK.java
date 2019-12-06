package datastructure.hashtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK {
	
	
public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i < nums.length;i++){
            if(map.containsKey(nums[i])) {
            	map.replace(nums[i],map.get(nums[i])+1);
            }
            else map.put(nums[i],1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>(){
         public int compare(Integer i1,Integer i2){
             return map.get(i2) -map.get(i1);
         }   
        });
        
        //fill the pq
        for(int i : map.keySet()){
            pq.add(map.get(i));
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<k ;i++){
            result.add(pq.poll());
        }
        
        return result; 
        
}
        public static void main(String[] args) {
        	
        	TopK tk = new TopK();
        	int[] nums = {11,11,11,22,22,33};
        	int k = 2;
        	tk.topKFrequent(nums, k);
        }
            
        
    
	
	
	
	
}
