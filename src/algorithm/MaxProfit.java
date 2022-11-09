package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class MaxProfit {

  public static void main(String[] args) {
    MaxProfit maxProfit = new MaxProfit();
    int i = maxProfit.jobScheduling(new int[]{1, 2, 4,5}, new int[]{5, 4, 6,6}, new int[]{10, 5, 8,2});
    System.out.println(i);
  }

  private class Job {
    private int startTime;

    private int endTime;
    private int profit;

    public Job(int sT, int eT, int p) {

      this.startTime = sT;
      this.endTime = eT;
      this.profit = p;
    }
  }

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    List<Job> jobs = new ArrayList<>();
    for (int i = 0; i < startTime.length; i++) {
      jobs.add(new Job(startTime[i], endTime[i], profit[i]));
    }

    jobs.sort(Comparator.comparingInt(a -> a.endTime));
    // Key => Time, Value => profitTillTime
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int ans = 0;

    for (Job currJob : jobs) {
      Integer entryTillStartTime = map.floorKey(currJob.startTime);
      int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
      ans = Math.max(ans, maxProfitTillStartTime + currJob.profit);
      System.out.println(currJob.endTime + " " +  ans);
      map.put(currJob.endTime, ans);
    }
    return ans;
  }
}
