
from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math



def find_top_n_competitors(num_competitors:int , find_top_n_competitors:int,competitors:List[str],num_reviews:int,reviews:List[str]) -> List[str]:
    competitor_review_count : Dict[str,int] = { } 
    output : List[str] = []
    
    #Iterate over all the competitors and initialized the count = 0 
    for competitor in competitors :
        if competitor not in competitor_review_count:
            competitor_review_count[competitor] = 0 

    #  Iterate over all the reviews and collect the count of occurences of competitors:
    for review in reviews:
        review_tokens:List[str] = review.split(' ')
        for review_token in review_tokens:
            review_token = review_token.lower()
            if review_token in competitor_review_count:
                competitor_review_count[review_token] += 1  

    # Sort the competitior review count 
    if len(competitor_review_count) > 0:
        sorted_competitor_review_count : List[Tuple[str,int]] = sorted(competitor_review_count.items(), key=lambda x: (x[1],x[0]),reverse=True) 

    for i in range(find_top_n_competitors):
        output.append(sorted_competitor_review_count[i][0]) 

    
    return output





if __name__ == "__main__": 
    competitors:List[str] = ['newshop','shopnow','afshion','fashionbeats','mymarket','tcellular']
    reviews :List[str] = ["newshop is providing good service in the city;everyone should try newshop",
                   "best services by newshop",
                   "fashionbeats has great services in the city",
                   "Im proud to have fashionbeats",
                   "mymarket has awesome service",
                   "thank Newshop for the quick delivery"]
    print(find_top_n_competitors(6,2,competitors,6,reviews))

