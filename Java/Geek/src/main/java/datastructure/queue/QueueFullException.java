package datastructure.queue;

public class QueueFullException extends Exception{

	int size;
	
	public QueueFullException(int s) {size = s;}
	
	public String toString() {
		return "\nQueue is full. Maximum size is " + size;
	}
}
