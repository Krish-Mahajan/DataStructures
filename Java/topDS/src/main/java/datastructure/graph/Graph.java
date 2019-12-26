package datastructure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
        logger.debug("Node visited is :" + index);
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
	        logger.debug("Node visited is :" + index);
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
  
  //Detect cycle in undirected graph using DFS
  public boolean detectCycleUndirectedGraphDFS() {
	  Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
	  //Initialize recStack,visited to false
	  for(int i=0;i<this.V ; i++) {
		  visited.put(i, false);
	  }
	  
	  for(Integer nodeIndex :this.adjList.keySet()) {
		  if(!visited.get(nodeIndex)) {
			  if(detectCycleUndirectedGraphDFSUtil(nodeIndex,visited,-1)) {
				  return true;
			  }
		  }
	  }
	  
	  return false;
	  
	  
  }
  
  
  private boolean detectCycleUndirectedGraphDFSUtil(int nodeIndex, Map<Integer,Boolean> visited, int parent ) {
	  
	  visited.put(nodeIndex, true);
	  
	  for(Edge e : this.adjList.get(nodeIndex)) {
		  int neighbourIndex = e.n2.getIndex();
		  if(!visited.get(neighbourIndex)) {
			  if(detectCycleUndirectedGraphDFSUtil(neighbourIndex,visited,nodeIndex)) {
				  return true;
			  }
		  }
		  else if(neighbourIndex !=parent) {
			  return true;
		  }
	  }
	  return false;
	  
  }
  
  
  // Detect cycle in UndirectedGraph using UnionFind
  public boolean detectCyclicUnDirectedGrapUnionFind() {
	  
	  //Subsets
	  Map<Integer,Integer> map_set_nodes = new HashMap<>();
	  
	  Set<Edge> edgeSet = new HashSet<>();
	  Set<Edge> edgesCovered = new HashSet<>();
	  
	  
	  //Initialize all Nodes to single sets  i,e -1
	  //Also create a set of Edge e
	  
	  //
	  for(int i=0 ; i< this.V ; i++) {
		  map_set_nodes.put(i, -1); // -1 indicating all nodes have different sets
		  for(Edge e : this.adjList.get(i)) {
			  edgeSet.add(e);
		  }
	  }
	  
	  //Iterate through all edges of graph , find subset of both vertices of every edge,
	  // if both subsets are same, then there is cycle in graph
	  for(Edge e: edgeSet) {
		  if(!edgesCovered.contains(e)) {
			  edgesCovered.add(e);
			  int set_n1 = this.find_set(map_set_nodes,e.n1.getIndex());
			  int set_n2 = this.find_set(map_set_nodes,e.n2.getIndex());
			  
			  if (set_n1 == set_n2) return true;
			  else this.union_set(map_set_nodes,set_n1,set_n2);
		  }
	  }

	  return false;
  }
  
  
  private int find_set(Map<Integer,Integer> map_set_nodes,int nodeIndex) {
	  if(map_set_nodes.get(nodeIndex) == -1) return nodeIndex;
	  else return this.find_set(map_set_nodes, map_set_nodes.get(nodeIndex));
	 
  } 
  
  
  private void union_set(Map<Integer,Integer> map_set_nodes,int set_n1 , int set_n2) {
	  map_set_nodes.put(set_n1, set_n2);
  }
  
  // topological sorting of DAG
  public Stack<Integer> topologicalSorting(){
	  Stack<Integer> stack = new Stack<Integer>();
	  Map<Integer,Boolean> visited = new HashMap<>();
	  Map<Integer,Boolean> recStack = new HashMap<Integer,Boolean>(); 
	  
	  
	  //Initialize visited to false for every index
	  for(int i =0 ; i < this.V ;i++) {
		  visited.put(i, false);
		  recStack.put(i, false);
	  }
	  
	  for(int i= 0; i< this.V ; i++) {
		  if(!visited.get(i)) {
			  this.topologicalSortUtil(i,visited,stack,recStack);
		  }
	  }
	  
	  
	  return stack;
  }
  
  
  private void topologicalSortUtil(int nodeIndex,Map<Integer,Boolean> visited,Stack<Integer> stack,  Map<Integer,Boolean> recStack) {
	  
	  visited.put(nodeIndex, true);
	  recStack.put(nodeIndex, true);
	  
	  for(  Edge neighbours : this.adjList.get(nodeIndex)) {
		   int neighbour_index = neighbours.n2.getIndex();
		   if(!visited.get(neighbour_index)){
			   this.topologicalSortUtil(neighbour_index, visited, stack, recStack);
		   }
		   else if(recStack.get(neighbour_index)) {
			   System.out.println("Cycle Detected");
			   return ;
		   }
	  }
	  recStack.put(nodeIndex, false);
	  stack.push(nodeIndex);
	  
  }
  
  

  // Print Graph Edge
  public void printGraph() {
    for (int v = 0; v < this.V; v++) {
      logger.debug("Edges passing out of Index v : "  +v);
      List<Edge> edges = this.adjList.get(v);
      for (Edge e : edges) {
        logger.debug( "/t" + e.n2.getIndex() + "---> " + e.n1.getIndex() + "weight :" +
        e.weight);
   
      }
    }
  }
  
  
  // Find shortest distance to every vertex from a given vertex given DAG
  public void shortestDistanceFromVertexDAG(int nodeIndex) {
	  
	  int POSITIVE_INF = 100000; 
	   Map<Integer,Integer>  distance = new HashMap<Integer,Integer>();
	   
	   //Initialize Distance to infinity for all vertex
	   for(int i=0;i< this.V;i++) {
		   distance.put(i,POSITIVE_INF );
	   }
	   
	   //set distance of nodeIndex to 0
	   distance.put(nodeIndex, 0);
	   
	   Stack<Integer> topoSort = this.topologicalSorting();
	   List<Integer> topoSortList = new ArrayList<Integer>();
	   while(!topoSort.isEmpty()) {
		   topoSortList.add(topoSort.pop());
	   }
	   
	   
	   //Loop through all the vertices 
	   for(int node : topoSortList) {
		   for (Edge e : this.adjList.get(node)) {
			    int neighbor_node_index = e.n2.getIndex();
			    int distance_neighbor_node = e.weight;
			    //update the distances
			    if(distance.get(neighbor_node_index) > distance.get(node) + distance_neighbor_node) {
			    	distance.put(neighbor_node_index, distance.get(node) + distance_neighbor_node);
			    }
		   }
	   }
	   
	   
	   //print the distances
	   for(int i= 0;i< this.V;i++) {
		   logger.debug("Distance of Node:" + i +" from NodeIndex : " + nodeIndex + " is :"+ distance.get(i));
	   }
	  
  } 
  
  // Function to check if the given graph is BiPartite using BFS
  public boolean isGraphBipartiteBFS() {
	  List<Integer> queue = new ArrayList<Integer>();
	  Map<Integer,Boolean> visited = new HashMap<>();
	  Map<Integer,String> color = new HashMap<>();
	  
	  //initialize visited as 0 for all nodes and initializing color of every node as gray
	  for(int i =0 ; i < this.V ; i++) {
		  visited.put(i, false);
		  color.put(i, "gray");
	  }
	  
	  //Let's start BFS with Node 0
	  queue.add(0);
	  color.put(0, "red");
	  
	  //BFS
	  while(queue.size() > 0) {
		  int nodeIndex = queue.remove(0);
		  if(!visited.get(nodeIndex)) {
			  visited.put(nodeIndex, true);
			  String color_node =color.get(nodeIndex);
			  
			  //find the neighbour nodes
			  for(Edge e:this.adjList.get(nodeIndex)) {
				  
				  int neighbourNodeIndex = e.n2.getIndex();
				  String color_neighbour = color.get(neighbourNodeIndex);
			  
				  // if both node and neighbour node same color then not a bipartite graph
				  if(color_node.equals(color_neighbour)) return false;

				  if(!visited.get(neighbourNodeIndex)) {
					 queue.add(neighbourNodeIndex);
					 String new_color =color_node.equals("red") ? "blue": "red" ;
					 color.put(neighbourNodeIndex, new_color);
				  }
			  }
		  }
	  }
	  
	  
	  
	  return true;
  } 
  
  //MST for undirected connectef graph
  public void kruskalMST() {
	  
	  Map<Integer,Integer> map_set_nodes = new HashMap<>();
	  
	  List<Edge> resultEdges = new ArrayList<>();
	  List<Edge> allEdges = new ArrayList<>();
	  int e = 0 ; //Index variable used for result resultEdges 
	  
	  //STEP 1 : SORT ALL EDGES IN NIN DECREASING ORDER OF WEIGHT
	  for(int i=0 ; i< this.V ; i++) {
		  map_set_nodes.put(i, -1); // -1 indicating all nodes have different sets
		  for(Edge edge : this.adjList.get(i)) {
			  allEdges.add(edge);
		  }
	  }
	  
	  Collections.sort(allEdges); 
	  
	  int i = 0 ; //counter of resultEdges
	  while (e < this.V -1) {
		  Node n1 = allEdges.get(i).n1;
		  Node n2 = allEdges.get(i).n2;
		  
		
		  
		  int set_n1 = this.find_set(map_set_nodes,n1.getIndex());
		  int set_n2 = this.find_set(map_set_nodes,n2.getIndex()); 
		  
		  if(set_n1  != set_n2) {
			  e = e +1;
			  resultEdges.add(allEdges.get(i));
			  this.union_set(map_set_nodes, set_n1, set_n2);
			  
		  }
		  i = i +1;
		  
	  }
	  
	  Collections.sort(resultEdges); 
	  for(Edge final_edge: resultEdges) { 
		  
		  int n1 = final_edge.n1.getIndex();
		  int n2 = final_edge.n2.getIndex(); 
		  int weight = final_edge.weight;
		  logger.debug("Edge is : " + n1 + " ----> " + n2 + " .weight is : " + weight);
	  }
	  
	  
  } 
  
  //Find no. of connected components in a graph AdjList
  public void connectedComponents() {
	  
	  Map<Integer,Boolean > visited = new HashMap<>();
	  for(int i=0;i < this.V;i++) {
		  visited.put(i, false);		  
	  }
	  
	  
	  
	  
	  for(int i=0 ;i < this.V;i++) {
		  for(Edge e : this.adjList.get(i)) {
			  Node n1 = e.n1;
			  if(!visited.get(n1.index)) {
				  this.connectedComponentsDFSUtil(visited,n1);
			  System.out.println(" ");
		  }
			  
	  }
	  }
	  
  }

  private void connectedComponentsDFSUtil(Map<Integer, Boolean> visited,Node n1){
	 
	  visited.put(n1.index, true);
	  System.out.print(n1.index + " ");
	  for(Edge e: this.adjList.get(n1.index)) {
		  Node neighbour_node = e.n2;
		  if(!visited.get(neighbour_node.index)) {
			  this.connectedComponentsDFSUtil(visited, neighbour_node);
		  }
	  }
}

// Node class
  static class Node {

    private int index;
    private String color ;
    Node(int index) {
      this.index = index;
    }
    
    private void setColor(String color) {
    	this.color = color;
    }

    private int getIndex() {
      return this.index;
    }
  }

  // Edge class
  static class Edge implements Comparable<Edge>{

    private Node n1;
    private Node n2;
    private int weight;

    Edge(Node n1, Node n2, int weight) {
      this.n1 = n1;
      this.n2 = n2;
      this.weight = weight;
    }

  @Override
  public int compareTo(Edge compareEdge) {
    return this.weight - compareEdge.weight;
  }
  }
}
