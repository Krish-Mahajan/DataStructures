package datastructure.stack;
/**
 * Implementation of stack using array
 * @author krish.mahajan@gmail.com
 *
 */
public class StackArray {

	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX]; //Maximum size of Stack
	
	

	StackArray()
	{
		top = -1;
	}
	
	
	/**
	 * check if stack is empty
	 * @return
	 */
	public boolean isEmpty()
	{
		return (top < 0);
	}
	
    /**
     * Add new element to stack	
     * @param x
     * @return
     */
	public boolean push(int x) 
	{
		if(top >=MAX -1)
		{    
			System.out.println("Stack Overflow"); 
			return false;
		}
		else
		{
			a[++top] = x;
			System.out.println(x + " Pushed into stack");
			return true;
		}
	}
	
	/**
	 * Remove element from stack
	 * @return
	 */
	public int pop() 
	{
		if( this.isEmpty()) 
		{
			System.out.println("Stack underflow");
			return 0;	
		}
		else
		{
			int x = a[top--];
			return x;
		}
	}
	
	/**
	 * See element at top of the stack
	 * @return
	 */
	public int peek()
	{
		if( this.isEmpty()) 
		{
			System.out.println("Stack underflow");
			return 0;	
		}
		else
		{
			return a[top];
		}
	}
}
