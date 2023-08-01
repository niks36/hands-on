package algorithm;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastDayWhenYouCanCross {

  public static void main(String[] args) {
    LastDayWhenYouCanCross lastDayWhenYouCanCross = new LastDayWhenYouCanCross();
    int i = lastDayWhenYouCanCross.latestDayToCross(2, 2,
        new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}});
    System.out.println(i);
  }

  private static final int[] dirs = {0, 1, 0, -1, 0};

  public int latestDayToCross(int row, int col, int[][] cells) {
    int ans = 0;
    int l = 1;
    int r = cells.length - 1;

    while (l <= r){
      final int  mid = (l + r)/2;
      if(canCross(mid, row,col, cells)){
        ans = mid;
        l = mid + 1;
      }else{
        r = mid - 1;
      }
    }
    return ans;
  }

  public boolean canCross(int day, int row, int col, int[][] cells) {
    int[][] matrix = new int[row][col];

    for (int i = 0; i < day; i++) {
      int filledRow = cells[i][0] - 1;
      int filledColumn = cells[i][1] - 1;
      matrix[filledRow][filledColumn] = 1;
    }

    Queue<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        queue.offer(new int[] {0, i});
        matrix[0][i] = 1;
      }
    }


    while (!queue.isEmpty()) {
      int[] element = queue.poll();
      int elementRow = element[0];
      int elementColumn = element[1];

      for (int k = 0; k < 4; ++k) {
        final int x = elementRow + dirs[k];
        final int y = elementColumn + dirs[k + 1];
        if (x < 0 || x == row || y < 0 || y == col)
          continue;
        if (matrix[x][y] == 1)
          continue;
        if (x == row - 1)
          return true;
        queue.offer(new int[] {x, y});
        matrix[x][y] = 1;
      }
    }

    return false;
  }
}
