from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys


class Node(object):
    '''Node class to represent node of a linkList''' 


    def __init__(self,data:int,next:Node=None,prev:Node=None)->None:
        self.data = data
        self.next = next
        self.prev = prev  


    def get_data(self)-> int:
        return self.data 


    def set_data(self,data:int) -> None:
        self.data = data 


    def get_next(self)-> Node:
        return self.next 

    
    def set_next(self,n:Node) -> None:
        self.next = n 


    def get_prev(self)->Node:
        return self.prev  


    def set_prev(self,n:Node)-> None:
        self.prev = n 



class LinkList(object) :
    '''
    LinkList class 
    '''

    def __init__(self,head:Node=None)-> None:
        self.head = head 

    def set_head(self,head:Node) -> None:
        if head is not None:
            self.head = head
        else:
            print('head cannot be none') 


    def get_head(self) -> Node:
        return self.head 


    def create_link_list_from_list(self,ll:List[int])-> None:
        if ll is not None and len(ll) > 0:
            self.set_head(Node(ll[0])) 
            curr_node : Node = self.get_head()
            for element in ll[1:]:
                curr_node.set_next(Node(element))
                curr_node = curr_node.get_next()  

    def print_link_list(self) -> None:
        curr_node : Node = self.get_head()
        while(curr_node is not None):
            print(curr_node.get_data(), end = ',')
            curr_node = curr_node.get_next()









    
