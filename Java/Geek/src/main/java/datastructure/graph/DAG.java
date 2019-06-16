package datastructure.graph;

import java.util.LinkedList;
import java.util.Stack;

public class DAG { 
	
	static final int POSITIVE_INF = 10000;
	static final int NEGATIVE_INF = -10000;
	
    LinkedList<adjListNode>[] adjListArray ;
    int V;
    
    public DAG(int v) {
    	adjListArray = (LinkedList<adjListNode>[])new LinkedList<?>[v];
    	this.V = v;
    	for(int i = 0 ; i < this.V ; ++i) {
    		adjListArray[i] = new LinkedList<adjListNode>();
    	}
    	
    }
    
    
    /**
     * Add Edge in a DAG
     * @param u
     * @param v
     * @param weight
     */
    public void addEdge(int u , int v ,int weight) {
    	adjListNode destNode = new adjListNode(v, weight);
    	this.adjListArray[u].add(destNode);
    } 
    
    
    /**
     * A utility function to print the adjacency list representation of Graph
     */
    public void printGraph() {

      for (int v = 0; v < this.V; v++) {
        System.out.println("Adjacency list of vertex " + v);
        System.out.print("head");
        for (adjListNode pCrawl : this.adjListArray[v]) {
          System.out.print("---> " + pCrawl.getV() + " , weight: " + pCrawl.getWeight());
        }
        System.out.println("\n");
      }
    }
    
    /**
     * Topological sort of DAG
     */
    public Stack<Integer> topoLogicalSort() {
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean[] visited = new boolean[this.V];
    	for(int i = 0 ; i < this.V ; i++) {
    		if(!visited[i]) topoLogicalSortUtil(stack , visited , i);
    		
    	}

    	return stack;
    }
    
    
	private void topoLogicalSortUtil(Stack<Integer> stack, boolean[] visited, int vertex) {
       
		// mark the current vertex as visited
		visited[vertex] = true;
		
		LinkedList<adjListNode> vertexLL = this.adjListArray[vertex];
		for(adjListNode vertexNeighbour : vertexLL) {
			if(!visited[vertexNeighbour.getV()]) topoLogicalSortUtil(stack, visited ,vertexNeighbour.getV() );
		}
		
		// push the current vertex to stack;
		stack.push(vertex);
    
  }
	
  /** REMEMBER
   * Find the shortest path to each vertex given current vertex
   * Using Topo Sort O(V+E)
   * @param v
   */
   public void shortestPathGivenVertex(int v) {
	   
	   //initialize all distances to INF
	   int[] dist = new int[this.V];
	   for(int i=0 ; i < V ; i++) {
		   dist[i] = this.POSITIVE_INF;
	   }
	   
	  dist[v] = 0;
	  
	  //process TopologicalSort
	  Stack<Integer> stack = this.topoLogicalSort();
	  
	  
	  
	  //update the shortest distances
	  while(!stack.isEmpty()) {
		  int node = stack.pop();
		  System.out.println("Processing node: " + node);
		  LinkedList<adjListNode> nodeLL = this.adjListArray[node];
		  for(adjListNode neighbour : nodeLL) {
			  if(dist[neighbour.getV()] > dist[node] + neighbour.getWeight()) {
				  dist[neighbour.getV()] = dist[node] + neighbour.getWeight();
			  }
		  }
	  }

	  for(int i : dist) {
		  System.out.print(i + " ");
	  }
   } 
   
   
   /** REMEMBER
    * Find the longest path to each vertex given current vertex 
    * Using Topo Sort O(V+E)
    * @param v
    */
    public void longestPathGivenVertex(int v) {
 	   
 	   //initialize all distances to INF
 	   int[] dist = new int[this.V];
 	   for(int i=0 ; i < V ; i++) {
 		   dist[i] = this.NEGATIVE_INF;
 	   }
 	   
 	  dist[v] = 0;
 	  
 	  //process TopologicalSort
 	  Stack<Integer> stack = this.topoLogicalSort();
 	  
 	  
 	  
 	  //update the shortest distances
 	  while(!stack.isEmpty()) {
 		  Integer node = stack.pop();
 		  System.out.println("Processing node: " + node);
 		  LinkedList<adjListNode> nodeLL = this.adjListArray[node];
 		  for(adjListNode neighbour : nodeLL) {
 			  if(dist[neighbour.getV()] < dist[node] + neighbour.getWeight()) {
 				  dist[neighbour.getV()] = dist[node] + neighbour.getWeight();
 			  }
 		  }
 	  }
 	  
 	  for(int i : dist) {
 		  System.out.print(i + " ");
 	  }
    }



  // inner class to define adjListNode
	class adjListNode{
		private int v;
		private int weight ;
		
		public adjListNode(int v , int weight) {
			this.v = v;
			this.weight = weight ;
		}
		
		public int getV() {
			return this.v;
		}
		
		
		public int getWeight(){
			return this.weight;
		}
		
		
		
	} 
	
	
	  public static void main(String args[]) 
	    { 
	        // Create a graph given in the above diagram.  Here vertex 
	        // numbers are 0, 1, 2, 3, 4, 5 with following mappings: 
	        // 0=r, 1=s, 2=t, 3=x, 4=y, 5=z 
		  DAG g = new DAG(6);  
	        g.addEdge(0, 1, 5); 
	        g.addEdge(0, 2, 3); 
	        g.addEdge(1, 3, 6); 
	        g.addEdge(1, 2, 2); 
	        g.addEdge(2, 4, 4); 
	        g.addEdge(2, 5, 2); 
	        g.addEdge(2, 3, 7); 
	        g.addEdge(3, 4, -1); 
	        g.addEdge(4, 5, -2); 
	        g.addEdge(3, 5, 1);
	  
	        int s = 1; 
	        System.out.println("Following are shortest distances "+ 
	                            "from source " + s ); 
	        g.shortestPathGivenVertex(s); 
	        System.out.println("\n" ); 
	        
	        System.out.println("Following are longest distances "+ 
                    "from source " + s ); 
            g.longestPathGivenVertex(s); 
	    }
	
	
}
