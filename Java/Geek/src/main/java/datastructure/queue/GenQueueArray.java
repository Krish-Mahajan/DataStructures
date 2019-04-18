package datastructure.queue;

public class GenQueueArray<T> implements IGenQ<T> {
	
	private T q[]; // this array holds the queue
	private  int putloc,getloc ; // the put and get indices
	

	
	
	//Construct an empty queue with the given array
	public GenQueueArray(T[] aRef) {
		q = aRef;
		putloc = getloc = 0;
	}
	
	/**
	 * Put am item in the queue
	 */
	@Override
	public void put(T obj) throws QueueFullException {
		
		if (putloc == q.length) throw new QueueFullException(q.length);
		
		q[putloc++] = obj; 
		
		
	}
	
	/**
	 * Get an item from the queue
	 */
	@Override
	public T get() throws QueueEmptyException {
		
		if(getloc == putloc) throw new QueueEmptyException();
		
		return q[getloc++];
	}
    
}
