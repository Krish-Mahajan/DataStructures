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
            print(curr_node.get_data(), end = ' ')
            curr_node = curr_node.get_next()   


    def insert(self, data:int=None,prev_node_data:int=None)-> None:
        '''
        insert a node in LinkList after a given node .
        If no node is given then new node will be added at end of the linkList
        '''
        if prev_node_data is None:
            curr_node = self.get_head()
            curr_next = curr_node.get_next()
            while(curr_node is not None):
                if curr_next is not None:
                    curr_node = curr_next 
                    curr_next = curr_node.get_next() 
                else:
                    curr_node.set_next(Node(data))
                    break 
        else:
            curr_node = self.get_head() 
            curr_next = curr_node.get_next()
            while(curr_node is not None):
                if curr_node.get_data() != prev_node_data :
                    curr_node = curr_next
                    curr_next = curr_node.get_next() 
                else :
                    curr_node.set_next(Node(data))
                    curr_node.get_next().set_next(curr_next)  
                    break

            if curr_node is None:
                print('{0} is not present in LinkList'.format(prev_node_data)) 


    def delete_node(self,node_data:int) -> None:
        '''
        Delete node in LinkList
        '''
        if node_data is not None:
            curr_node : Node  = self.get_head()
            curr_prev : Node= None
            curr_next :Node = curr_node.get_next()
            while(curr_node is not None):
                if curr_node.get_data() != node_data :
                    curr_prev = curr_node
                    curr_node = curr_next 
                    curr_next = curr_node.get_next() 
                else:
                    if curr_node.get_data() != self.get_head().get_data() :
                        curr_prev.set_next(curr_next) 
                        break
                    else:
                        self.set_head(curr_next) 
                        break 


    def find_linklist_size_recursively(self)-> int:
        ''' 
        find size of link_list recursively
        '''
        if self.get_head() is not None:
            return self.__linklist_size(self.get_head(),0) 
        else:
            print('LinkList has no head')
            return 0

    
    def __linklist_size(self, node:Node,size:int) -> int:
        if node is not None:
            return self.__linklist_size(node.get_next() , 1 + size) 
        else:
            return size 


    def reverse_linklist_iteratively(self) -> None:
        '''
        reverse the link_list iteratively
        '''
        if self.get_head() is not None:
            curr_node : Node = self.get_head()
            curr_next : Node = None
            curr_prev : Node = None
            while curr_node is not None:
                curr_next = curr_node.get_next()
                curr_node.set_next(curr_prev)
                curr_prev = curr_node 
                curr_node = curr_next 
            self.set_head(curr_prev) 



    def reverse_linklist_recursively(self) -> None:
        '''
        reverse linklist recursively
        '''
        return self._reverse_linklist_recursively(self.get_head()) 


    def _reverse_linklist_recursively(self,cur_node:Node,cur_prev:Node=None) -> None:
        if cur_node is not None:
            cur_next:Node = cur_node.get_next() 
            cur_node.set_next(cur_prev) 
            cur_prev = cur_node 
            cur_node = cur_next  
            return self._reverse_linklist_recursively(cur_node,cur_prev=cur_prev)

        self.set_head(cur_prev) 


    def reverseK(self, k:int) -> None:
        '''
        reverse LinkList in  group of K
        '''
        self._reverseK(self.get_head(),k) 

    
    def _reverseK(self,node:Node, k:int) -> Node: 
        cur_node:Node = node
        cur_prev:Node = None
        cur_next:Node = None
        count:int = 0 
        while cur_node is not None and count < k: 
            cur_next = cur_node.get_next()
            cur_node.set_next(cur_prev)
            cur_prev = cur_node
            cur_node = cur_next 
            count = count + 1 
        if cur_next is not None:
            self.get_head().set_next(self._reverseK(cur_next,k))

        self.set_head(cur_prev)
        return cur_prev





    
    











    
