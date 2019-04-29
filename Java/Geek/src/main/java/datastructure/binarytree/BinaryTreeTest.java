package datastructure.binarytree;

import java.util.Arrays;

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
		
		
		logger.info("Inserting new elements in Binary Tree\n");
		BinaryTree<Double> tree1 = new BinaryTree<Double>();
		Double nums[] = {100.0 , 20.0, 500.0 , 10.0 ,30.0};
		tree1.insertFromArray(nums);
		logger.info(" INORDER TRAVERSAL OF THE TREE AFTER INSERTION FROM ARRAY: ");
		try {
			tree1.inorderTraversal(tree1);
			logger.info("\n");
		} catch (RootNotSetException e) {
			e.printStackTrace();
		}
		logger.info("\n");
		
		tree1.insert(45.0);
		logger.info(" INORDER TRAVERSAL OF THE TREE AFTER INSERTING SINGLE ELEMENT: ");
		try {
			tree1.inorderTraversal(tree1);
			logger.info("\n");
		} catch (RootNotSetException e) {
			e.printStackTrace();
		}
		logger.info("\n");		logger.info(" INORDER TRAVERSAL OF THE TREE AFTER INSERTION FROM ARRAY: ");
		try {
			tree1.inorderTraversal(tree1);
			logger.info("\n");
		} catch (RootNotSetException e) {
			e.printStackTrace();
		}
		logger.info("\n");
		
		
		logger.info("is 45.0 present in Tree?\n");
		boolean x1 = tree1.searchBST(45.0);
		logger.info(x1);
		logger.info("\n");
		
		logger.info("is 55.0 present in Tree?\n");
		boolean x2 = tree1.searchBST(55.0);
		logger.info(x2);
		logger.info("\n");
		
		
		logger.info("is 30.0 present in Tree?\n");
		boolean x3 = tree1.searchBST(55.0);
		logger.info(x3);
		logger.info("\n");
	
		
		
		
	}
}
