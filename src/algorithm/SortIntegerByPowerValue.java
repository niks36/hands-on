package algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortIntegerByPowerValue {

  public static void main(String[] args) {
    //
    SortIntegerByPowerValue sortIntegerByPowerValue = new SortIntegerByPowerValue();
    System.out.println(sortIntegerByPowerValue.getKth(118,974,825));
  }

  public int getKth(int lo, int hi, int k) {
    Comparator<int[]> comparator = (a,b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (b[0] - a[0]);
    PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
    PriorityQueue<Item> maxHeap = new PriorityQueue<Item>(Comparator.comparingInt(Item::getPower).thenComparing(Item::getNum));
    //   HashMap<Integer,Integer> valueMap = new HashMap<>();
    for(int i = lo; i<= hi; i++){
      int value = getSteps(i);
      queue.offer(new int[]{value, i});
      if(queue.size() > k){
        queue.remove();
      }
    }
    return queue.remove()[1];
  }

  HashMap<Integer, Integer> cache = new HashMap<>();

  private int getSteps(int number){
    if(number == 1){
      return 0;
    }
    if(cache.containsKey(number)) return cache.get(number);
    int power =  1 + (number % 2 == 0 ? getSteps(number/2) : getSteps(3*number + 1));

    cache.put(number, power);
    return power;

  }

  class Item {
    int num;
    int power;

    public Item (int num, int power){
      this.num = num;
      this.power = power;
    }

    public int getNum() {
      return num;
    }

    public int getPower() {
      return power;
    }

    @Override
    public String toString() {
      return "Item{" +
          "num=" + num +
          ", power=" + power +
          '}';
    }
  }
}
