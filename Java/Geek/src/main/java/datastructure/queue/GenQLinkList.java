package datastructure.queue;

import datastructure.linkedlist.LinkedList;
import datastructure.linkedlist.LinkedList.Node;

public class GenQLinkList<T extends Comparable<T>> implements IGenQLinkList<T> {

	
	private LinkedList<T> l = new LinkedList<T>(); // This LinkedList holds the Queue
	private LinkedList<T>.Node<T> front;  //Start , End will hold references to start & end of LinkList
	private LinkedList<T>.Node<T> rear;
	
	public GenQLinkList() {
		this.front = rear = null;
		
	}


	@Override
	public void put(T obj) {
		if(this.isGenQLinkListEmpty())
		{
			LinkedList<T>.Node<T> head = l.new Node<T>(obj);
			this.l.setHead(head);
			this.front = head;
			this.rear = head;
			
		}
		else
		{
			this.l.push(obj);
			this.rear = this.l.getHead();
		}
	
		
	}

	// wrong implementation
	@Override
	public T get() throws QueueEmptyException {
		if(this.isGenQLinkListEmpty())
		{
			System.out.println("Queue is Empty");
			return null;
		}
		else
		{
			LinkedList<T>.Node<T> frontNode = front;
			front = this.front.getNext();
			return frontNode.getData();
		}
	}
	
	
	public boolean isGenQLinkListEmpty() {
		if(this.l.getHead() == null) return true;
		else return false;
			
	}

}
