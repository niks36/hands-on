package algorithm;

public class CloneLinkedListWithRandomPointer {


  public Node copyRandomList(Node head) {
    if(head == null) return head;

    Node node = head;

    while(node != null){
      Node newNode = new Node(node.val);
      newNode.next = node.next;
      node.next = newNode;
      node = newNode.next;
    }
    node = head;


    while (node != null){
      if(node.next != null){
        Node copyNode   = node.next;
        Node random   = node.random;
        if(random != null){
          copyNode.random = random.next;
        }else{
          copyNode.random = null;
        }
      }
      node = node.next.next;
    }

    node = head;

    Node copy = head.next;
    Node temp = copy;

    while(node != null){
      node.next = node.next.next;
      if(copy.next != null){
        copy.next = copy.next.next;
      }
      node = node.next;
      copy = copy.next;
    }

  return
       temp;
  }
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
  public static void main(String[] args) {
    //
  }
}
