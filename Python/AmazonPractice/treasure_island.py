
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math 



class Node(object) :
    def __init__(self,index:str , data:str) -> None:
        self.index = index
        self.data = data  
        self.dist = 0


    def get_node_index(self) -> str:
        return self.index


class Graph(object) : 
    '''
    A class to represent a graph.A graph is a list of adjancency lists.
    Size of the list will be the number of the list.
    ''' 
    def __init__(self,V:int=None)-> None:
        '''
        Initializes a new graph object
        '''
        self.adj_list: Dict[str,List[Node]] = {}
        self.V = V
    

def create_graph_adj_list(mat:List[List[str]],node_map: Dict[str,Node]) -> Dict[str,List[Node]]:

    total_rows:int = len(mat) 
    total_column_each_row = len(mat[0]) 

    g : Graph = Graph(len(mat)*len(mat[0]))  
    
    '''
    node_map: Dict[str,Node]= {}

    #Create Node out of every mat entry:
    for row_index in range(len(mat)):
            for col_index in range(len(mat[row_index])): 
                index:str = str(row_index)+str(col_index)
                n : Node = Node(index,mat[row_index][col_index]) 
                node_map[index] = n 
    '''

    #Create adj_list_representation out of the matrix
    for row_index in range(len(mat)):
        for col_index in range(len(mat[row_index])): 
            index = str(row_index)+str(col_index)
            n= node_map[index]
            neighbour_nodes:List[Node] = find_neighbor_nodes(node_map,row_index,col_index,total_rows,total_column_each_row)
            if index not in g.adj_list:
                g.adj_list[index] = neighbour_nodes


    return g.adj_list 


def create_map_of_nodes(mat:List[List[str]]) -> Dict[str,Node]:
    node_map: Dict[str,Node]= {}

    #Create Node out of every mat entry:
    for row_index in range(len(mat)):
            for col_index in range(len(mat[row_index])): 
                index:str = str(row_index)+str(col_index)
                n : Node = Node(index,mat[row_index][col_index]) 
                node_map[index] = n  

    return node_map


def BFS(start_node:Node,adj_list:Dict[str,List[Node]]) -> int:

    '''
    Breadth First Traversal of Graph
    '''

    count :int = 0
    if start_node is not None: 

        visited : Dict[str,bool] = {}
        for node_index in adj_list:
            visited[node_index] = False

        start_node.dist = 0
        queue : List[Node] = [start_node] 


        while len(queue) > 0:
            node : Node = queue.pop(0)
            if node.data == 'X':
                count = node.dist
                break
            if visited[node.get_node_index()] !=True:
                visited[node.get_node_index()] = True
                print('Node visited is :{}'.format(node.get_node_index()))
                neighbor_nodes:List[Node] =adj_list[node.get_node_index()] 
                for neighbor_node in neighbor_nodes:
                    if visited[neighbor_node.get_node_index()] !=True:
                        neighbor_node.dist = node.dist + 1
                        queue.append(neighbor_node) 

    return count


def find_neighbor_nodes(node_map:Dict[str,Node],row_index:int,col_index:int,total_rows:int,total_column_each_row:int) -> List[Node]: 

    neighbour_nodes : List[Node] = []

    #look ahead 
    if col_index < total_column_each_row -1:
        n:Node = node_map.get(str(row_index)+str(col_index+1))
        if n.data !='D':
            neighbour_nodes.append(n)

    #look behind 
    if col_index > 0:
        n= node_map.get(str(row_index)+str(col_index-1))
        if n.data !='D':
            neighbour_nodes.append(n)



    #look down
    if row_index < total_rows -1 :
         n = node_map.get(str(row_index+1)+str(col_index))
         if n.data !='D':
            neighbour_nodes.append(n)



    #look up 
    if row_index > 0 :
        n = node_map.get(str(row_index-1)+str(col_index))
        if n.data !='D':
            neighbour_nodes.append(n)

    return neighbour_nodes 


def find_minimum_nodes(mat:List[List[str]]) -> int:
    node_map: Dict[str,Node] = create_map_of_nodes(mat)
    adj_list:  Dict[str,List[Node]] = create_graph_adj_list(mat,node_map) 
    return BFS(node_map['00'],adj_list)













if __name__ == "__main__":  

    mat = [['O', 'O', 'O', 'O'],
          ['D', 'O', 'D', 'O'],
          ['O', 'O', 'O', 'O'],
          ['X', 'D', 'D', 'O']]

    print(find_minimum_nodes(mat))