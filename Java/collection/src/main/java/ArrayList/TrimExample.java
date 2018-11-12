package ArrayList;

import java.util.ArrayList;
public class TrimExample {
  public static void main(String args[]) {
    ArrayList<Integer> arraylist = new ArrayList<Integer>(50);
    arraylist.add(1);
    arraylist.add(2);
    arraylist.add(3);
    arraylist.add(4);
    arraylist.add(5);
    arraylist.add(6);
    arraylist.add(7);
    arraylist.add(1);
    arraylist.add(1);
    arraylist.add(1);
    arraylist.trimToSize();
    System.out.println(arraylist);
  }
}
