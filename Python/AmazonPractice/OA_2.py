
import itertools

# Cell class to store status of each server ( Cell === Server)
class Cell(object):

    def __init__(self,cur_status,next_status =-1):
        self.cur_status = cur_status 
        self.next_status =  next_status #by default next status is -1 i,e unknown



def minimumDays(rows, columns, grid):
    
    #check if not all servers status is 0 , else there'll be no update 
    if (all(server == 0 for server in itertools.chain(*grid))):
        print("No server with updated software")
        return 
    
    #check if  all servers status is 1 , 0 days required then
    if (all(server == 1 for server in itertools.chain(*grid))):
        print("All server already with updated software")
        return 0
    
    
    
    if len(grid) > 0:
        cell_map= current_status_cell(grid)    #Create hash  of the all the server
        total_rows = len(grid) 
        total_column_each_row = len(grid[0]) 
        total_days  = 0  #counter of total days to update all server
    
        while True: 
            total_days = total_days + 1
            for row_index in range(len(grid)):
                for col_index in range(len(grid[row_index])): 
                    c= cell_map.get(str(row_index)+str(col_index))
                    if c.cur_status == 1:  #Found a updated server
                        look_all_direction(cell_map,row_index,col_index,total_rows,total_column_each_row)   
            
            
            #Update the status of all the Servers
            update_new_status(grid,cell_map) 
    
            #check if all servers are already updated 
            if(check_all_updated(grid,cell_map)): break 


        return total_days  
        
    else :
        print(' Grid empty') 
        return 





#Index all the cell (i,e Servers) key will be the index i,e 00 , 01 etc..
def current_status_cell(grid):
    cell_map = {}
    for row_index in range(len(grid)):
        for col_index in range(len(grid[row_index])): 
                 c  = Cell(grid[row_index][col_index])
                 cell_map[str(row_index)+str(col_index)] = c 

    return cell_map


#update servers to new status 
def update_new_status(grid, cell_map):
    for row_index in range(len(grid)):
        for col_index in range(len(grid[row_index])): 
            c = cell_map[(str(row_index) + str(col_index))]
            if c.next_status != -1 : #that is the status has been changed
                c.cur_status = c.next_status 
                grid[row_index][col_index]=c.cur_status


#Any  server can update its adjacent server 
def look_all_direction(cell_map,row_index,col_index,total_rows,total_column_each_row):
    
    #look ahead 
    if col_index < total_column_each_row -1:
        c = cell_map.get(str(row_index)+str(col_index+1))
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
     

#check if all the servers are updated 
def check_all_updated(grid,cell_map): 
    all_updated  = True
    for row_index in range(len(grid)):
        for col_index in range(len(grid[row_index])): 
            c = cell_map[(str(row_index) + str(col_index))]
            if c.cur_status == 0:
                all_updated = False
                return all_updated

    return all_updated