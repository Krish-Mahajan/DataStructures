package datastructure.binarytree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestBinaryTree { 
	
	
	
	
	
	// test to check inordertraversal of BST (should be a sorted array)
	@Test
	public void testInoderTraversal() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         bst.inorderTraversal(bst.root);
	
		
	}
	
	
	@Test
	public void testConvertBTToBST() {
		
	    BinaryTree<Integer> tree = new BinaryTree<Integer>();
	    tree.root = new BinaryTree.Node<Integer>(1);
	    tree.root.leftChild =  new BinaryTree.Node<Integer>(2);
	    tree.root.rightChild =  new BinaryTree.Node<Integer>(3);
	    tree.root.leftChild.leftChild = new BinaryTree.Node<Integer>(4);
	    tree.root.leftChild.leftChild.rightChild = new BinaryTree.Node<Integer>(5);
	    tree.inorderTraversal(tree.root);
	    System.out.println("Converting BT to BST");
	    tree.convertBToBST();
	}
	
	
	@Test
	public void testAncestorBT() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         bst.findAncestorBT(4);
	
		
	}
	
	
	@Test
	public void testAncestorBST() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         bst.findAncestorBST(10);
	
		
	}
	
	@Test
	public void testCommonAncestorBST() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         bst.findCommonAncestorBST(4,14);
         //bst.findCommonAncestorBT(4,14);
	
		
	}
	
	
	@Test
	public void testCommonAncestorBT() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         bst.findCommonAncestorBT(4,14);
	
		
	}
	
	
	@Test
	public void testIsBTBST() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         System.out.println(bst.isBTBST()); //true
  
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
 	    tree.root = new BinaryTree.Node<Integer>(1);
 	    tree.root.leftChild =  new BinaryTree.Node<Integer>(2);
 	    tree.root.rightChild =  new BinaryTree.Node<Integer>(3);
 	    tree.root.leftChild.leftChild = new BinaryTree.Node<Integer>(4);
 	    tree.root.leftChild.leftChild.rightChild = new BinaryTree.Node<Integer>(5);
 	    System.out.println(tree.isBTBST()); //false

		
	}
	
	@Test
	public void testBSTfromSortedArray() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         Collections.sort(ll);
         bst.createBSTfromSortedArray(ll);
         bst.inorderTraversal(bst.root);
         //System.out.println(bst.root.key);
	
		
	}
	
	@Test
	public void testWidthOfTree() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         int max_width = bst.widthOfTree(bst.root);
         System.out.println(" Max width is: " + max_width);	
	}
	
	@Test
	public void testDepthOfNodeBST() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         System.out.println(bst.DepthOfNodeBST(bst.root, 12,0));
         
	}
	
	@Test
	public void testDepthOfNodeBT() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         System.out.println(bst.DepthOfNodeBT(bst.root, 4,0));
         
	}
	
	@Test
	public void testDiameterofNodeBT() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         System.out.println(bst.diameterBT(bst.root));
         
	}
	
	@Test
	public void testcountTotalPathWithGivenSum() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 22, 4, 12, 10, 14);
         bst.insertList(ll);
         System.out.println(bst.countTotalPathWithGivenSum(bst.root, 26));
         
	}
	
	@Test
	public void testlargestSubtreeSum() {
         BinaryTree<Integer> bst = new BinaryTree<>();
        // List<Integer> ll = Arrays.asList(20, 8, 22, -4, 12, 10, 14);
         List<Integer> ll = Arrays.asList(0);
         bst.insertList(ll);
         System.out.println(bst.largestSubtreeSum(bst.root));
         
	} 
	
	
	@Test
	public void testVerticalOrderTraversal() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 30, 4, 12, 10, 14,21,23,22);
         bst.insertList(ll);
         System.out.println(bst.verticalOrderTraversal());
         
      
	}
	
	
	@Test
	public void testLevelOrderBFS() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 30, 4, 12, 10, 14,21,23,22);
         bst.insertList(ll);
         System.out.println(bst.levelOrderBFS(bst.root));
         
      
	}
	
	@Test
	public void testZigZagTraversal() {
         BinaryTree<Integer> bst = new BinaryTree<>();
         List<Integer> ll = Arrays.asList(20, 8, 30, 4, 12, 10, 14,21,23,22);
         bst.insertList(ll);
         System.out.println(bst.zizzagTraversal(bst.root));
         
      
	}
	
	
	
	
}
