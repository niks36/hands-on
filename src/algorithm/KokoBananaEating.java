package algorithm;

import java.util.Arrays;

public class KokoBananaEating {

  public static void main(String[] args) {
    //
    KokoBananaEating kokoBananaEating = new KokoBananaEating();
    int i = kokoBananaEating.minEatingSpeed(new int[] {3, 6, 7, 11}, 8);
    System.out.println(i);
  }

  public int minEatingSpeed(int[] piles, int H) {
    int left = 1;
    int right = Arrays.stream(piles).max().getAsInt();

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (canEatBanana(mid, piles) <= H) {
        right = mid - 1;
      } else {
        left = left + 1;
      }
    }
    return left;
  }

  private int canEatBanana(int mid, int[] piles) {
    int totalHours = 0;
    for (int pile : piles) {
      totalHours += pile / mid;
      if (pile % mid != 0) totalHours++;
    }
    return totalHours;
  }
}
