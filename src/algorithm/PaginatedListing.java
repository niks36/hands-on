package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PaginatedListing {

  public static void main(String[] args) {
    //
  }

  public List<String> paginate(List<String> list) {
    if (list.isEmpty()) return Collections.emptyList();

    List<String> result = new ArrayList<>();
    Comparator<String> comparator =
        (o1, o2) -> {
          Double score1 = Double.parseDouble(o1.split(",")[2]);
          Double score2 = Double.parseDouble(o2.split(",")[2]);
          return score2.compareTo(score1);
        };

    PriorityQueue<String> priorityQueue = new PriorityQueue<>(comparator);
    PriorityQueue<String> queue = new PriorityQueue<>(comparator);

    for (String s : list) {
      priorityQueue.offer(s);
    }

    int count = 0;
    Set<String> set = new HashSet<>();
    while (!priorityQueue.isEmpty()) {
      String s = priorityQueue.poll();
      String host = s.split(",")[0];

      if (set.contains(host)) {
        queue.offer(s);
      } else {
        result.add(s);
        set.add(s);
        count++;
      }

      if (count == 12) {
        set.clear();
        count = 0;
        priorityQueue.addAll(queue);
        queue.clear();
      }
    }

    if (!queue.isEmpty()) {
      result.addAll(queue);
    }

    return result;
  }
}
