package algorithm;

public class IntersectionLinkedList {

  public static void main(String[] args) {


  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if(headA == null) return null;
    if(headB == null) return null;

    ListNode pointer1 = headA;
    ListNode pointer2 = headB;

    while (pointer1 != pointer2){
      pointer1 = pointer1 == null ? headB : pointer1.next;
      pointer2 = pointer2 == null ? headA : pointer2.next;
    }

    return pointer1;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
