package datastructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;
public class StringArray { 
	
	
	//CTCI 1.1 
	public boolean isStringUnique(String s){
		
		Map<Character,Integer> countCh = new HashMap<>();
		
		for(int i=0 ; i< s.length();i++){
			if(countCh.containsKey(s.charAt(i))) return false; 
			else {
				countCh.put(s.charAt(i), 0);
			}
			
		}
		
		
		return true;
	}
	
	
	//CTCI 1.2 
	public boolean isPermutation(String s1,String s2) {
		
		
		if(s1.length() !=s2.length()) return false;
		
		char[] arrs1 = s1.toCharArray();
		Arrays.sort(arrs1); 
		String s1_new = new String(arrs1);
		
		char[] arrs2 = s1.toCharArray();
		Arrays.sort(arrs2);
		String s2_new = new String(arrs2);
		
		return s1_new.equals(s2_new);
	} 
	
	
	
	
	
	
	
	
	
	
	
}
