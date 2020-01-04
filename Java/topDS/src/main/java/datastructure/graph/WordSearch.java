package datastructure.graph;

public class WordSearch {

 
    public boolean exist(char[][] board, String word) {
        char[][] grid = board;
        
       // if(grid.length ==0) return false;
        
        

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int r=0;r < grid.length ;r++){
            for(int c=0; c <grid[r].length;c++){
                if( grid[r][c] ==word.charAt(0) && !visited[r][c]){
                    if(dfs(grid,r,c,visited,word,1)) return true;    
                }
            }
        }
        
        return false;
    }
    
    
    private final static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    
    public boolean dfs(char[][] grid ,int r , int c, boolean[][] visited,String word,int position){
        
        if(position >= word.length()) return true;
        
        
        visited[r][c] = true;
        for(int[] dir : dirs){
            int r_new = r + dir[0];
            int c_new = c + dir[1];
            if(isSafe(grid,r_new,c_new)){
                if(!visited[r_new][c_new] && grid[r_new][c_new]==word.charAt(position)){
                   if (dfs(grid,r_new,c_new,visited, word,position+1))
                	   return true;
                }
            }
        }
        visited[r][c] = false;
        return false;
    }
    
    
    private boolean isSafe(char[][] grid ,int r , int c){
         return r >=0 && r < grid.length && c >=0  && c <grid[0].length;
        
    }
    
    
    public static void main(String[] args) {
    	WordSearch w = new WordSearch();
    	char[][] board = {{'A','B','C','E'},
    			          {'S','F','E','S'},
    			          {'A','D','E','E'}};
    	String word = "ABCESEEEFS";
    	System.out.println(w.exist(board, word));
    }

    

    
    
}