package datastructure.graph;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Stack;

public class TestGraph { 
	
	
	
		
		final Logger logger = Logger.getLogger(TestGraph.class.getName());

		
		
		// test to check printing to graph
		@Test
		public void testGraph() {
			logger.debug("Testing Graph Representation");
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
		logger.debug("Testing BFS");
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
			logger.debug("Testing DFS");
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
		    logger.debug("Testing if the directed graph is cyclic");
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
		
		
		
		@Test
		public void testTopologicalSortingDFS() {
		     Graph g = new Graph(6); 
		        g.addEdge(5, 2,0); 
		        g.addEdge(5, 0,0); 
		        g.addEdge(4, 0,0); 
		        g.addEdge(4, 1,0); 
		        g.addEdge(2, 3,0); 
		        g.addEdge(3, 1,0);  
		        
		        
		        logger.debug("Following is a Topological " + 
		                           "sort of the g1 graph"); 
		        Stack<Integer> stack = g.topologicalSorting();
		        // Print contents of stack 
		        while (stack.empty()==false) 
		            logger.debug(stack.pop() + " "); 
		        
		        
		        
		        logger.debug("Following is a Topological " + 
                        "sort of the g2 graph"); 
		        Graph g2 = new Graph(2);
		        g2.addEdge(0, 1,0); 
		        g2.addEdge(1, 0,0); 
		        
		        Stack<Integer> stack2 = g2.topologicalSorting();
		        // Print contents of stack 
		        while (stack2.empty()==false) 
		            logger.debug(stack2.pop() + " "); 
		}
		
		
		
		@Test
		public void testShortestPathDAG() {
			  Graph g = new Graph(6); 
		        g.addEdge(0, 1, 5); 
		        g.addEdge(0, 2, 3); 
		        g.addEdge(1, 3, 6); 
		        g.addEdge(1, 2, 2); 
		        g.addEdge(2, 4, 4); 
		        g.addEdge(2, 5, 2); 
		        g.addEdge(2, 3, 7); 
		        g.addEdge(3, 4, -1); 
		        g.addEdge(4, 5, -2);
		        
		        g.shortestDistanceFromVertexDAG(1);
		}
		
		
		@Test
		public void testUnDirectedGraphCyclicUnionFind() {
			  Graph g = new Graph(5); 
		        g.addEdge(0, 1, 5); 
		        g.addEdge(0, 2, 3); 
		        g.addEdge(1, 3, 6); 
		        g.addEdge(1, 4, 2); 
		        //g.addEdge(3, 4, 4); 
		        //g.addEdge(2, 5, 2); 
		        //g.addEdge(2, 3, 7); 
		        //g.addEdge(3, 4, -1); 
		        //g.addEdge(4, 5, -2);
		        
		        logger.debug(g.detectCyclicUnDirectedGrapUnionFind());
		}
		
		
		@Test
		public void testUnDirectedGraphCyclicDFS() {
			  Graph g = new Graph(5); 
		        g.addEdge(0, 1, 5); 
		        g.addEdge(0, 2, 3); 
		        g.addEdge(1, 3, 6); 
		        g.addEdge(2, 3, 6); 
		        g.addEdge(1, 4, 2); 
		        //g.addEdge(3, 4, 4); 
		        //g.addEdge(2, 5, 2); 
		        //g.addEdge(2, 3, 7); 
		        //g.addEdge(3, 4, -1); 
		        //g.addEdge(4, 5, -2);
		        
		        System.out.println(g.detectCycleUndirectedGraphDFS());
		} 
		
		
		@Test
		public void testIsGraphBiPartiteBFS() {
			  Graph g = new Graph(6); 
		        g.addEdge(0, 1, 0); 
		        g.addEdge(1, 2, 0); 
		        g.addEdge(2, 3, 0); 
		        g.addEdge(3, 4, 0); 
		        g.addEdge(4, 5, 0); 
		        g.addEdge(5, 0, 0); 
		        //g.addEdge(4, 0, 0); 

		        
		        logger.debug(g.isGraphBipartiteBFS());
		}
		
		
		@Test
		public void testKruskalMST() {
			  Graph g = new Graph(4); 
		        g.addEdge(0, 1, 10); 
		        g.addEdge(1, 3, 15); 
		        g.addEdge(3, 2, 4); 
		        g.addEdge(2, 0, 6); 
		        g.addEdge(0, 3, 5); 
		        ///g.addEdge(5, 0, 0); 
		        //g.addEdge(4, 0, 0); 

		        
		       g.kruskalMST();
		}
		
		
		@Test
		public void testConnectedComponents() {
			  Graph g = new Graph(5); 
		        //g.addEdge(0, 1, 10); 
		        //g.addEdge(1, 3, 15); 
		        //g.addEdge(3, 2, 4); 
		        //g.addEdge(2, 0, 6); 
		        //g.addEdge(0, 3, 5); 
		        
		        g.addEdge(1, 0,0);  
		        g.addEdge(1, 2,0);  
		        g.addEdge(3, 4,0);
		        g.connectedComponents();


		        
		      
		}
	
	
		
	}
	
	
	
	

