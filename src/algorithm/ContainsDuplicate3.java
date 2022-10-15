package algorithm;

import java.util.TreeSet;

public class ContainsDuplicate3 {

  public static void main(String[] args) {
    //
    ContainsDuplicate3 containsDuplicate3 = new ContainsDuplicate3();

    boolean b = containsDuplicate3.containsNearbyAlmostDuplicate(new int[]{8,7,15,1,6,1,9,15}, 1, 3);
    System.out.println(b);
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//    List<Integer> list = new ArrayList<>();
//
//    for (int i = 0; i < nums.length; i++) {
//
//      int difference = Math.abs(nums[i] - valueDiff);
//      System.out.println("i : " + i + " difference : " + difference + "list " + list);
//
//      if (list.contains(difference)) {
//        return true;
//      }
//      list.add(nums[i]);
//
//      if (list.size()  == indexDiff + 1) {
//        list.remove(0);
//      }
//    }
//    return false;

    TreeSet<Integer> set = new TreeSet<>();
    for(int i = 0; i< nums.length ; i++){
      Integer smallest = set.floor(nums[i]);
      Integer largest = set.ceiling(nums[i]);

      if(smallest != null && nums[i] - smallest <= valueDiff){
        return  true;
      }

      if(largest != null && largest - nums[i] <= valueDiff){
        return  true;
      }
      set.add(nums[i]);

      if(set.size() > indexDiff){
        set.remove(nums[i-indexDiff]);
      }
    }
    return false;
  }
}
