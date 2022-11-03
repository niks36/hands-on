package algorithm;

import java.util.Arrays;

public class CoinsChange {

  public static void main(String[] args) {
    //
    //  int i = minCoins(6249, new int[] {186, 83, 408, 419});

    int i = minCoins(11, new int[] {1, 2, 5});

    // int i = minCoins(18, new int[] {1,5,7});
    System.out.println(i);
  }

  public static int minCoins(int n, int a[]) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    return minCoins(n, a, dp);
  }

  public int minCoins1(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);

    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static int minCoins(int n, int a[], int dp[]) {
    if (n == 0) return 0;
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < a.length; i++) {
      if (n - a[i] >= 0) {
        int subAns = 0;
        if (dp[n - a[i]] != -1) {
          subAns = dp[n - a[i]];
        } else {
          subAns = minCoins(n - a[i], a, dp);
        }
        if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
          ans = subAns + 1;
        }
      }
    }
    System.out.println(ans + " " + n);
    return dp[n] = ans;
  }
}
