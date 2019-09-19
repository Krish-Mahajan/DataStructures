
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
                
            if dest.get_node_index() not in self.adj_list.keys():
                self.adj_list[dest.get_node_index()] = []
                


    def print_graph(self) -> None:
        '''
        Function to print current status of the project
        ''' 
        for node_index in self.adj_list.keys():
            neighbor_nodes:List[int] = [neighbor_node.get_node_index() for neighbor_node in self.adj_list[node_index]]
            print('Node : {} has following neighbor nodes {}'.format(node_index , neighbor_nodes))  


    def BFS(self,start_node:Node)-> None: 
        '''
        Breadth First Traversal of Graph
        '''
        if start_node is not None:
            queue : List[Node] = [start_node] 
            visited : List[bool]= [False]*len(self.adj_list)

            while len(queue) > 0:
                node : Node = queue.pop(0)
                if visited[node.get_node_index()] !=True:
                    visited[node.get_node_index()] = True
                    print('Node visited is :{}'.format(node.get_node_index()))
                    neighbor_nodes:List[Node] = self.adj_list[node.get_node_index()] 
                    for neighbor_node in neighbor_nodes:
                        if visited[neighbor_node.get_node_index()] !=True:
                            queue.append(neighbor_node) 



    def DFS(self , start_node:Node) -> None: 
        '''
        Depth first traversal of Tree
        ''' 
        if start_node is not None:
            stack : List[Node] =[start_node]
            visited : List[bool] = [False]*len(self.adj_list) 
            while len(stack) > 0:
                cur_node :Node = stack.pop()
                if visited[cur_node.get_node_index()] !=True:
                    visited[cur_node.get_node_index()] = True
                    print('Node visited is :{}'.format(cur_node.get_node_index()))
                    neighbor_nodes:List[Node] = self.adj_list[cur_node.get_node_index()] 
                    for neighbor_node in neighbor_nodes:
                        if visited[neighbor_node.get_node_index()] !=True:
                            stack.append(neighbor_node)  

    def topological_sort(self) -> None:
        '''
        Topological sort of DAG
        '''
        visited : List[bool] = [False]*len(self.adj_list)  
        stack : List[int] =[]

        for cur_node_index in  self.adj_list.keys():
            if visited[cur_node_index] !=True:
                self._topo_sort_util(stack,visited,cur_node_index) 

        print("Topological sorting of the graph is")
        while len(stack) >0:
            print(stack.pop() , end = " ") 


    def _topo_sort_util(self, stack:List[int],visited:List[bool],cur_node_index:int) -> None:
        visited[cur_node_index] = True 
        neighbor_nodes:List[Node] = self.adj_list[cur_node_index] 
        for neighbor_node in neighbor_nodes:
                if visited[neighbor_node.get_node_index()] !=True:
                    self._topo_sort_util(stack,visited,neighbor_node.get_node_index()) 
    
        stack.append(cur_node_index)






        


            





    





