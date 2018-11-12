package HashMap;

import java.util.HashMap;

public class RemoveMappingExample {
	 
	 public static void main(String[] args) {
	 
	    // Creating a HashMap of int keys and String values
	    HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	 
	    // Adding Key and Value pairs to HashMap
	    hashmap.put(11,"Value1");
	    hashmap.put(22,"Value2");
	    hashmap.put(33,"Value3");
	    hashmap.put(44,"Value4");
	    hashmap.put(55,"Value5");
	    hashmap.put(66,"Value6");
	 
	    // Displaying HashMap Elements
	    System.out.println("HashMap Elements: " + hashmap);

	    // Removing Key-Value pairs for key 33
	    Object removedElement1 = hashmap.remove(33);
	    System.out.println("Element removed is: " +removedElement1);
	 
	    // Removing Key-Value pairs for key 55
	    Object removedElement2 = hashmap.remove(55);
	    System.out.println("Element removed is: " +removedElement2);

	    // Displaying HashMap Elements after remove
	    System.out.println("After Remove:");
	    System.out.println("--------------");
	    System.out.println("HashMap Elements: " + hashmap);
	 }
	}