
from __future__ import annotations
import unittest
from typing import List, Set, Dict, Tuple, Optional
import random 
from link_list import LinkList , Node  


class LinkListTestCase(unittest.TestCase):

    def test_link_list_from_list(self)->None: 
        print('\nInserting Elements in LinkList using Python List') 
        elements :List[int] =[ ] 
        ll : LinkList = LinkList()
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements are :{}'.format(elements))
        ll.create_link_list_from_list(elements)
            

        ll.print_link_list()


        print('\n******************************************\n') 


    def test_add_elements_to_link_list_at_end(self)-> None:
        print('\Insert element in existing LinkList') 
        elements :List[int] =[ ] 
        ll : LinkList = LinkList()
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements of linkList are :{}'.format(elements))
        ll.create_link_list_from_list(elements) 

        new_element:int = random.randrange(0,101)
        print('Adding new element {0}'.format(new_element)) 
        ll.insert(new_element) 
        print('Elements of linkList are adding new element')
        ll.print_link_list()  


    def test_add_elements_to_link_list_at_random_place(self) -> None: 
        print('\Insert element in existing LinkList') 
        elements :List[int] =[ ] 
        ll : LinkList = LinkList()
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements of linkList are :{}'.format(elements))
        ll.create_link_list_from_list(elements) 

        after_element:int = random.choice(elements)
        new_element:int = random.randrange(0,100)
        print('Adding new element {0} after exisiting element {1}'.format(new_element,after_element)) 
        ll.insert(data=new_element,prev_node_data=after_element) 
        print('Elements of linkList are adding new element')
        ll.print_link_list()   


    def test_delete_node(self) -> None: 
        print('\Insert element in existing LinkList') 
        elements :List[int] =[ ] 
        ll : LinkList = LinkList()
        #random.seed(a=1)
        elements = [random.randrange(0,101) for _ in range(10)]  
        print('Elements of linkList are :{}'.format(elements))
        ll.create_link_list_from_list(elements) 

        element_to_delete:int = random.choice(elements)
        print('Deleting element {0} from LinkList'.format(element_to_delete)) 
        ll.delete_node(element_to_delete)
        print('Elements of linkList after deleting element')
        ll.print_link_list()   


    def test_link_list_size(self) -> None: 
        print('\Insert element in existing LinkList') 
        elements :List[int] =[ ] 
        ll : LinkList = LinkList()
        size:int = random.randrange(0,20)
        elements = [random.randrange(0,101) for _ in range(size)] 
        print('No of elements to be inserted in LinkList are {0}'.format(len(elements))) 
        print('Elements of linkList are :{}'.format(elements))
        ll.create_link_list_from_list(elements) 

        size_recurse : int = ll.find_linklist_size_recursively()
        print('Size of LinkList is {0}'.format(size_recurse)) 


    def reverse_linklist_iteratively(self)-> None: 
        print('\Insert element in existing LinkList') 
        elements :List[int] =[ ] 
        ll : LinkList = LinkList()
        size:int = random.randrange(0,20)
        elements = [random.randrange(0,101) for _ in range(size)] 
        #elements = [85, 13, 53, 86, 58, 48]
        print('No of elements to be inserted in LinkList are {0}'.format(len(elements))) 
        print('Elements of linkList are :{}'.format(elements))
        ll.create_link_list_from_list(elements) 
        ll.print_link_list() 

        ll.reverse_linklist_iteratively()
        print('LinkList after reversing iteratively') 
        ll.print_link_list()  



    def reverse_linklist_recursively(self)-> None: 
        print('\Insert element in existing LinkList') 
        elements :List[int] =[ ] 
        ll : LinkList = LinkList()
        size:int = random.randrange(0,20)
        elements = [random.randrange(0,101) for _ in range(size)] 
        #elements = [85, 13, 53, 86, 58, 48]
        print('No of elements to be inserted in LinkList are {0}'.format(len(elements))) 
        print('Elements of linkList are :{}'.format(elements))
        ll.create_link_list_from_list(elements) 
        ll.print_link_list() 

        ll.reverse_linklist_recursively()
        print('LinkList after reversing recursively') 
        ll.print_link_list()  



    def reverse_linklist_K(self)-> None: 
        print('\Insert element in existing LinkList') 
        elements :List[int] =[ ] 
        ll : LinkList = LinkList()
        #size:int = random.randrange(0,20)
        #elements = [random.randrange(0,101) for _ in range(size)] 
        elements = [85, 13, 53, 86, 58, 48]
        print('No of elements to be inserted in LinkList are {0}'.format(len(elements))) 
        print('Elements of linkList are :{}'.format(elements))
        ll.create_link_list_from_list(elements) 
        ll.print_link_list() 

        ll.reverseK(3)
        print('LinkList after reversing recursively in group of K') 
        ll.print_link_list() 
        







if __name__ == "__main__": 
    #unittest.main()
    test = LinkListTestCase()
    #test.test_link_list_from_list() 
    #test.test_add_elements_to_link_list_at_end()
    #test.test_add_elements_to_link_list_at_random_place()
    #test.test_delete_node()
    #test.test_link_list_size() 
    #test.reverse_linklist_iteratively()
    #test.reverse_linklist_recursively()
    test.reverse_linklist_K()

