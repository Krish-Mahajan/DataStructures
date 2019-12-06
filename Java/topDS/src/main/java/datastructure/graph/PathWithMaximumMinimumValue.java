package datastructure.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/path-with-maximum-minimum-value/
// BFS with PriorityQueue
public class PathWithMaximumMinimumValue {
	
	
	
	
    private static class Point{
        int r;
        int c;
        int val;
        Point(int r,int c,int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
    } 
    
    
    private boolean isCorrectPoint(int rnew,int cnew,int R ,int C){
        return rnew >=0 && rnew<R && cnew >=0 && cnew < C ;
        
    }
    
    public int maximumMinimumPath(int[][] A) {
        
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
        
        public int compare(Point p1, Point p2){
            return p2.val- p1.val;
        }
        });
        
        pq.add(new Point(0,0,A[0][0]));
        
        int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int R = A.length;
        int C = A[0].length;
        
        boolean[][] visited = new boolean[R][C];
        
       //start BFS
        int min = Integer.MAX_VALUE;
        while(true){
            Point p = pq.poll();
            if(p.val < min) min = p.val;
            if(p.r == R -1 && p.c == C -1) break;
            if(!visited[p.r][p.c]){
                visited[p.r][p.c] = true;
                for(int[] dir :DIRS){
                    int pRnew = p.r + dir[0];
                    int pCnew = p.c + dir[1];
                    if(isCorrectPoint(pRnew,pCnew,R,C)){
                    	if(!visited[pRnew][pCnew])
                        pq.add(new Point(pRnew,pCnew,A[pRnew][pCnew]));
                    }
                }
            }
        }
        return min;
        
        
    }
	
    public static void main(String[] args) {
    	
    	int[][] M  = new int[][] { 
    		{ 5, 4, 5 }, 
			{ 1 ,2, 6 }, 
			{ 7, 4, 6}           };  
			
		PathWithMaximumMinimumValue mx = new PathWithMaximumMinimumValue();
		System.out.println(mx.maximumMinimumPath(M));
    }
	
	
	
	
	
	
}
