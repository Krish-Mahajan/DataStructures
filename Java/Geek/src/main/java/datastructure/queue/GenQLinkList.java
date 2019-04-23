package datastructure.queue;

import datastructure.linkedlist.LinkedList;
import datastructure.linkedlist.LinkedList.Node;

public class GenQLinkList<T> implements IGenQ<T> {

	private LinkedList<Double> l = new LinkedList<Double>(); // This LinkedList holds the Queue
	private LinkedList<Double>.Node<Double> start,end;  //Start , End will hold references to start & end of LinkList
	
	
	@Override
	public void put(T obj) throws QueueFullException {
		if(this.isGenQLinkListEmpty())
//		{
//			LinkedList<T>.Node<T> head = new LinkedList<T>.Node<T>(obj);
//			// this.l.setHead(new LinkedList<T>.Node<T>(obj));
//			this.l.setHead(head);
//		}
//		
		
	}

	@Override
	public T get() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean isGenQLinkListEmpty() {
		if(this.l.getHead() == null) return true;
		else return false;
			
	}

}
