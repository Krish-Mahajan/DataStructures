package ComparableComparator;

public class Author1 implements Comparable<Author1> {

	String firstName;
	String lastName;
	String bookName; 
	
	Author1(String first,String last,String book){
		this.bookName = book;
		this.lastName = last;
		this.firstName = first;
	}
	
	
/* This is where we write the logic to Sort based on lastname. */
	@Override
	public int compareTo(Author1 au) {
		/* Sorting by last name */ 
		return this.lastName.compareTo(au.lastName); 
		
	}  
	

	
	
	

}
