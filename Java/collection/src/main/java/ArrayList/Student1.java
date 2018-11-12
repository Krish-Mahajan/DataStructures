package ArrayList;

public class Student1 implements Comparable<Student1>{
	private String studentname;
    private int rollno;
    private int studentage;

    public Student1(int rollno, String studentname, int studentage) {
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

	@Override
	public int compareTo(Student1 comparestu) {
		int compareage = ((Student1) comparestu).getStudentage(); 
		
		/* For Ascending order*/
		return this.studentage - compareage;
	}

    @Override
    public String toString() {
        return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
    }

}
