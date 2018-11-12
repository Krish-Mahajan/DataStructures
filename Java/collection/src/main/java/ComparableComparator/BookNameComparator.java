package ComparableComparator;

import java.util.Comparator;

class BookNameComparator implements Comparator<Author2> {

	@Override
	public int compare(Author2 a1, Author2 a2) {
		return a1.bookName.compareTo(a2.bookName);
		
	}
	
}