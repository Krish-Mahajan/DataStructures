package datastructure.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

  Node<T> root;

  BinaryTree(T key) {
    if (this.root == null) {
      this.root = new Node<T>(key);
    }
  }

  BinaryTree() {
    this.root = null;
  }

  // Get root element of Binary Tree
  public T getRootKey() {
    return this.root.key;
  }

  // insert operation as Binary Search Tree
  public void insert(T key) {
    if (this.root != null) {
      this.insertUtil(key, this.root);

    } else {
      this.root = new Node<T>(key);
    }
  }

  private void insertUtil(T key, Node<T> node) {
    if (node != null) {
      if (key.compareTo(node.key) < 0) {
        if (node.leftChild != null) {
          this.insertUtil(key, node.leftChild);
        } else {
          node.leftChild = new Node<T>(key);
          node.leftChild.parent = node;
        }
      } else {
        if (node.rightChild != null) {
          this.insertUtil(key, node.rightChild);
        } else {
          node.rightChild = new Node<T>(key);
          node.rightChild.parent = node;
        }
      }
    }
  }

  // inorder tree traversal
  public void inorderTraversal(Node<T> node) {
    if (node != null) {
      this.inorderTraversal(node.leftChild);
      System.out.println(node.key);
      this.inorderTraversal(node.rightChild);
    }
  }

  public void convertBToBST() {
    List<T> list = new ArrayList<>();
    this.convertBToBSTUtil1(this.root, list);
    Collections.sort(list);
    this.convertBToBSTUtil2(this.root, list);
    this.inorderTraversal(this.root);
  }

  private void convertBToBSTUtil1(Node<T> node, List<T> ll) {
    if (node != null) {
      this.convertBToBSTUtil1(node.leftChild, ll);
      ll.add(node.key);
      this.convertBToBSTUtil1(node.rightChild, ll);
    }
  }

  private void convertBToBSTUtil2(Node<T> node, List<T> ll) {
    if (node != null) {
      this.convertBToBSTUtil2(node.leftChild, ll);
      node.key = ll.remove(0);
      this.convertBToBSTUtil2(node.rightChild, ll);
    }
  }

  // Find ancestor of a node in Binary Tree
  public void findAncestorBT(T key) {
    this.findAncestorBTUtil(key, this.root);
  }

  private boolean findAncestorBTUtil(T key, Node<T> node) {
    if (node == null) {
      return false;
    }

    if (node.key == key) {
      return true;
    } else if (findAncestorBTUtil(key, node.leftChild)
        || findAncestorBTUtil(key, node.rightChild)) {
      System.out.println(node.key);
      return true;
    } else return false;
  }

  // Find ancestor of a node in Binary Search Tree
  public void findAncestorBST(T key) {
    this.findAncestorBSTUtil(key, this.root);
  }

  private boolean findAncestorBSTUtil(T key, Node<T> node) {
    if (node == null) return false;

    if (node.key == key) return true;

    if (node.key.compareTo(key) > 0) {
      if (findAncestorBSTUtil(key, node.leftChild)) {
        System.out.println(node.key);
        return true;
      }
    } else if (node.key.compareTo(key) < 0) {
      if (findAncestorBSTUtil(key, node.rightChild)) {
        System.out.println(node.key);
        return true;
      }
    }
    return false;
  }

  // Find common ancestors of two node in Binary Search Tree
  public void findCommonAncestorBST(T key1, T key2) {
    this.findCommonAncestorBSTUtil(key1, key2, this.root);
  }

  private boolean findCommonAncestorBSTUtil(T key1, T key2, Node<T> node) {
    if (node == null) {
      return false;
    }

    if (node.key.compareTo(key1) < 0 && node.key.compareTo(key2) < 0) {
      System.out.println(node.key);
      return findCommonAncestorBSTUtil(key1, key2, node.rightChild);
    }

    if (node.key.compareTo(key1) > 0 && node.key.compareTo(key2) > 0) {
      System.out.println(node.key);
      return findCommonAncestorBSTUtil(key1, key2, node.leftChild);
    } else if ((node.key.compareTo(key1) < 0 && node.key.compareTo(key2) > 0)
        || (node.key.compareTo(key1) > 0 && node.key.compareTo(key2) < 0)) {
      System.out.println(node.key); // first common ancestor
      return false;
    }

    return false;
  }

  // Find common ancestors of two node in Binary Tree
  public void findCommonAncestorBT(T key1, T key2) {
    this.findCommonAncestorBTUtil(key1, key2, this.root);
  }

  private boolean findCommonAncestorBTUtil(T key1, T key2, Node<T> node) {

    if (node == null) {
      return false;
    }

    if (covers(key1, node.leftChild) && covers(key2, node.leftChild)) {
      System.out.println(node.key);
      return findCommonAncestorBTUtil(key1, key2, node.leftChild);
    } else if (covers(key1, node.rightChild) && covers(key2, node.rightChild)) {
      System.out.println(node.key);
      return findCommonAncestorBTUtil(key1, key2, node.rightChild);
    } else if ((covers(key1, node.rightChild) && covers(key2, node.leftChild))
        || (covers(key1, node.leftChild) && covers(key2, node.rightChild))) {
      System.out.println(node.key); // first common ancestor
      return false;
    }

    return false;
  }
  // Function to check if a key is present in subtree
  private boolean covers(T key, Node<T> node) {
    if (node == null) return false;

    if (key == node.key) return true;

    return (covers(key, node.leftChild) || covers(key, node.rightChild));
  }

  // Find if given binary tree BST without inorder traversal
  public boolean isBTBST() {

    return isBTBSTUtil(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBTBSTUtil(Node<T> node, int mIN_VALUE, int mAX_VALUE) {

    if (node == null) return true;

    Integer node_key = (Integer) node.key;

    if (node_key > mAX_VALUE || node_key < mIN_VALUE) return false;

    return (isBTBSTUtil(node.leftChild, mIN_VALUE, node_key)
        && isBTBSTUtil(node.rightChild, node_key, mAX_VALUE));
  }
  
  


// create balanced binary search tree from a sorted array
  public void createBSTfromSortedArray(List<T> list) {
    int start = 0;
    int end = list.size() - 1;
    this.createBSTfromSortedArrayUtil(list, start, end);
  }

  private void createBSTfromSortedArrayUtil(List<T> list, int start, int end) {
    if (start > end) return;
    int mid = (start + end) / 2;
    this.insert((list.get(mid)));
    this.createBSTfromSortedArrayUtil(list, start, mid - 1);
    this.createBSTfromSortedArrayUtil(list, mid + 1, end);
  }

  // insert element from a List
  public void insertList(List<T> ll) {
    for (T key : ll) {
      this.insert(key);
    }
  }

  // find height of a node in BT O(n)
  public int heightOfNode(Node<T> node) {
    if (node == null) return 0;

    int heightLeftTree = heightOfNode(node.leftChild);
    int heightRightTree = heightOfNode(node.rightChild);

    return 1 + Math.max(heightLeftTree, heightRightTree);
  }

  // Level order traversal of BST O(n*2)
  public Map<Integer, Integer> levelOrderTraversal(Node<T> node) {
    int heightOfTree = heightOfNode(this.root);
    Map<Integer, Integer> nodeCount = new HashMap<>();
    for (int level = 1; level <= heightOfTree; level++) {
      nodeCount.put(level, 0);
      this.widthOfTreeUtil(this.root, nodeCount, level, 1);
    }
    return nodeCount;
  }

  private void widthOfTreeUtil(
      Node<T> node, Map<Integer, Integer> nodeCount, int targetLevel, int currentLevel) {
    if (node == null) return;

    if (currentLevel == targetLevel) {
      nodeCount.put(targetLevel, nodeCount.get(currentLevel) + 1);
    }

    this.widthOfTreeUtil(node.leftChild, nodeCount, targetLevel, currentLevel + 1);
    this.widthOfTreeUtil(node.rightChild, nodeCount, targetLevel, currentLevel + 1);
  }

  
  //Level Order using BFS
  List<List<Integer>> levelList = new ArrayList<>(); 
  
  class NodeLevel{
      Node<Integer> node;
      int level;
      NodeLevel(Node<Integer> node ,int level){
          this.node = node;
          this.level = level;
      }
  }
  
 
  public List<List<Integer>> levelOrderBFS(Node<Integer> root) {
      
      Queue<NodeLevel> q = new LinkedList<>();
      q.add(new NodeLevel(root,1));
      
      //BFS
      while(!q.isEmpty()){
          
          NodeLevel node = q.poll();
          if( levelList.size() < node.level){
              levelList.add(new ArrayList<>());
              }
          levelList.get(levelList.size()-1).add(node.node.key);
          
          List<Node<Integer>> neighbourNodes = new ArrayList<>();
          neighbourNodes.add(node.node.leftChild);	  
          neighbourNodes.add(node.node.rightChild);	  
          for(Node<Integer> neighbourNode : neighbourNodes){
              if(neighbourNode!=null) q.add(new NodeLevel(neighbourNode,node.level+1));    
          }
      }
      
       return levelList;
  }
  
  
  // Find width of Tree O(n*2) Solution
  public int widthOfTree(Node<T> node) {
    int heightOfTree = heightOfNode(this.root);
    int max_width = 1;
    for (int level = 1; level <= heightOfTree; level++) {
      int level_width = this.widthOfTreeLevel(this.root, level, 1);
      if (level_width > max_width) max_width = level_width;
    }
    return max_width;
  }
 
  private int widthOfTreeLevel(Node<T> node, int targetLevel, int currentLevel) {

    if (node == null) return 0;

    if (targetLevel == currentLevel) return 1;
    else if (targetLevel != currentLevel) {
      int node_leftTree = widthOfTreeLevel(node.leftChild, targetLevel, currentLevel + 1);
      int node_rightTree = widthOfTreeLevel(node.rightChild, targetLevel, currentLevel + 1);
      return node_leftTree + node_rightTree;
    } else return 0;
  }

  // search for a element and return depth from root in BST
  public int DepthOfNodeBST(Node<T> node, T targetKey,int level) {
    if (node == null) return 0;

    if (node.key.compareTo(targetKey) == 0) return level;
    else if (node.key.compareTo(targetKey) > 0) {
      return DepthOfNodeBST(node.leftChild, targetKey,level + 1);
    } else {
      return DepthOfNodeBST(node.rightChild, targetKey,level + 1);
    }
  }

  // search for a element and return depth from root in BT
  public int DepthOfNodeBT(Node<T> node, T targetKey, int level) {
    if (node == null) return 0;

    if (node.key.compareTo(targetKey) == 0) return level;

    /**
    int downLevel = DepthOfNodeBT(node.leftChild, targetKey, level + 1);
    if (downLevel != 0) return downLevel;

    downLevel = DepthOfNodeBT(node.rightChild, targetKey, level + 1); 
    return downLevel;*/
    return Math.max(DepthOfNodeBST(node.leftChild, targetKey, level+1),DepthOfNodeBST(node.rightChild, targetKey, level+1));
  }

  // Diameter of a node in BT Brute Force(No of nodes in longest path of tree) O(n*2)
  public int diameterBT(Node<T> node) {

    if (node != null) {

      int lheight = this.heightOfNode(node.leftChild);
      int rheight = this.heightOfNode(node.rightChild);

      int ldiameter = this.diameterBT(node.leftChild);
      int rdiameter = this.diameterBT(node.rightChild);

      return Math.max((lheight + rheight + 1), Math.max(ldiameter, rdiameter));
    }

    return 0;
  }

  //Find total path with given sum in Binary Tree going downwards O(n*2) Brute Force
  public int countTotalPathWithGivenSum(Node<T> node, int targetSum) {

    if (node == null) return 0;

    int countOfPathsInCurrentNode = countTotalPathWithGivenSumUtil(node, targetSum, 0);
    int countOfPathsInLeftNode = countTotalPathWithGivenSum(node.leftChild, targetSum);
    int countOfPathsInRightNode = countTotalPathWithGivenSum(node.rightChild, targetSum);

    return countOfPathsInCurrentNode + countOfPathsInLeftNode + countOfPathsInRightNode;
  }

  private int countTotalPathWithGivenSumUtil(Node<T> node, int targetSum, int currentSum) {

    if (node == null) {
      return 0;
    }
    currentSum = currentSum + (int) node.key;
    
    if (targetSum == currentSum) {
      return 1;
    }

    int countOfPathsInLeftNode =
        this.countTotalPathWithGivenSumUtil(node.leftChild, targetSum, (int) currentSum);
    int countOfPathsRightNode =
        this.countTotalPathWithGivenSumUtil(node.rightChild, targetSum, (int) currentSum);

    return countOfPathsInLeftNode + countOfPathsRightNode;
  }


  
  // Find path downwards with maximum sum
  //https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
  public int findMaximumSumPathDownwards(Node<T> node ) {
	  List<Integer> sumSofar = new ArrayList<>();
	  findMaximumSumPathUtil(node, sumSofar);
	  return maxSum;
	  
  }
  private void findMaximumSumPathUtil(Node<T> node,List<Integer> sumSofar){
	  
	  if(node == null) return; 
	  
	  sumSofar.add((int)node.key);
	  
	  this.findMaximumSumPathUtil(node.leftChild, sumSofar);
	  this.findMaximumSumPathUtil(node.rightChild, sumSofar);
	  
	  int sum = 0;
	  for(int i = sumSofar.size()-1 ; i>=0 ;i--) {
		  sum = sum + sumSofar.get(i);
		  if( sum > maxSum) maxSum = sum;
	  }
	  
	  sumSofar.remove(sumSofar.indexOf(node.key));
	  
	  

  
  }
  
  //Find subtree with Maximum sum
  //https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/
  static int maxSum =Integer.MIN_VALUE;;
  public int largestSubtreeSum(Node<T> node) {
	  largestSubtreeSumUtil(node);
	   
	   return maxSum;

  }
  
  
  public int largestSubtreeSumUtil(Node<T> node){
	  
	  if(node == null) return 0 ; 
	  
	  int  sumSofar = (int) node.key ; 
	  sumSofar += this.largestSubtreeSumUtil(node.leftChild);
	  sumSofar +=  this.largestSubtreeSumUtil(node.rightChild);
	  
	  if(sumSofar > maxSum) maxSum = sumSofar;
	  
	  return Math.max(0, sumSofar);
	  
  }
  // correct solution
  /**
   * class Solution {
  int max_sum = Integer.MIN_VALUE;

  public int max_gain(TreeNode node) {
    if (node == null) return 0;

    // max sum on the left and right sub-trees of node
    int left_gain = Math.max(max_gain(node.left), 0);
    int right_gain = Math.max(max_gain(node.right), 0);

    // the price to start a new path where `node` is a highest node
    int price_newpath = node.val + left_gain + right_gain;

    // update max_sum if it's better to start a new path
    max_sum = Math.max(max_sum, price_newpath);

    // for recursion :
    // return the max gain if continue the same path
    return node.val + Math.max(left_gain, right_gain);
  }

  public int maxPathSum(TreeNode root) {
    max_gain(root);
    return max_sum;
  }
}
   * @return
   */
  
  
  //Find Vertical Order traversal BST
  public Map<Integer,List<Integer>> verticalOrderTraversal() {
	  Map<Integer,List<Integer>> map =  new HashMap<>();
	  this.verticalOrderTraversalUtil(this.root,map,0);
	  return map;
  }
  
  

  
  

private void verticalOrderTraversalUtil(Node<T> node,Map<Integer, List<Integer>> map,int level){
	
	if(node != null) {
		if(map.containsKey(level)) {
			 if(level >0)  map.get(level).add(0,(int) node.key);
			 else
		     map.get(level).add((int) node.key);
		}
		else {
			List<Integer> l = new ArrayList<>();
			if(level > 0) l.add(0,(int)node.key);
			else l.add((int)node.key);
			map.put(level,l);		
		}
		verticalOrderTraversalUtil(node.leftChild, map, level-1);
		verticalOrderTraversalUtil(node.rightChild, map, level+1);
		
	}
	else return;
}


//zizgzag traversal 
public List<List<Integer>> zizzagTraversal(Node<T> node){
	   List<List<Integer>> list = new ArrayList<List<Integer>>();
		zizzagTraversalUtil(node,list,0);
		return list;
}



private void zizzagTraversalUtil(Node<T> node,List<List<Integer>> list, int level){
	if(node !=null) {
		if(list.size() <= level) {
			 list.add(new ArrayList<>());
		}
		
		if(level %2 ==0) {
				list.get(level).add((int) node.key);
			}
		else {
				list.get(level).add(0,(int) node.key);
			}
				
		
	
		zizzagTraversalUtil(node.leftChild, list, level+1);
		zizzagTraversalUtil(node.rightChild, list, level+1);

			
		
	}
}



static class Node<T extends Comparable<T>> {

    Node<T> parent;
    Node<T> leftChild;
    Node<T> rightChild;
    T key;

    Node(T key) {
      this.key = key;
      this.leftChild = null;
      this.rightChild = null;
      this.parent = null;
    }
  }
}
