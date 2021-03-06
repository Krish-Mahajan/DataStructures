package datastructure.stack;

public class StackLinkedListTest { 
	
	public static void main(String[] args) {
		
		StackLinkedList<Integer> sl = new StackLinkedList<Integer>();
		sl.push(10);
		sl.push(20);
		sl.push(30);
		System.out.print("Current stack is: ");
		sl.printStack();
		System.out.println();
		System.out.println(sl.pop() + " Element is popped out");
		System.out.print("Current stack is: ");
		sl.printStack();
		System.out.println();
		System.out.println("Current element at top of the stack is " + sl.peek());
		
		
		StackLinkedList<Integer> sl1 = new StackLinkedList<Integer>();
		sl1.push(4);
		sl1.push(5);
		sl1.push(2);
		sl1.push(25);
		sl1.push(30);
		
		sl1.printNGE(5);
		sl1.printNGE(25);
		sl1.printNGE(4);
		sl1.printNGE(2); 
		
		
		StackLinkedList<Integer> sl2 = new StackLinkedList<Integer>();
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
		
		
		StackLinkedList<Integer> sl3 = new StackLinkedList<Integer>();
		sl3.push(30);
		sl3.push(-5);
		sl3.push(18);
		sl3.push(14);
		sl3.push(-3);
		System.out.print("Stack before reversal ");
		sl3.printStack();
		sl3.sortRecursively();
		System.out.println(" ");
		System.out.print("Stack After recursively sorting ");
		sl3.printStack();
	
		System.out.println(" ");
		String check1 = "[()]{}{[()()]()}";
		boolean is_balanced1 = StackLinkedList.checkBalancedParanthese(check1);
		System.out.print("Expression "+ check1 + " is balanced: " + is_balanced1); 
		
		
		System.out.println(" ");
		String check2 = "[(])";
		boolean is_balanced2 = StackLinkedList.checkBalancedParanthese(check2);
		System.out.print("Expression "+ check2 + " is balanced: " + is_balanced2);
	}

}
