package datastructure.binaryheap;

import java.lang.reflect.Array;

import org.apache.log4j.Logger;

/**
 * Java Implementation Min heap
 *
 * @author krish.mahajan@gmail.com
 */
public class MinHeap<T extends Comparable<T>> {

	final Logger logger = Logger.getLogger(MinHeap.class.getName()); 
 	
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
   if(2*pos <= this.size) return this.heap[2 * pos];
   else return null;
  }

  /**
   * Function to get position of left child
   *
   * @param pos
   * @return
   */
  public int getLeftChildPos(int pos) {
    return 2 * pos;
  }

  /**
   * Function to get position of left child
   *
   * @param pos
   * @return
   */
  public int getRightChildPos(int pos) {
    return 2 * pos + 1;
  }

  /**
   * Function to retrieve right child of the node
   *
   * @param pos Position of the child node
   * @return
   */
  public T getRightChild(int pos) {
	  if(2*pos + 1 <= this.size) return this.heap[2 * pos + 1];
	  else return null;
  }

  /**
   * Swap two elements of BinaryHeap
   *
   * @param pos1
   * @param pos2
   */
  private void swap(int pos1, int pos2) {
    T tmp;
    tmp = this.heap[pos1];
    this.heap[pos1] = this.heap[pos2];
    this.heap[pos2] = tmp;
  }

  /**
   * Function to insert new elements in MinHeap
   *
   * @param key
   */
  public void insert(T key) {
    this.size = size + 1;
    this.heap[size] = key;
    int current = this.size;
    if (current != 1) {
      while (this.heap[current].compareTo(this.getParent(current)) < 0 && current != 1) {
        this.swap(current, current / 2);
        current = current / 2;
      }
    }
  }

  /** Function to know if the given position has leaf node or not. */
  private boolean isLeaf(int pos) {
    if (pos > (size / 2) && pos <= size) {
      return true;
    }
    return false;
  }

  /**
   * Remove the front element from the heap(The minimum element)
   *
   * @return Minimum element of the heap
   */
  public T remove() {
    T min_element = this.heap[FRONT];
    heap[FRONT] = this.heap[size--];
    this.heap[size + 1] = null;
    if(this.size > 1) this.minHeapify(FRONT);
    return min_element;
  }

  private void minHeapify(int pos) {
    if (!this.isLeaf(pos)) {
      if (this.getRightChild(pos) != null) {
        if (heap[pos].compareTo(getLeftChild(pos)) > 0
            || heap[pos].compareTo(getRightChild(pos)) >0 ) {
          if (getLeftChild(pos).compareTo(getRightChild(pos)) < 0) {
            this.swap(pos, getLeftChildPos(pos)); // swap with left child
            minHeapify(getLeftChildPos(pos));
          } else {
            this.swap(pos, getRightChildPos(pos));
            minHeapify(getRightChildPos(pos));
          }
        }
      } else if(this.getLeftChild(pos) != null){
        if (heap[pos].compareTo(getLeftChild(pos)) > 0) {
          this.swap(pos, getLeftChildPos(pos)); // swap with left child
          minHeapify(getLeftChildPos(pos));
        }
      }
    }
  }

  public T[] sort(Class<T> clazz) {
    
    int size = this.size;
    @SuppressWarnings("unchecked")
    T[] arr = (T[]) Array.newInstance(clazz, size);
    for (int i = 1; i <= size; i++) {
        T element = this.remove();
   //     logger.info("CURRENT HEAP: \n");
  //      this.print();
    	arr[i - 1] = element;
    }
    return arr;
  }

  /** Function to print MinHeap */
  public void print() {
    for (int i = 1; i <= size / 2; i++) {
      System.out.print(
          " PARENT : "
              + heap[i]
              + " LEFT CHILD : "
              + heap[2 * i]
              + " RIGHT CHILD :"
              + heap[2 * i + 1]);
      System.out.println();
    }
  }
}
