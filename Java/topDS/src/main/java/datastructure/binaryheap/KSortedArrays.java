package datastructure.binaryheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSortedArrays {
	
	//Using Comparator 
	private static class Point1{
		int value;
		int rowIndex;
		int colIndex;
		
		Point1(int value,int rowIndex,int colIndex){
			this.value = value;
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
		}
	}
	
	
	private static class PointComparator implements Comparator<Point1>{

    @Override
    public int compare(Point1 o1, Point1 o2) {
      if(o1.value > o2.value) return 1;
      if(o1.value < o2.value) return -1;
      else return 0;
    }
		
	}
	
	
	//Using Comparable
	private static class Point2 implements Comparable<Point2>{
		int value;
		int rowIndex;
		int colIndex;
		
		Point2(int value,int rowIndex,int colIndex){
			this.value = value;
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
		}

    @Override
    public int compareTo(Point2 o2) {
    	   if(this.value > o2.value) return 1;
    	      if(this.value < o2.value) return -1;
    	      else return 0;
 
    }
	}
	
	
	public int[] mergeKSortedArrays(int[][] arr) {
		
		
		int resultSize = 0;
		//PriorityQueue<Point1> pq = new PriorityQueue<>(new PointComparator());
		PriorityQueue<Point2> pq = new PriorityQueue<>();
		
		//Add first three elements of each array to priorityQueue 
		for(int i= 0; i<arr.length;i++) {
			//pq.add(new Point1(arr[i][0],i,0));
			pq.add(new Point2(arr[i][0],i,0));
			resultSize += arr[i].length;
		}
		
	
		int[] finalArr = new int[resultSize];
		
		//Add all the elements to final array
		for(int i=0;i <resultSize ;i++) {
			//Point1 p = pq.remove();
			Point2 p = pq.remove();
			finalArr[i] = p.value;
			
			//Find the next element to be added to the PQ which will the element in the p array
			
			//if element still present in that row
			if(p.colIndex < arr[p.rowIndex].length -1) {
				//Point1 newP = new Point1(arr[p.rowIndex][p.colIndex+1],p.rowIndex,p.colIndex+1);
				Point2 newP = new Point2(arr[p.rowIndex][p.colIndex+1],p.rowIndex,p.colIndex+1);
				pq.add(newP);
			}
			
			else {
				//Point1 newP = new Point1(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
				Point2 newP = new Point2(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
				pq.add(newP);
			}
		}
		
		
		return finalArr;
	} 
	
	
	public static void main(String[] arr) {
		
	       int[][] arr1 = {{2, 6, 12, 34}, 
	                {1, 9, 20, 1000}, 
	                {23, 34, 90, 2000}}; 
	  
	        System.out.println("Merged array is :"); 
	  
	        KSortedArrays ks = new KSortedArrays();
	        System.out.println(ks.mergeKSortedArrays(arr1).toString());
	       
	}
	
	
	
	
}
