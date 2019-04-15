package datastructure.stack;

public class StackLinkedListTest { 
	
	public static void main(String[] args) {
		
//		StackLinkedList sl = new StackLinkedList();
//		sl.push(10);
//		sl.push(20);
//		sl.push(30);
//		System.out.print("Current stack is: ");
//		sl.printStack();
//		System.out.println();
//		System.out.println(sl.pop() + " Element is popped out");
//		System.out.print("Current stack is: ");
//		sl.printStack();
//		System.out.println();
//		System.out.println("Current element at top of the stack is " + sl.peek());
//		
		
//		StackLinkedList sl1 = new StackLinkedList();
//		sl1.push(4);
//		sl1.push(5);
//		sl1.push(2);
//		sl1.push(25);
//		sl1.push(30);
		
//		sl1.printNGE(5);
//		sl1.printNGE(25);
//		sl1.printNGE(4);
//		sl1.printNGE(2); 
		
		
		StackLinkedList sl2 = new StackLinkedList();
		sl2.push(4);
		sl2.push(3);
		sl2.push(2);
		sl2.push(1);
		System.out.print("Stack before reversal ");
		sl2.printStack();
		sl2.reverse();
		System.out.println(" ");
		System.out.print("Stack After reversal ");
		sl2.printStack();
	}

}
