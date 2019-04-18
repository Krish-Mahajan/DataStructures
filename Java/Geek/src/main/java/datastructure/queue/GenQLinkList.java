package datastructure.queue;

import datastructure.linkedlist.LinkedList;
import datastructure.linkedlist.LinkedList.Node;

public class GenQLinkList<T> implements IGenQ<T> {

	private LinkedList l = new LinkedList(); // This LinkedList holds the Queue
	private Node start,end;  //Start , End will hold references to start & end of LinkList
	
	
	@Override
	public void put(T obj) throws QueueFullException {
		if(this.isGenQLinkListEmpty())
		{
			this.l.setHead(new Node(obj));
		}
		
		
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
