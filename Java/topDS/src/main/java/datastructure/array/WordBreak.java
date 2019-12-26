package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {

	  return wordBreakUtil(s, wordDict);

  }
  
  public boolean wordBreakUtil(String s ,List<String> dict){
      if(s.isEmpty()) return true;
      
      else{
          for(int end = 1; end <= s.length();end++){
              if(dict.contains(s.substring(0,end))){
                  boolean found = wordBreakUtil(s.substring(end,s.length()),dict);
                  return found;
              }
          }
      }
      
      return false;
  }
  

  public static void main(String[] args) {

   WordBreak w = new WordBreak();
   String stest = "leetcode";
   List<String> wordList = new ArrayList<>(Arrays.asList("leet","code"));
   System.out.println(w.wordBreak(stest, wordList));
   
  }
}
