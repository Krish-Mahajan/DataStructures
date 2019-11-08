
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math

class Node(object):
    '''
    A Python Program to represent adjacency list of the node
    ''' 
    def __init__(self,data:int,weight:int=0)-> None: 
        if data is not None:
            self._index:int = data 
            self._weight:int = weight
        else: print("A node must have data to be created") 


    def get_node_index(self)->int:
        '''
        Return Index of the node
        '''
        if self._index is not None:
            return self._index 
        else:
            print('No such node present yet')
            return None  

    
    def get_node_weight(self) -> int:
        '''
        get node weight
        ''' 
        return self._weight



class Graph(object):
    '''
    A class to represent a graph.A graph is a list of adjancency lists.
    Size of the list will be the number of the list.
    ''' 
    def __init__(self,V:int=None)-> None:
        '''
        Initializes a new graph object
        '''
        self.adj_list: Dict[int,List[Node]] = {}
        self.V = V

        
    def add_undirected_edge(self,src:Node ,dest:Node,weight:int=None) -> None: 
        '''
        Add a undirected edge between source node and destination node
        '''
        if not weight:
            if src is not None and dest is not None: 
                if src.get_node_index() in self.adj_list.keys():
                    self.adj_list[src.get_node_index()].append(dest)
                else: 
                    self.adj_list[src.get_node_index()] = [dest]  

                if dest.get_node_index() in self.adj_list.keys():
                    self.adj_list[dest.get_node_index()].append(src)
                else: 
                    self.adj_list[dest.get_node_index()] = [src]   

        else: 
            if src is not None and dest is not None: 
                if src.get_node_index() in self.adj_list.keys():
                    self.adj_list[src.get_node_index()].append(Node(dest.get_node_index(),weight))
                else: 
                    self.adj_list[src.get_node_index()] = [Node(dest.get_node_index(),weight)]  

                if dest.get_node_index() in self.adj_list.keys():
                    self.adj_list[dest.get_node_index()].append(Node(src.get_node_index(),weight))
                else: 
                    self.adj_list[dest.get_node_index()] = [Node(src.get_node_index(),weight)]   

            

    
    def add_directed_edge(self,src:Node ,dest:Node , weight:int=None) -> None:
        '''
        Add a directed edge between source node and destination node
        ''' 
        if not weight:
            if src is not None and dest is not None: 
                if src.get_node_index() in self.adj_list.keys():
                    self.adj_list[src.get_node_index()].append(dest)
                else: 
                    self.adj_list[src.get_node_index()] = [dest]   
                    
                if dest.get_node_index() not in self.adj_list.keys():
                    self.adj_list[dest.get_node_index()] = []  

        else: 
            if src is not None and dest is not None: 
                new_dest_node : Node = Node(dest.get_node_index(),weight)
                if src.get_node_index() in self.adj_list.keys():
                    self.adj_list[src.get_node_index()].append(new_dest_node)
                else: 
                    self.adj_list[src.get_node_index()] = [new_dest_node]   
                    
                if new_dest_node.get_node_index() not in self.adj_list.keys():
                    self.adj_list[new_dest_node.get_node_index()] = [] 

                


    def print_graph(self) -> None:
        '''
        Function to print current status of the project
        ''' 
        for node_index in self.adj_list.keys():
            neighbor_nodes:List[int] = [neighbor_node.get_node_index() for neighbor_node in self.adj_list[node_index]]
            print('Node : {} has following neighbor nodes {}'.format(node_index , neighbor_nodes))  


    def BFS(self,start_node:Node)-> None: 
        '''
        Breadth First Traversal of Graph
        '''
        if start_node is not None:
            queue : List[Node] = [start_node] 

            #Assuming List index is 0 - n range
            visited : List[bool]= [False]*len(self.adj_list)

            while len(queue) > 0:
                node : Node = queue.pop(0)
                if visited[node.get_node_index()] !=True:
                    visited[node.get_node_index()] = True
                    print('Node visited is :{}'.format(node.get_node_index()))
                    neighbor_nodes:List[Node] = self.adj_list[node.get_node_index()] 
                    for neighbor_node in neighbor_nodes:
                        if visited[neighbor_node.get_node_index()] !=True:
                            queue.append(neighbor_node) 



    def DFS(self , start_node:Node) -> None: 
        '''
        Depth first traversal of Tree
        ''' 
        if start_node is not None:
            stack : List[Node] =[start_node] 
            
            #Assuming List index is 0 - n range
            visited : List[bool] = [False]*len(self.adj_list) 
            while len(stack) > 0:
                cur_node :Node = stack.pop()
                if visited[cur_node.get_node_index()] !=True:
                    visited[cur_node.get_node_index()] = True
                    print('Node visited is :{}'.format(cur_node.get_node_index()))
                    neighbor_nodes:List[Node] = self.adj_list[cur_node.get_node_index()] 
                    for neighbor_node in neighbor_nodes:
                        if visited[neighbor_node.get_node_index()] !=True:
                            stack.append(neighbor_node)  

    def topological_sort(self) -> List[int]:
        '''
        Topological sort of DAG
        '''
        visited : List[bool] = [False]*len(self.adj_list)  
        stack : List[int] =[]

        for cur_node_index in  self.adj_list.keys():
            if visited[cur_node_index] !=True:
                self._topo_sort_util(stack,visited,cur_node_index) 

        print("\nTopological sorting of the graph is") 
        for i in stack[::-1]:
            print(i , end = ' ')
        print('\n')
        return stack


    def _topo_sort_util(self, stack:List[int],visited:List[bool],cur_node_index:int) -> None:
        visited[cur_node_index] = True  

        for neighbor_node in self.adj_list[cur_node_index]:
                if visited[neighbor_node.get_node_index()] !=True:
                    self._topo_sort_util(stack,visited,neighbor_node.get_node_index()) 
    
        stack.append(cur_node_index) 



    def shortest_path_given_vertex_DAG(self,start_node:Node)->None:
        '''
        Shortest path to every node given start_node 
        '''
        # Initializing all distances 
        dist : List[int] = [10000]*len(self.adj_list.keys()) 
        dist[start_node.get_node_index()] = 0 


        stack : List[int] = self.topological_sort() 

        #Update the shortest distances
        while( len(stack) > 0):
            node_index : int = stack.pop() 
            print('Processing Node : {}'.format(node_index))
            neighbour_nodes : List[Node] = self.adj_list[node_index] 
            neighbour_nodes =[ n for n in  neighbour_nodes if n.get_node_index() != start_node.get_node_index()]
            for neighbour_node in neighbour_nodes:
                if dist[neighbour_node.get_node_index()] > dist[node_index] + neighbour_node.get_node_weight() :
                    dist[neighbour_node.get_node_index()] = dist[node_index] + neighbour_node.get_node_weight() 


        print('Minimum distances of node from Node :{}'.format(start_node.get_node_index()))
        for d in dist:
            print(d , end = ' ')  
        print('\n')



    def longest_path_given_vertex_DAG(self,start_node:Node)->None:
        '''
        Shortest path to every node given start_node 
        '''
        # Initializing all distances 
        dist : List[int] = [-10000]*len(self.adj_list.keys()) 
        dist[start_node.get_node_index()] = 0 


        stack : List[int] = self.topological_sort() 

        #Update the shortest distances
        while( len(stack) > 0):
            node_index : int = stack.pop() 
            print('Processing Node : {}'.format(node_index))
            neighbour_nodes : List[Node] = self.adj_list[node_index] 
            neighbour_nodes =[ n for n in  neighbour_nodes if n.get_node_index() != start_node.get_node_index()]
            for neighbour_node in neighbour_nodes:
                if dist[neighbour_node.get_node_index()] < dist[node_index] + neighbour_node.get_node_weight() :
                    dist[neighbour_node.get_node_index()] = dist[node_index] + neighbour_node.get_node_weight() 


        print('Max distances of node from Node :{}'.format(start_node.get_node_index()))
        for d in dist:
            print(d , end = ' ')
        print('\n') 



    def isDirectedGraphCyclicDFS(self) -> bool:
        '''
        Calculate if a given directed graph is cyclic using DFS approach
        '''
        visited:List[bool] = [False]*len(self.adj_list) 
        rec_stack :List[bool]= [False]*len(self.adj_list) 

        for node in self.adj_list:
            if visited[node] == False:
                if self.isDirectedGraphCyclicDFSUtil(node,visited,rec_stack) == True:
                    return True 
        return False  



    def isDirectedGraphCyclicDFSUtil(self,node_index:int,visited:List[bool],rect_stack:List[bool]) -> bool:

        visited[node_index] = True 
        rect_stack[node_index] = True 

        for neighbor_node in self.adj_list[node_index]:
            if visited[neighbor_node.get_node_index()] == False:
                if self.isDirectedGraphCyclicDFSUtil(neighbor_node.get_node_index(),visited,rect_stack) == True:
                   return True 
            elif rect_stack[neighbor_node.get_node_index()] == True:
                return True 
        
        rect_stack[node_index] = False
        return False 


    def is_undirected_graph_cyclic(self) -> bool:
        
        '''
        Function to check if undirected graph is cyclic using union 
        and find.
        '''

        parent : List[int] = [-1]*self.V  #to make sure edges are pass only once (i,e 1-2 and 2-1 is counted as one)
        edges_covered : List[List[int]] = []
        
        for node in self.adj_list:
                for neighbor_node in self.adj_list[node]:
                    edge:List[int] = [node,neighbor_node.get_node_index()]
                    edge.sort()
                    if edge not in edges_covered:
                        edges_covered.append((edge))
                        x:int = self.find_parent(parent,node)
                        y:int = self.find_parent(parent,neighbor_node.get_node_index())
                        if x ==y:
                            return True
                        self.union(parent,x,y) 

        return False


    def find_parent(self,parent:List[int],node_index:int) -> int:
        if parent[node_index] == -1 :
            return node_index 
        else:
            return self.find_parent(parent,parent[node_index]) 





    def union(self,parent:List[int],x:int,y:int) -> None:
        x_set:int = self.find_parent(parent,x) 
        y_set:int = self.find_parent(parent,y)
        parent[x_set] = y_set  





    def kruskal_mst(self) -> None:
        '''
        Minimum spanning tree for undirected connected graph
        '''
        result : List[List[int]] = [] #This will store resultant MST
        i:int = 0 #Index variable used for sorted edges 
        e:int =0  #Index variable used for result[]

        #STEP 1 SORT ALL EDGES IN NON DECREASING ORDER OF WEIGHT 
        sorted_edges : List[List[int]] = self.sort_edge_based_on_weight()  

        parent : List[int] =[-1]*self.V  



        #Number of edges to be taken ins equal to V - 1 
        while e < self.V -1 : 
            #Step 2 : pick the smallest edge ad increment , the index for next iteration 
            u:int =  sorted_edges[i][0]
            v:int =  sorted_edges[i][1]
            w:int =  sorted_edges[i][2] 

            i = i + 1 
            x:int = self.find_parent(parent,u)
            y:int = self.find_parent(parent,v) 

            #If including this edge doesn't cause cycle, #Include it in result and increment the index
            # of result for next edge 
            if x!=y:
                e = e + 1
                result.append([u,v,w])
                self.union(parent,x,y) 
            #Else discard the edge 

               # print the contents of result[] to display the built MST 
        print("Following are the edges in the constructed MST")
        for u,v,weight  in result: 
            #print str(u) + " -- " + str(v) + " == " + str(weight) 
            print ("%d -- %d == %d" % (u,v,weight)) 




    def sort_edge_based_on_weight(self) -> List[List[int]]: 
        edges_covered : List[List[int]] = []
        result : List[List[int]] = []
        for node in self.adj_list:
            for neighbor_node in self.adj_list[node]:
                edge:List[int] = [node,neighbor_node.get_node_index()]
                edge.sort()
                if edge not in edges_covered:
                    result.append([node,neighbor_node.get_node_index(),neighbor_node.get_node_weight()]) 
        result = sorted(result,key=lambda item: item[2])
        return result