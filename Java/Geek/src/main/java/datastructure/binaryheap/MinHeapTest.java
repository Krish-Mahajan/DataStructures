package datastructure.binaryheap;

public class MinHeapTest {
	
	public static void main(String[] args) {

    MinHeap<Double> mh = new MinHeap<Double>(Double.class,10);
    mh.insert(1.0);
    mh.insert(3.0);
    mh.insert(6.0);
    mh.insert(5.0);
    mh.insert(9.0);
    mh.insert(8.0);
    mh.print();
	}
}
