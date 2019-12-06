package datastructure.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    
    private static class Word{
        int dist;
        String s;
        Word(String s , int dist){
            this.dist =dist ;
            this.s =s;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordListOriginal) {
        
    	Set<String> wordList = new HashSet(wordListOriginal);
    	
    	Queue<Word> q = new ArrayDeque<>();
        Map<String,Boolean> visited = new HashMap<>();
        Map<String,Integer> distance = new HashMap<>();
        
        //Initialize Map
        for(String s: wordList) {
            visited.put(s,false);
            distance.put(s,0);
        } 
        
        
        Word firstWord = new Word(beginWord,1);
        visited.put(firstWord.s,false);
        distance.put(firstWord.s,1);
        
        q.add(firstWord);
        
        
        while(!q.isEmpty()){
            Word curWord = q.poll();
            if(curWord.s.equals(endWord)) return distance.get(curWord.s);
            if(!visited.get(curWord.s)){
                visited.put(curWord.s,true);
                Set<String> neighbours = getNeighbours(curWord.s.toCharArray(),wordList);
                for(String neighbour : neighbours){
                    if(!visited.get(neighbour)){
                        Word newWord = new Word(neighbour,distance.get(curWord.s)+1);
                        distance.put(newWord.s, newWord.dist);
                        q.add(newWord);
                    }
                }
            }
        }
        return 0;
        
    }
    
    
    

    
    // Returns set of words that are present in wordList and can be 
    // formed by changing only one character in the string
    private Set<String> getNeighbours(char[] word, Set<String> wordList) {
        Set<String> ret = new HashSet<String>();
        for(int i = 0; i < word.length; i++) {
            char c = word[i];
            
            for(char j = 'a'; j <= 'z'; j++) {
                word[i] = j;
                String finalWord = String.valueOf(word);
                if(wordList.contains(finalWord)) {
                    ret.add(finalWord);
                    wordList.remove(finalWord);
                }
            }
            word[i] = c;
        }
        return ret;
    }
    
    
    public static void main(String[] arr) {
    	
    	String beginWord = "hit";
    	String endWord = "cog";
    	String[] a = new String[] {"hot","dot","dog","lot","log","cog"};
    	List<String> wordList = Arrays.asList(a);
    	WordLadder w = new WordLadder();
    	System.out.println(w.ladderLength(beginWord, endWord, wordList));
    	
    }
}
