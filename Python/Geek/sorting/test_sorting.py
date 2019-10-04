from __future__ import annotations
import unittest
from typing import List, Set, Dict, Tuple, Optional
import random  
from merge_sort import MergeSort 
from quick_sort import QuickSort


class SortTestCase(unittest.TestCase):
    
    '''
    Test for merge sort functionality
    ''' 
    def test_merge_sort(self) -> None: 
        elements :List[int] =[ ] 
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(100)]  
        #elements = [96, 90, 85, 78, 81, 97, 14, 29, 73, 84] 
        print('Elements are :{}'.format(elements))
        ms = MergeSort(elements) 
        sorted_elements = ms.sort() 
        print('Elements after sorting are : {}'.format(elements)) 
        elements.sort()
        self.assertEqual(elements,sorted_elements)   


    '''
    Test for quick sort functionality
    '''
    def test_quick_sort(self) -> None: 
        elements :List[int] =[ ] 
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(100)]  
        #elements = [75, 10, 92, 92, 35] 
        print('Elements are :{}'.format(elements))
        qs = QuickSort() 
        sorted_elements = qs.sort(elements) 
        print('Elements after sorting are : {}'.format(elements)) 
        elements.sort()
        self.assertEqual(elements,sorted_elements)   


    


if __name__ == "__main__": 
    #unittest.main()
    test = SortTestCase()
    #test.test_merge_sort()
    test.test_quick_sort()

