package datastructure.graph;

import java.util.Stack;

/**
 * REMEMBER
 * Code to find minimum number of throws to reach point 30 from point 1 in a board.
 * Solved using BFS Approach
 * @author krish.mahajan@ibm.com
 *
 */
public class Board { 
	
	
	static class Square{
		private int index;
		private int dist = 0;
	} 
	
	
	static int minThrow(int[] move) {
		
		//Queue<Square> queue = new LinkedList<Square>();
		Stack<Square> queue = new Stack<Square>();
		boolean[] visited = new boolean[30];
		
		Square cur_square = new Square();
		cur_square.index = 0;
		cur_square.dist = 0;
		visited[cur_square.index] = true;
		queue.add(cur_square);
		
		while(!queue.isEmpty()) {
		     //cur_square = queue.poll();
			cur_square = queue.pop();
		    if(cur_square.index == 30-1) break;
			for(int j = cur_square.index + 1; j <= cur_square.index + 6 && j< 30 ; j++) {
			if(!visited[j]) {
				Square next_square = new Square();
				next_square.index = j;
				next_square.dist = cur_square.dist + 1;
				visited[j] = true;
				
				if(move[j] != -1) {
					Square dest_square = new Square();
					dest_square.index = move[j];
					dest_square.dist = next_square.dist ; 
					visited[move[j]] = true;
					queue.add(dest_square);
				}
				else queue.add(next_square);
			}
		}
	}
		return cur_square.dist;
	}
	
	
	public static void main(String[] args) {
		int[] moves = new int[30];
		for(int i =0 ; i< 30 ; i++) {
			moves[i] = -1;
		}
		
	    // Ladders 
        moves[2] = 21; 
        moves[4] = 7; 
        moves[10] = 25; 
        moves[19] = 28; 
  
        // Snakes 
        moves[26] = 0; 
        moves[20] = 8; 
        moves[16] = 3; 
        moves[18] = 6;  
        
        System.out.println("Min Dice throws required is " +
        minThrow(moves));
  
	}
}
