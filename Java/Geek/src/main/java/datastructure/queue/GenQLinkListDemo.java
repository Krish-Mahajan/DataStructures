package datastructure.queue;

public class GenQLinkListDemo {

	public static void main(String args[]) {
	    
		// Create an integer queue
		GenQLinkList<Integer> q = new GenQLinkList<Integer>();
		
		Integer iVal;
		System.out.println("Demonstrate a queue of Integers. ");
		
		for(int i=0; i<5 ;i++)
		{
			System.out.println("Adding " + i + " to q.");
			q.put(i);
		}
		System.out.println();
		
		
		// Getting entrees from Queue
		try {
			for(int i = 0;i < 5; i++) {
				System.out.println("Getting next Integer from Q: ");
				iVal = q.get();
				System.out.println(iVal);
			}
		}catch(QueueEmptyException exc)
		{
			System.out.println(exc);
		}
		
		System.out.println();
	
		
		
	}
	
}
