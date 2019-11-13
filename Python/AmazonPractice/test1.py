

from __future__ import annotations
import sys 
import random 
from typing import List, Set, Dict, Tuple 


class Node(object) : 
    
    def __init__(self,index:int,current_day_status:int,next_day_status:int=None) -> None:
        self.index:int = index
        self.cds:int = current_day_status
        self.nds :int= next_day_status 
        
        
    def update_status(self,list_of_node:List[Node]) -> None:
        #Find neighbour nodes 
        
        #Index of current cell
        index:int = self.index 
        
        #CAse 1 : if nodes are not last two nodes
        if index not in [0,7] :
            neighbour_node_previous:Node= list_of_node[self.index - 1]
            neighbour_node_next:Node = list_of_node[self.index + 1]
            if ( neighbour_node_next.cds == 1 and neighbour_node_previous.cds == 1):
                self.nds = 0 
            elif ( neighbour_node_next.cds == 0 and neighbour_node_previous.cds == 0):
                self.nds = 0
            else:
                self.nds = 1 
                
        #Case 2 : First Node 
        if index == 0:
            neighbour_node_next = list_of_node[1] 
            if ( neighbour_node_next.cds == 0):
                self.nds = 0
            else:
                self.nds = 1   
                
        #Case 3 : Last Node 
        if index == 7:
            neighbour_node_previous = list_of_node[6]
            if ( neighbour_node_previous.cds == 0):
                self.nds = 0
            else:
                self.nds = 1   
            
                
        

def cellCompete(states, days) :
    # WRITE YOUR CODE HERE 
    list_of_node:List[Node] = [] 
    
    # store Nodes in a list with current_day_status
    for index in range(len(states)):
        n:Node = Node(index,states[index]) 
        list_of_node.append(n)  

        
    for day in range(days):
        #some logic to iterate over current state and update next_day_status for 
        #each passing day 
        for node in list_of_node :
            node.update_status(list_of_node)
        
        #NOw iterate over each node to update cds = nds
        for node in list_of_node :
            node.cds = node.nds   
            
        cds_status:List[int] = [node.cds for node in list_of_node]
        print("current day status {} after iteration {}".format(cds_status,day+1))
            
        
            
            
    #Return the final state 
    final_state:List[int] = []
    for node in list_of_node :
        final_state.append(node.nds)        
        
    print("Output is {}".format(final_state))
    return final_state 
    
if __name__ == "__main__":
    '''
    states = [1,0,0,0,0,1,0,0]
    days = 1 
    print('Test case 1 ')
    cellCompete(states,days)  
    '''
    
    #cellCompete(states,days) 
    x= 'Krish'
    for i in range(2,len(x)+1):
        print(x[:i])  