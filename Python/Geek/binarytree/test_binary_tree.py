

from __future__ import annotations
import unittest
from typing import List, Set, Dict, Tuple, Optional
import random 
from binary_tree import BinaryTree , Node 


class BinaryTreeTestCase(unittest.TestCase):
    '''
    Tests for Binary Tree Functions
    '''

    def test_inorder_tree_traversal(self)-> None: 
        print('\nInserting Elements in BST using List') 
        bt = BinaryTree()
        elements :List[int] =[ ] 
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements are :{}'.format(elements))
        for key in elements:
            bt.insert(key) 

        #Sorting original elements
        elements.sort()
        print('Elements after sorting are : {}'.format(elements)) 

        #Inoder Traversal
        node_list:List[Node] = bt.inorder_tree_traversal()  
        node_list_keys = [node.get_key() for node in node_list] 

        #checking elements are coming sorted after inorder traversal
        print('Elements after inorder traversal are :{}'.format(node_list_keys))
        self.assertEqual(elements,node_list_keys) 
        print('******************************************\n')


    def test_inorder_successor(self)-> None:  

        print('\nInserting Elements in BST using List') 
        bt = BinaryTree()
        elements :List[int] =[ ] 
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements are :{}'.format(elements))
        for key in elements:
            bt.insert(key) 


        #Inoder Traversal
        node_list:List[Node] = bt.inorder_tree_traversal()  
        node_list_keys = [node.get_key() for node in node_list] 

        #checking elements are coming sorted after inorder traversal
        print('Elements after inorder traversal are :{}'.format(node_list_keys))

        print('Inorder successor of each element in BST is:') 
        for i in range(len(node_list[:-1])):
            in_succ_node:Node = bt.inorder_successor(node_list[i])
            print(node_list[i].get_key(),in_succ_node.get_key()) 
            self.assertEqual(in_succ_node.get_key(),node_list[i+1].get_key()) 
        print('******************************************\n') 


    def test_height_of_tree(self)-> None: 
        print('\nInserting Elements in BST using List') 
        bt = BinaryTree()
        elements :List[int] =[ ] 
        random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements are :{}'.format(elements))
        for key in elements:
            bt.insert(key) 

        height : int = bt.height_of_tree() 
        print('height of the tree is : {}'.format(height))
        self.assertEqual(height,6)  
        print('******************************************\n')


    def test_level_order_traversal(self)-> None:
        elements = [17, 72, 97, 8, 32, 15, 63, 97, 57, 60]  
        print('Elements are :{}'.format(elements)) 
        bt = BinaryTree()
        print('\nInserting Elements in BST using List') 
        for key in elements:
            bt.insert(key)   
        
        print("Level Order Traversal is: ")
        t:Tuple[Tuple[int,int],...]= bt.level_order_traversal()
        correct_t: Tuple[Tuple[int,int],...] = ((1, 17), (2, 8), (2, 72), (3, 15), (3, 32), (3, 97), (4, 63), (4, 97), (5, 57), (6, 60)) 
        self.assertEqual(t,correct_t) 
        print('******************************************\n')


    def test_width_of_tree(self)-> None: 
        elements = [17, 72, 97, 8, 32, 15, 63, 97, 57, 60]  
        print('Elements are :{}'.format(elements)) 
        bt = BinaryTree()
        print('\nInserting Elements in BST using List') 
        for key in elements:
            bt.insert(key)   
        width:int = bt.width_of_tree() 
        print('Width of the tree is :{}'.format(width))
        self.assertEqual(width,3) 
        print('******************************************\n')


    def test_nodes_at_k_distance(self)-> None: 
        elements = [17, 72, 97, 8, 32, 15, 63, 97, 57, 60]  
        print('Elements are :{}'.format(elements)) 
        bt = BinaryTree()
        print('\nInserting Elements in BST using List') 
        for key in elements:
            bt.insert(key)   
        nodes_k:List[Node] = bt.nodes_k_distance(2) 
        nodes_k_keys = [nodes.get_key() for nodes in nodes_k]
        print('Nodes at distance 2 are :{}'.format(nodes_k_keys))
        self.assertEqual(nodes_k_keys,[15,32,97]) 
        print('******************************************\n') 



    def test_diameter_of_tree(self)-> None: 
        elements = [17, 72, 97, 8, 32, 15, 63, 97, 57, 60]  
        print('Elements are :{}'.format(elements)) 
        bt = BinaryTree()
        print('\nInserting Elements in BST using List') 
        for key in elements:
            bt.insert(key)   
        diameter:int = bt.diameter_of_binary_tree(bt.get_root()) 
        print('Diameter of the tree is:{}'.format(diameter))
        self.assertEqual(diameter,7) 
        print('******************************************\n') 


    def test_search_key_in_BST(self)-> None: 
        bt = BinaryTree()
        elements :List[int] =[ ] 
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements are :{}'.format(elements))
        for key1 in elements:
            bt.insert(key1)  

        key:int = random.choice(elements)
        print("Searching for following elemet in BST: {}".format(key))
        node:Node = bt.search_element_BST(key) 
        print("Following element found in BST: {}".format(node.get_key()))
        self.assertEqual(node.get_key(),key) 
        print('******************************************\n') 


    def test_find_ancestors_in_BST(self) -> None: 
        elements = [17, 72, 97, 8, 32, 15, 63, 97, 57, 60]  
        print('Elements are :{}'.format(elements)) 
        bt = BinaryTree()
        print('\nInserting Elements in BST using List') 
        for key1 in elements:
            bt.insert(key1)   

        key:int = random.choice(elements)
        print("Finding ancestors for following elemet in BST: {}".format(key))
        element_present:bool = bt.print_ancestors_node(key,bt.get_root()) 
        self.assertEqual(element_present,True) 
        print('******************************************\n') 



    def test_create_binary_search_tree_from_sorted_list(self) -> None:
        bt = BinaryTree()
        elements :List[int] = []
        elements = [random.randrange(0,1000) for _ in range(20)]
        elements.sort() 
        print('Elements are {}'.format(elements)) 
        bt.create_BST_from_sorted_array(elements)   

        #Inoder Traversal
        node_list:List[Node] = bt.inorder_tree_traversal()  
        node_list_keys = [node.get_key() for node in node_list] 

        #checking elements are coming sorted after inorder traversal
        print('Elements after inorder traversal are :{}'.format(node_list_keys))
        self.assertEqual(elements,node_list_keys) 
        print('******************************************\n') 


    def test_delete_node(self) -> None:
        bt = BinaryTree()
        elements :List[int] = [] 
        #elements= [ random.randrange(0,1000) for _ in range(0,20)] 
        elements =  [664, 120, 513, 233, 837, 117, 744, 289, 978, 488, 926, 799, 57, 168, 586, 937, 36, 821, 789, 7]
        print('Elements are {}'.format(elements)) 
        print('\nInserting Elements in BST using List') 
        for key in elements:
            bt.insert(key)   

        #element_to_delete : int = random.choice(elements) 
        element_to_delete : int = 744 
        print("Element to be delete from BST:{}".format(element_to_delete))
        bt.delete_node(element_to_delete) 

        elements.remove(element_to_delete)
        elements.sort() 
        print('Initial Elements after sorting and removing key are {}'.format(elements))  
        

        #Inoder Traversal after deleting
        node_list:List[Node] = bt.inorder_tree_traversal()  
        node_list_keys = [node.get_key() for node in node_list] 

        #checking elements are coming sorted after deletion of node
        print('Elements after inorder traversal are :{}'.format(node_list_keys)) 
        self.assertEqual(elements,node_list_keys) 




if __name__ == "__main__": 
    #unittest.main()
    test = BinaryTreeTestCase()
    #test.test_height_of_tree()
    #test.test_level_order_traversal()
    #test.test_nodes_at_k_distance()
    #test.test_diameter_of_tree()
    #test.test_search_key_in_BST()
    #test.test_find_ancestors_in_BST()
    #test.test_create_binary_search_tree_from_sorted_list()
    test.test_delete_node()

    

    
