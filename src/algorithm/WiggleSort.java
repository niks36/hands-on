package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class WiggleSort {


  public static void main(String[] args) {
    //
    WiggleSort wiggleSort = new WiggleSort();
    wiggleSort.wiggleSort(new Integer[]{1,5,1,1,6,4});
  }

  public void wiggleSort(Integer[] nums) {
    ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(nums));
    TreeSet<Integer> integerTreeSet = new TreeSet<>(ints);

    for (int i = 0; i < integerTreeSet.size(); i++) {
      Integer first = integerTreeSet.pollFirst();
      if (first != null) {
        System.out.println(first);
      }
       Integer pollLast = integerTreeSet.pollLast();
      if (pollLast != null) {
        System.out.println(pollLast);
      }
    }
  }
}
