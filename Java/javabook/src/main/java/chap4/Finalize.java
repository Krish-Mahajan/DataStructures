package chap4;

public class Finalize {
 
	public static void main(String args[]) {
		int count;
		
		FDemo ob = new FDemo(0) ;
		
		/* 
		 * Now generate large no. of objects. At some point,garbage collection 
		 * will occur.
		 */ 
		for(count=1 ; count < 1000000 ; count++) 
			ob.generator(count);
	}
} 

class FDemo {
	int x;
	
	FDemo(int i){
		x = i;
	} 
	
	//called when object is recycled 
	protected void finalize() {
		System.out.println("Finalizing " + x);
	} 
	
	//generated an object that is immediately destroyed 
	void generator(int i) {
		FDemo o = new FDemo(i);
	} 
} 
