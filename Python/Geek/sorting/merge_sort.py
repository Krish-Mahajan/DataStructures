
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys

class MergeSort(object): 

    def __init__(self,arr:List[int]) -> None:
        if arr is not None and len(arr) > 0: 
            self.arr : List[int] = arr
        else:
            print("Array is null or no elements are present") 

    def sort(self) -> List[int]: 
         '''
         Sort the array
         '''
         l_index:int = 0 
         r_index:int = len(self.arr) -1 

         self.__sort(l_index,r_index) 
         return self.arr


    def __sort(self,l_index:int,r_index:int)-> None:
        if l_index < r_index : 
            m_index:int = int((l_index + r_index)/2) 
            self.__sort(l_index,m_index) 
            self.__sort(m_index + 1,r_index) 
            self.__merge(l_index,m_index,r_index)  


    def __merge(self,l_index:int,m_index:int,r_index:int) -> None:

        temp_arr_1 :List[int] = self.arr[l_index:m_index+1]
        temp_arr_2 :List[int]= self.arr[m_index + 1 : r_index+1]  

        i :int = 0 
        j: int = 0 

        # Initial index of merged subarray 
        k:int = l_index 

        # Compare each element
        while i < len(temp_arr_1) and j < len(temp_arr_2):
            if temp_arr_1[i] > temp_arr_2[j]:
                self.arr[k] = temp_arr_2[j] 
                j = j+1
                k = k +1 
            else:
                self.arr[k] = temp_arr_1[i] 
                i = i + 1 
                k = k + 1

        while j < len(temp_arr_2):
            self.arr[k] = temp_arr_2[j] 
            j = j+1
            k = k +1  

        while i < len(temp_arr_1):
            self.arr[k] = temp_arr_1[i] 
            i = i +1 
            k = k + 1







