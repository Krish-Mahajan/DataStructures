



from __future__ import annotations
from typing import List, Set, Dict, Tuple, Optional 
import sys
import math 


def reorder_logs(logs:List[str]) -> List[str]:
    logs_map : Dict[str,List[str]] = {}
    letter_log_map : Dict[str,str] = {}
    digit_log_map : Dict[str,str] = {} 

    for log in logs:
        log_tokenized:List[str] = log.split(' ')
        logs_map[log_tokenized[0]] = log_tokenized
        if  log_tokenized[1].isdigit():
            digit_log_map[log_tokenized[0]] = log_tokenized[1]
        else:
            letter_log_map[log_tokenized[0]] = log_tokenized[1]


    #sort letter_digit_log_map
    sorted_letter_log_map : List[Tuple[str,str]] = sorted(letter_log_map.items(), key=lambda x: (x[1],x[0])) 

    
    
    output_list:List[str] = []
    for  key,value in sorted_letter_log_map: 
         text_list:List[str] = logs_map[key]
         text :str = ' '
         text = text.join(text_list) 
         output_list.append(text) 

    for key in digit_log_map :
        text_list = logs_map[key] 
        text = ' '
        text = text.join(text_list) 
        output_list.append(text) 



    return output_list
    

if __name__ == "__main__":  
    logs:List[str] = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    print(reorder_logs(logs))