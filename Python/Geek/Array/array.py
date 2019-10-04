
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys


class Array(object):

    def binary_search(self, arr:List[int] , key:int) -> bool :
        if arr is not None and key is not None:
            return self.__binary_search(arr,0,len(arr)-1,key)  
        else:
            return False

    def __binary_search(self,arr:List[int],start_index:int,end_index:int,key:int) -> bool:
        if start_index > end_index : return False
        else :
            mid_index : int = int((start_index + end_index) /2)
            if key > arr[mid_index]:
                return self.__binary_search(arr,mid_index + 1,end_index,key) 
            elif key < arr[mid_index]:
                return self.__binary_search(arr,start_index,mid_index-1,key) 
            else:
                return True