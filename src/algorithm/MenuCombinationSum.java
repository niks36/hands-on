package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MenuCombinationSum {

  public static void main(String[] args) {
    //
    MenuCombinationSum menuCombinationSum = new MenuCombinationSum();
    List<List<Double>> lists =
        menuCombinationSum.combinationSum(
            new double[] {10.02, 1.11, 2.22, 3.01, 4.02, 2.00, 5.03}, 7.03);
    System.out.println(lists);
  }

  public List<List<Double>> combinationSum(double[] candidates, double target) {

    if (candidates == null || candidates.length == 0 || target <= 0) return new ArrayList<>();

    List<List<Double>> result = new ArrayList<>();
    int intTarget = (int) Math.round(target * 100);
    int[] intCand = new int[candidates.length];
    for (int i = 0; i < intCand.length; i++) {
      intCand[i] = (int) Math.round(candidates[i] * 100);
    }

    combinationSum(intCand, 0, intTarget, new ArrayList<>(), result);
    return result;
  }

  public void combinationSum(
      int[] candidates, int index, int target, List<Double> list, List<List<Double>> result) {
    if (target == 0) {
      result.add(list);

    } else if (target > 0) {
      for (int i = index; i < candidates.length; i++) {
        List<Double> newList = new ArrayList<>(list);
        newList.add((double) candidates[i] / 100);
        combinationSum(candidates, i, target - candidates[i], newList, result);
      }
    }
  }

  public void combinationSum1(
      int[] candidates, int index, int target, List<Double> list, List<List<Double>> result) {
    if (target == 0) {
      result.add(list);
    } else if (target > 0) {
      for (int i = index; i < candidates.length; i++) {
        ArrayList<Double> newList = new ArrayList<>(list);
        newList.add((double) candidates[i] / 100);
        combinationSum1(candidates, i, target - candidates[i], newList, result);
      }
    }
  }
}
