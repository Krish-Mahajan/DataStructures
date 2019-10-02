from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys 


class QuickSort(object):

    def sort(self,arr:List[int])-> List[int]:
        return self.__sort_util(arr,0,len(arr)-1) 


    def __sort_util(self,arr:List[int],low:int,high:int) -> List[int]:
        if ( low < high) :
            pivot_index : int = self.__partition(arr,low,high)  
            self.__sort_util(arr,low,pivot_index-1)
            self.__sort_util(arr,pivot_index+1,high) 

        return arr 


    def __partition(self,arr:List[int],low:int,high:int)-> int:
         
         #Index to keep track of elements less than pivot element
        i:int = low -1  

         #pivot element
        pivot_element:int = arr[high] 

        
        #most important for loop
        for j,element in enumerate(arr[low:high],start=low):
             if arr[j] <= pivot_element :
                 i = i+1
                 arr[i], arr[j] = arr[j],arr[i] 

        #Finally swap the pivot element
        arr[i+1],arr[high] = arr[high],arr[i+1] 

        return i + 1
    
