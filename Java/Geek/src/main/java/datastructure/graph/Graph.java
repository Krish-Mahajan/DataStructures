package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.apache.log4j.Logger;

public class Graph { 
	
	
	static final Logger logger = Logger.getLogger(Graph.class.getName());

  // No. of vertices
  int V;

  // Each element of the array will be a LinkedList
  LinkedList<Integer>[] adjListArray;

  Graph(int V) {
    this.V = V;
    adjListArray = (LinkedList<Integer>[]) new LinkedList<?>[V];
    for (int i = 0; i < V; i++) {
      adjListArray[i] = new LinkedList<Integer>();
    }
  }

  /**
   * Adds an edge to undirected graph
   * @param src
   * @param dest
   */
  public void addEdge(int src, int dest) {

    // Add an edge from src to des
    this.adjListArray[src].add(dest);

    // Since graph is undirected , add an edge from dest to src also
    this.adjListArray[dest].add(src);
  }

  // A utility function to print the adjacency list representation of Graph
  public void printGraph() {

    for (int v = 0; v < this.V; v++) {
      System.out.println("Adjacency list of vertex " + v);
      System.out.print("head");
      for (Integer pCrawl : this.adjListArray[v]) {
        System.out.print("---> " + pCrawl);
      }
      System.out.println("\n");
    }
  }

  /**
   * Breadth First Traversal of a graph
   * @param startNode
   */
  public void BFS(int startNode) {

    
	// create a queue for BFS
	Queue<Integer> queue = new LinkedList<Integer>();
    
	//Create a boolean array of visited Nodes
	boolean[] visited = new boolean[this.V];

    //Enqueue the current node 
	queue.add(startNode);
	
    while (!queue.isEmpty()) {
      int node = queue.poll();
      if (!visited[node]) {
        visited[node] = true;
        System.out.print(node + " ");
        LinkedList<Integer> nodeLL = this.adjListArray[node];
        for (int neighbour : nodeLL) {
          if (!visited[neighbour]) queue.add(neighbour);
        }
      }
    }
  }
  
  
  
  /**
   * Depth First Traversal of a graph
   * @param startNode
   */
  public void DFS(int startNode){
	  
	  // Create a stack for DFS
	  Stack<Integer> stack = new Stack<Integer>();
	  
	  //create a boolean array of visited nodes
	  boolean[] visited = new boolean[this.V];
	  
	  //Stack up the current node
	  stack.add(startNode);
	  
	  while(!stack.isEmpty()) {
		  int node = stack.pop();
		  if(!visited[node]) {
			  visited[node] = true;
			  System.out.print(node + " ");
			  LinkedList<Integer> nodeLL = this.adjListArray[node];
			  for(int neighbour : nodeLL) {
				  if(!visited[neighbour]) stack.add(neighbour);
			  }
		  }
	  }
  }

  public static void main(String[] args) {
    int V = 6;
    Graph graph = new Graph(V);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(2, 3);  
    graph.addEdge(2, 4);
    graph.addEdge(1, 5);

    

    
    logger.info("Graph is : \n");
    graph.printGraph();

    logger.info("BFS from node 0 is : \n");
    graph.BFS(0); 
    logger.info("\n"); 
  
    
    logger.info("DFS from node 0 is : \n");
    graph.DFS(0); 
    logger.info("\n");
    
//    logger.info("BFS from node 2 is : \n");
//    graph.BFS(2);  
//    logger.info("\n");
//    
    
  
    
//    logger.info("DFS from node 2 is : \n");
//    graph.DFS(2);  
//    logger.info("\n");
//    
//    Graph g = new Graph(4); 
//    
//    g.addEdge(0, 1); 
//    g.addEdge(0, 2); 
//    g.addEdge(1, 2); 
//    g.addEdge(2, 0); 
//    g.addEdge(2, 3); 
//    g.addEdge(3, 3); 
//
//    System.out.println("Following is Breadth First Traversal "+ 
//                       "(starting from vertex 2 for graph 2)"); 
//    
//    g.BFS(2);  
//    
//    System.out.println("Following is Depth First Traversal "+ 
//            "(starting from vertex 2)"); 
//
//    g.DFS(2); 
  }
}
