package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorting {
	public static void main(String args[]) {

		ArrayList<String> listofcountries = new ArrayList<String>();
		listofcountries.add("India");
		listofcountries.add("US");
		listofcountries.add("China");
		listofcountries.add("Denmark");

		/* Unsorted List */
		System.out.println("Before Sorting:");
		for (String counter : listofcountries) {
			System.out.println(counter);
		}

		/* Sort statement */
		Collections.sort(listofcountries);

		/* Sorted List */
		System.out.println("After Sorting:");
		for (String counter : listofcountries) {
			System.out.println(counter);
		}

		/* Sorting in decresing order */
		Collections.sort(listofcountries, Collections.reverseOrder());

		/* Sorted List */
		System.out.println("After in Sorting in decresing order:");
		for (String counter : listofcountries) {
			System.out.println(counter);
		}

		/* Sorting using comparable */
		ArrayList<Student1> student1List = new ArrayList<Student1>();
		student1List.add(new Student1(223, "Chaitanya", 26));
		student1List.add(new Student1(245, "Rahul", 24));
		student1List.add(new Student1(209, "Ajeet", 32));

		
		System.out.println("using age & comparable");
		Collections.sort(student1List);

		for (Student1 str : student1List) {
			System.out.println(str);
		}

		/* Sorting using comparable */
		ArrayList<Student2> arraylist2 = new ArrayList<Student2>();
		arraylist2.add(new Student2(223, "Chaitanya", 26));
		arraylist2.add(new Student2(100, "Rahul", 24));
		arraylist2.add(new Student2(209, "Ajeet", 32));

		System.out.println("using name & comparator");
		Collections.sort(arraylist2,Student2.StuNameComparator);

		for (Student2 str : arraylist2) {
			System.out.println(str);
		} 
		
		System.out.println("using rollno & comparator");
		Collections.sort(arraylist2,Student2.StuRollNo);

		for (Student2 str : arraylist2) {
			System.out.println(str);
		}
	}
}
