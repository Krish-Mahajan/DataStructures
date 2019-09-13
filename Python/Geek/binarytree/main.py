

from typing import List, Set, Dict, Tuple, Optional
import random 
from binary_tree import BinaryTree , Node

if __name__ == "__main__": 
    '''
    bt = BinaryTree()
    bt.set_root(1.0)
    bt.get_root().set_left_child(2.0) 
    bt.get_root().set_right_child(3.0) 
    bt.get_root().get_left_child().set_left_child(4.0) 
    bt.get_root().get_left_child().set_right_child(5.0)  

    print('Inorder Traversal of the binary tree is:\n')
    bt.inorder_tree_traversal() 
    
    print('Preorder Traversal of the binary tree is:\n')
    bt.preorder_tree_traversal() 
    
    print('Postorder Traversal of the binary tree is:\n')
    bt.postorder_tree_traversal() 
    '''

    print('Inserting Elements in BST using List') 
    bt2 = BinaryTree()
    elements :List[int] =[ ] 
    random.seed(a=1)
    elements = [random.randrange(0,101) for _ in range(10)]  
    print('Elements are :{}'.format(elements))
    for key in elements:
        bt2.insert(key) 

    print('Inorder Traversal of the binary tree is:')
    node_list:List[Node] = bt2.inorder_tree_traversal()  
    node_list_keys = [node.get_key() for node in node_list]
    print(node_list_keys)
    
    '''
    print('Preorder Traversal of the binary tree is:\n')
    bt2.preorder_tree_traversal() 
    
    print('Postorder Traversal of the binary tree is:\n')
    bt2.postorder_tree_traversal()  
    '''  
    print('Inorder successor of each element in BST is:')
    for node in node_list:
        in_succ_key:int = bt2.inorder_successor(node)
        print(node.get_key(),in_succ_key)

    
