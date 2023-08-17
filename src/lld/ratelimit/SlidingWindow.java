package lld.ratelimit;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindow implements RateLimit{

  Queue<Long> slidingWindow;
  int timeWindowInSeconds;
  int bucketCapacity;

  public SlidingWindow(int timeWindowInSeconds, int buckerCapacity) {
    this.timeWindowInSeconds = timeWindowInSeconds;
    this.bucketCapacity = buckerCapacity;
    slidingWindow = new ConcurrentLinkedDeque<>();
  }

  @Override
  public boolean canAllow() {
    Long currentTime = System.currentTimeMillis();
    //removeOldMessage();
    if(slidingWindow.size() < bucketCapacity){
      slidingWindow.offer(currentTime);
      return true;
    }
    return false;
  }
}
