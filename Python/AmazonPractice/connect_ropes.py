

from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math 


def find_min_cost(l:List[int],total_cost:int=0) -> int:
    if len(l) == 0:
        return total_cost 
    elif len(l) == 1:
        cost:int = l.pop()
        return find_min_cost(l,total_cost)
    else:
        l.sort()
        cost= l[0] + l[1] 
        l = l[2:] 
        l.append(cost)
        total_cost = total_cost + cost 
        return find_min_cost(l,total_cost)






if __name__ == "__main__":   
    #l= [8, 4, 6, 12]
    #l = [20, 4, 8, 2]
    #l = [1, 2, 5, 10, 35, 89]
    l = [2, 2, 3, 3]
    print(find_min_cost(l))