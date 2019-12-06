package datastructure.stringarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class ReOrderData { 
	
	
public String[] reorderLogFiles(String[] logs) {
        
    String[] new_list = new String[logs.length];
    List<String> digit_list = new ArrayList<>();   
    Map<String,String[]> map = new HashMap<>();
    
    /**
    PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
        
        public int compare(String s1, String s2){
            if(map.get(s1)[1].compareTo(map.get(s2)[1])== 0){
               return s1.compareTo(s2);
            }
            
            return map.get(s1)[1].compareTo(map.get(s2)[1]);
        }
    });*/
    
    
    Arrays.sort(logs, new Comparator<String>(){
        
    	
    	
        public int compare(String s1, String s2){
        	
        	String[] split1 = s1.split(" ",2);
        	String[] split2 = s1.split(" ",2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;

            
        }
    });
    
    for(String log :logs){
        String[] log_entrees = log.split(" ",2);
        char second_entry = log_entrees[1].charAt(0);
        if(!Character.isDigit(second_entry)){
            map.put(log_entrees[0],log_entrees);
        }
        else digit_list.add(log);
    }
    
    /**
    for(String key:map.keySet()){
        pq.add(key);
    }
    
    int i =0;
    while(!pq.isEmpty()){
        String key = pq.poll();
        /**
        StringBuilder builder = new StringBuilder();
        for(String s :map.get(key)) {
        	builder.append(s +" ");
        }
        //new_list[i] = builder.toString();
        new_list[i] = String.join(" ",map.get(key));
        i++;
    }
    
    for(int j=0;j< digit_list.size();j++){
        new_list[i] = digit_list.get(j);
        i++;
    }*/
    
    return logs;
    
    
}
        
        
    
	
	public static void main(String[] arr) {
		
		String[] s = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		  Set<Character> closeBrackets = new HashSet<>(Arrays.asList(')','}',']'));
		ReOrderData ro = new ReOrderData();
		ro.reorderLogFiles(s);
	}
	
	
}
