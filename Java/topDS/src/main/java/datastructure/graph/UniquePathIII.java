package datastructure.graph;

public class UniquePathIII {
	
private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

private static int count=0;

private void dfs(int[][] grid, boolean[][] visited,int r , int c,int todo){
   
	todo--;
	if(todo <0) return;
    
    //Found end point
    if(grid[r][c] == 2){
        if(todo ==0) {
        	UniquePathIII.count +=1;
            return;
            	}
           
    }
    
    visited[r][c] = true;
    
    for(int[] dir : dirs){
        int r_new = r + dir[0];
        int c_new = c + dir[1];
        if(isSafe(grid,r_new ,c_new)){
            if(!visited[r_new][c_new] && grid[r_new][c_new]!=-1){
                dfs(grid,visited,r_new,c_new,todo);
            }
        }
    }
    visited[r][c] = false;
    
}


private boolean isSafe(int[][] grid,int r , int c){
    return r>=0 && r < grid.length && c>=0 && c<grid[0].length;
}



public int uniquePathsIII(int[][] grid) {
    
    int startR=0;
    int startC=0;
    int todo =0;
    for(int r=0; r< grid.length ; r++){
        for(int c=0 ; c<grid.length ; c++){
            
        	if(grid[r][c] !=-1) todo++;
        	
        	if(grid[r][c] == 1) {
                startR =r;
                startC = c;
            }
            
        }
    }
    
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    dfs(grid,visited,startR,startC,todo);
    return UniquePathIII.count;
    

}
    
    public static void main(String[] args) {
    	int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
    	UniquePathIII path = new UniquePathIII();
    	System.out.print(path.uniquePathsIII(grid));
    }
    
}
