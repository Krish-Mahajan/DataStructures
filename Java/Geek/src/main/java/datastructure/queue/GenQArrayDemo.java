package datastructure.queue;

public class GenQArrayDemo {

	public static void main(String args[]) {
		// Create an integer queue
		
		Integer iStore[] = new Integer[10];
		GenQueueArray<Integer> q = new GenQueueArray<Integer>(iStore);
		
		Integer iVal;
		System.out.println("Demonstrate a queue of Integers. ");
		
		// Adding entrees to Q
		try {
			for(int i=0; i<5 ;i++)
			{
				System.out.println("Adding " + i + " to q.");
				q.put(i);
			}
		} catch(QueueFullException exc)
		{ 
			System.out.println(exc);
			
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
