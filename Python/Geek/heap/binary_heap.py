

from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys


class MinBinaryHeap(object):
    """
    Representation of Binary Min Heap
    """

    def __init__(self,arr:List[int]=[])-> None:
        self.arr = arr 
        self.size = len(self.arr)

    
    def get_parent_node(self,pos:int)->int:
        """
        Return Parent Node of Child Node
        """
        if pos is not None and self.arr[pos] is not None:
            return self.arr[int(pos/2)] 
        else:
            return None   


    def get_parent_node_pos(self,pos:int) -> int:
        '''
        return parent pos of a children node
        ''' 
        if pos is not None:
            return int(pos/2)
        else:
            return None

    def left_child_node(self,pos:int)-> int:
        """
        Return left child node of a parent node
        """
        if pos is not None :
            if self.arr[2*pos] is not None:
                return self.arr[2*pos]  
            else:
                return None
        else:
            return None 

   
    def left_child_node_pos(self ,pos:int) ->int:
        """
        Return left child node position of a parent node
        """ 
        if pos is not None:
            return 2*pos
        else:
            return None 


    def right_child_node(self,pos:int)-> int:
        """
        Return right child node of a parent node
        """
        if pos is not None :
            if self.arr[2*pos+1] is not None:
                return self.arr[2*pos]  
            else:
                return None
        else:
            return None 

   
    def right_child_node_pos(self ,pos:int) ->int:
        """
        Return right child node position of a parent node
        """ 
        if pos is not None:
            return 2*pos + 1
        else:
            return None  


    def insert_element_min_heap(self,key:int)-> None:
        '''
        Insert element in min_heap
        '''
        if key is not None:
            self.size +=1
            self.arr.insert(self.size,key) 
            if len(self.arr) > 2:
                cur_pos:int= len(self.arr) 
                while(cur_pos < self.get_parent_node(cur_pos) and cur_pos !=1) :
                    self.swap_elements(cur_pos,self.get_parent_node_pos(cur_pos)) 
                    cur_pos = self.get_parent_node_pos(cur_pos) 


    def swap_elements(self,pos1:int,pos2:int) -> None:
        '''
        swap elements of heap
        '''
        if pos1 is not None and pos2 is not None:
            self.arr[pos1] , self.arr[pos2] = self.arr[pos2] , self.arr[pos1]

    
            

      

   




        