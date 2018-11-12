package chap6;

public class Stack {
 
	
	private char stck[]; // this array holds the stack 
	private int tos; // top of stack 
	
	// Construct an empty stack given its size 
	Stack(int size) {
		stck = new char[size] ; // allocate memory for stack 
		tos = 0;
	} 
	
	// Construct stack from a stack
	Stack(Stack ob) {
		this.tos = ob.tos;
		this.stck = new char[ob.stck.length];
		
		// copy elements
		for(int i=0; i < tos ; i++) 
			stck[i] = ob.stck[i];
	} 
	
	// Construct a stack with initial values.
	Stack(char a[]) {
		stck = new char[a.length]; 
		
		for( int i= 0; i < a.length ; i++) {
			push(a[i]);
		}
	} 
	
	void push(char ch) {
		if(this.tos == stck.length) {
			System.out.println(" -- Stack is full"); 
			return;
		} 
		
		stck[tos] = ch;
		tos++;
	} 
	
	char pop() {
		if(tos==0) {
			System.out.println("-- Stack is empty.");
			return (char) 0;
		} 
		
		tos--;
		return stck[tos];
	}
}
