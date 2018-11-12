package ComparableComparator;

import java.util.ArrayList;
import java.util.Collections;

public class SortAuth1 { 
	
	public static void main(String args[]) {
		ArrayList<Author1> al = new ArrayList<Author1>(); 
	      al.add(new Author1("Henry","Miller", "Tropic of Cancer"));  
	      al.add(new Author1("Nalo","Hopkinson", "Brown Girl in the Ring"));
	      al.add(new Author1("Frank","Miller", "300"));
	      al.add(new Author1("Deborah","Hopkinson", "Sky Boys"));
	      al.add(new Author1("George R. R.","Martin", "Song of Ice and Fire")); 
	      
	      /* Sorting the list using Collections.sort() method*/ 
	      Collections.sort(al); 
	      for(Author1 str:al) {
	    	  System.out.println(str.firstName + " " + str.lastName + " " + "Book: "+str.bookName);
	      }
	 
		
	}

}
