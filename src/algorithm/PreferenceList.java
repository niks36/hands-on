package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PreferenceList {
  //TOPOLOGICAL sort

  public static void main(String[] args) {
    //
    PreferenceList preferenceList = new PreferenceList();
    List<List<Integer>> preferences = new ArrayList<>();
    List<Integer> p1 = new ArrayList<Integer>() {{
      add(2);
      add(3);
      add(5);
    }};
    List<Integer> p2 = new ArrayList<Integer>() {{
      add(4);
      add(2);
      add(1);
    }};
    List<Integer> p3 = new ArrayList<Integer>() {{
      add(4);
      add(1);
      add(5);
      add(6);
    }};
    List<Integer> p4 = new ArrayList<Integer>() {{
      add(4);
      add(7);
    }};
    preferences.add(p1);
    preferences.add(p2);
    preferences.add(p3);
    preferences.add(p4);
    List<Integer> res = preferenceList.getPreference(preferences);

  }

  public List<Integer> getPreference(List<List<Integer>> preferences) {
    Map<Integer, Integer> inDegree = new HashMap<>();
    Map<Integer, Set<Integer>> nodes = new HashMap<>();
    for (List<Integer> l : preferences) {
      for (int i = 0; i < l.size() - 1; i++) {
        int from = l.get(i);
        int to = l.get(i + 1);
        if (!nodes.containsKey(from)) {
          inDegree.put(from, 0);
          nodes.put(from, new HashSet<>());
        }
        if (!nodes.containsKey(to)) {
          inDegree.put(to, 0);
          nodes.put(to, new HashSet<>());
        }
        if (!nodes.get(from).contains(to)) {
          Set<Integer> s = nodes.get(from);
          s.add(to);
          nodes.put(from, s);
        }
        inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
      }
    }
    Queue<Integer> q = new LinkedList<>();
    for (int k : inDegree.keySet()) {
      if (inDegree.get(k) == 0) {
        q.offer(k);
      }
    }
    List<Integer> res = new ArrayList<>();
    while (!q.isEmpty()) {
      int id = q.poll();
      res.add(id);
      Set<Integer> neighbors = nodes.get(id);
      for (int next : neighbors) {
        int degree = inDegree.get(next) - 1;
        inDegree.put(next, degree);
        if (degree == 0) q.offer(next);
      }
    }
    return res;
  }
}
