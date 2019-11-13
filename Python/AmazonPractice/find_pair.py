




from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math 


def find_pair(nums:List[int],target:int) -> List[int]:
    output_list:List[List[int]] = []
    for i in range(len(nums)):
        for j in range(i+1,len(nums)): 
            if nums[i]+nums[j] == target - 30:
                    output_list.append([i,j])
    
    max_num:float = - math.inf

    if len(output_list)>1: 
        new_output_list :List[int] = []
        for index in output_list:
            if (nums[index[0]] > max_num or nums[index[1]] > max_num):
                if (nums[index[0]] > nums[index[1]]):
                    max_num = nums[index[0]] 
                else:
                    max_num = nums[index[1]]

                new_output_list.clear()
                new_output_list.append(index[0])
                new_output_list.append(index[1])
        return new_output_list

    return output_list[0]


if __name__ == "__main__":  
    #nums:List[int] = [1, 10, 25, 35, 60] 
    nums = [20, 50, 40, 25, 30, 10]
    target:int = 90 
    print(find_pair(nums,target))