package chap8;


// Demonstrate the ICharQ interface
public class IQDemo {
 
	public static void main(String args[]) {
		FixedQueue q1 =  new FixedQueue(10);
		DynQueue q2 = new DynQueue(5); 
		CircularQueue q3 = new CircularQueue(10); 
		
		ICharQ iQ ;
		char ch;
		int i; 
		
		iQ = q1;
		
		// Put some characters into fixed queue 
		for(i=0;i<10;i++) {
			iQ.put((char) ('A'+ i));
		} 
		
		
		// show the queue 
		System.out.print("contents of fixed queue: "); 
		for(i=0;i<10;i++) {
			ch = iQ.get();
			System.out.print(ch);
		}  
		System.out.println();
		
		
		iQ = q2;
		// Put some characters into dynamic queue 
		for(i=0;i<10;i++) {
			iQ.put((char) ('Z'- i));
		} 
		
		
		// show the queue 
		System.out.print("contents of dynamic queue: "); 
		for(i=0;i<10;i++) {
			ch = iQ.get();
			System.out.print(ch);
		}  
		System.out.println();
		
		
		iQ = q3;
		// Put some characters into circular queue 
		for(i=0;i<10;i++) {
			iQ.put((char) ('A'+ i));
		} 
		
		
		// show the queue 
		System.out.print("contents of circular queue: "); 
		for(i=0;i<10;i++) {
			ch = iQ.get();
			System.out.print(ch);
		}  
		System.out.println();
	}
	
}
