
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys


class Node(object):
    '''
    A Python Program to represent adjacency list of the node
    ''' 
    def __init__(self,data:int)-> None: 
        if data is not None:
            self._index:int = data 
        else: print("A node must have data to be created") 


    def get_node_index(self)->int:
        '''
        Return Index of the node
        '''
        if self._index is not None:
            return self._index 
        else:
            print('No such node present yet')
            return None 



class Graph(object):
    '''
    A class to represent a graph.A graph is a list of adjancency lists.
    Size of the list will be the number of the list.
    ''' 
    def __init__(self)-> None:
        '''
        Initializes a new graph object
        '''
        self.adj_list: Dict[int,List[Node]] = {}
       


    def add_undirected_edge(self,src:Node ,dest:Node) -> None: 
        '''
        Add a undirected edge between source node and destination node
        '''
        if src is not None and dest is not None: 
            if src.get_node_index() in self.adj_list.keys():
                self.adj_list[src.get_node_index()].append(dest)
            else: 
                self.adj_list[src.get_node_index()] = [dest]  

            if dest.get_node_index() in self.adj_list.keys():
                self.adj_list[dest.get_node_index()].append(src)
            else: 
                self.adj_list[dest.get_node_index()] = [src]  

    
    def add_directed_edge(self,src:Node ,dest:Node) -> None:
        '''
        Add a directed edge between source node and destination node
        ''' 
        if src is not None and dest is not None: 
            if src.get_node_index() in self.adj_list.keys():
                self.adj_list[src.get_node_index()].append(dest)
            else: 
                self.adj_list[src.get_node_index()] = [dest]   


    def print_graph(self) -> None:
        '''
        Function to print current status of the project
        ''' 
        for node_index in self.adj_list.keys():
            neighbor_nodes:List[int] = [neighbor_node.get_node_index() for neighbor_node in self.adj_list[node_index]]
            print('Node : {} has following neighbor nodes {}'.format(node_index , neighbor_nodes)) 


            





    





