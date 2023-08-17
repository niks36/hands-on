package algorithm;

import java.util.HashSet;
import java.util.LinkedList;

public class SlidingPuzzle {

  public static void main(String[] args) {
    //
    SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
    int i = slidingPuzzle.slidingPuzzle(new int[][]{{4,1,2},{5,0,3}});
    System.out.println(i);
  }

  public int slidingPuzzle(int[][] board) {
//    LinkedList<Pair<String,Integer>> queue = new LinkedList<>();
//
//    String target = "123450";
//
//    StringBuilder stringBuilder = new StringBuilder();
//    for (int i = 0; i < board.length; i++) {
//      for (int j = 0; j < board[i].length; j++) {
//        stringBuilder.append(board[i][j]);
//      }
//    }
//    String initial = stringBuilder.toString();
//
//    int[][] swapIds = new int[][] {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
//
//    queue.add(Pair.of(initial,0));
//
//    HashSet<String> set = new HashSet<>();
//    set.add(initial);
//    int minLevel = -1;
//
//
//    while (!queue.isEmpty()) {
//      Pair<String, Integer> pop = queue.pop();
//      String puzzleBoard = pop.getFirst();
//      int level = pop.getSecond();
//      if (puzzleBoard.equals(target)) {
//        if(minLevel < level){
//          minLevel = level;
//        }
//        break;
//      }
//      int index = find0Index(puzzleBoard);
//      for (int i : swapIds[index]) {
//        StringBuilder newPuzzleBoard = new StringBuilder(puzzleBoard);
//        char c = newPuzzleBoard.charAt(i);
//        newPuzzleBoard.setCharAt(index, c);
//        newPuzzleBoard.setCharAt(i, '0');
//
//        String s = newPuzzleBoard.toString();
//        if(!set.contains(s)){
//          queue.add(Pair.of(s, level + 1));
//          set.add(s);
//        }
//
//      }
//
//    }
//    return minLevel;
    return 0;
  }

  public int find0Index(String str){
   return str.indexOf('0');
  }
}
