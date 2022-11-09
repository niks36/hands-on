package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindingOcean {

  public static void main(String[] args) {
    FindingOcean findingOcean = new FindingOcean();
//    List<String> testData = new ArrayList<>() {{
//      add("WWWLLLW");
//      add("WWLLLWW");
//      add("WLLLLWW");
//    }};

    List<String>  testData = new ArrayList<String>() {{
      add("LLLLLLLLLLLLLLLLLLLL");
      add("LLLLLLLLLLLLLLLLLLLL");
      add("LLLLLLLLLLLLLLWLLLLL");
      add("LLWWLLLLLLLLLLLLLLLL");
      add("LLWWLLLLLLLLLLLLLLLL");
      add("LLLLLLLLLLLLLLLLLLLL");
      add("LLLLLLLWWLLLLLLLLLLL");
      add("LLLLLLLLWWLLLLLLLLLL");
      add("LLLLLLLLLWWWLLLLLLLL");
      add("LLLLLLLLLLWWWWWWLLLL");
      add("LLLLLLLLLLWWWWWWLLLL");
      add("LLLLLLLLLLWWWWWWLLLL");
      add("LLLLWWLLLLWWWWWWLLLL");
      add("LLLLWWWLLLWWWWWWWWWW");
      add("LLLLLWWWWWWWWWWWLLLL");
      add("LLLLLLLLLLLLLLWWWWLL");
      add("LLLLLLLLLLLLLLWLLLLL");
      add("LLLLWLLLLLLLLLLLLWLL");
      add("LLLLLLLLLLLLLLLLLLWL");
    }};
    char[][] map = new char[testData.size()][testData.get(0).length()];
    for (int i = 0; i < testData.size(); i++)
      for (int j = 0; j < testData.get(i).length(); j++)
        map[i][j] = testData.get(i).charAt(j);
   //findingOcean.floodFill(map, 9, 12, 'W', 'O');
    findingOcean.floodFill1(map, 9 ,12, 'W', 'O');

    for (int i = 0; i < testData.size(); i++) {
      for (int j = 0; j < testData.get(i).length(); j++) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }


  public void floodFill1(char[][] board, int i, int j, char oldColor, char newColor) {
    if(board[i][j] == oldColor){
      floodFill(board,i,j, 'O');
    }
  }

  private void floodFill(char[][] grid, int i, int j, char newColor) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 'L' || grid[i][j] == newColor) return;

    grid[i][j] = newColor;
   // print(grid);
    floodFill(grid, i+1, j, newColor);
    floodFill(grid, i-1, j, newColor);
    floodFill(grid, i, j+1, newColor);
    floodFill(grid, i, j-1, newColor);
    return;
  }

  public void floodFill(char[][] board, int i, int j, char oldColor, char newColor) {
    if (board[i][j] != oldColor || board[i][j] == newColor) {
      return;
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(i * board[0].length + j);
    board[i][j] = newColor;

    while (!queue.isEmpty()) {
      int pos = queue.poll();
      int m = pos / board[0].length;
      int n = pos % board[0].length;

      if (m + 1 < board.length && board[m + 1][n] == oldColor) {
        queue.add((m + 1) * board[0].length + n);
        board[m + 1][n] = newColor;
      }
      if (m - 1 >= 0 && board[m - 1][n] == oldColor) {
        queue.add((m - 1) * board[0].length + n);
        board[m - 1][n] = newColor;
      }
      if (n + 1 < board[0].length && board[m][n + 1] == oldColor) {
        queue.add(m * board[0].length + n + 1);
        board[m][n + 1] = newColor;
      }
      if (n - 1 >= 0 && board[m][n - 1] == oldColor) {
        queue.add(m * board[0].length + n - 1);
        board[m][n - 1] = newColor;
      }
    }
  }

//  public void print(char[][] map){
//    System.out.println("Grid::");
//    for (int i = 0; i < map.length; i++) {
//      for (int j = 0; j < map[i].length; j++) {
//        System.out.print(map[i][j]);
//      }
//      System.out.println();
//    }
//  }



}
