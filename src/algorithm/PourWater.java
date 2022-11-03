package algorithm;

public class PourWater {

  public static void main(String[] args) {
    PourWater pourWater = new PourWater();
    int[] ints = pourWater.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3);
    for(int i = 0; i < ints.length; i++){
      System.out.print(ints[i]);
    }
  }

  public int[] pourWater(int[] heights, int V, int K) {
    for(int i = 0; i < V; i++) {
      int cur = K;
      // Move left
      while(cur > 0 && heights[cur] >= heights[cur - 1]) {
        cur--;
      }
      // Move right
      while(cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) {
        cur++;
      }
      // Move left to K
      while(cur > K && heights[cur] >= heights[cur - 1]) {
        cur--;
      }
      System.out.println(cur);
      heights[cur]++;

    }

    return heights;
  }
}
