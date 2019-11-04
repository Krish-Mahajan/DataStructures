




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


    def ancestor_of_a_node(self, node_key:int,node_list:List[int]=[]) -> List[int]:
        self.__ancestor_of_a_node_help(self.get_root(),node_key,node_list)  
        return node_list


    def __ancestor_of_a_node_help(self, node:Node,orginal_node_key:int,node_list:List[int]) -> bool :
        if node is None:
            return False 

        if node.get_node_key() == orginal_node_key :
            return True 

        elif(self.__ancestor_of_a_node_help(node.get_left_child(),orginal_node_key,node_list) or self.__ancestor_of_a_node_help(node.get_right_child(),orginal_node_key,node_list)):
            print("Ancestor for key {} is : {}".format(orginal_node_key,node.get_node_key()))
            node_list.append(node.get_node_key())
            return True 

        else:
            return False 



    def first_common_ancestor(self, node1_key:int , node2_key:int) -> None:
       node1_ancestors : List[int] = self.ancestor_of_a_node(node1_key,[]) 
       node2_ancestors : List[int] = self.ancestor_of_a_node(node2_key,[])  
       if(set(node1_ancestors) & set(node2_ancestors)) :
           common_ancestors :Set[int] = set(node1_ancestors) & set(node2_ancestors) 
           print('Common ancestor is :{}'.format(list(common_ancestors)[-1])) 

       else:
           print('No common ancestor')


       print(node1_ancestors) 
       print(node2_ancestors)  



class BinaryTreeTestCase(unittest.TestCase): 

    def test_first_common_ancestor_of_node(self)-> None: 
        print('\nInserting Elements in BST using List') 
        bt = BinaryTree()
        elements :List[int] =[ ] 
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements are :{}'.format(elements))
        for key in elements:
            bt.insert(key) 

        node1_key:int = random.choice(elements)
        node2_key:int = random.choice(elements) 

        print('Keys are {} and {}'.format(node1_key,node2_key))
        print('Common ancestors are')
        bt.first_common_ancestor(node1_key,node2_key)
        
        #self.assertEqual(height,6)  
        print('******************************************\n')  


    
 




if __name__ == "__main__": 
    #unittest.main()
    test = BinaryTreeTestCase()
    test.test_first_common_ancestor_of_node()

    


