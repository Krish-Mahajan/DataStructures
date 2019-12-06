package datastructure.stringarray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	
	
	   private static class Word{
	        String s;
	        int count;
	        Word(String s , int count){
	           this.s = s;
	            this.count = count;
	        }
	    }
	    
	    public List<String> topKFrequent(String[] words, int k) {
	        
	        Map<String, Word> map = new HashMap<>();
	        for(String s : words){
	            if(map.containsKey(s)){
	                map.get(s).count = map.get(s).count+1;
	            }
	            else{
	                map.put(s,new Word(s,1));
	            }
	        }
	        
	        //Add elements to priorityQueue based on frequency
	        PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>(){
	            
	        	public int compare(Word w1,Word w2){
	                if(w2.count - w1.count ==0){
                        return w1.s.compareTo(w2.s);
                    }
	                return w2.count - w1.count;
	            }
	        });
	        
	        for(String s :map.keySet()){
	            pq.add(map.get(s));
	        }
	        
	        //Extract element from PQ
	        List<String> resultString = new ArrayList<>();
	        for(int i=0;i<k;i++){
	        	String s = pq.poll().s;
	            resultString.add(s);
	        }
	         
	        return resultString;
	        }
	    
	    
	    public static void main(String[] args) {
	    	String[] s= {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
	    	String[] s2 = {"i", "love", "leetcode", "i", "love", "coding"};
	    			
	    	int k =2;
	    	TopKFrequentWords tk = new TopKFrequentWords();
	    	System.out.println(tk.topKFrequent(s2, k));
	    }
	        
	
	
}
