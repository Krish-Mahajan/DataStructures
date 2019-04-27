package datastructure.binarytree;

import org.apache.log4j.Logger;

public class BinaryTreeTest {

	public static void main(String[] args) {

		
		final  Logger logger = Logger.getLogger(BinaryTreeTest.class.getName());
		
		BinaryTree<Double> tree = new BinaryTree<Double>();
		tree.setRoot(1.0);
		
		try {
			tree.getRoot().setLeftChild(2.0);
			tree.getRoot().setRightChild(3.0);
			tree.getRoot().getLeftChild().setLeftChild(4.0);
			tree.getRoot().getLeftChild().setRightChild(5.0);
		} catch (RootNotSetException e) {		
			e.printStackTrace();
		}
		
		try {
			logger.info(" INORDER TRAVERSAL OF THE TREE: ");
			tree.inorderTraversal(tree);
			logger.info("\n");
			logger.info(" PREORDER TRAVERSAL OF THE TREE: ");
			tree.preorderTraversal(tree);
			logger.info("\n");
			logger.info(" POSTORDER TRAVERSAL OF THE TREE: ");
			tree.postorderTraversal(tree);
			logger.info("\n");
			
		} catch (RootNotSetException e) {
			e.printStackTrace();
		}
		
		
	}
}
