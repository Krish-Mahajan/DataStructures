package datastructure.graph;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGraph { 
	
	
	
		
		final Logger logger = Logger.getLogger(TestGraph.class.getName());

		
		
		// test to check printing to graph
		@Test
		public void testGraph() {
			int V =4;
			Graph graph = new Graph(V);
		    graph.addEdge(0, 1,0);
		    graph.addEdge(0, 2,0);
		    graph.addEdge(1, 2,0);  
		    graph.addEdge(2, 0,0);
		    graph.addEdge(2, 3,0);
		    graph.addEdge(3, 3,0);
		    graph.printGraph();
			
		}
		
		
		
		
		//test to check BFS
		@Test
		public void testBFS() {
			int V =4;
			Graph graph = new Graph(V);
		    graph.addEdge(0, 1,0);
		    graph.addEdge(0, 2,0);
		    graph.addEdge(1, 2,0);  
		    graph.addEdge(2, 0,0);
		    graph.addEdge(2, 3,0);
		    graph.addEdge(3, 3,0);
		    graph.BFS(2);
		
		} 
		
		
		//test to check DFS
		@Test
		public void testDFS() {
			int V =4;
			Graph graph = new Graph(V);
		    graph.addEdge(0, 1,0);
		    graph.addEdge(0, 2,0);
		    graph.addEdge(1, 2,0);  
		    graph.addEdge(2, 0,0);
		    graph.addEdge(2, 3,0);
		    graph.addEdge(3, 3,0);
		    graph.DFS(2);
		
		} 
		
		
		
		//test to check directed graph cyclic using DFS
		@Test
		public void testDirectedGraphCyclicDFS() {
			int V =4;
			Graph graph = new Graph(V);
		    graph.addEdge(0, 1,0);
		    graph.addEdge(0, 2,0);
		    graph.addEdge(1, 2,0);  
		    graph.addEdge(2, 0,0);
		    graph.addEdge(2, 3,0);
		    graph.addEdge(3, 3,0);
		    System.out.println(graph.detectCyclicDirectedGraphDFS());
		
		} 
		
	
		
	}
	
	
	
	

