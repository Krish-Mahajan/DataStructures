package chap13;

public class QueueFullException extends Exception{
  int size;  
  
  public QueueFullException(int s) { 
	  this.size = s;
} 
  public String toString() {
	  return "\nQueue is full. Maximum size is " + size;
  }
  
} 

