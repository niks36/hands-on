package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MaxCandies {

  public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
    int n = status.length; // count of boxes
    boolean[] usedBoxes = new boolean[n]; // this are used once
    boolean[] boxFound = new boolean[n];// new box we found
    Queue<Integer> q = new LinkedList<>();
    for (int v : initialBoxes) {
      q.add(v);
      boxFound[v] = true; // initial boxes
    }
    int candy = 0;
    while (!q.isEmpty()) {
      int cur = q.poll();
      if (status[cur] == 1 && !usedBoxes[cur]) { // not used and box open
        candy += candies[cur];
        usedBoxes[cur] = true;
        for (int k : keys[cur]) { // all keys in that box
          status[k] = 1;
          if (boxFound[k]) q.add(k);// box was found and we have the key
        }
        for (int k : containedBoxes[cur]) {// all boxes in cur box
          boxFound[k] = true;
          q.add(k);
        }
      }
    }
    return candy;
  }

}
