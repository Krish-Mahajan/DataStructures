package datastructure.dynamicprogramming;

public class PaintHouse {
	
	   private int color_index = -1;
	   public int minCost(int[][] costs) {
	        if(costs.length ==0) return 0;
	        
	        return  minCostUtil(costs.length-1,costs);
	    }
	    
	    private int minCostUtil(int n , int[][] costs){
	        
	        if(n < 0) return 0;     
	        
	        if(n == 0 ) {
	            int min = Integer.MAX_VALUE;
		        for( int i=0 ; i< costs[n].length ;i++){
		                    if(costs[n][i] < min) {
		                    min = costs[n][i];
		                    color_index = i;
		                    }
		                }
	        	return costs[0][color_index];
	        }
	        else{
	        	
	        	int cost_previous =  minCostUtil(n-1,costs);
	        	updateColorIndex(n, costs);
	            int cost_n = costs[n][color_index] + cost_previous;
	            return cost_n ;
	        }
	    }
	    
	    private void updateColorIndex(int n,int[][] costs) {
            if(color_index ==0) color_index = costs[n][1] > costs[n][2] ? 2 : 1;
            else if(color_index ==1) color_index = costs[n][0] > costs[n][2] ? 2 : 0;
            else color_index = costs[n][0] > costs[n][1] ? 1 : 0;
	    }
	    
	    public static void main(String[] args) {
	    	PaintHouse ph = new PaintHouse();
	    	int[][] costs = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
	    	System.out.println(ph.minCost(costs));
	    	
	    }
	
	
	
}
