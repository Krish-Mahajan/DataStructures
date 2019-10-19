
from test import Node 
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys


class A(object): 
    def funct(self)->None:
        n = Node(4) 
        print(n.get_node_index()) 
        data = n.get_node_index() 
        print(type(data))

if __name__ == '__main__':
    a = A()
    a.funct() 

    adj_list: Dict[int,List[int]] = {} 
    if 1 not in adj_list.keys():
        print('Not found') 
