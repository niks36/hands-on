package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/keys-and-rooms
public class KeyAndRooms {

  public static void main(String[] args) {}

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visitedRooms = new boolean[rooms.size()];
    visitedRooms[0] = true;

    Queue<Integer> queue = new PriorityQueue<>();
    queue.offer(0);

    while (!queue.isEmpty()) {
      Integer integer = queue.poll();
      visitedRooms[integer] = true;
      List<Integer> keys = rooms.get(integer);
      for (Integer key : keys) {
        if (!visitedRooms[key]) {
          queue.offer(key);
        }
      }
    }
    boolean result = true;
    for (boolean visited : visitedRooms) {
      if (!visited) {
        return false;
      }
    }
    return result;
  }
}
