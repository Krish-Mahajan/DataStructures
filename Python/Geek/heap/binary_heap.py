

from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys


class MinBinaryHeap(object):
    """
    Representation of Binary Min Heap
    """

    def __init__(self,arr:List[int]=None)-> None:
        
        if arr is None:
            self.arr :List[int] = []
            self.arr.insert(0, None)
        else:
            self.arr = arr 
            self.arr.insert(0,None)
            
  

    
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

    def get_left_child_node(self,pos:int)-> int:
        """
        Return left child node of a parent node
        """
        if pos is not None :
            if 2*pos <= len(self.arr) -1:
                return self.arr[2*pos]  
            else:
                return None
        else:
            return None 

   
    def get_left_child_node_pos(self ,pos:int) ->int:
        """
        Return left child node position of a parent node
        """ 
        if pos is not None:
            return 2*pos
        else:
            return None 


    def get_right_child_node(self,pos:int)-> int:
        """
        Return right child node of a parent node
        """
        if pos is not None :
            if 2*pos+1 <= len(self.arr) -1:
                return self.arr[2*pos+1]  
            else:
                return None
        else:
            return None 

   
    def get_right_child_node_pos(self ,pos:int) ->int:
        """
        Return right child node position of a parent node
        """ 
        if pos is not None:
            return 2*pos + 1
        else:
            return None    


    def is_leaf_pos(self,pos:int) -> bool:
        '''
        Function to know if pos it leaf node
        ''' 
        if pos > int(len(self.arr)/2) and pos < len(self.arr):
            return True
        
        return False


    def insert_element_min_heap(self,key:int)-> None:
        '''
        Insert element in min_heap
        '''
        if key is not None: 
            self.arr.append(key) 
            if len(self.arr) > 2:
                cur_pos:int= len(self.arr) - 1
                while( cur_pos >1 and self.arr[cur_pos] < self.get_parent_node(cur_pos)) :
                    self.swap_elements(cur_pos,self.get_parent_node_pos(cur_pos)) 
                    cur_pos = self.get_parent_node_pos(cur_pos) 


    def swap_elements(self,pos1:int,pos2:int) -> None:
        '''
        swap elements of heap
        '''
        if pos1 is not None and pos2 is not None:
            self.arr[pos1] , self.arr[pos2] = self.arr[pos2] , self.arr[pos1]  



    def remove(self) -> int:
        '''
        Removes and return topmost element from the heap
        '''
        key:int = self.arr[1] # 0 index element is None 
        if len(self.arr) >2 :
            self.arr[1] = self.arr.pop()
            self.min_heapify(1)
        return key 


    def min_heapify(self, pos:int)-> None:
        '''
        min_heapify the current position
        '''
        if not self.is_leaf_pos(pos):
            if self.get_right_child_node(pos) is not None:
                if(self.arr[pos] > self.get_left_child_node(pos) or self.arr[pos] > self.get_right_child_node(pos)):
                    if (self.get_left_child_node(pos) < self.get_right_child_node(pos)):
                        self.swap_elements(pos,self.get_left_child_node_pos(pos)) 
                        self.min_heapify(self.get_left_child_node_pos(pos))
                    else:
                        self.swap_elements(pos , self.get_right_child_node_pos(pos))
                        self.min_heapify(self.get_right_child_node_pos(pos))
            else:
                if self.get_left_child_node(pos) is not None:
                    if(self.arr[pos] > self.get_left_child_node(pos)):
                        self.swap_elements(pos,self.get_left_child_node_pos(pos)) 
                        self.min_heapify(self.get_left_child_node_pos(pos)) 


    def heap_sort(self) -> List[int]: 
        '''
        heap_sort 
        '''
        sorted_list : List[int] = []
        for element in self.arr[1:]:
            sorted_list.append(self.remove())
        return sorted_list


    def print(self) -> None:
        '''
        Print elements of the heap
        '''
        for i in range(int(len(self.arr)/2)) :
            if i==0:  pass
            print(i)
            print('Parent : {} ,Left child {} , Right Child {}'.format(self.arr[i],self.arr[2*i],self.arr[2*i+1]))

    
            

      

   




        