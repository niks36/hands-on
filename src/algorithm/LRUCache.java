

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  class Node {
    int key;
    int value;
    Node pre;
    Node post;
  }

  private Map<Integer, Node> cache = new HashMap<>();

  private int count;

  private int capacity;

  private Node head, tail;

  private void addNode(Node node) {
    node.pre = head;
    node.post = head.post;

    head.post.pre = node;
    head.post = node;
  }

  private void removeNode(Node node) {
    Node pre = node.pre;
    Node post = node.post;

    pre.post = post;
    post.pre = pre;
  }

  private void moveToHead(Node node) {
    removeNode(node);
    addNode(node);
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.count = 0;

    head = new Node();
    head.pre = null;

    tail = new Node();
    tail.post = null;

    head.post = tail;
    tail.pre = head;
  }

  public void print(){
    System.out.print("Cache map ");
    for (int i : cache.keySet()) {
      System.out.print(i);
    }
    System.out.println();
    display();
    System.out.println("========");
  }
  public void display() {
    //Node current will point to head
    Node current = head;
    if(head == null) {
      System.out.println("List is empty");
      return;
    }
    System.out.println("Nodes of doubly linked list: ");
    while(current != null) {
      //Prints each node by incrementing the pointer.

      System.out.print(current.value + " ");
      current = current.post;
    }
    System.out.println();
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null) {
      return -1;
    }

    this.moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node node = cache.get(key);
    if (node == null) {
      Node newNode = new Node();
      newNode.key = key;
      newNode.value = value;
      this.cache.put(key, newNode);
      this.addNode(newNode);
      ++count;

      if (count > capacity) {
        Node tail = this.popTail();
        System.out.println("removing tail "+ tail.key);
        this.cache.remove(tail.key);
      }
    }else{
      node.value = value;
      this.moveToHead(node);
    }
    print();
  }

  private Node popTail() {
    Node node = tail.pre;
    this.removeNode(node);
    return node;
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(3);
    lruCache.put(1,1);
    lruCache.put(2,2);
    lruCache.put(3,3);
    lruCache.put(4,4);
    lruCache.put(2,2);
    lruCache.put(5,5);
    lruCache.put(6,6);

  }
}
