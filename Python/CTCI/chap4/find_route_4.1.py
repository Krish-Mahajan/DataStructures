

from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys 
import random , unittest


class Node(object): 

    def __init__(self,index:int,weight:int=None) :
        if index is not None:
            self.__index = index 
            if weight is not None:
                self.__weight = weight 

    def get_index(self) -> int:
        return self.__index 


    def get_weight(self) -> int:
        return self.__weight 


class Graph(object):

    def __init__(self) -> None:
        self.adj_list : Dict[int,List[Node]] = {}  


    def add_directed_edge(self,index1:int,index2:int,weight:int=None) -> None: 
        if index1 is not None and index2 is not None:
            if index1 not in self.adj_list:
                self.adj_list[index1] = [Node(index2,weight)] 
            else:
                self.adj_list[index1].append(Node(index2,weight)) 
            if index2  not in self.adj_list:
                self.adj_list[index2] = [] 

    #Function to check if path existing between two nodes
    def BFS(self, index1:int , index2:int) -> bool: 
        if index1 in self.adj_list and index2 in self.adj_list :
            queue:List[int] = [] 

            #Assuming List index is 0 - n range
            visited : List[bool] = [False]*len(self.adj_list) 
            
            queue.append(index1) 
            while len(queue) > 0:
                index:int = queue.pop(0)
                if visited[index] != False:
                    visited[index] = True
                    print('Node visited is :{}'.format(index))
                    neighbour_nodes : List[Node] = self.adj_list[index]
                    for node in neighbour_nodes :
                        if node.get_index() == index2:
                            return True
                        if visited[node.get_index()] == False:
                            queue.append(node.get_index())

        return False 


    #Function to check if path existing between two nodes
    def DFS(self,index1:int, index2:int) -> bool:
        if index1 in self.adj_list and index2 in self.adj_list :
            stack:List[int] = [] 

            #Assuming List index is 0 - n range
            visited : List[bool] = [False]*len(self.adj_list) 
            
            stack.append(index1) 
            while len(stack) > 0:
                index:int = stack.pop()
                if visited[index] != False:
                    visited[index] = True
                    print('Node visited is :{}'.format(index))
                    neighbour_nodes : List[Node] = self.adj_list[index]
                    for node in neighbour_nodes :
                        if node.get_index() == index2:
                            return True
                        if visited[node.get_index()] == False:
                            stack.append(node.get_index()) 

        return False





