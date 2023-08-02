package algorithm;

import java.util.HashMap;
import java.util.Map;

public class KDifferentPairs {

  public int findPairs(int[] nums, int k) {

    if (k < 0) return -1;
    int result = 0;
    Map<Integer, Integer> numberMap = new HashMap<>();
    for (int num : nums) {
      numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
    }
    System.out.println(numberMap);
    for (int n : numberMap.keySet()) {
      if (k == 0) {
        if (numberMap.get(n) >= 2) result++;
      } else {
        if (numberMap.containsKey(n + k)) result++;
      }
    }
    return result;
  }
}
