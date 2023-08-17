package algorithm;

public class ReverseLinkedList {

  public static void main(String[] args) {

  }

  Node reverse(Node node) {
    Node prev = null;
    Node current = node;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  class Node {
    int value;
    Node next;


  }
}
