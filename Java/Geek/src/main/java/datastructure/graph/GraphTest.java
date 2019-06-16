package datastructure.graph;

import org.apache.log4j.Logger;

import datastructure.binarytree.BinaryTreeTest;

public class GraphTest {
	

	  public static void main(String[] args) { 
		  
		final Logger logger = Logger.getLogger(GraphTest.class.getName());
		  
	    int V = 6;
	    Graph graph = new Graph(V);
	    graph.addEdgeDirected(0, 1);
	    graph.addEdgeDirected(0, 2);
	    graph.addEdgeDirected(2, 3);  
	    graph.addEdgeDirected(2, 4);
	    graph.addEdgeDirected(1, 5);

	    

	    
	    logger.info("Graph1 is : \n");
	    graph.printGraph();

	    logger.info("BFS from node 0 is : \n");
	    graph.BFS(0); 
	    logger.info("\n"); 
	  
	    
	    logger.info("DFS from node 0 is : \n");
	    graph.DFS(0); 
	    logger.info("\n");
	    
	    

	    
	    int V2 = 4;
	    Graph graph2 = new Graph(V);
	    graph2.addEdgeDirected(0, 1);
	    graph2.addEdgeDirected(0, 2);
	    graph2.addEdgeDirected(1, 2);  
	    graph2.addEdgeDirected(2, 0);
	    graph2.addEdgeDirected(2, 3);
	    graph2.addEdgeDirected(3, 3);

	    logger.info("\n");
	    logger.info("\n");
	    logger.info("Graph2 is : \n");
	    graph2.printGraph();
	    logger.info("\n");
	    
	    
	    logger.info("Back Edges in Graph2 are:\n");
	    graph2.DFS(2); 
	    logger.info("\n");
	    
	    
	       // Create a graph given in the above diagram 
        Graph g1 = new Graph(5); 
        g1.addEdgeUndirected(1, 0); 
        g1.addEdgeUndirected(0, 2); 
        g1.addEdgeUndirected(2, 0); 
        g1.addEdgeUndirected(0, 3); 
        g1.addEdgeUndirected(3, 4);  
        
	    logger.info("Back Edges in g1 are:\n");
	    g1.DFS(1); 
	    logger.info("\n"); 
	    
	    
	    Graph g = new Graph(6); 
        g.addEdgeDirected(5, 2); 
        g.addEdgeDirected(5, 0); 
        g.addEdgeDirected(4, 0); 
        g.addEdgeDirected(4, 1); 
        g.addEdgeDirected(2, 3); 
        g.addEdgeDirected(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g.topologicalSort(); 

	    
//	    logger.info("BFS from node 2 is : \n");
//	    graph.BFS(2);  
//	    logger.info("\n");
	//    
	    
	  
	    
//	    logger.info("DFS from node 2 is : \n");
//	    graph.DFS(2);  
//	    logger.info("\n");
	//    
//	    Graph g = new Graph(4); 
	//    
//	    g.addEdgeDirected(0, 1); 
//	    g.addEdgeDirected(0, 2); 
//	    g.addEdgeDirected(1, 2); 
//	    g.addEdgeDirected(2, 0); 
//	    g.addEdgeDirected(2, 3); 
//	    g.addEdgeDirected(3, 3); 
	//
//	    System.out.println("Following is Breadth First Traversal "+ 
//	                       "(starting from vertex 2 for graph 2)"); 
	//    
//	    g.BFS(2);  
	//    
//	    System.out.println("Following is Depth First Traversal "+ 
//	            "(starting from vertex 2)"); 
	//
//	    g.DFS(2); 
	  }
}
