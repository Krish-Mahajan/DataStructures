package datastructure.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
	
	
    public boolean isValid(String s) {
        char[] ch_array = s.toCharArray();
        Set<Character> closeBrackets = new HashSet<>(Arrays.asList(')','}',']'));
        Stack<Character> stack = new Stack<Character>();
        for(char c : ch_array){
            if(!closeBrackets.contains(c)){
                stack.push(c);
            }
            else{
                Character openBracket = stack.pop();
                if(openBracket.equals('{')) {
                    if(Character.compare(c,'}') !=0) return false;
                }
                if(openBracket.equals('[')) {
                    if(Character.compare(c,']') !=0) return false;
                }
                if(openBracket.equals('(')) {
                    if(Character.compare(c,')') !=0) return false;
                }
            }
        }
         return stack==null ? true : false ;
    }
    
    
    public static void main(String[] args) {
    	
    	ValidParentheses p = new ValidParentheses();
    	String s = "()";
    	p.isValid(s);
    }
}
