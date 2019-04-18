package datastructure.queue;

/**
 * A generic Queue Interface
 * @author krish.mahajan@gmail.com
 */
public interface IGenQ<T> {
	
	// Put an item into the queue
	void put(T ch) throws QueueFullException;
	
	//Get an item from the queue
	T get() throws QueueEmptyException;

}
