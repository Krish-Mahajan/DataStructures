
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math 

def recommend_product(numProducts:int,repository:List[str],customerQuery:str) -> List[List[str]]:

    suggestion_list:List[List[str]] = []

    #Iterate over queries starting from first two character
    for i in range(2,len(customerQuery)+1):
        query_till_now:str = customerQuery[:i] 
        products:List[str] = recommend_products_query(repository,query_till_now) 
        suggestion_list.append(products)

    return suggestion_list 

def recommend_products_query(repository:List[str],query_till_now:str) -> List[str]:

    product_list:List[str]= []

    #Iterate over repository for possible products for each repository
    for product in repository:
        if product[:len(query_till_now)].lower() == query_till_now.lower(): #compare lower case
            product_list.append(product) 

    if len(product_list) > 3:
        product_list.sort()
        return product_list[0:3] 

    return product_list





if __name__ == "__main__":  
    numProducts:int = 5
    repository:List[str] = ["mobile", "mouse", "moneypot", "monitor", "mousepad"]
    customerQuery :str= "mouse"
    print(recommend_product(numProducts,repository,customerQuery))
