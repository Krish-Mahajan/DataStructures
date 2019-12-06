package datastructure.binaryheap;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {

  private static final int FRONT = 1;
  List<T> heap;

  BinaryHeap() {
    // First element is a dummy element
    this.heap = new ArrayList<T>();
    heap.add(null);
  }

  // Get left child position
  private T getLeftChild(int index) {
    if (2 * index < this.heap.size()) {
      return heap.get(2 * index);
    } else {
      return null;
    }
  }

  // Get left child position
  private T getRightChild(int index) {
    if (2 * index + 1 < this.heap.size()) {
      return this.heap.get(2 * index + 1);
    } else {
      return null;
    }
  }

  private T getParent(int index) {
    if ((int) (index / 2) > 0) {
      return this.heap.get((int) index / 2);
    } else {
      return null;
    }
  }

  private void swap(int index1, int index2) {
    T tmp = this.heap.get(index1);
    this.heap.set(index1, this.heap.get(index2));
    this.heap.set(index2, tmp);
  }

  private void insert(T element) {
    this.heap.add(element);
    int current_index = this.heap.size() - 1;
    while (current_index > 1
        && this.heap.get(current_index).compareTo(this.getParent(current_index)) < 0) {
      this.swap(current_index, (int) current_index / 2);
      current_index = (int) current_index / 2;
    }
  }

  private boolean isLeaf(int index) {
    if (index >= (int) this.heap.size() / 2 && index <= this.heap.size() - 1) {
      return true;
    }
    return false;
  }

  // Min Heapify on a given node
  public void minHeapify(int index) {

    if (!this.isLeaf(index)) {

      // if right child is not null
      if (this.getRightChild(index) != null) {
        // if the current element is bigger than left or right child
        if (this.heap.get(index).compareTo(this.getRightChild(index)) > 0
            || this.heap.get(index).compareTo(this.getLeftChild(index)) > 0) {
          // Right child greater
          if (this.getRightChild(index).compareTo(this.getLeftChild(index)) > 0) {
            // replace parent with left child
            this.swap(index, 2 * index);
            this.minHeapify(2 * index);
          }
          // Left child greater
          else {
            // replace parent with right child
            this.swap(index, 2 * index + 1);
            this.minHeapify(2 * index + 1);
          }
        }
        // if only left child is present
      } else {
        if (this.heap.get(index).compareTo(this.getLeftChild(index)) > 0) {
          this.swap(index, 2 * index);
          this.minHeapify(2 * index);
        }
      }
    }
  }

  // Retrieve the element at top of the heap
  public T remove() {

	if (this.heap.size() > 2) {
    T minElement = this.heap.get(1);
    T lastElement = this.heap.remove(this.heap.size() - 1);
      this.heap.set(1, lastElement);
      this.minHeapify(1);
    return minElement;
	}
	else {
		 T minElement = this.heap.remove(this.heap.size() - 1);
		 return minElement;
	}
  }

  public void heapSort() {
     while(this.heap.size() >1) {
      T element = this.remove();
      System.out.println(element);
    }
  }

  private void printHeap() {
    for (int i = 1; i <= this.heap.size() / 2; i++) {
      System.out.println("CURR_ELE: " + this.heap.get(i));
      System.out.print(" PARENT : " + this.getParent(i));
      System.out.print(" LEFT CHILD : " + this.getLeftChild(i));
      System.out.print(" RIGHT CHILD :" + this.getRightChild(i));
      System.out.println();
    }
  }

  public static void main(String[] args) {

    BinaryHeap<Integer> mh = new BinaryHeap<>();

    mh.insert(8);
    mh.insert(9);
    mh.insert(5);
    mh.insert(6);
    mh.insert(3);
    mh.insert(1);

    mh.printHeap();
    System.out.println("HeapSort is : ");
    mh.heapSort();
  }
}
