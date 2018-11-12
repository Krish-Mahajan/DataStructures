package chap13; 

import chap8.FixedQueue;

public class QueueEmptyException extends Exception{
  
	public String toString() {
		return "\nQueue is empty. ";
	}
	
}
