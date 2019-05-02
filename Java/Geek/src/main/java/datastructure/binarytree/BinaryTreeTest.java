package datastructure.binarytree;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class BinaryTreeTest {

  public static void main(String[] args) throws RootNotSetException {

    final Logger logger = Logger.getLogger(BinaryTreeTest.class.getName());

    BinaryTree<Double> tree = new BinaryTree<Double>();
    tree.setRoot(1.0);

    tree.getRoot().setLeftChild(2.0);
    tree.getRoot().setRightChild(3.0);
    tree.getRoot().getLeftChild().setLeftChild(4.0);
    tree.getRoot().getLeftChild().setRightChild(5.0);

    logger.info(" INORDER TRAVERSAL OF THE TREE: ");
    tree.inorderTraversal(tree);
    logger.info("\n");
    logger.info(" PREORDER TRAVERSAL OF THE TREE: ");
    tree.preorderTraversal(tree);
    logger.info("\n");
    logger.info(" POSTORDER TRAVERSAL OF THE TREE: ");
    tree.postorderTraversal(tree);
    logger.info("\n");

    logger.info("Inserting new elements in Binary Tree\n");
    BinaryTree<Double> tree1 = new BinaryTree<Double>();
    Double nums[] = {100.0, 20.0, 500.0, 10.0, 30.0};
    tree1.insertFromArray(nums);
    logger.info(" INORDER TRAVERSAL OF THE TREE AFTER INSERTION FROM ARRAY: ");

    tree1.inorderTraversal(tree1);
    logger.info("\n");

    logger.info("\n");

    tree1.insert(45.0);
    logger.info(" INORDER TRAVERSAL OF THE TREE AFTER INSERTING SINGLE ELEMENT: ");

    tree1.inorderTraversal(tree1);
    logger.info("\n");

    logger.info("\n");
    logger.info(" INORDER TRAVERSAL OF THE TREE AFTER INSERTION FROM ARRAY: ");

    tree1.inorderTraversal(tree1);
    logger.info("\n");

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

    logger.info("Inserting new elements in Binary Tree to test Inorder Successor\n");
    BinaryTree<Double> treeI = new BinaryTree<Double>();
    Double data[] = {20.0, 8.0, 22.0, 4.0, 12.0, 10.0, 14.0};
    treeI.insertFromArray(data);
    logger.info(" INORDER TRAVERSAL OF THE TREE AFTER INSERTION FROM ARRAY: ");
    tree1.inorderTraversal(treeI);
    logger.info("\n");

    logger.info("INORDER SUCCESSOR OF ELEMENT " + treeI.getRoot().getLeftChild().getKey() + " : ");
    System.out.println(treeI.inorderSuccessor(treeI.getRoot().getLeftChild()).getKey());

    logger.info(
        "Deleting element " + treeI.getRoot().getRightChild().getKey() + " from the tree\n");
    treeI.deleteNode(treeI.getRoot().getRightChild());
    logger.info(" INORDER TRAVERSAL OF THE TREE AFTER DELETION FROM ARRAY: ");
    tree1.inorderTraversal(treeI);
  }
}
