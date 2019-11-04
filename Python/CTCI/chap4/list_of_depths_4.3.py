from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys 
import random , unittest

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



    def height_of_node(self,node:Node) -> int:
        if node is not None:
            return 1 + max(self.height_of_node(node.get_left_child()),self.height_of_node(node.get_right_child()))
        else:
            return 0 


    def create_ll(self) -> Dict[int,List[int]]:
        height_of_tree : int = self.height_of_node(self.get_root())
        ll : Dict[int,List[int]] = {}
        for i in range(height_of_tree):
            self.__help_create_ll(self.get_root(),ll,1,i+1) 
        for key in ll:
            print('Nodes at level {} are : {}'.format(key,ll[key]))
        return ll 

    def __help_create_ll(self,node:Node,ll:Dict[int,List[int]],level:int,target_level:int) -> None:
        if node is not None:
            if level == target_level :
                if level not in ll :
                    ll[level] = [node.get_node_key()] 
                else:
                    ll[level].append(node.get_node_key()) 
            self.__help_create_ll(node.get_left_child(),ll,level+1,target_level)
            self.__help_create_ll(node.get_right_child(),ll,level+1,target_level) 
        

class BinaryTreeTestCase(unittest.TestCase): 

    def test_first_common_ancestor_of_node(self)-> None: 
        print('\nInserting Elements in BST using List') 
        bt = BinaryTree()
        elements :List[int] =[ ] 
        random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements are :{}'.format(elements))
        for key in elements:
            bt.insert(key) 

        print('List at different Levels are')
        bt.create_ll()
        
        #self.assertEqual(height,6)  
        print('******************************************\n')  


    
 




if __name__ == "__main__": 
    #unittest.main()
    test = BinaryTreeTestCase()
    test.test_first_common_ancestor_of_node()