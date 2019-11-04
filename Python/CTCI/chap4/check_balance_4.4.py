



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
            return 1+ max(self.height_of_node(node.get_left_child()), self.height_of_node(node.get_right_child())) 
        else:
            return 0 


    def is_BST_Balanced(self) -> bool:
        return self.__help_is_BST_balanced(self.get_root()) 


    def __help_is_BST_balanced(self, node:Node) -> bool :
        if node is not None:
            lheight = self.height_of_node(node.get_left_child()) 
            rheight = self.height_of_node(node.get_right_child()) 
            if (abs(lheight - rheight) > 1):
                return False 
            return (self.__help_is_BST_balanced(node.get_left_child()) and self.__help_is_BST_balanced(node.get_right_child())) 

        else:
            return True 


    def create_BST_from_sorted_array(self, arr:List[int])->None: 
        '''
        Create Binary Search Tree from sorted array
        '''
        self._create_BST_from_sorted_array(arr,0,len(arr)-1) 


    def _create_BST_from_sorted_array(self,arr:List[int],min:int,max:int)-> None: 
        if min > max: return

        curr_key_index:int = int((min + max)/2)
        self.insert(arr[curr_key_index]) 
        self._create_BST_from_sorted_array(arr,min,curr_key_index-1) 
        self._create_BST_from_sorted_array(arr,curr_key_index+1,max)  







class BinaryTreeTestCase(unittest.TestCase): 

    def test_height_of_tree(self)-> None: 
        print('\nInserting Elements in BST using List') 
        bt = BinaryTree()
        elements :List[int] =[ ] 
        random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements are :{}'.format(elements))
        for key in elements:
            bt.insert(key) 

        height : int = bt.height_of_node(bt.get_root()) 
        print('height of the tree is : {}'.format(height))
        #self.assertEqual(height,6)  
        print('******************************************\n')  


    
    def test_is_BST_balanced(self)-> None: 
        print('\nInserting Elements in BST using List') 
        bt = BinaryTree()
        elements :List[int] =[ ] 
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        elements.sort()
        print('Elements are :{}'.format(elements))
        bt.create_BST_from_sorted_array(elements)

        height : int = bt.height_of_node(bt.get_root()) 
        print('height of the tree is : {}'.format(height)) 
        print('Is BST balanced :{}'.format(bt.is_BST_Balanced()))
        #self.assertEqual(height,6)  
        print('******************************************\n') 





if __name__ == "__main__": 
    #unittest.main()
    test = BinaryTreeTestCase()
    test.test_is_BST_balanced()