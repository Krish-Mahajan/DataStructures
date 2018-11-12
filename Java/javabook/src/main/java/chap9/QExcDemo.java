package chap9;

public class QExcDemo {

	public static void main(String args[]) {
		 FixedQueue q = new FixedQueue(10); 
		 char ch;
		 int i; 
		 
		 try {
			 //overun the queue 
			 for(i=0;i<11;i++) {
				 System.out.print("Attempting to store :" + (char) ('A' + i)); 
				 q.put((char)('A'+i)); 
				 System.out.println("-OK"); 
			 } 
			 System.out.println();
		 }
		 catch(QueueFullException exc) {
			 System.out.println(exc);
		 } 
		 System.out.println(); 
		 
		 
		 
		 try {
			 //overun the queue 
			 for(i=0;i<11;i++) {
				 System.out.print("Getting next char: "); 
				 ch = q.get(); 
				 System.out.println(ch);
				 
			 } 
			 System.out.println();
		 }
		 catch(QueueEmptyException exc) {
			 System.out.println(exc);
		 } 
		 System.out.println();
	}
}
