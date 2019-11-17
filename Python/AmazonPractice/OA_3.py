
            
def numberAmazonTreasureTrucks(rows, column, grid):
        
    numofisland = 0
    if len(grid) == 0 or grid == None:
        return 0 
    
    for i in range(0 , len(grid)):
        for j in range(0, len(grid[i])):
            if grid[i][j] == 1:
                numofisland +=  dfs(grid , i , j)
                
    return numofisland
                
                    
                    
def dfs( grid, i , j):
    if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[i]) or grid[i][j] == '0':
        return 0 
    
    grid[i][j] = '0'
    
    dfs(grid, i+1, j) #down
    dfs(grid, i-1 , j) #up
    dfs(grid, i, j+1) #right
    dfs(grid, i, j-1) #left

    return 1



    
if __name__ == "__main__":  
    '''
    mat = [[1, 1, 1, 1, 1],
            [1, 1, 1, 1, 1],
            [0, 1, 0, 1, 1],
            [1, 1, 1, 0, 1]]
    '''
    mat = [['1', '1', '0', '0'],
           ['0', '0', '1', '0'],
           ['0', '0', '0', '0'],
           ['1', '0', '1', '1'],
           ['1', '1', '1', '1']]
    
    
    mat1 = [['1', '1', '0', '0'],
            ['0', '0', '0', '0'],
           ['0', '0', '1', '1'],
           ['0', '0', '0', '0']]
        
        
    rows = 4
    column = 4
    
    print(numberAmazonTreasureTrucks( rows, column,mat1))