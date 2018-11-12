package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListInitialization {
 
	
	public static void main(String args[]) {
		
		// Example 1 (using asList)
		ArrayList<String> obj = new ArrayList<String>( Arrays.asList("pratap","peter","Harsh"));
		System.out.println("Elements are:"+obj); 
		
		// Example 2 (using Anonymous inner class)
		ArrayList<String> cities = new ArrayList<String>(){{
			add("Delhi");
			add("Agra");
			add("Chennai");
		}}; 
		System.out.println("Content of Array list cities:"+ cities); 
		
		
		// Example 3 ( Normal way)
		ArrayList<String> books = new ArrayList<String>();  
		books.add("Java Book1"); 
		books.add("Java Book2");
		books.add("Java Book3");
		
		
		System.out.println("Books stored in array list are:"+ cities); 
		
		// Example using collections.ncopies 
		
		ArrayList<Integer> intlist = new ArrayList<Integer>(Collections.nCopies(10, 5));
		System.out.println("ArrayList items"+ intlist); 
	
	}
}
