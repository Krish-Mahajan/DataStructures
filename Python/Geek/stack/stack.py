

from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys


class Stack(object): 


    def reverse_stack(self,arr:List[int]) -> None:
        '''
        Reverse stack using Push / Pop operations
        '''
        if len(arr) > 0 :
            top_element : int = arr[-1]
            arr.pop() 
            self.reverse_stack(arr) 
            self.__insert_at_bottom(arr,top_element)
        else:
            return 


    def __insert_at_bottom(self,arr:List[int],element:int) -> None: 
        if len(arr) == 0 :
            arr.append(element) 
        else :
            top_element : int = arr[-1]
            arr.pop() 
            self.__insert_at_bottom(arr,element)
            arr.append(top_element) 



    def sort_stack(self,arr:List[int]) -> None:
        '''
        sort a  stack using Push / Pop operations
        '''
        if len(arr) > 0 :
            top_element : int = arr[-1]
            arr.pop() 
            self.sort_stack(arr) 
            self.__insert_in_order(arr,top_element)
        else:
            return 


    def __insert_in_order(self,arr:List[int],element:int) -> None: 
        if len(arr) == 0 :
            arr.append(element) 
        else :
            top_element : int = arr[-1] 
            if element < top_element :
                arr.pop() 
                self.__insert_in_order(arr,element)
                arr.append(top_element) 
            else :
                arr.append(element)






