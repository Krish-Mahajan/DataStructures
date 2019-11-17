package datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinStepNeeded { 
	
	/**
	 * REMEMBER
	 * Function to calculate GCD of two numbers
	 * @param a
	 * @param b
	 * @return
	 */
	private static int gcd(int a , int b) {
		
		if( a == 0) return b;
		
		if( b == 0) return a;
		
		
		if( a == b) return b;
		
		if( a > b) return gcd(a- b ,b);
		
		else return gcd(a, b - a);

	}
	
	
	/**
	 * REMEMBER
	 * Function to check if position x reachable from position k using d1 & d2 steps
	 * @param x
	 * @param k
	 * @param d1
	 * @param d2
	 * @return
	 */
	private static boolean checkIfReachable(int x , int k , int d1 , int d2) {
		 
		int gcd = gcd(d1, d2);
		if((x - k)% gcd == 0) return true;
		return false;
	}
	/**
	 * Function to calculate minimum number of steps needed to go x from k using steps d1 & d2
	 * @param x
	 * @param k
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int minStepNeeded(int x , int k , int d1 , int d2) {
		if(checkIfReachable(x, k, d1, d2)) {
			Queue<Integer> queue = new LinkedList<Integer>();
			Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
			Map<Integer, Integer> distance = new HashMap<Integer, Integer>();
			
			queue.add(k);
			distance.put(k, 0);
			visited.put(k, false);
			
			while(!queue.isEmpty()) {
			     int cur_pos = queue.poll();
			     if( cur_pos == x) return distance.get(cur_pos);
			     if(! visited.get(cur_pos)) {
	    			 visited.put(cur_pos, true);
			    	 int[] new_pos = {cur_pos + d1 ,cur_pos - d1,cur_pos + d2 ,cur_pos - d2};
			    	 for (int neigh_pos : new_pos) {
 			    		 if(visited.get(neigh_pos) == null) visited.put(neigh_pos, false);
			    		 if(!visited.get(neigh_pos)) {
			    			 distance.put(neigh_pos, distance.get(cur_pos) + 1);
			    			 queue.add(neigh_pos);
			    		 }
			    	 }
			    	 
			     }
			}
			
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		int x =  8;
		int k = 10;
		int d1 = 4 , d2 = 6;
		System.out.println("Minimum steps Needed " +  MinStepNeeded.minStepNeeded(x, k, d1, d2));
	}
	
	
	
}
