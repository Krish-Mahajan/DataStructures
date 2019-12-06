


package datastructure.graph;

import java.util.*;


class isRotten { 
    
    private static final int[][]  DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
    private static final int  isROTTEN = 2;
    private static final int  isFRESH = 1;
    
    private static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    private boolean isFresh(int r,int c, int R,int C,int[][] grid){
        return r>=0 && r<R && c >=0 && c<C &&  grid[r][c]==isFRESH;
    }
    
    public int orangesRotting(int[][] grid) {
        
         int R = grid.length;
         int C = grid[0].length;
                             
        Queue<Point> rottenTomatoList = new ArrayDeque<Point>();
        int freshOrange = 0;
        for(int r=0 ;r< grid.length;r++){
            for(int c=0; c< grid[r].length;c++){
                if(grid[r][c] == isROTTEN){
                    rottenTomatoList.add(new Point(r,c));
                }
                if(grid[r][c] == isFRESH){
                    freshOrange++;
                }
            }
        }
        if(freshOrange ==0) return 0;
        int mins =1;
        while(!rottenTomatoList.isEmpty()){
        	int initialRottenTomatoSize= rottenTomatoList.size();
            for(int i = 0; i<initialRottenTomatoSize;i++){
                Point p = rottenTomatoList.poll();
                for(int[] dir :DIRS){
                    int p_x = p.x + dir[0];
                    int p_y = p.y + dir[1];
                    if(isFresh(p_x,p_y,R,C,grid)){
                        freshOrange--;
                        if(freshOrange == 0) return mins;
                        grid[p_x][p_y]= isROTTEN;
                        rottenTomatoList.add(new Point(p_x,p_y));
                    }
                }
            }
            mins=mins+1;
        }
        
        return -1;
    }
    
    
    
    public static void main(String[] args) {
		 

	        
    		int[][] grid = {{1},{2},{1},{1}};
	        

    		isRotten z = new isRotten();
	        System.out.println(z.orangesRotting(grid));
	        
	
}
}