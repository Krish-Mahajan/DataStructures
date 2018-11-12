package ComparableComparator;

import java.util.Comparator;

public class Author2 implements Comparable<Author2> {
	
	  String firstName; 
	  String bookName; 
	  int auAge; 
	  Author2(String first, String book, int age){ 
	    this.firstName = first; 
	    this.bookName = book; 
	    this.auAge = age; 
	  } 
	  public String getFirstName() { 
	    return firstName; 
	  }
	  public void setFirstName(String firstName) { 
	    this.firstName = firstName; 
	  }
	  public String getBookName() { 
	    return bookName; 
	  }
	  public void setBookName(String bookName) { 
	    this.bookName = bookName; 
	  }
	  public int getAuAge() { 
	    return auAge; 
	  }
	  public void setAuAge(int auAge) { 
	    this.auAge = auAge; 
	  }
	
	
	
	
	@Override 
	  /* 
	   * When we only use Comparable, this is where we write sorting
	   * logic. This method is called when we implement the Comparable
	   * interface in our class and call Collections.sort()
	   */ 
	public int compareTo(Author2 au) {
		return this.firstName.compareTo(au.firstName);   
		
	}

}  


