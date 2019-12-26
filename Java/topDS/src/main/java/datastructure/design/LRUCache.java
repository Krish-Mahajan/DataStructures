package datastructure.design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache { 
	

    int maxCapacity ;
    int currentCapacity;
    Map<Integer,Integer> count = new HashMap<>();  
    Map<Integer,Integer> map ;
    PriorityQueue<Integer> pq;
    
    public LRUCache(int capacity) {
        
    	maxCapacity = capacity;
        currentCapacity =0;
        count = new HashMap<>();  
        map = new HashMap<>();
        
        pq = new PriorityQueue<>( new Comparator<Integer>(){

            public int compare(Integer key1, Integer key2){
                return count.get(key1) - count.get(key2);
            }

      });
    }
    
    public int get(int key) {
        
        if(this.map.containsKey(key)){
             count.put(key,map.getOrDefault(key,0)+1);
            return map.get(key);
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.size() == maxCapacity){
            
            int keyToRemove = pq.poll();
            
            map.remove(keyToRemove);
            count.remove(keyToRemove);
            
            map.put(key,value);
            count.put(key,1);
        }
        else{
            map.put(key,value);
            count.put(key,map.getOrDefault(key,0)+1);

        }
    }
	

}
