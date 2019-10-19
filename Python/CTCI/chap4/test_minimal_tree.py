


from __future__ import annotations
import unittest
from typing import List, Set, Dict, Tuple, Optional
import random 
from minimal_tree import  Node,BST 

class TestMinimalBSTTree(unittest.TestCase):

    def test_minimal_bst_tree(self)-> None:
        arr:List[int] = [random.randrange(0,100) for n in range(10)] 
        arr.sort() 
        print("Sorted array is :{}".format(arr))
        binary_search_tree:BST = BST()
        binary_search_tree.min_bst_from_sorted_array(arr)
        binary_search_tree.inoder_traversal(binary_search_tree.get_root())  


if  __name__ == "__main__":
    test = TestMinimalBSTTree()
    test.test_minimal_bst_tree()

