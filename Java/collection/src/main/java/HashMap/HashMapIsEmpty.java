package HashMap;

import java.util.HashMap;

public class HashMapIsEmpty { 
	 public static void main(String args[]) {
		 
		    // Create a HashMap
		    HashMap<Integer, String> hmap = new HashMap<Integer, String>(); 
		 
		 
		    // Checking whether HashMap is empty or not
		    /* isEmpty() method signature and description -
		     * public boolean isEmpty(): Returns true if this map 
		     * contains no key-value mappings.
		     */
		    System.out.println("Is HashMap Empty? "+hmap.isEmpty());
		 
		    // Adding few elements
		    hmap.put(11, "Jack");
		    hmap.put(22, "Rock");
		    hmap.put(33, "Rick");
		    hmap.put(44, "Smith");
		    hmap.put(55, "Will");
		 
		    // Checking again
		    System.out.println("Is HashMap Empty? "+hmap.isEmpty());
		  } 

}
