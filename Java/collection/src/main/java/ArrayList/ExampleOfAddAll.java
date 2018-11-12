package ArrayList;

import java.util.ArrayList;
import java.util.List;
public class ExampleOfAddAll {
   public static void main(String[] args) { 
        // ArrayList1 of String type
        ArrayList<String> al = new ArrayList<String>();
        al.add("Hi");
        al.add("hello");
        al.add("String");
        al.add("Test");
        System.out.println("ArrayList1 before addAll:"+al);

        //ArrayList2 of String Type
        ArrayList<String> al2 = new ArrayList<String>();
        al2.add("Text1");
        al2.add("Text2");
        al2.add("Text3");
        al2.add("Text4");

        //Adding ArrayList2 into ArrayList1
        al.addAll(al2);
        System.out.println("ArrayList1 after addAll:"+al);  
        
      //Adding ArrayList2 in ArrayList1 at 3rd position(index =2)
       al.addAll(2, al2);
       System.out.println("ArrayList1 after adding ArrayList2 at 3rd Pos:\n"+al);
        
       //Adding elements to a List
       List<String> list = new ArrayList<String>();
       list.add("Text 4");
       list.add("Text 5");
       list.add("Text 6"); 
       
       //Adding all lements of list to ArrayList using addAll
       al.addAll(list);
       System.out.println("Updated ArrayList Elements: "+al);
        
       
       //String ArrayList
       ArrayList<String> al21 = new ArrayList<String>();
       al21.add("AB");    //al21.remove("AA);
       al21.add("CD");
       al21.add("EF");
       al21.add("GH");
       al21.add("AB");
       al21.add("YZ");
       System.out.println("ArrayList before remove:");
       for(String var: al21){
            System.out.println(var);
       }
       //Removing 1st element
       al21.remove(0);
       //Removing 3rd element from the remaining list
       al21.remove(2);
       //Removing 4th element from the remaining list
       al21.remove(2);
       System.out.println("ArrayList After remove:");
       for(String var2: al21){
             System.out.println(var2);
       }
    }
   }
