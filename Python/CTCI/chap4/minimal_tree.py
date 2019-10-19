


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


    def __help_min_bst_from_sorted_array(self,arr:List[int],min_index:int,max_index:int) -> None:
        if min_index <= max_index :
            mid_index = int((min_index + max_index) / 2)
            self.insert(arr[mid_index])
            self.__help_min_bst_from_sorted_array(arr,min_index,mid_index - 1)
            self.__help_min_bst_from_sorted_array(arr,mid_index+1,max_index)
     



    


    



            

    