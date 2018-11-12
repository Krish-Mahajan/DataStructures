package TreeMap;

import java.util.*;

public class TreeMapReverseOrder { 
	
	public static void main(String args[]) {
		
		Map<Integer,String> treemap = new TreeMap<Integer, String>(Collections.reverseOrder());  
		
		// put elements to the map 
		treemap.put(0, "Jack"); 
		treemap.put(1, "Rick");
		treemap.put(2, "Kate");
		treemap.put(3, "Tom");
		treemap.put(4, "Steve");
		
		
		Set set = treemap.entrySet();
		Iterator i = set.iterator();
		
		//Display elements 
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey()+ ": "); 
			System.out.println(me.getValue());
		}
		
	}

}
