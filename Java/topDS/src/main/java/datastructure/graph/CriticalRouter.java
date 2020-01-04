package datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Articulation point or cut vertices in a graph
 *
 * @author krish.mahajan@ibm.com
 */
public class CriticalRouter {

  int V;
  Map<Integer, List<Edge>> adjList = new HashMap<>();

  // Add critical Network in a graph
  CriticalRouter(int V) {
    this.V = V;
    for (int i = 0; i < V; i++) {
      adjList.put(i, new ArrayList<Edge>());
    }
  }

  // Add Edge in a Graph
  public void addEdge(int n1, int n2, int weight) {
    Node node1 = new Node(n1);
    Node node2 = new Node(n2);
    this.adjList.get(n1).add(new Edge(node1, node2, weight));
  }

  private void initializeVisited(Map<Integer, Boolean> visited) {
    // initialize visited as false for all vertex
    for (int i = 0; i < this.V; i++) {
      visited.put(i, false);
    }
  }



  // One by One mark each vertex as visited and check no of connected component
  // in rest of the graph
  public List<Integer> criticalRouter() {
    List<Integer> cv = new ArrayList<>();
    Map<Integer, Boolean> visited = new HashMap<>();
    this.initializeVisited(visited);

    // Now mark visited as true for each vertex(i,e remove the vertex) and
    // check if no of connected components comes out more than 1
    // initialize visited as false for all vertex after the call
    for (int i = 0; i < this.V; i++) {
      visited.put(i, true);
      if (noOfconnectedComponent(visited) > 1) {
        System.out.println(i + ":is a cut vertex");
        cv.add(i);
      }
      this.initializeVisited(visited);
    }

    return cv;
  }


  // find no of connectedComponents using DFS
  public int noOfconnectedComponent(Map<Integer, Boolean> visited) {

    int noOfComponents = 0;

    // Loop through all the possible vertices which are not visited.
    for (int i = 0; i < V; i++) {

      if (!visited.get(i)) {
        // Remove this vertex from the graph to check if we get more than one connected graph
        connectedComponentsDFS(i, visited);
        ++noOfComponents;
      }
    }
    return noOfComponents;
  }



  // Initial call to DFS
  private void connectedComponentsDFS(int vertex, Map<Integer, Boolean> visited) {

    Stack<Integer> stack = new Stack<>();

    // Start DFS on the given vertex
    stack.add(vertex);
    while (!stack.isEmpty()) {
      int nodeIndex = stack.pop();
      if (!visited.get(nodeIndex)) {
        // connectedComponentsDFSUtil(visited,stack,nodeIndex);

        visited.put(nodeIndex, true);
        // Now Loop through adjList of NodeIndex
        for (Edge e : this.adjList.get(nodeIndex)) {
          int neighbourNodeIndex = e.n2.index;
          if (!visited.get(neighbourNodeIndex)) {
            stack.add(neighbourNodeIndex);
          }
        }
      }
    }
  }

  // DFS Util Method
  private void connectedComponentsDFSUtil(
      Map<Integer, Boolean> visited, Stack<Integer> stack, int nodeIndex) {

    visited.put(nodeIndex, true);

    // Now Loop through adjList of NodeIndex
    for (Edge e : this.adjList.get(nodeIndex)) {
      int neighbourNodeIndex = e.n2.index;
      if (!visited.get(neighbourNodeIndex)) {
        stack.add(neighbourNodeIndex);
        connectedComponentsDFSUtil(visited, stack, neighbourNodeIndex);
      }
    }
  }

  /** Class representating simulation of Node of a Graph */
  static class Node {

    int index;

    Node(int index) {
      this.index = index;
    }
  }

  /** Class Representing simulation of Edge of a Grapg */
  static class Edge {

    Node n1;
    Node n2;
    int weight;

    Edge(Node n1, Node n2, int weight) {
      this.n1 = n1;
      this.n2 = n2;
      this.weight = weight;
    }
  }

  public static void main(String[] args) {

    /**
     * CriticalRouterNetwork g = new CriticalRouterNetwork(6); g.addEdge(1, 2, 0); g.addEdge(2, 1,
     * 0);
     *
     * <p>g.addEdge(1, 3, 0); g.addEdge(3, 1, 0);
     *
     * <p>g.addEdge(3, 4, 0); g.addEdge(4, 3, 0);
     *
     * <p>g.addEdge(1, 4, 0); g.addEdge(4, 1, 0);
     *
     * <p>g.addEdge(4, 5, 0); g.addEdge(5, 4, 0);
     *
     * <p>g.addEdge(0, 3, 0); g.addEdge(3, 0, 0);
     */
    CriticalRouter g = new CriticalRouter(4);
    g.addEdge(0, 1, 0);
    g.addEdge(1, 0, 0);

    g.addEdge(1, 2, 0);
    g.addEdge(2, 1, 0);

    g.addEdge(2, 0, 0);
    g.addEdge(0, 2, 0);

    g.addEdge(1, 3, 0);
    g.addEdge(1, 3, 0);

     g.criticalRouter();
    //g.criticalConnection();
  }
}
