package datastructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/**
 * Representation of a graph in terms of nodes and Edges.
 * This graph representation is Birectional.
 * @author krish.mahajan@ibm.com
 *
 */
public class BipartiteGraph { 
	
	private LinkedList<Node>[] adjList;
	private boolean[] visited;
	private int V;
	private Set<Edge> graphEdges;
	private Map<Integer,Node> graphNodes;
	
	@SuppressWarnings("unchecked")
  public BipartiteGraph(int v) {
		this.V = v;
		graphEdges = new HashSet<Edge>();
		graphNodes = new HashMap<Integer,Node>();
		adjList = (LinkedList<Node>[])new LinkedList<?>[v];
		
		// Initialize the Graph
		for( int i =0 ; i < V ; i++) {
			adjList[i] = new LinkedList<Node>();
		}
	}
	
	/**
	 * Add Bidrectional edge in the graph and update the class parameters
	 * @param weight
	 * @param nodeIndex1
	 * @param nodeIndex2
	 */
	
	public void addEdge(int weight,int nodeIndex1 , int nodeIndex2 ) {
		Node n1 = null;
		Node n2 = null;
		
		// check if node index already present
		if(this.graphNodes.get(nodeIndex1) != null) 
			 n1 = this.graphNodes.get(nodeIndex1);
		
		else  n1 = new Node(nodeIndex1 , "white"); 
			
		
		
		if(this.graphNodes.get(nodeIndex2) != null) 
			 n2 =  this.graphNodes.get(nodeIndex2);
		
		else n2 =  new Node(nodeIndex2 , "white");
			 
		
		
		// Add graph Edges
		Edge e1 = new Edge(weight, n1.getIndex() , n2.getIndex());
		Edge e2 = new Edge(weight, n2.getIndex() , n1.getIndex());
		
		// update the Adj List
		adjList[n1.getIndex()].add(n2);
		adjList[n2.getIndex()].add(n1);
		
		n1.addConnection(e1);
		n2.addConnection(e2); 
		
		//update the class parameters
		this.graphEdges.add(e1);
		this.graphEdges.add(e2);
		
		this.graphNodes.put(nodeIndex1, n1);
		this.graphNodes.put(nodeIndex2, n2);
		
	}
	
	
    /**
     * A utility function to print the adjacency list representation of Graph
     */
    public void printGraph() {

        for(int j=0 ; j < this.adjList.length; j++) {
        	Node n = this.graphNodes.get(j);
        	System.out.println("Adjacency list of vertex " + n.getIndex()); 
    	   for(Node neighbour :this.adjList[j]) {
    		   int neighbour_index = neighbour.getIndex();
    		   Edge neighbour_edge = n.getConnectionInfo(neighbour);
    		   int neighbour_weight = neighbour_edge.getWeight();
        		System.out.print("--->(" + neighbour_index + ",weight: " + neighbour_weight + ")");
        	}
    	   System.out.println("\n");
        }
        }
 	
    /**
     * Inner class presentation of a node
     * @author krish.mahajan@ibm.com
     *
     */
	private class Node{
		private int index;
		private String color;
		private  Set<Edge> connections = new HashSet<Edge>();
		
		Node(int index , String color ){
			this.index = index;
			this.color = color;
		}
		
		public int getIndex() {
			return this.index;
		}
		
		public String getColor() {
			return this.color;
		}
		
		public void setColor(String color) {
			this.color = color;
		}
		
		public void addConnection(Edge edge) {
			this.connections.add(edge);
		}
		
		public Set<Edge> getNodeConnections(){
			return this.connections;
		}
		
		public Edge getConnectionInfo(Node n) {
			for(Edge e : this.connections ) {
				if( e.getEdgeDirection()[0] == this.getIndex() && e.getEdgeDirection()[1] == n.getIndex()) {
					return e;
				}
			}
			
			return null;
		}
		
		
	}
	
	/**
	 * Inner class presentation of an edge of the graph
	 * @author krish.mahajan@ibm.com
	 *
	 */
	private class Edge{ 
		private int weight;
		private int[] edgeDirection;
		
		public Edge(int weight,int startingNodeIndex, int endingNodeIndex) {
			edgeDirection = new int[2];
			this.weight = weight;
			edgeDirection[0] = startingNodeIndex ;
			edgeDirection[1] = endingNodeIndex;
		}
		
		public int getWeight() {
			return this.weight;
		}
		
		public int[] getEdgeDirection() {
			return this.edgeDirection;
		}
		
	}
	
	
	public static void main(String[] args) {
	    BipartiteGraph g = new BipartiteGraph(6); 
        g.addEdge(7,5, 2); 
        g.addEdge(2 ,2, 0); 
        g.addEdge(4 ,4, 0); 
        g.addEdge(5 ,4, 1); 
        g.addEdge(5,2, 3); 
        g.addEdge(4 ,3, 1); 
  
        System.out.println("Following is the given graph"); 
        g.printGraph();
        
        
        System.out.println("BFS of  the given graph from index 0"); 
        g.BFS(0);
        System.out.println("\n"); 
	} 
	
	
	
	/**
	 * BFS on the given graph while marking neighbour with different Color
	 * @param nodeIndex
	 */
	public void BFS(int nodeIndex) {
		
		boolean[] visited = new boolean[this.V];
		Queue<Node> queue = new LinkedList<Node>();
		
	    Node node = this.graphNodes.get(nodeIndex);
	    node.setColor("green");
	    queue.add(node);
	    
	    
	    while(!queue.isEmpty()) {
	    	  node = queue.poll();
	    	  if(!visited[node.getIndex()]) {
	    	  visited[node.getIndex()] = true;
	    	  System.out.print("(" + node.getIndex() + "," + node.getColor() + ")----> ");
	    	  LinkedList<Node> neighbour_node_list = this.adjList[node.getIndex()];
	    	  for(Node neighbour_node : neighbour_node_list) {
	    		  int neighbour_node_index = neighbour_node.getIndex();
	    		  if(!visited[neighbour_node_index]) {
	    			  queue.add(neighbour_node);
	    			  if(node.getColor().equals("green")) neighbour_node.setColor("red");
	    			  if (node.getColor().equals("red"))  neighbour_node.setColor("green");
	    		  }
	    	  }
	    }
		
	}
	
	}
}
