numRouters = 7
numLinks = 7
Links = [[0,1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3,4]]

class Router:
    def __init__(self,val):
        self.val = val
        self.links = []
    def addLink(self,router):
        self.links.append(router)

def dfs(rootNode,removedOne):
    visited = {}
    stack = []
    stack.append(rootNode)
    while len(stack) > 0:
        top = stack.pop()
        if  top.val in visited.keys():
            continue
        if  top.val != removedOne.val:
            visited[top.val] = 1
            stack += top.links
    return len(visited)
        
def criticalRouters(nR,nL,L):
    rList = [Router(i) for i in range(nR)]
    for link in L:
        rList[link[0]].addLink(rList[link[1]])
        rList[link[1]].addLink(rList[link[0]])
        
    
    criticals = []
    for i in range(nR):
        if i==0:
            rootNode = rList[1]
        else:
            rootNode = rList[0]
        removedOne = rList[i]

        visitedNum = dfs(rootNode,removedOne)
        if visitedNum == nR-1:
            continue
        else:
            criticals.append(i)
    return criticals

r = criticalRouters(numRouters,numLinks,Links)
print (r)