package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    CombinationSum combinationSum = new CombinationSum();
    List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 5}, 8);
    System.out.println(lists);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    if (candidates == null || candidates.length == 0) return new ArrayList<>();

    List<List<Integer>> result = new ArrayList<>();
    combinationSum(candidates,0, target, new ArrayList<>(), result);
    return result;
  }

  public void combinationSum(
      int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> result) {
    if (target == 0) {
      result.add(list);

    } else if (target > 0) {
      for (int i = index; i < candidates.length; i++) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(candidates[i]);
        combinationSum(candidates, i, target - candidates[i], newList, result);
      }
    }
  }
}
