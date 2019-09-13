from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 

class Node(object):
    'A node class to represent individual Node'
    def __init__(self, item:int)->None:
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

    def set_left_child(self,left_child_key:int)->None:
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

    def set_right_child(self,right_child_key:int)->None:
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
        if key is not None and self.get_root() is not None:
            self._insert_help(self.get_root(),key)
        elif self.get_root() is None:
            self.set_root(key)
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

    def inorder_successor(self,node:Optional[Node]) -> Optional[int]:
        '''
        Find inorder successor of a node in BST
        '''
        if node is not None:
            if node.get_right_child() is not None: 
                inorder_successor_node:Optional[Node] = self.find_min_right_subtree(node.get_right_child()) 
                if inorder_successor_node is not None: 
                    return inorder_successor_node.get_key() 
                else:
                    return None
            else: 
                if node.get_parent() is not None:
                    inorder_successor_node = self.find_max_parent_node(node.get_parent(),node) 
                    if inorder_successor_node is not None: 
                        return inorder_successor_node.get_key() 
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


    
            