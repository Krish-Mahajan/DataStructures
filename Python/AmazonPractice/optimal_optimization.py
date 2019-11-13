
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math 

def find_optimal_list(l1:List[List[int]], l2: List[List[int]],target:int) -> List[List[int]]:
    
    output_list : List[List[int]] = []
    max_sum:float = -math.inf
    for element_l1 in l1:
        for element_l2 in l2:
            if element_l1[1] + element_l2[1] <= target:
                if element_l1[1] + element_l2[1] > max_sum:
                    max_sum = element_l1[1] + element_l2[1] 
                    output_list.clear()
                    output_list.append([element_l1[0] ,element_l2[0]]) 

                if element_l1[1] + element_l2[1] == target: 
                    if [element_l1[0] ,element_l2[0]] not in output_list:
                        output_list.append([element_l1[0] ,element_l2[0]]) 


    return output_list



if __name__ == "__main__":  
    
    '''
    a :List[List[int]]= [[1, 2], [2, 4], [3, 6]]
    b : List[List[int]] = [[1, 2]]
    target:int = 7 
    '''
    a = [[1, 3], [2, 5], [3, 7], [4, 10]]
    b = [[1, 2], [2, 3], [3, 4], [4, 5]]
    target = 10
    print(find_optimal_list(a,b,target))