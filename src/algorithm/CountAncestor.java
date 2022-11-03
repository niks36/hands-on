package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CountAncestor {

  public static void main(String[] args) {
    //
  }

  public List<List<Integer>> getAncestors(int n, int[][] edges) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashMap<Integer, Integer> indegreeMap = new HashMap<>();
    List<Set<Integer>> result = new ArrayList<>();
    int[] indegree = new int[n];

    for(int i = 0 ;i<n ; i++){
      result.add(i, new HashSet<>());
      map.put(i, new ArrayList<>());
    }
    for (int j = 0; j < edges.length; j++) {
      int[] arr = edges[j];
      map.get(arr[0]).add(arr[1]);
      indegree[arr[1]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int parent = queue.poll();
      List<Integer> integers = map.get(parent);
      for (Integer child : integers) {
        result.get(child).add(parent);
        result.get(child).addAll(result.get(parent));
        indegree[child]--;
        if (indegree[child] == 0) {
          queue.offer(child);
        }
      }
    }
    List<List<Integer>> newResult = new ArrayList<>();
    for (Set<Integer> s : result) {
      ArrayList<Integer> list = new ArrayList<>(s);
      Collections.sort(list);
      newResult.add(list);
    }
    return newResult;
  }
}
