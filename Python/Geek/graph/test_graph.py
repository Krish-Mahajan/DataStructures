
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


    def test_is_directed_graph_cyclic_DFS(self) -> None: 
        g = Graph()
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3) 
        g.add_directed_edge(Node_0, Node_1) 
        g.add_directed_edge(Node_0, Node_2) 
        g.add_directed_edge(Node_1, Node_2) 
       # g.add_directed_edge(Node_2, Node_0) 
        #g.add_directed_edge(Node_2, Node_3) 
        #g.add_directed_edge(Node_3, Node_3)  

        print("Is graph Cyclic :{}".format(g.isDirectedGraphCyclicDFS())) 


    def test_is_undirected_graph_cyclic(self) -> None: 
        g = Graph(3)
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        g.add_undirected_edge(Node_0, Node_1) 
        g.add_undirected_edge(Node_1, Node_2) 
        g.add_undirected_edge(Node_2, Node_0) 
   

        print("Is undirected_graph Cyclic :{}".format(g.is_undirected_graph_cyclic()))

  
    def test_kruskal_mst(self) -> None:
        '''
        g = Graph(4) 
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3 )
        g.add_directed_edge(Node_0, Node_1, 10) 
        g.add_directed_edge(Node_0, Node_2, 6) 
        g.add_directed_edge(Node_0, Node_3, 5) 
        g.add_directed_edge(Node_1, Node_3, 15) 
        g.add_directed_edge(Node_2, Node_3, 4) 
        '''
        graph = Graph(9) 
        Node_0 = Node(0)
        Node_1 = Node(1)
        Node_2 = Node(2)
        Node_3 = Node(3)
        Node_4 = Node(4)
        Node_5 = Node(5)
        Node_6 = Node(6)
        Node_7 = Node(7)
        Node_8 = Node(8)
        graph.add_undirected_edge(Node_0, Node_1, 4) 
        graph.add_undirected_edge(Node_0, Node_7, 8) 
        graph.add_undirected_edge(Node_1, Node_2, 8) 
        graph.add_undirected_edge(Node_1, Node_7, 11) 
        graph.add_undirected_edge(Node_2, Node_3, 7) 
        graph.add_undirected_edge(Node_2, Node_8, 2) 
        graph.add_undirected_edge(Node_2, Node_5, 4) 
        graph.add_undirected_edge(Node_3, Node_4, 9) 
        graph.add_undirected_edge(Node_3, Node_5, 14) 
        graph.add_undirected_edge(Node_4, Node_5, 10) 
        graph.add_undirected_edge(Node_5, Node_6, 2) 
        graph.add_undirected_edge(Node_6, Node_7, 1) 
        graph.add_undirected_edge(Node_6, Node_8, 6) 
        graph.add_undirected_edge(Node_7, Node_8, 7) 
        graph.kruskal_mst()
             


if __name__ == "__main__": 
    #unittest.main()
    test = GraphTestCase()
    #test.test_graph_insertion()
    #test.test_graph_BFS()
    #test.test_graph_DFS() 
    #test.test_graph_topo_sort()
    #test.test_shortest_path_given_vertex_DAG() 
    #test.test_longest_path_given_vertex_DAG()
    #test.test_is_directed_graph_cyclic_DFS()
    #test.test_is_undirected_graph_cyclic() 
    test.test_kruskal_mst()


