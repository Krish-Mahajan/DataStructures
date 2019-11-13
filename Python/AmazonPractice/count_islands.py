

from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math 


def count_island(mat:List[List[str]]) -> int:

    new_mat: List[List[str]] = make_2d_array(mat) 
    count_island :int = 0
    for row_index in range(len(new_mat)):
        for col_index in range(len(new_mat[row_index])):  
            if new_mat[row_index][col_index] == '1':  
                if(is_island(new_mat,row_index,col_index)): count_island +=1 



    return count_island 


def is_island(mat:List[List[str]],row_index:int,col_index:int) -> bool:
    
    if col_index < len(mat[row_index])-1:    
        right:str = mat[row_index][col_index+1]
    else:
        right = '0'

    if col_index > 0:
        left:str = mat[row_index][col_index-1]
    else: 
        left = '0'

    if row_index > 0:
        up:str = mat[row_index-1][col_index]
    else:
         up = '0'

    if row_index < len(mat)-1:
        down:str = mat[row_index+1][col_index] 
    else:
        down = '0'

    if (right + left + up + down) == '0000':
        return True 

    return False


def make_2d_array(mat:List[List[str]]) -> List[List[str]]: 

    new_mat: List[List[str]] = [] 
    for row_index in range(len(mat)):
        area:List[str]= []
        for col in mat[row_index]:
            for col_ch in col:
                area.append(col_ch) 
        new_mat.append(area)

    return new_mat







if __name__ == "__main__":   

    mat:List[List[str]] = [
           ['11110'],
          ['11010'],
           ['11000'],
          ['00000']
           ] 

    mat2:List[List[str]] = [
                                ['11000'],
                                ['11000'],
                                ['00100'],
                                ['00011']
                            ]      


    print(count_island(mat2))