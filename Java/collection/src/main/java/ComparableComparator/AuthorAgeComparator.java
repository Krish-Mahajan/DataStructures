package ComparableComparator;

import java.util.Comparator;

class AuthorAgeComparator implements Comparator<Author2> {

	@Override
	public int compare(Author2 a1, Author2 a2) {
		if(a1.auAge == a2.auAge) return 0;
		else if (a1.auAge > a2.auAge) return 1;
		else return -1;
		
	}
	
} 