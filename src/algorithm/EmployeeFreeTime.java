package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {

  public static void main(String[] args) {
    //
    EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();
    List<Interval> intervals = employeeFreeTime.employeeFreeTime(
        List.of(
            List.of(new Interval(1, 2), new Interval(5, 6)),
            List.of(new Interval(2, 3)),
            List.of(new Interval(4, 6), new Interval(8,10))));
    System.out.println(intervals);
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    if (schedule.isEmpty()) return Collections.emptyList();

    List<Interval> list = new ArrayList<>();

    schedule.forEach(list::addAll);
    list.sort(Comparator.comparingInt(i -> i.start));

    List<Interval> result = new ArrayList<>();
    int preEnd = list.get(0).end;
    for (Interval interval : list) {
      if (interval.start > preEnd) {
        result.add(new Interval(preEnd, interval.start));
      }
      preEnd = Math.max(preEnd, interval.end);
    }

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
