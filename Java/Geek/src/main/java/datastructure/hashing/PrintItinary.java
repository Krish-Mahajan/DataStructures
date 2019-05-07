package datastructure.hashing;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class PrintItinary {

  public static void main(String[] args) {

    HashMap<String, String> dataset = new HashMap<String, String>();
    dataset.put("Chennai", "Bangalore");
    dataset.put("Bombay", "Delhi");
    dataset.put("Goa", "Chennai");
    dataset.put("Delhi", "Goa");

    printItinerary(dataset);
  }

  private static void printItinerary(HashMap<String, String> dataset) {

    String starting_point = null;

    HashMap<String, String> reverse_dataset = new HashMap<String, String>();

    for (Entry<String, String> en : dataset.entrySet()) {
      reverse_dataset.put(en.getValue(), en.getKey());
    }

    for (String en : dataset.keySet()) {
      if (!reverse_dataset.containsKey(en)) {
        starting_point = en;
        break;
      }
    }
    
    if(starting_point != null) {
    	while(dataset.containsKey(starting_point)) {
    		System.out.println(starting_point + "-->" + dataset.get(starting_point));
    		starting_point = dataset.get(starting_point);
    	}
    }
    else {System.out.println("Itinerary is wrong");}
  }
}
