package datastructure.binaryheap;

import org.apache.log4j.Logger;



public class MinHeapTest {
	
	public static void main(String[] args) {

	final Logger logger = Logger.getLogger(MinHeapTest.class.getName());
    MinHeap<Double> mh = new MinHeap<Double>(Double.class,10);
    mh.insert(1.0);
    mh.insert(3.0);
    mh.insert(6.0);
    mh.insert(5.0);
    mh.insert(9.0);
    mh.insert(8.0);
    logger.info("CURRENT HEAP: \n");
    mh.print(); 
    
    logger.info("Minimum Element: " + mh.remove());
    logger.info("\n");
    logger.info("CURRENT HEAP AFTER REMOVING MINIMUM ELEMENT:\n" );
    mh.print();
    logger.info("Minimum Element: " + mh.remove());
    logger.info("\n");
    logger.info("CURRENT HEAP AFTER REMOVING MINIMUM ELEMENT:\n" );
    mh.print();
    
    logger.info("HEAPSORT: \n");
    Double nums[] = mh.sort(Double.class);
    for(double d : nums) {
    	System.out.print(d + " ");
    }
    logger.info("\n");

    
    
    
	}
}
