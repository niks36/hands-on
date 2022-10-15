package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSorts {

  public static void main(String[] args) {
    //
  }

  public ListNode mergeKLists(ListNode[] lists) {

    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

    for(ListNode list : lists){
      priorityQueue.offer(list);
    }
    ListNode head = null;
    ListNode tail = null;
    while (!priorityQueue.isEmpty()){
      ListNode listNode = priorityQueue.poll();
      if(head == null){
        head = tail = listNode;
      }else{
        tail.next = listNode;
        tail = listNode;
      }

      if(listNode.next != null){
        priorityQueue.offer(listNode.next);
      }

    }
    return head;
  }

   class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
