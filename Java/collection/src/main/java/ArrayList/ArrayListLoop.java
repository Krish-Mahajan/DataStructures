package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator; 


public class ArrayListLoop { 
	
	public static void main(String [] args) {
		
		ArrayList<Integer> arrlist = new ArrayList<Integer>(); 
		arrlist.add(14); 
		arrlist.add(7); 
		arrlist.add(39); 
		arrlist.add(40); 
		
		/*For Loop for iterating ArrayList */ 
		System.out.println("For loop"); 
		for(int counter =0;counter < arrlist.size(); counter++) {
			System.out.println(arrlist.get(counter));
		} 
		
		/* Advanced for Loop*/
		for(Integer num : arrlist){
			System.out.println(num);
		} 
		
		/*While loop iterating ArrayList*/ 
		System.out.println("While Loop"); 
		int count = 0; 
		while(arrlist.size()> count) {
			System.out.println(arrlist.get(count)); 
			count++ ;
		}  
		
		/*Looping Array List using Iterator*/
		System.out.println("Iterator"); 
		
		Iterator iter = arrlist.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		} 
		
		/* Looping using Enumeration */
		Enumeration<Integer> e = Collections.enumeration(arrlist); 
		System.out.println("ArrayList elements: ");
		while(e.hasMoreElements())
			System.out.println(e.nextElement());
		
		
	}

}
