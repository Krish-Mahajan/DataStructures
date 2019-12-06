package datastructure.binaryheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoint {
	
	
    private static class Point{
        int x;
        int y;
        int d;
        
        Point(int x , int y , int d){
            this.x =x;
            this.y=y;
            this.d=d;
        }
    }
    
    
    public int[][] kClosest(int[][] points, int K ){
        
    	Comparator<Point> byDistance = new Comparator<Point>() {
    		@Override
    		public int compare(Point p1,Point p2) {
    			return p1.d-p2.d;
    		}
    	};
    	
        PriorityQueue<Point> pq = new PriorityQueue<>(byDistance);
        
        for(int i=0;i<points.length;i++) {
        	int distance = (int) Math.pow(points[i][0],2) + (int) Math.pow(points[i][1],2);
        	Point p = new Point(points[i][0],points[i][1],distance);
        	pq.add(p);
        }
        
        //Extract K closest points 
        int[][] kclosestPoints = new int[K][2];
        for(int i=1 ; i<=K ;i++) {
        	Point p = pq.poll();
        	int[] coordinates = new int[2];
        	coordinates[0] = p.x;
        	coordinates[1] = p.y;
        	kclosestPoints[i]= coordinates;
        }
        
        return kclosestPoints;
        																		
    }
	
	
	
}
