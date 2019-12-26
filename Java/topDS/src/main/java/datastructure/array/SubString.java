package datastructure.array;

public class SubString {
	
	
	/**
	   public void subString(char str[], int n) { 
	        // Pick starting point 
	        for (int len = 3; len <= n; len++) { 
	            // Pick ending point 
	            for (int i = 0; i <= n - len; i++) { 
	                //  Print characters from current 
	                // starting point to current ending 
	                // point.   
	                int j = i + len - 1; 
	                for (int k = i; k <= j; k++) { 
	                    System.out.print(str[k]); 
	                } 
	  
	                System.out.println(); 
	            } 
	        } 
	    } */
	   
	   
	   public void subString(String str, int n) { 
	        // Pick starting point 
	        for (int len = 1; len <= n; len++) { 
	            // Pick ending point 
	            for (int i = 0; i <= n - len; i++) { 
	            	System.out.println(str.substring(i,i+len)); 
	                //  Print characters from current 
	                // starting point to current ending 
	                // point.   
	                //int j = i + len - 1; 

	            } 
	        } 
	    } 
	  
	// Driver program to test above function 
	    public static void main(String[] args) { 
	        char str[] = {'a', 'b', 'c'}; 
	        SubString sclass = new SubString();
	        //sclass.subString(str, str.length); 
	        String s = "abc";
	        sclass.subString(s, s.length()); 
	  
	    }
	
	
	
	
}
