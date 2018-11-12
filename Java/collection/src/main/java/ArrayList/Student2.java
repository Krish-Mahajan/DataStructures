package ArrayList;

import java.util.Comparator;

public class Student2{
	private String studentname;
    private int rollno;
    private int studentage;

    public Student2(int rollno, String studentname, int studentage) {
         this.rollno = rollno;
         this.studentname = studentname;
         this.studentage = studentage;
    }

    public String getStudentname() {
         return studentname;
    }
    public void setStudentname(String studentname) {
	this.studentname = studentname;
    }
    public int getRollno() {
	return rollno;
    }
    public void setRollno(int rollno) {
	this.rollno = rollno;
    }
    public int getStudentage() {
	return studentage;
    }
    public void setStudentage(int studentage) {
 	this.studentage = studentage;
    }

	 /* Comparator for sorting list by student rollNo */ 
    public static Comparator<Student2> StuRollNo = new Comparator<Student2>() {
    	
    	public int compare(Student2 s1, Student2 s2) {
    		int rollno1 = s1.getRollno();
    		int rollno2 = s2.getRollno(); 
    		
    		/* For ascending order*/
    		return rollno1- rollno2;
    	}};
    
    	
   	 /* Comparator for sorting list by student name */ 
        public static Comparator<Student2> StuNameComparator = new Comparator<Student2>() {
        	
        	public int compare(Student2 s1, Student2 s2) {
        		String StudentName1 = s1.getStudentname().toUpperCase();
        		String StudentName2 = s2.getStudentname().toUpperCase();
        		
        		/* For ascending order*/
        		return StudentName1.compareTo(StudentName2);
        	}}; 
        	
        	  @Override
        	    public String toString() {
        	        return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
        	    }
    
    }


