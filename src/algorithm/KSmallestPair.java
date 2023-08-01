package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPair {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    List<List<Integer>> result = new ArrayList<>(); // Result list to store the pairs
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (o[0] + o[1])));

    for(int i = 0; i < k && i < nums1.length; i++){
      pq.add(new int[]{nums1[i], nums2[0], 0});
    }

    while (!pq.isEmpty() && k-- > 0){
      int[] current = pq.poll();

      result.add(Arrays.asList(current[0], current[1]));

      if(current[2] < nums2.length){
        pq.offer(new int[]{current[0], nums2[current[2] + 1],current[2] + 1});
      }
    }
    return result;
  }
}
