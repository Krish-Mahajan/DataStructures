from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math

class Cell(object):

    def __init__(self,cur_status:int,next_status:int =-1) -> None:
        self.cur_status = cur_status 
        self.next_status =  next_status


    

def how_many_hours(mat:List[List[int]]) -> int: 

    cell_map: Dict[str,Cell]= current_status_cell(mat)

    total_rows:int = len(mat) 
    total_column_each_row = len(mat[0]) 
    total_hours :int = 0 

    while True: 
        total_hours = total_hours + 1
        for row_index in range(len(mat)):
            for col_index in range(len(mat[row_index])): 
                c:Cell = cell_map.get(str(row_index)+str(col_index))
                if c.cur_status == 1:  #Found a Zombie 
                    look_all_direction(cell_map,row_index,col_index,total_rows,total_column_each_row)   
        
        update_new_status(mat,cell_map)


        if(check_all_zombie(mat,cell_map)): break 


    return total_hours  


def current_status_cell(mat:List[List[int]]) -> Dict[str,Cell]:
    cell_map:Dict[str,Cell] = {}
    for row_index in range(len(mat)):
        for col_index in range(len(mat[row_index])): 
                 c : Cell = Cell(mat[row_index][col_index])
                 cell_map[str(row_index)+str(col_index)] = c 

    return cell_map



def update_new_status(mat:List[List[int]], cell_map:Dict[str,Cell]) -> None:
    for row_index in range(len(mat)):
        for col_index in range(len(mat[row_index])): 
            c:Cell = cell_map[(str(row_index) + str(col_index))]
            if c.next_status != -1 : #that is the status has been changed
                c.cur_status = c.next_status 
                mat[row_index][col_index]=c.cur_status



def look_all_direction(cell_map:Dict[str,Cell],row_index:int,col_index:int,total_rows:int,total_column_each_row:int) -> None:
    
    #look ahead 
    if col_index < total_column_each_row -1:
        c:Cell = cell_map.get(str(row_index)+str(col_index+1))
        c.next_status =1


    #look behind 
    if col_index > 0:
        c= cell_map.get(str(row_index)+str(col_index-1))
        c.next_status =1


    #look down
    if row_index < total_rows -1 :
         c = cell_map.get(str(row_index+1)+str(col_index))
         c.next_status =1


    #look up 
    if row_index > 0 :
        c = cell_map.get(str(row_index-1)+str(col_index))
        c.next_status = 1
     


def check_all_zombie(mat:List[List[int]],cell_map:Dict[str,Cell]) -> bool: 
    all_zombie : bool = True
    for row_index in range(len(mat)):
        for col_index in range(len(mat[row_index])): 
            c:Cell = cell_map[(str(row_index) + str(col_index))]
            if c.cur_status == 0:
                all_zombie = False
                return all_zombie

    return all_zombie








if __name__ == "__main__":  
    mat = [[1, 1, 1, 1, 1],
            [1, 1, 1, 1, 1],
            [0, 1, 0, 1, 1],
            [1, 1, 1, 0, 1]]

    print(how_many_hours(mat))