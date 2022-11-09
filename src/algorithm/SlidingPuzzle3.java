package algorithm;

import java.util.HashSet;
import java.util.LinkedList;

public class SlidingPuzzle3 {

  public static void main(String[] args) {
    //
    SlidingPuzzle3 slidingPuzzle = new SlidingPuzzle3();
    int i = slidingPuzzle.slidingPuzzle(new int[][] {{1,2,3}, {4,8,5}, {7,0,6}});
    System.out.println(i);
  }

  public int slidingPuzzle(int[][] board) {

    String target = "123456780";

    StringBuilder initial = new StringBuilder();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        initial.append(board[i][j]);
      }
    }

    LinkedList<Tuple> queue = new LinkedList<>();
    queue.add(new Tuple(initial.toString(), 0));

    int[][] swapIds =
        new int[][] {
          {1, 3}, {0, 2, 4}, {1, 5}, {0, 4, 6}, {1, 3, 5, 7}, {2, 4, 8}, {3, 7}, {6, 4, 8}, {7, 5}
        };

    Integer level = -1;
    HashSet<String> set = new HashSet<>();
    set.add(initial.toString());

    while (!queue.isEmpty()) {
      Tuple poll = queue.poll();

      if (poll.val.equals(target) && level < poll.level) {
        level = poll.level;
        break;
      }

      int findOIndex = find0Index(poll.val);
      for (int i : swapIds[findOIndex]) {
        StringBuilder newPuzzleBoard = new StringBuilder(poll.val);
        char ch = newPuzzleBoard.charAt(i);
        newPuzzleBoard.setCharAt(findOIndex, ch);
        newPuzzleBoard.setCharAt(i, '0');

        if(!set.contains(newPuzzleBoard.toString())){
          queue.offer(new Tuple(newPuzzleBoard.toString() , poll.level + 1));
          set.add(newPuzzleBoard.toString());
        }
      }
    }

    return level;
  }

  public int find0Index(String str) {
    return str.indexOf('0');
  }

  class Tuple {
    String val;
    Integer level;

    public Tuple(String val, Integer level) {
      this.val = val;
      this.level = level;
    }
  }
}
