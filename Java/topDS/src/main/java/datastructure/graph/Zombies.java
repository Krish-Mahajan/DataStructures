package datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Zombies { 
	
	/**
	 * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) 
	 * human beings into zombies every hour. Find out how many hours does it take to infect all humans?
	 * 
	 */
	private static final int ZOMBIE = 1;
	private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public int minHours(List<List<Integer>> grid) {
	    int people = 0;
	    Queue<Point> zombies = new ArrayDeque<>();
	    for (int r = 0; r < grid.size(); r++) {
	        for (int c = 0; c < grid.get(0).size(); c++) {
	            if (grid.get(r).get(c) == ZOMBIE) {
	                zombies.add(new Point(r, c));
	            } else {
	                people++;
	            }
	        }
	    }

	    if (people == 0) return 0;
	    int hours = 1;

	    while(true) {
	    	
	    	
	    	Queue<Point> zombies_new = new ArrayDeque<>();
	        for (int sz = zombies.size(); sz > 0; sz--) {
	            Point zombie = zombies.poll();

	            for (int[] dir : DIRS) {
	                int r = zombie.r + dir[0];
	                int c = zombie.c + dir[1];

	                if (isHuman(grid, r, c)) {
	                    people--;
	                    if (people == 0) return hours;
	                    grid.get(r).set(c, ZOMBIE);
	                    zombies_new.add(new Point(r, c));
	                }
	            }
	        }
	        zombies = zombies_new;
	        hours = hours+ 1;
	    	
	    }
	 
	    
	}

	private boolean isHuman(List<List<Integer>> grid, int r, int c) {
	    return r >= 0 && r < grid.size() &&c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) != ZOMBIE;
	}

	private static class Point {
	    int r, c;
	    Point(int r, int c) {
	        this.r = r;
	        this.c = c;
	    }
	}
	
	
	
	public static void main(String[] args) {
		 
	        List<Integer> row1 = Arrays.asList(0, 1, 1, 0, 1);
	        List<Integer> row2 = Arrays.asList(0, 1, 0, 1, 0);
	        List<Integer> row3 = Arrays.asList(0, 0, 0, 0, 1);
	        List<Integer> row4 = Arrays.asList(0, 1, 0, 0, 0);
	        
	        List<List<Integer>> grid = new ArrayList<>();
	        grid.add(row1);grid.add(row2);grid.add(row3);grid.add(row4);
	        Zombies z = new Zombies();
	        System.out.println(z.minHours(grid));
	        
	
}
	
	
}
	
	
	
	
	
	
