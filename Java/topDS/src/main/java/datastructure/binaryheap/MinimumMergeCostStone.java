package datastructure.binaryheap;

import java.util.Comparator;
import java.util.PriorityQueue;

import datastructure.binaryheap.MinimumMergeCostStone.KPairs;

public class MinimumMergeCostStone {
	
	 class KPairs {
	        int[] kPair;
	        int index;
	        int sum = 0;
	        
	        public KPairs(int[] kPair , int index){
	            this.index = index;
	            this.kPair = kPair;
	            for(int val : kPair){
	                this.sum += val;
	            }
	            
	           }
	            
	    }
public int mergeStones(int[] stones, int K) {
        
        int cost = 0;
        
        PriorityQueue<KPairs> pq = new PriorityQueue<>( new Comparator<KPairs>(){
            
            public int compare( KPairs k1 , KPairs k2){
                return k1.sum - k2.sum;
            } 
            
        });
        
        while(stones.length !=1){
            
        for(int i=0 ; i <= stones.length -K ;i++){
            int[] kPair = new int[K];
            for(int j=i; j< i+K ; j++){
                kPair[j-i] = stones[j];
            }
            pq.add(new KPairs( kPair,i));
            
         }
        
         cost = cost + pq.peek().sum ;
         int index = pq.peek().index;
         
        // new rack    
        if(stones.length -K+1 <=0) return -1;
        int[] stones_new = new int[stones.length -K+1];
         
        //before index
        for(int j=0;j< stones_new.length;j++){
             if(j == index){
            	 stones_new[j] = pq.peek().sum;
            	 j = j+ K -1;
             }
            
            else stones_new[j] = stones[j];
         }
        stones = stones_new;
        pq.clear();
        }
        
        return cost;     
        
    }
	
    public static void main(String[] args) {
    	int[] stones = {3,2,4,1}; int K = 2;
    	MinimumMergeCostStone msk = new MinimumMergeCostStone();
    	System.out.println(msk.mergeStones(stones, K));
    }
	
	
	
}
