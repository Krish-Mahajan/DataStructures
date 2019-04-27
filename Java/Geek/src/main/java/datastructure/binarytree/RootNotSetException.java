package datastructure.binarytree;

import org.apache.log4j.Logger;

public class RootNotSetException extends Exception {
   
	final static Logger logger = Logger.getLogger(BinaryTree.class.getName());
	
	public String toString() {
		logger.info("Root not set");
		return "Root of the BinaryTree is not set ye\n";
	}
}
