
package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

  public static void main(String[] args) {
    //
    MergeInterval mergeInterval = new MergeInterval();
//    List<Interval> intervals = mergeInterval.employeeFreeTime(
//        List.of(
//            List.of(new Interval(1, 3), new Interval(2, 6)),
//            List.of(new Interval(8, 10)),
//            List.of(new Interval(15, 18))));
    List<Interval> intervals = mergeInterval.employeeFreeTime(
        List.of(
            List.of(new Interval(1, 4), new Interval(4, 5))));
    System.out.println(intervals);
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    if (schedule.isEmpty()) return Collections.emptyList();

    List<Interval> list = new ArrayList<>();

    schedule.forEach(list::addAll);
    list.sort(Comparator.comparingInt(i -> i.start));

    List<Interval> result = new ArrayList<>();
    int preEnd = list.get(0).end;
    int preStart = list.get(0).start;
    for (Interval interval : list) {
      if (interval.start > preEnd) {
        result.add(new Interval(preStart, preEnd));
        preStart = interval.start;
      }
      preEnd = Math.max(preEnd, interval.end);
    }

    result.add(new Interval(preStart, preEnd));
    return result;
  }

  static class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }

    @Override
    public String toString() {
      return "Interval{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }

  ;
}
