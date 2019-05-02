package datastructure.linkedlist;

import org.apache.log4j.Logger;

/**
 * @author krish.mahajan@gmail.com
 * @param <T>
 */
public class LinkedList<T extends Comparable<T>> {

  static final Logger logger = Logger.getLogger(LinkedList.class.getName());

  private Node<T> head; // head of list

  public Node<T> getHead() {
    return head;
  }

  public void setHead(Node<T> head) {
    this.head = head;
  }

  /**
   * TO check if the current node is the head of the list (Assuming LinkedList has unique entries)
   *
   * @param n
   * @return
   */
  public boolean isHead(Node<T> n) {
    if (n.getData().equals(this.getHead().getData())) return true;
    return false;
  }

  public LinkedList<T> createLinkedListArray(T[] data) {
    LinkedList<T> l = new LinkedList<T>();
    l.setHead(new Node<T>(data[0]));
    Node<T> currL = l.getHead();
    for (int i = 1; i < data.length; i++) {
      currL.setNext(new Node<T>(data[i]));
      currL = currL.getNext();
    }

    return l;
  }

  /* Linked list Node */
  public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T data;
    private Node<T> next;

    // Constructor to create a new node
    // Next is by default initialized
    public Node(T d) {
      this.data = d;
    }

    public T getData() {
      return data;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }

    public int compareTo(Node<T> o) {
      return this.getData().compareTo(o.getData());
    }
  }

  public void printList() {
    Node<T> start = this.getHead();
    while (start != null) {
      logger.info(start.getData().toString() + " ");
      start = start.getNext();
      // logger.info(" ");
    }
  }

  /**
   * Add a new node at the start of LinkedList
   *
   * @param new_data
   */
  public void push(T new_data) {
    Node<T> new_node = new Node<T>(new_data);
    new_node.next = this.getHead();
    this.setHead(new_node);
  }

  /**
   * Add a node next to given node (cannot add new node at the start of linkedList)
   *
   * @param newNodeData Data value of new node
   * @param insertAfterNodeData Data value of given node
   */
  public void insertAfter(T newNodeData, T insertAfterNodeData) {
    // create the new_node
    Node<T> new_node = new Node<T>(newNodeData);

    // search the existing node with given data value starting at head of the
    // LinkedList
    Node<T> curr = this.getHead();
    Node<T> currNext = curr.next;

    // iterate over the linkedList till the node is found or end of the LinkedList
    // is reached
    while (curr != null) {
      if (curr.getData().equals(insertAfterNodeData)) {
        break;
      }

      curr = currNext;
      currNext = curr.getNext();
    }
    if (curr == null) {
      logger.info("LinkedList has no Node with the value :" + insertAfterNodeData);
    } else {
      curr.setNext(new_node);
      new_node.setNext(currNext);
    }
  }

  /**
   * Delete a node in LinkedList with given data value
   *
   * @param data
   */
  public void deleteNode(T data) {

    // Iterate over the linkList to find the given node to be deleted
    Node<T> currPrev = null;
    Node<T> curr = this.getHead();

    while (curr != null) {
      if (curr.getData().equals(data)) {

        // if curr is head of the linkedList
        if (this.isHead(curr)) {
          this.setHead(curr.getNext());
          break;
        }
        // delete the node and make the new connections
        currPrev.setNext(curr.getNext());
        break;
      }

      currPrev = curr;
      curr = curr.getNext();
    }
    if (curr == null) {
      logger.info("Key was not found");
    }
  }

  /**
   * Find size of LinkedList iteratively
   *
   * @return size of LinkedList
   */
  public int IterativeSize() {
    if (this.getHead() == null) {
      logger.info("No linkedList found");
      return 0;
    }
    Node<T> curr = this.getHead();
    int size = 0;
    while (curr != null) {
      curr = curr.getNext();
      size += 1;
    }
    return size;
  }

  /**
   * REMEBER Find size of LinkedList recursively
   *
   * @return size of LinkedList.
   */
  public int RecursiveSize() {
    Node<T> curr = this.getHead();
    int size = this.RecursiveSize(curr);
    return size;
  }

  private int RecursiveSize(Node<T> curr) {
    if (curr == null) {
      return 0;
    }

    return 1 + RecursiveSize(curr.getNext());
  }

  /**
   * SwapNodes of linkedList
   *
   * @param key1 Key of Node1
   * @param key2 Key of Node2
   */
  public void swapNodes(T key1, T key2) {

    if ((Double) key1 == null && (Double) key2 == null) {
      logger.info("Keys cannot be null");
      return;
    }
    Node<T> currNode = this.getHead();
    Node<T> prevNode = null,
        key1Node = null,
        key1PrevNode = null,
        key2Node = null,
        key2PrevNode = null;

    while (currNode != null) {

      if (key1.equals(currNode.getData())) {
        key1PrevNode = prevNode;
        key1Node = currNode;
      }

      if (key2.equals(currNode.getData())) {
        key2PrevNode = prevNode;
        key2Node = currNode;
      }

      // break the iteration if both the list are found
      if (key1Node != null && key2Node != null) break;

      prevNode = currNode;
      currNode = currNode.getNext();
    }

    // check if any of the keyNode is not null
    if (key1Node == null || key2Node == null) {
      logger.info("One of the key was not found in the LinkedList");
      return;
    }

    // swap the nodes

    if (key1PrevNode != null) key1PrevNode.setNext(key2Node);
    else this.setHead(key2Node);

    if (key2PrevNode != null) key2PrevNode.setNext(key1Node);
    else this.setHead(key1Node);

    Node<T> tmp = key1Node.getNext();
    key1Node.setNext(key2Node.getNext());
    key2Node.setNext(tmp);
  }

  /** REMEMBER Reverse the LinkList iteratively */
  public void reverseList() {

    Node<T> curr = this.getHead();
    Node<T> next = null;
    Node<T> prev = null;
    while (curr != null) {
      next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
    }
    this.setHead(prev);
  }

  /** Reverser the LinkList recursively */
  public void reverseList(Node<T> curr, Node<T> prev) {

    if (curr == null) {
      this.setHead(prev);
      return;
    } else {
      Node<T> next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
      reverseList(curr, prev);
    }
  }

  /** Merge two sorted LinkList (My version) */
  public LinkedList<T> mergeTwoSortedLinkList(LinkedList<T> l1, LinkedList<T> l2) {

    // LinkedList l; -- wrong , all local variable must be initialized , not true for class.static
    // or instance variable

    // LinkedList  l = null; wrong , here you're only creating a reference which is initialized to
    // null , that reference is yet not
    // attached to an object(something in memory) , because it has not been newed yet.

    LinkedList<T> l;
    l = new LinkedList<T>();

    // Both the list shouldn't be empty
    if (l1.getHead() == null & l2.getHead() == null) {
      logger.info("Both the list cannot be empty");
    }

    // if anyone of the list is empty , simply return other
    if (l1.getHead() == null && l2.getHead() != null) {
      l = l2;
      return l;
    }

    if (l1.getHead() != null && l2.getHead() == null) {
      l = l1;
      return l;
    }

    Node<T> currL1 = l1.getHead();
    Node<T> currL2 = l2.getHead();

    // set the head of the new LinkedList first
    if (currL1.getData().compareTo(currL2.getData()) >= 0) {
      l.setHead(currL1);
      currL1 = currL1.getNext();
    } else {
      l.setHead(currL2);
      currL2 = currL2.getNext();
    }

    Node<T> currL = l.getHead();

    // iterate and compare the two list
    while (currL1 != null) {
      T currL1Key = currL1.getData();
      while (currL2 != null) {
        T currL2Key = currL2.getData();
        if (currL2Key.compareTo(currL1Key) <= 0) {
          currL.setNext(currL2);
          currL = currL.getNext();
        } else {
          currL.setNext(currL1);
          currL = currL.getNext();
          break;
        }
        currL2 = currL2.getNext();
      }
      currL1 = currL1.getNext();
    }

    // L1 finishes first
    if (currL1 == null & currL2 != null) {
      while (currL2 != null) {
        currL.setNext(currL2);
        currL = currL.getNext();
        currL2 = currL2.getNext();
      }
    }

    // L2 finishes first
    if (currL2 == null & currL1 != null) {
      while (currL1 != null) {
        currL.setNext(currL1);
        currL = currL.getNext();
        currL1 = currL1.getNext();
      }
    }

    return l;
  }

  /** Merge two sorted LinkList (easier solution) */
  public LinkedList<T> sortedMerge(LinkedList<T> l1, LinkedList<T> l2) {

    Node<T> headA = l1.getHead();
    Node<T> headB = l2.getHead();

    /* a dummy first node to hang the result on */
    Node<T> dummyNode = (Node<T>) new Node<Integer>(0);

    /* tail points to the last result node */
    Node<T> currNode = dummyNode;
    while (true) {
      /* if either list runs out,use the other list */
      if (headA == null) {
        currNode.setNext(headB);
        break;
      }
      if (headB == null) {
        currNode.setNext(headA);
        break;
      }

      /* Compare the data of the two lists , whichever lists
       * data is smaller , append it into tail and advance the head
       * to the next node
       */
      if (headA.getData().compareTo(headB.getData()) <= 0) {
        currNode.setNext(headA);
        headA = headA.getNext();
      } else {
        currNode.setNext(headB);
        headB = headB.getNext();
      }
      // Advance the node
      currNode = currNode.getNext();
    }

    LinkedList<T> l = new LinkedList<T>();
    l.setHead(dummyNode.getNext());
    return l;
  }
  /**
   * REMEMBER Reverse a LinkList in group of K
   *
   * @param head
   * @param k
   * @return
   */
  public Node<T> reverseK(Node<T> head, int k) {
    Node<T> curr = head;
    Node<T> next = null;
    Node<T> prev = null;

    int count = 0;

    while (count < k && curr != null) {
      next = curr.getNext();
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }

    /**
     * Next is now a pointer to (K+1)th node Recursively call the list, starting from next. And make
     * rest of the list as next of first node
     */
    if (next != null) head.next = reverseK(next, k);

    // prev is now head of the input list
    return prev;
  }
}
