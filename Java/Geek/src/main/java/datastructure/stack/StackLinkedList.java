package datastructure.stack;

import datastructure.linkedlist.LinkedList;
import datastructure.linkedlist.LinkedList.Node;


public class StackLinkedList {

	LinkedList l = new LinkedList();

	
	/**
	 * check if stack is empty
	 * @return
	 */
	public boolean isEmpty() {
		if(l.getHead() == null) return true;
		else return false;
	}
	
    /**
     * Add new element to stack	
     * @param x
     * @return
     */
	public void push(double x) {
		l.push(x);
	}
	
	
	/**
	 * Remove element from stack
	 * @return
	 */
	public double pop() {
		if(this.l.getHead() != null)
		{
			double tmp = l.getHead().getData();
			l.setHead(l.getHead().getNext());
			return tmp;
		}
		else
		{   
			System.out.println("No element in stack");
			return 0;
		}
	} 
	
	/**
	 * See element at top of the stack
	 * @return
	 */
	public double peek() {
		if(this.l.getHead() !=null) return this.l.getHead().getData();
		else 
		{
			System.out.println("No element in stack");
			return 0;
		}
	}
	/**
	 * Print all the elements of stack starting from top
	 */
	public void printStack() {
		if(this.l.getHead() != null)
		{
			l.printList();
		}
		else
		{
			System.out.println("No element in stack");
		}
	}

	
	/**
	 * Print the next greater element for every element
	 */
	public void printNGE(int n) {
		if(this.l.getHead() != null)
		{
			Node curr = this.l.getHead();
			double nextRIghtMax = curr.getData();
			while( curr != null & curr.getData() != n )
			{
				if(curr.getData() > n) nextRIghtMax = curr.getData();
				curr = curr.getNext();
			}
			if(curr != null && nextRIghtMax > n)
			{
				System.out.println("Next Greater element than " +n + " in the stack on right side is " + nextRIghtMax);
	
			}
			else
			{
				System.out.println("No element greater than " + n + " found on right side in the stack" );
			}
		}
		else
		{
			System.out.println("Stack is empty");
			return;
		}
	}
	
	/**
	 * Reverse stack , using Push Pop
	 * (https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/)
	 */
	public void reverse() {
		if(!this.isEmpty())
		{
			 double x = this.peek();
			 this.pop();
			 reverse();
			 insert_at_bottom(x);
		}
		else return ;
	}
	
	private void insert_at_bottom(double x) {
		if(this.isEmpty())
		{
			this.push(x);
			return;
		}
		else
		{
			double a = this.peek();
			this.pop();
			insert_at_bottom(x);
			this.push(a);
		}
	}
}
