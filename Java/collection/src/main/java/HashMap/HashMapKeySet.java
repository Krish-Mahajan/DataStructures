package HashMap;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;
class HashMapKeySet{

  public static void main(String args[]) {
 
    // Create a HashMap
    HashMap<String, String> hmap = new HashMap<String, String>(); 
 
    // Adding few elements
    hmap.put("Key1", "Jack");
    hmap.put("Key2", "Rock");
    hmap.put("Key3", "Rick");
    hmap.put("Key4", "Smith");
    hmap.put("Key5", "Will");
 
    // Getting Set of HashMap keys
    /* public Set<K> keySet(): Returns a Set view of the keys contained
     * in this map. The set is backed by the map, so changes to the map 
     * are reflected in the set, and vice-versa. 
     */
    Set<String> keys = hmap.keySet();

    System.out.println("Set of Keys contains: ");
 
    /* If your HashMap has integer keys then specify the iterator like
     * this: Iterator<Integer> it = keys.iterator();
     */
    Iterator<String> it = keys.iterator();
    // Displaying keys. Output will not be in any particular order
    while(it.hasNext()){
       System.out.println(it.next());
    } 
  }
}