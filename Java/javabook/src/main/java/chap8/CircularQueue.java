package chap8;

public class CircularQueue implements ICharQ{  
	
	private char q[]; //this array holds the queue 
	private int putloc,getloc ; // the put and get indices
	
	public CircularQueue(int size) {
		q = new char[size+1] ;// allocate memory for queue  
		putloc = getloc = 0;
				
	}
	
	
	
	// put a character into the queue
	public void put(char ch) {
		/* Queue is full if either putloc is one less than getloc , or if putloc is a the end of the array
		 * and getloc is at the beginning */
		 if(putloc +1 == getloc|((putloc==q.length-1) & (getloc==0))) {
			 System.out.println("-Queue is empty");
			 return ;
		 } 
		 
		 q[putloc++] = ch;
		 if(putloc ==q.length) putloc =0; // loopback
		
	}

	
	
	// get a character from the Queue
	public char get() {
		
		if(getloc ==putloc) {
			System.out.println("- Queue is full."); 
			return (char) 0;
		}
		
		char ch = q[getloc++];
		if(getloc ==q.length) getloc =0 ; // loop back 
		return ch;
	} 
	

}
