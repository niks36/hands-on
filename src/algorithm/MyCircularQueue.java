package algorithm;

class MyCircularQueue {

class Node {
  int value;
  Node next;


}

  int size;
  int count;
  Node head = null;
  Node tail = null;
  public MyCircularQueue(int k) {
    this.size = k;
  }

  public boolean enQueue(int value) {

    if(count >= size){
      return false;
    }

    if(head == null){
      Node node = new Node();
      node.value = value;
      node.next = node;
      count++;
      head = node;
      tail = node;
      return true;
    }

    count++;

    Node node = new Node();
    node.value = value;
    node.next = head;

    tail.next = node;
    tail = node;

    return true;

  }

  public boolean deQueue() {
    if(count == 0) return false;

    if(count == 1) {
      head = null;
      tail = null;
      count--;
      return true;
    }

    Node node = head.next;
    tail.next = node;
    head.next = null;
    head = node;
    count--;

    return true;
  }

  public int Front() {
    if (head != null){
      return head.value;
    }
    return -1;
  }

  public int Rear() {
    if (tail != null){
      return tail.value;
    }
    return -1;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == size;
  }
}