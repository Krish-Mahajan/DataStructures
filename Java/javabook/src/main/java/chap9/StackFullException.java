package chap9;

public class StackFullException extends Exception{ 
	int size;
	
	public StackFullException(int s) {
		this.size =s;
	} 
	
	public String toString() {
		return "\nStack is full.Maximum size is " + size;
	}

}
