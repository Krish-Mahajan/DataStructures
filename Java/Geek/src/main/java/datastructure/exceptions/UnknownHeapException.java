package datastructure.exceptions;

public class UnknownHeapException extends Exception { 
	
	public String toString() {
		return " Heap can only be either MinHeap or MaxHeap";
	}
}



