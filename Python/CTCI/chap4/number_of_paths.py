

from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys 


class Node(object):

    def __init__(self, data:int) -> None:
        if data is not None:
            self.__data = data
            self.__left_child_node : Node = None
            self.__right_child_node : Node = None

    def get_node_data(self) -> int:
        return self.__data  


    def get_left_child_node(self) -> Node:
        return self.__left_child_node 


    def get_right_child_node(self) -> Node:
        return self.__right_child_node 


    def set_right_child_node(self,node_data:int) -> None: 
        if node_data is not None:
            self.__right_child_node = Node(node_data) 


    def set_left_child_node(self,node_data:int) -> None: 
        if node_data is not None:
            self.__left_child_node = Node(node_data)



class BST(object):

    def __init__(self,root_data:int=None)-> None:
        if root_data is not None:
            self.__root:Node = Node(root_data)
        else:
            self.__root = None  


    def get_root(self)-> Node:
        return self.__root


    def insert(self,node_data:int = None) -> None:
        if self.__root == None: 
            self.__root = Node(node_data)
        else:
            self.__insert_help(self.__root , node_data)  


    def __insert_help(self,node:Node,node_data:int) -> None:
        if node is not None:
            if node.get_node_data() >= node_data :
                if node.get_left_child_node() is not None:
                    self.__insert_help(node.get_left_child_node(),node_data) 

                else:
                    node.set_left_child_node(node_data) 

            else:
                if node.get_right_child_node() is not None:
                    self.__insert_help(node.get_right_child_node(),node_data)
                else:
                    node.set_right_child_node(node_data)   


    def inoder_traversal(self,node:Node) -> None:
        if node is not None:
            self.inoder_traversal(node.get_left_child_node())
            print(node.get_node_data(),end= " ")
            self.inoder_traversal(node.get_right_child_node())

    
    def min_bst_from_sorted_array(self,arr:List[int]) -> None:
        min_index :int = 0
        max_index : int = len(arr) - 1 
        return self.__help_min_bst_from_sorted_array(arr,min_index,max_index) 

    #CTCI 4.1 
    def __help_min_bst_from_sorted_array(self,arr:List[int],min_index:int,max_index:int) -> None:
        if min_index <= max_index :
            mid_index = int((min_index + max_index) / 2)
            self.insert(arr[mid_index])
            self.__help_min_bst_from_sorted_array(arr,min_index,mid_index - 1)
            self.__help_min_bst_from_sorted_array(arr,mid_index+1,max_index) 


    #CTCI 4.12
    def count_number_of_paths(self,sum:int) -> int:
        return self.number_of_paths_from_node(self.get_root(),sum) 


    def number_of_paths_from_node(self, node:Node , sum:int) -> int:
        
        if node is not None:
            no_of_paths_from_root : int = self.count_no_of_paths_from_root(node,sum)
            no_of_paths_in_left_tree : int = self.count_no_of_paths_from_root(node.get_left_child_node(),sum) 
            no_of_paths_in_right_tree : int = self.count_no_of_paths_from_root(node.get_right_child_node(),sum) 
            total_paths :int = no_of_paths_from_root + no_of_paths_in_left_tree + no_of_paths_in_right_tree
            return total_paths  
        else :
            return 0   


    def count_no_of_paths_from_root(self,node:Node,total_sum:int,nodes_so_far:List[int]=[]) -> int:
        if node is None:
            return 0
        else:
            no_of_paths : int = 0 
            nodes_so_far.append(node.get_node_data()) 
            for i in range(len(nodes_so_far)): 
                if sum(nodes_so_far[i:]) == total_sum:
                    no_of_paths += 1


            no_of_paths += self.count_no_of_paths_from_root(node.get_left_child_node(),total_sum,nodes_so_far[:]) 
            no_of_paths += self.count_no_of_paths_from_root(node.get_right_child_node(),total_sum,nodes_so_far[:]) 
            return no_of_paths 


    #CTCI 4.10 
    def is_subtree(self,root_node:Node,child_node:Node) -> bool:
        root_node_pre_order_traversal_string : str  = self.pre_order_traversal(root_node)  
        child_node_pre_order_traversal_string : str = self.pre_order_traversal(child_node) 

        if child_node_pre_order_traversal_string in root_node_pre_order_traversal_string :
            return True 

        else :
            return False  


    def pre_order_traversal(self,node:Node,traversal_str:str = ' ') -> str:
        if node is not None:
            traversal_str += str(node.get_node_data()) 
            self.pre_order_traversal(node.get_left_child_node(),traversal_str)
            self.pre_order_traversal(node.get_right_child_node(),traversal_str) 
            return traversal_str
        else:
            traversal_str += 'x'
            return traversal_str
            


    




    


    


    
        
