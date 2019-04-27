package datastructure.stack;

import datastructure.linkedlist.LinkedList;
import datastructure.linkedlist.LinkedList.Node;

public class StackLinkedList<T extends Comparable<T>> {

	LinkedList<T> l = new LinkedList<T>();

	/**
	 * check if stack is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (l.getHead() == null)
			return true;
		else
			return false;
	}

	/**
	 * Add new element to stack
	 * 
	 * @param x
	 * @return
	 */
	public void push(T x) {
		l.push(x);
	}

	/**
	 * Remove element from stack
	 * 
	 * @return
	 */
	public T pop() {
		if (this.l.getHead() != null) {
			T tmp = l.getHead().getData();
			l.setHead(l.getHead().getNext());
			return tmp;
		} else {
			System.out.println("No element in stack");
			return null;
		}
	}

	/**
	 * See element at top of the stack
	 * 
	 * @return
	 */
	public T peek() {
		if (this.l.getHead() != null)
			return this.l.getHead().getData();
		else {
			System.out.println("No element in stack");
			return null;
		}
	}

	/**
	 * Print all the elements of stack starting from top
	 */
	public void printStack() {
		if (this.l.getHead() != null) {
			l.printList();
		} else {
			System.out.println("No element in stack");
		}
	}

	/**
	 * Print the next greater element for every element
	 */
	public void printNGE(T n) {
		if (this.l.getHead() != null) {
			LinkedList<T>.Node<T> curr = this.l.getHead();
			T nextRIghtMax = curr.getData();
			while (curr != null & curr.getData() != n) {
				if (curr.getData().compareTo(n) > 0)
					nextRIghtMax = curr.getData();
				curr = curr.getNext();
			}
			if (curr != null && nextRIghtMax.compareTo(n) > 0) {
				System.out.println("Next Greater element than " + n + " in the stack on right side is " + nextRIghtMax);

			} else {
				System.out.println("No element greater than " + n + " found on right side in the stack");
			}
		} else {
			System.out.println("Stack is empty");
			return;
		}
	}

	/**
	 * REMEMBER Reverse stack , using Push Pop
	 * (https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/)
	 */
	public void reverse() {
		if (!this.isEmpty()) {
			T x = this.peek();
			this.pop();
			reverse();
			insert_at_bottom(x);
		} else
			return;
	}

	private void insert_at_bottom(T x) {
		if (this.isEmpty()) {
			this.push(x);
			return;
		} else {
			T a = this.peek();
			this.pop();
			insert_at_bottom(x);
			this.push(a);
		}
	}

	/**
	 * REMEMBER Sort a stack recursively only using Stack operation
	 * push(),pop(),top()
	 * (https://www.geeksforgeeks.org/sort-a-stack-using-recursion/)
	 */

	public void sortRecursively() {
		if (!this.isEmpty()) {
			T x = this.peek();
			this.pop();
			sortRecursively();
			insertInOrder(x);
		} else
			return;
	}

	public void insertInOrder(T x) {
		if (this.isEmpty()) {
			this.push(x);
		} else {
			T a = this.peek();
			if (a.compareTo(x) > 0) {
				this.pop();
				insertInOrder(x);
				this.push(a);
			} else
				this.push(x);
		}
	}

	/**
	 * 
	 * @return size of stack
	 */
	public int size() {
		return this.l.IterativeSize();

	}

	/**
	 * Function to check if given parantheses is balanced or not.
	 * @param expr
	 * @return
	 */
	public static boolean checkBalancedParanthese(String expr) {

		StackLinkedList<Character> s = new StackLinkedList<Character>();

		char x;

		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
			switch (ch) {
			case '[':
				s.push(ch);
				break;

			case '(':
				s.push(ch);
				break;

			case '{':
				s.push(ch);
				break;

			case ')':

				x = s.pop();
				if (x != '(') return false;
					break;
			case ']':

				x = s.pop();
				if (x != '[') return false;
				    break;
					 
			case '}':
				x = s.pop();
				if (x != '{') return false; 
				   break;
					
			}
		}
		if (s.size() > 0)
			return false;

		return true;

	}

}
