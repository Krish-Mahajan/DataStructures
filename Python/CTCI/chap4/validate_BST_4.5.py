

from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys 

class Node(object):

    def __init__(self,key:int=None) -> None:
        if key is not None: 
            self.__key :int= key  
            self.__left_child :Node = None 
            self.__right_child :Node = None 
            self.__parent : Node = None  

    def set_node_key(self,key:int) -> None:
        
        if key is not None:
            self.__key = key  
        else :
            raise Exception("node key cannot be None") 


    def get_node_key(self) -> int:
        return self.__key 


    def set_left_child(self, node:Node) -> None:
        if node is not None:
            self.__left_child = node 
        else:
            raise Exception("node cannot be None") 


    def set_right_child(self,node:Node) -> None:
        if node is not None:
            self.__right_child = node 

        else:
            raise Exception("node cannot be None")  


    def set_parent(self, node:Node) -> None:
        if node is not None:
            self.__parent = node 
        else:
            raise Exception('node cannot be None')


    def get_left_child(self) -> Node:
        return self.__left_child 


    def get_right_child(self) -> Node:
        return self.__right_child   


    def get_parent(self) -> Node:
        return self.__parent  



class BinaryTree(object):

    def __init__(self, root:Node = None) -> None:
            self.__root : Node = root  

    def set_root(self,root:Node) -> None:
        if root is not None:
            self.__root = root   


    def get_root(self) -> Node:
        return self.__root


    def insert(self,node_data:int = None) -> None:
        if self.__root == None: 
            self.__root = Node(node_data)
        else:
            self.__insert_help(self.__root , node_data)  


    def __insert_help(self,node:Node,node_data:int) -> None:
        if node is not None:
            if node.get_node_key() >= node_data :
                if node.get_left_child() is not None:
                    self.__insert_help(node.get_left_child(),node_data) 

                else:
                    node.set_left_child(Node(node_data)) 

            else:
                if node.get_right_child() is not None:
                    self.__insert_help(node.get_right_child(),node_data)
                else:
                    node.set_right_child(Node(node_data))     


    #CTCI 4.5
    def validate_BST(self) -> bool: 
        '''
        check if a binary tree is BST without inordertraversal
        '''
        MAX_INT : int = sys.maxsize
        MIN_INT : int = -sys.maxsize
        return self.__validate_BST(self.get_root(),MAX_INT,MIN_INT) 



    def __validate_BST(self,node:Node,min:int,max:int) ->  bool:
        if node is None:
            return True 

        if (node.get_node_key() <= min or node.get_node_key() >= max):
            return False 

 
        return (self.__validate_BST(node.get_left_child(),min,node.get_node_key()) and self.__validate_BST(node.get_right_child(),node.get_node_key(),max)) 



    





    

    



    




    





    
        



    


