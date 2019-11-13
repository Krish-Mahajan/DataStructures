
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
   * Adds an edge to an Undirected graph
   * @param src
   * @param dest
   */
  public void addEdgeUndirected(int src, int dest) {

    // Add an edge from src to des
    this.adjListArray[src].add(dest); 
    
    // Add an edge from des to src
    this.adjListArray[dest].add(src);

  }
  
  /**
   * Adds an edge to a directed graph
   * @param src
   * @param dest
   */
  public void addEdgeDirected(int src, int dest) {

    // Add an edge from src to des
    this.adjListArray[src].add(dest);

  }

  /**
   * A utility function to print the adjacency list representation of Graph
   */
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
   * REMEMBER
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
   * REMEMBER 
   * Depth First Traversal of a graph along with Cycle Detection
   * @param startNode
   */
  public void DFS(int startNode){
	  
	  // Create a stack for DFS
	  Stack<Integer> stack = new Stack<Integer>();
	  
	  //create a boolean array of visited nodes
	  boolean[] visited = new boolean[this.V];
	  
	  //Stack up the current node
	  stack.push(startNode);
	  
	  while(!stack.isEmpty()) {
		  int node = stack.pop();
		  if(!visited[node]) {
			  visited[node] = true;
			  System.out.println(node + " ");
			  LinkedList<Integer> nodeLL = this.adjListArray[node];
			  for(int neighbour : nodeLL) {
				  if(!visited[neighbour]) stack.push(neighbour);
					 else {
						 System.out.println(node + "---->" + neighbour); 
					 }
			  }
		  }
	  }
  }
  
  
  /**
   * REMEMBER
   * Topological sort DFS way
   * Time complexity O(V + E)
   */
  public void topologicalSort() {
	  Stack<Integer> stack = new Stack<Integer>();
	  
	  // All vertices initially are non Visited 
	  boolean[] visited = new boolean[this.V];
	  
	  //call the recursive helper function to store
	  // Topological sort starting from all vertices
	  // one by one
	  for(int i=0 ; i < this.V ; i++) {
		 if(!visited[i])topoSortUtil(i,stack,visited);
	 }
	  
	  while(!stack.isEmpty()) {
		  System.out.print(stack.pop() + " ");
	  }
       
  }
  
  private void topoSortUtil(int vertex , Stack<Integer> stack ,boolean[] visited) {
	  // mark the current vertex as visited 
	  visited[vertex] = true;
	  LinkedList<Integer> vertexLL = this.adjListArray[vertex];
	  for(Integer neighbour : vertexLL) {
		  if(!visited[neighbour]) topoSortUtil(neighbour, stack, visited);
	  }
	  
	  //push the current vertex to stack 
	  stack.push(vertex);
  }
  
   
}
