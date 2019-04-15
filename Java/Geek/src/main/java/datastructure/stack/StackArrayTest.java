package datastructure.stack;

public class StackArrayTest {

	public static void main(String args[]) {
		StackArray s = new StackArray();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop()+ " Popped from stack");
	}
	
}
