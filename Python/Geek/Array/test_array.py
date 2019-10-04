
from __future__ import annotations
import unittest
from typing import List, Set, Dict, Tuple, Optional
import random 
from array import Array


class ArrayTestCase(unittest.TestCase):

    def test_binary_search_array(self)->None: 
        print('\nInserting Elements in LinkList using Python List') 
        elements :List[int] =[ ] 
        arr : Array = Array()
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        elements.sort()
        key:int = random.choice(elements)
        print('Elements are :{}'.format(elements))
        found :bool = arr.binary_search(elements,key) 

        print('Key : {} present in arr ; {}'.format(key,found))


if __name__ == "__main__": 
    #unittest.main()
    test = ArrayTestCase()
    test.test_binary_search_array()
