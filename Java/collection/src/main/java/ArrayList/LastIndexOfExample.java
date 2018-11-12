package ArrayList;

import java.util.ArrayList;
public class LastIndexOfExample {
  public static void main(String args[]) {
      //ArrayList of Integer Type
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(1);
      al.add(88);
      al.add(9);
      al.add(17);
      al.add(17);
      al.add(9);
      al.add(17);
      al.add(91);
      al.add(27);
      al.add(1);
      al.add(17);

      System.out.println("Last occurrence of element 1: "+al.lastIndexOf(1));
      System.out.println("Last occurrence of element 9: "+al.lastIndexOf(9));
      System.out.println("Last occurrence of element 17: "+al.lastIndexOf(17));
      System.out.println("Last occurrence of element 91: "+al.lastIndexOf(91));
      System.out.println("Last occurrence of element 88: "+al.lastIndexOf(88)); 
   }
}