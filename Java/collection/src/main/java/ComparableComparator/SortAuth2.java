package ComparableComparator;

import java.util.ArrayList;
import java.util.Collections;

public class SortAuth2 { 
	
	public static void main(String args[]) {
	     ArrayList<Author2> al=new ArrayList<Author2>();        
	     al.add(new Author2("Henry", "Tropic of Cancer",  45));
	     al.add(new Author2("Nalo", "Brown Girl in the Ring", 56));
	     al.add(new Author2("Frank", "300", 65));
	     al.add(new Author2("Deborah", "Sky Boys", 51));
	     al.add(new Author2("George R. R.", "A Song of Ice and Fire", 62));
	     
	     /*Sorting the list using Authors first name using comparable*/
	     System.out.println("Sorting by Author First Name:");
	     Collections.sort(al);
	     for(Author2 au: al){       
	         System.out.println(au.getFirstName()+", "+au.getBookName()+", "+
	             au.getAuAge());        
	       } 
	     
	     
	     //Sorting using AuthirAgeComparator 
	     System.out.println(" ");
	     System.out.println("Sorting by Author age:") ;
	     Collections.sort(al, new AuthorAgeComparator()); 
	     for(Author2 au: al){       
	         System.out.println(au.getFirstName()+", "+au.getBookName()+", "+
	            au.getAuAge());        
	       } 
	     
	     //Sorting using BookNameComparator  
	     System.out.println(" ");
	     System.out.println("Sorting by Book Name:");
	     Collections.sort(al, new BookNameComparator());
	     for(Author2 au: al){       
	         System.out.println(au.getFirstName()+", "+au.getBookName()+", "+
	            au.getAuAge());        
	       } 
	     
	}

}
