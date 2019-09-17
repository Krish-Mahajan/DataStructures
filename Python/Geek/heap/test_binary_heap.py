



from __future__ import annotations
import unittest
from typing import List, Set, Dict, Tuple, Optional
import random 
from binary_heap import MinBinaryHeap 


class MinBinaryHeapTestCase(unittest.TestCase):
    '''
    Test for Min Binary Tree
    ''' 

    def test_binary_heap_insertion(self):
        print("Inserting Elements in Binary Heap")
        bh = MinBinaryHeap() 
        elements:List[int] = [random.randrange(0,1000) for _ in range(10)] 
        #elements:List[int] = [761, 327, 332, 385, 605, 772, 945, 737, 976, 518]
        print('Elements are:{}'.format(elements))
        for key in elements:
            bh.insert_element_min_heap(key)  

        print("Heap after Elements insertion are")
        bh.print() 


    
    def test_binary_heap_sort(self):
        print("Inserting Elements in Binary Heap")
        bh = MinBinaryHeap() 
        elements:List[int] = [random.randrange(0,1000) for _ in range(10)] 
        #elements:List[int] = [76, 984, 610, 238, 347, 633, 915, 576, 403, 165]
        print('Elements are:{}'.format(elements))
        for key in elements:
            bh.insert_element_min_heap(key)   
      
        sorted_list : List[int] = bh.heap_sort()
        print("Elements after heap sort are : {}".format(sorted_list)) 
        elements.sort()
        self.assertEqual(elements,sorted_list)

    

if __name__ == "__main__": 
    unittest.main()
    #test = MinBinaryHeapTestCase()
    #test.test_binary_heap_sort()