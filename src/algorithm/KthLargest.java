package algorithm;

import java.util.PriorityQueue;

public class KthLargest {

  public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    for(int i = 0; i<k ; i++){
      queue.add(nums[i]);
    }

    for(int i = k; i< nums.length; i++){
      if(queue.peek() < nums[i]){
        queue.poll();
        queue.add(nums[i]);
      }
    }
    return queue.peek();
  }

}
