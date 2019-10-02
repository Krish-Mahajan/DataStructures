
from __future__ import annotations
import unittest
from typing import List, Set, Dict, Tuple, Optional
import random  

from graph import Graph,Node 

class GraphTestCase(unittest.TestCase):
    '''
    Unit test for Graph
    ''' 

    def test_graph_insertion(self)-> None:
        print('Adding nodes in Graph') 
        graph = Graph() 
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3)
        Node_4 = Node(4)
        graph.add_undirected_edge(Node_0, Node_1) 
        graph.add_undirected_edge(Node_0, Node_4) 
        graph.add_undirected_edge(Node_1, Node_2) 
        graph.add_undirected_edge(Node_1, Node_3) 
        graph.add_undirected_edge(Node_1, Node_4)
        graph.add_undirected_edge(Node_2, Node_3)
        graph.add_undirected_edge(Node_3, Node_4) 
        graph.print_graph()  


    def test_graph_BFS(self)-> None:  
        graph = Graph() 
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3)
        graph.add_directed_edge(Node_0, Node_1) 
        graph.add_directed_edge(Node_0, Node_2) 
        graph.add_directed_edge(Node_1, Node_2) 
        graph.add_directed_edge(Node_2, Node_0)
        graph.add_directed_edge(Node_2, Node_3)
        graph.add_directed_edge(Node_3, Node_3) 
        graph.BFS(Node_2) 


    def test_graph_DFS(self)-> None:  
        graph = Graph() 
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3)
        graph.add_directed_edge(Node_0, Node_1) 
        graph.add_directed_edge(Node_0, Node_2) 
        graph.add_directed_edge(Node_1, Node_2) 
        graph.add_directed_edge(Node_2, Node_0)
        graph.add_directed_edge(Node_2, Node_3)
        graph.add_directed_edge(Node_3, Node_3) 
        graph.DFS(Node_2) 


    def test_graph_topo_sort(self) -> None:
        graph = Graph() 
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3) 
        Node_4 = Node(4)
        Node_5 = Node(5)
        graph.add_directed_edge(Node_5, Node_2) 
        graph.add_directed_edge(Node_5, Node_0) 
        graph.add_directed_edge(Node_4, Node_0) 
        graph.add_directed_edge(Node_4, Node_1)
        graph.add_directed_edge(Node_2, Node_3)
        graph.add_directed_edge(Node_3, Node_1) 
        graph.topological_sort()    


    def test_shortest_path_given_vertex_DAG(self) -> None: 
        graph = Graph()
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3) 
        Node_4 = Node(4)
        Node_5 = Node(5)
        Node_6 = Node(6)
        graph.add_directed_edge(Node_0, Node_1,5) 
        graph.add_directed_edge(Node_0, Node_2,3) 
        graph.add_directed_edge(Node_1, Node_3,6) 
        graph.add_directed_edge(Node_1, Node_2,2)
        graph.add_directed_edge(Node_2, Node_4,4)
        graph.add_directed_edge(Node_2, Node_5,2) 
        graph.add_directed_edge(Node_2, Node_5,2)
        graph.add_directed_edge(Node_2, Node_3,7)
        graph.add_directed_edge(Node_3, Node_4,-1)
        graph.add_directed_edge(Node_4, Node_5,-2)

        graph.shortest_path_given_vertex_DAG(Node_1) 


    def test_longest_path_given_vertex_DAG(self) -> None: 
        graph = Graph()
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3) 
        Node_4 = Node(4)
        Node_5 = Node(5)
        Node_6 = Node(6)
        graph.add_directed_edge(Node_0, Node_1,5) 
        graph.add_directed_edge(Node_0, Node_2,3) 
        graph.add_directed_edge(Node_1, Node_3,6) 
        graph.add_directed_edge(Node_1, Node_2,2)
        graph.add_directed_edge(Node_2, Node_4,4)
        graph.add_directed_edge(Node_2, Node_5,2) 
        graph.add_directed_edge(Node_2, Node_5,2)
        graph.add_directed_edge(Node_2, Node_3,7)
        graph.add_directed_edge(Node_3, Node_4,-1)
        graph.add_directed_edge(Node_4, Node_5,-2)
        
        graph.longest_path_given_vertex_DAG(Node_1)

             


if __name__ == "__main__": 
    #unittest.main()
    test = GraphTestCase()
    #test.test_graph_insertion()
    #test.test_graph_BFS()
    #test.test_graph_DFS() 
    #test.test_graph_topo_sort()
    test.test_shortest_path_given_vertex_DAG() 
    test.test_longest_path_given_vertex_DAG()

