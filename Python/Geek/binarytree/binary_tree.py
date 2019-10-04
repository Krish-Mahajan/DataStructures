from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys

class Node(object):
    'A node class to represent individual Node'
    def __init__(self, item:Optional[int]=None)->None: 
        if item is not None:
            self.__key = item
            self.__parent = self.__left_child = self.__right_child = Optional[Node] 

    def get_key(self)-> int:
        return self.__key

    def set_key(self,key:int)->None:
        self.__key = key   


    def get_parent(self) -> Optional[Node]:
        if(isinstance(self.__parent,Node)):
            return self.__parent 
        else:
            return None

    def get_left_child(self)-> Optional[Node]:
        if isinstance(self.__left_child, Node):
            return self.__left_child 
        else:
            return None

    def set_left_child(self,left_child_key:Optional[int])->None:
        if left_child_key!=None:
            self.__left_child = Node(left_child_key)
            self.__left_child.__parent = self
        else:
            self.__left_child = None  

    def get_right_child(self)-> Optional[Node]:
        if isinstance(self.__right_child, Node):
            return self.__right_child  
        else:
            return None

    def set_right_child(self,right_child_key:Optional[int])->None:
        if right_child_key!=None:
            self.__right_child = Node(right_child_key)
            self.__right_child.__parent = self
        else:
            self.__right_child = None 


class BinaryTree(object):
    'A BinaryTree class to represent individual BinaryTree'

    def __init__(self, root_key:int=None)-> None:
        if root_key:
            self.__root = Optional[Node(root_key)]
        else:
            self.__root = None 


    def set_root(self,root_key:int)-> None:
        self.__root = Node(root_key) 

    
    def get_root(self)-> Optional[Node]:
        if self.__root :
            return self.__root 
        else:
            print('Root Node not set Exception') 
            return None
        
    def inorder_tree_traversal(self)-> Optional[List[Node]]: 
        self.node_list_inorder:List[Node]=[]
        '''
        Inorder Tree Traversal
        '''
        if self.__root == None :
            print('Root Node not set Exception') 
            return None
        else:
            self.__inorder_tree_traversal(self.get_root(),self.node_list_inorder) 
            return self.node_list_inorder

    def __inorder_tree_traversal(self, node:Optional[Node]=None,node_list:List[Node]=None)-> None: 
        if node is not None:
            self.__inorder_tree_traversal(node.get_left_child())
            self.node_list_inorder.append(node)
            self.__inorder_tree_traversal(node.get_right_child()) 
            
            
    def preorder_tree_traversal(self)->None: 
        '''
        Preorder Tree Traversal
        '''
        if self.__root == None :
            print('Root Node not set Exception')
        else:
            self.__preorder_tree_traversal(self.get_root())

    def __preorder_tree_traversal(self, node:Optional[Node]) -> None:
        if node is None:
            return
        else: 
            print(node.get_key())
            self.__preorder_tree_traversal(node.get_left_child())
            self.__preorder_tree_traversal(node.get_right_child()) 
            
            
    def postorder_tree_traversal(self) -> None: 
        '''
        PostOrder Tree Traversal
        '''
        if self.__root == None :
            print('Root Node not set Exception')
        else:
            self.__postorder_tree_traversal(self.get_root())

    def __postorder_tree_traversal(self, node:Optional[Node]) -> None:

        if node is None:
            return
        else: 
            self.__postorder_tree_traversal(node.get_left_child())
            self.__postorder_tree_traversal(node.get_right_child()) 
            print(node.get_key()) 


    def insert(self,key:int) -> None: 
        '''
        Functions to insert element in BinaryTree
        '''
        if key is not None :
            if self.get_root() is  None:
                self.set_root(key) 
            else:
                self._insert_help(self.get_root(),key)           
        elif key is None:
                print("Key is null")
    
    def _insert_help(self,node:Optional[Node],key:int) -> None:
        if node is not None:
            if(key <= node.get_key()):
                if(node.get_left_child() is not None):
                    self._insert_help(node.get_left_child(),key)
                else:
                    node.set_left_child(key) 
                    return
            else:
                if(node.get_right_child() is not None):
                    self._insert_help(node.get_right_child(),key)
                else:
                    node.set_right_child(key) 
                     
    def insert_from_list(self,l:List[int])-> None: 
        '''
        Function to insert elements in BST using List
        '''
        for element in l:
            self.insert(element) 

    def inorder_successor(self,node:Optional[Node]) -> Optional[Node]:
        '''
        Find inorder successor of a node in BST
        '''
        if node is not None:
            if node.get_right_child() is not None: 
                inorder_successor_node:Optional[Node] = self.find_min_right_subtree(node.get_right_child()) 
                if inorder_successor_node is not None: 
                    return inorder_successor_node
                else:
                    return None
            else: 
                if node.get_parent() is not None:
                    inorder_successor_node = self.find_max_parent_node(node.get_parent(),node) 
                    if inorder_successor_node is not None: 
                        return inorder_successor_node
                    else:
                        return None
                else :
                    print('Node n :{} has no inorder successor'.format(node.get_key)) 
                    return None

        else :
            return None


    def find_min_right_subtree(self,node:Optional[Node]) -> Optional[Node]:
        '''
        Find node with minimum key on right subtree
        '''
        if(node is not None and node.get_left_child() is not None):
            return self.find_min_right_subtree(node.get_left_child()) 
        elif node is not None and node.get_left_child() is None:
            return node 
        else:
            return None 

  


    def  find_max_parent_node(self,parent: Optional[Node] ,node:Node) -> Optional[Node]:
        '''
        Find ancestor parent node with Key greater than current node
        '''
        if parent is not None: 
            if parent.get_key() < node.get_key():
                return self.find_max_parent_node(parent.get_parent(),node) 
            else:
                return parent 
        else:
            return node 

    def height_of_tree(self) -> int: 
        '''
        Function to calculate height of tree
        '''
        if self.get_root() is not None:
            height :int = self._height_of_node(self.get_root()) 
            return height

        else:
            return 0

    def _height_of_node(self,node:Optional[Node])-> int:
        '''
        Function to calculate height of a node in Binary Tree
        '''
        if node is not None:
            return ( 1 + max(self._height_of_node(node.get_left_child()),self._height_of_node(node.get_right_child())))
        else:
            return 0 

    
    def level_order_traversal(self)-> Tuple[Tuple[(int,int)],...]:
        '''
        Function to calculate level_order_traversal of Binary Tree(Breadth First Travesal)
        '''
        height_of_tree :int = self.height_of_tree() 
        self.t:Tuple[Tuple[(int,int)],...] = ()
        for level in range(height_of_tree):
            self.print_level_order_keys(self.get_root(),1,level+1,self.t) 
        return self.t
        
    def print_level_order_keys(self,node:Optional[Node],initial_level:int,target_level:int,t:Tuple[Tuple[(int,int)],...])-> None:
        if node is not None:
            if(initial_level == target_level): 
                print(target_level , '->' , node.get_key())
                self.t += ((target_level,node.get_key()),) 
            else:
                self.print_level_order_keys(node.get_left_child(),initial_level+1,target_level,self.t) 
                self.print_level_order_keys(node.get_right_child(),initial_level+1,target_level,self.t) 


    def width_of_tree(self)-> int:
        '''
        Function to calculate width of Binary Tree
        '''
        if self.get_root() is not None:
            map :Dict[int,int] = {}
            map = self._width(self.get_root(),1,map) 
            #print(map)
            return max(map,key=map.get)
        else:
            return 0

    def _width(self,node:Optional[Node],level:int,map:Dict[int,int])-> Dict[int,int]:
        if node is not None: 
            if level not in map.keys():
                map[level] = 1
            else:
                map[level] +=1
            self._width(node.get_left_child(),level+1,map)
            self._width(node.get_right_child(),level+1,map) 
            return map 
        else:
            return map  


    def nodes_k_distance(self,k:int)->Optional[List[Node]]:
        '''
        Find Nodes at K distance
        '''
        if self.get_root() is not None: 
            nodes_k:List[Node]=[]
            nodes_k= self._nodes_k_distance(self.get_root(),nodes_k,k)
            return nodes_k

        else:
            return None  


    def _nodes_k_distance(self,node:Optional[Node],nodes_k:List[Node],k:int)->List[Node]:
        if node is not None: 
            if k == 0:
                nodes_k.append(node)
            self._nodes_k_distance(node.get_left_child(),nodes_k,k-1)
            self._nodes_k_distance(node.get_right_child(),nodes_k,k-1) 
            return nodes_k 
        else:
            return nodes_k 


    def diameter_of_binary_tree(self,node:Optional[Node]=None)-> int: 
        '''
        Function to calculate diameter of binary tree
        '''
        if node is None:
            return 0
        else:
            lheight:int = self._height_of_node(node.get_left_child())
            rheight:int = self._height_of_node(node.get_right_child()) 

            diameter_ltree:int = self.diameter_of_binary_tree(node.get_left_child())
            diameter_rtree:int = self.diameter_of_binary_tree(node.get_right_child()) 

            return max((lheight+rheight),max(diameter_ltree,diameter_rtree))  


    def search_element_BST(self,key:int)->Optional[Node]: 
        '''
        Search for a key in BST
        '''
        return self._search_element_BST(key,self.get_root()) 


    def _search_element_BST(self,key:int,node:Optional[Node])->Optional[Node]:
        if node is None:
            return None 
        else: 
            if key < node.get_key():
                return self._search_element_BST(key,node.get_left_child()) 
            elif key > node.get_key():
                return self._search_element_BST(key,node.get_right_child())
            else:
                return node  


    def print_ancestors_node(self,key:int,node:Optional[Node])->bool:
        '''
        Print ancestors of a key in binary_tree
        '''
        if node is None:
            return False 
        
        elif node.get_key() == key :
            return True

        elif(self.print_ancestors_node(key,node.get_left_child()) or self.print_ancestors_node(key,node.get_right_child())):
            print(node.get_key()) 
            return True 
        
        else: return False 



    def check_binary_tree_if_BST(self)-> bool: 
        '''
        check if a binary tree is BST without doing inorder traversing
        '''
        if self.get_root() is not None: 
            MAX_INT = sys.maxsize
            MIN_INT = -sys.maxsize
            ans:bool = self._check_binary_tree_if_BST(self.get_root(),MAX_INT,MIN_INT)
            return ans

        else:
            return False  

    def _check_binary_tree_if_BST(self, node:Optional[Node],max:int,min:int)->bool: 

        if node is None: return True

        if(node.get_key() >= max or node.get_key() <= min):return False 

        return( self._check_binary_tree_if_BST(node.get_left_child(),node.get_key(),min) and (self._check_binary_tree_if_BST(node.get_right_child(),node.get_key(),max))) 



    def create_BST_from_sorted_array(self, arr:List[int])->None: 
        '''
        Create Binary Search Tree from sorted array
        '''
        self._create_BST_from_sorted_array(arr,0,len(arr)-1) 


    def _create_BST_from_sorted_array(self,arr:List[int],min:int,max:int)-> None: 
        if min > max: return

        curr_key_index:int = int((min + max)/2)
        self.insert(arr[curr_key_index]) 
        self._create_BST_from_sorted_array(arr,min,curr_key_index-1) 
        self._create_BST_from_sorted_array(arr,curr_key_index+1,max)  


    def delete_node(self,key:int)->None:
        """
        Delete node of BST (Buggy Code)
        Most difficult
        """
        node:Optional[Node] = self.search_element_BST(key) 
        if node is not None:
            # Case 1. Node is a leaf
            if( node.get_left_child() is None and node.get_right_child() is None): 
                if node.get_parent() is not None:
                    if node.get_key() <= node.get_parent().get_key() : 
                        node.get_parent().set_left_child(None)
                    else:
                        node.get_parent().set_right_child(None) 
        

            #Case 2. Node has both the child
             #Find Inorder successor of Tree , copy the content to current Node and delete the inorder successor
            elif  node.get_left_child() is not None and node.get_right_child() is not None :
                inorder_succ_node:Optional[Node] = self.inorder_successor(node) 
                if inorder_succ_node is not None: 
                    tmp_key:int = inorder_succ_node.get_key()
                    self.delete_node(tmp_key) 
                    node.set_key(tmp_key) 

            #case 3 Node has single child
            else:
                if node.get_right_child() is None and node.get_left_child() is not None:
                    node.set_key(node.get_left_child().get_key())
                    node.set_left_child(None) 
                else:
                    node.set_key(node.get_right_child().get_key())
                    node.set_right_child(None)



    







    



        






        
            



    
            