
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math


def popularNToys(numToys:int, topToys:int, toys:List[str], 
                    numQuotes:int, quotes:List[str]):  

    
    toys_count : Dict[str,int] = {}
    output_list:List[str] = []  

    #Initialize initial toy count to 0
    for toy in toys :
        if toy not in toys_count:
            toys_count[toy.lower()] = 0  

    
    #  Iterate over all the Quotes and collect the count of occurences of toys:
    for quote in quotes:
        quote_tokens:List[str] = quote.split(' ')
        for quote_token in quote_tokens:
            quote_token = quote_token.lower() #case insentive comparison
            if quote_token in toys_count:
                toys_count[quote_token] += 1   

    # removing toys with count = 0
    toys_count_new : Dict[str,int] = {k: v for k, v in toys_count.items() if v > 0} 

    # Sort the competitior review count 
    if len(toys_count) > 0:
        sorted_toys_count : List[Tuple[str,int]] = sorted(toys_count_new.items(), key=lambda x: (x[1],x[0]),reverse=True) 

    
    #If top Toys more than no. of toys
    if topToys > numToys :
        topToys = len(sorted_toys_count)


    for i in range(topToys):
        output_list.append(sorted_toys_count[i][0])  


    return output_list

    