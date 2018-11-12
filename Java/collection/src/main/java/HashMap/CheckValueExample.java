package HashMap;

import java.util.HashMap;



public class CheckValueExample {
 
 public static void main(String[] args) {
 
    // Creating a HashMap of int keys and String values
    HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
 
    // Adding Key and Value pairs to HashMap
    hashmap.put(11,"Chaitanya");
    hashmap.put(22,"Pratap");
    hashmap.put(33,"Singh");
    hashmap.put(44,"Rajesh");
    hashmap.put(55,"Kate");
 
    // Checking Value Existence
    boolean flag = hashmap.containsValue("Singh");
    System.out.println("String Singh exists in HashMap? : " + flag);
 }
}