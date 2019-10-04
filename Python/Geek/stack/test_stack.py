
from __future__ import annotations
import unittest
from typing import List, Set, Dict, Tuple, Optional
import random 
from stack import Stack 


class StackTestCase(unittest.TestCase):

    def test_stack_reversal(self)->None: 
        print('\nInserting Elements in LinkList using Python List') 
        size:int = random.randrange(0,20)
        elements = [random.randrange(0,101) for _ in range(size)] 
        print('Elements of stack before reversal :{}'.format(elements)) 
        #elements :List[int] =[ 4,3,2,1] 
        s : Stack = Stack()
        s.reverse_stack(elements)
        print('Elements of stack after reversal :{}'.format(elements))   


    def test_stack_sorting(self)->None: 
        print('\nInserting Elements in LinkList using Python List') 
        size:int = random.randrange(0,20)
        elements = [random.randrange(0,101) for _ in range(size)] 
        #elements :List[int] =[ 2,4,3,1] 
        print('Elements of stack before sorting :{}'.format(elements)) 
        #
        s : Stack = Stack()
        s.sort_stack(elements)
        print('Elements of stack after sorting :{}'.format(elements)) 



if __name__ == "__main__": 
    #unittest.main()
    test = StackTestCase()
    #test.test_stack_reversal()
    test.test_stack_sorting()
