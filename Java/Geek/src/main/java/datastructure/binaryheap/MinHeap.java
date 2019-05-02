package datastructure.binaryheap;

import java.lang.reflect.Array;

/**
 * Java Implementation Min heap
 *
 * @author krish.mahajan@gmail.com
 */
public class MinHeap<T extends Comparable<T>> {

  private T[] heap;
  private int size;
  private int maxsize;

  private static final int FRONT = 1;

  public MinHeap(Class<T> clazz, int maxsize) {
    this.maxsize = maxsize;
    this.size = 0;
    heap = this.getArray(clazz, maxsize);
    heap[0] = null;
  }

  public <T> T[] getArray(Class<T> clazz, int maxsize) {
    @SuppressWarnings("unchecked")
    T[] arr = (T[]) Array.newInstance(clazz, maxsize + 1);
    return arr;
  }

  /**
   * Function to retrive the parent node
   *
   * @param pos : Position of the child node
   * @return
   */
  public T getParent(int pos) {
    return this.heap[pos / 2];
  }

  /**
   * Function to retrieve left child of the node
   *
   * @param pos : Position of the child node
   */
  public T getLeftChild(int pos) {
    return this.heap[2 * pos];
  }

  /**
   * Function to retrieve right child of the node
   *
   * @param pos Position of the child node
   * @return
   */
  public T getRightChild(int pos) {
    return this.heap[2 * pos + 1];
  }

  private void swap(int pos1, int pos2) {
    T tmp;
    tmp = this.heap[pos1];
    this.heap[pos1] = this.heap[pos2];
    this.heap[pos2] = tmp;
  }

  
  /**
   * Function to insert new elements in MinHeap
   * @param key
   */
  public void insert(T key) {
	 this.size = size + 1;
	 this.heap[size] = key;
	 int current = this.size;
	 if(current != 1) {
	 while(this.heap[current].compareTo(this.getParent(current)) < 0 && current != 1 ) {
		 this.swap(current, current/2);
		 current = current/2;
	 }
	 }
	  
  }
  
  
  /**
   * Function to print MinHeap
   */
  public void print() 
  { 
      for (int i = 1; i <= size / 2; i++) { 
          System.out.print(" PARENT : " + heap[i] 
                   + " LEFT CHILD : " + heap[2 * i] 
                 + " RIGHT CHILD :" + heap[2 * i + 1]); 
          System.out.println(); 
      } 
  } 
}
