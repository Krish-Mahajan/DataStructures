


import unittest
from typing import List, Set, Dict, Tuple, Optional
import random 
from binary_tree import BinaryTree , Node 


class BinaryTreeTestCase(unittest.TestCase):
    '''
    Tests for Binary Tree Functions
    '''

    def test_inorder_tree_traversal(self): 
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


    def test_inorder_successor(self):  

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
            in_succ_key:int = bt.inorder_successor(node_list[i])
            print(node_list[i].get_key(),in_succ_key) 
            self.assertEqual(in_succ_key,node_list[i+1].get_key())
    




if __name__ == "__main__": 
    unittest.main()
    

    
