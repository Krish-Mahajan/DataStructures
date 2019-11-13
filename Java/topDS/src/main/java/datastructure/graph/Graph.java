package datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Graph {

  // Logger for the file
  static final Logger logger = Logger.getLogger(Graph.class.getName());

  // Declare Variables

  private int V; // No of vertices

  private Map<Integer, List<Edge>> adjList; // adjList of the graph

  Graph(int V) {
    this.V = V; // Total vertices in the Graph
    this.adjList = new HashMap<>();
    
    for (int i = 0; i < V; i++) { // All possible nodes are initialized with empty edges
      this.adjList.put(i, new ArrayList<Edge>());
    }
  }

  // Add Edge to the graph
  public void addEdge(int v1, int v2, int weight) {
    if (v1 < this.V && v2 < this.V) {
      Node n1 = new Node(v1);
      Node n2 = new Node(v2);
      this.adjList.get(n1.getIndex()).add(new Edge(n1, n2, weight));

    }
  }

  // BFS of graph Time O(V+E)
  public void BFS(int startNodeIndex) {
    List<Integer> queue = new ArrayList<Integer>();
    Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

    // Initialize visited to false for every vertex
    for (int node_index : this.adjList.keySet()) {
      visited.put(node_index, false);
    }

    queue.add(startNodeIndex);
    visited.put(startNodeIndex, false);

    while (!queue.isEmpty()) {
      int index = queue.remove(0);
      if (!visited.get(index)) {
        visited.put(index, true);
        System.out.println("Node visited is :" + index);
        List<Edge> indexEdges = this.adjList.get(index);
        for (Edge e : indexEdges) {
          if (!visited.get(e.n2.getIndex())) {
            queue.add(e.n2.getIndex());
          }
        }
      }
    }
  } 
  
  // Depth First traversal of the graph Time 0(V+E)
  public void DFS(int startNodeIndex) {
	 
	    List<Integer> stack = new ArrayList<Integer>();
	    Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

	    // Initialize visited to false for every vertex
	    for (int node_index : this.adjList.keySet()) {
	      visited.put(node_index, false);
	    }

	    stack.add(startNodeIndex);
	    visited.put(startNodeIndex, false);

	    while (!stack.isEmpty()) {
	      int index = stack.remove(stack.size()-1);
	      if (!visited.get(index)) {
	        visited.put(index, true);
	        System.out.println("Node visited is :" + index);
	        List<Edge> indexEdges = this.adjList.get(index);
	        for (Edge e : indexEdges) {
	          if (!visited.get(e.n2.getIndex())) {
	            stack.add(e.n2.getIndex());
	          }
	        }
	      }
	    }
	 
	  
  }
  
  
  //Detect cycle Directed Graph using DFS 0(V+E)
  public boolean detectCyclicDirectedGraphDFS() {
	  Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
	  Map<Integer,Boolean> recStack = new HashMap<Integer,Boolean>(); 
	  
	  
	  //Initialize recStack,visited to false
	  for(int i=0;i<this.V ; i++) {
		  visited.put(i, false);
		  recStack.put(i, false);
	  }
	  
	  for(Integer nodeIndex :this.adjList.keySet()) {
		  if(!visited.get(nodeIndex)) {
			  if(detectCyclicDirectedGraphDFSUtil(nodeIndex,visited,recStack)) {
				  return true;
			  }
		  }
	  }
	  
	  return false;
  } 
  
  
  private boolean detectCyclicDirectedGraphDFSUtil(int nodeIndex, Map<Integer,Boolean> visited, Map<Integer,Boolean> recStack) {
	  
	  visited.put(nodeIndex, true);
	  recStack.put(nodeIndex, true);
	  
	  for(Edge e : this.adjList.get(nodeIndex)) {
		  int neighbourIndex = e.n2.getIndex();
		  if(!visited.get(neighbourIndex)) {
			  if(detectCyclicDirectedGraphDFSUtil(neighbourIndex,visited,recStack)) {
				  return true;
			  }
		  }
		  else if(recStack.get(neighbourIndex)) {
			  return true;
		  }
	  }
	  recStack.put(nodeIndex, false);
	  return false;
  }
  
  

  // Print Graph Edge
  public void printGraph() {
    for (int v = 0; v < this.V; v++) {
      // logger.debug("Edges passing out of Index v : "  +v);
      System.out.println("Edges passing out of Index v : " + v);
      List<Edge> edges = this.adjList.get(v);
      for (Edge e : edges) {
        // logger.debug( "/t" + e.n2.getIndex() + "---> " + e.n1.getIndex() + "weight :" +
        // e.weight);
        System.out.println(e.n1.getIndex() + "---> " + e.n2.getIndex() + "weight :" + e.weight);
      }
    }
  }

  // Node class
  static class Node {

    private int index;

    Node(int index) {
      this.index = index;
    }

    private int getIndex() {
      return this.index;
    }
  }

  // Edge class
  static class Edge {

    private Node n1;
    private Node n2;
    private int weight;

    Edge(Node n1, Node n2, int weight) {
      this.n1 = n1;
      this.n2 = n2;
      this.weight = weight;
    }
  }
}
