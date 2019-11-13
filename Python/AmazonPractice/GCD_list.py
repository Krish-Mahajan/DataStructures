

from typing import List, Set, Dict, Tuple, Optional

def cal_gcd(a:int,b:int) -> int:
    if a == 0 :return b 
    if b == 0 :return a 
    if a == b :return b

    if a > b :return cal_gcd(a-b,b) 
    else :return cal_gcd(a,b-a)



def generalizedGCD(num:int, arr:List[int])-> int: 

    gcd_till_now:int = arr[0]
    for i in range(1,len(arr)-1):
        new_gcd:int = cal_gcd(gcd_till_now,arr[i+1]) 
        gcd_till_now = new_gcd

    return gcd_till_now


    
    



if __name__ == "__main__":
     ans:int = generalizedGCD(5,[2,4,6,8,10])
     print(ans)

