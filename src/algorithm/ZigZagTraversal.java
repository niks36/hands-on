package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

  public String convert(String s, int numRows) {
    if(numRows ==1 || numRows >= s.length()){
      return s;
    }

    ArrayList<StringBuilder> al = new ArrayList<>();
    int index = 0;
    for(int i =0; i<numRows; i++)
      al.add(new StringBuilder());

    return "";

//    for char in s:
//    rows[index].append(char)
//    if index == 0:
//    step = 1
//    elif index == numRows - 1:
//    step = -1
//    index += step

  }
}

//  class Solution {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode A) {
//      Queue<TreeNode> queue = new LinkedList<>();
//      queue.add(A);
//      List<List<Integer>> res = new ArrayList<>();
//      if(A== null) return res;
//      List<Integer> sub;
//      int level = 0;
//      while(!queue.isEmpty()){
//        int size = queue.size();
//        sub = new ArrayList<>();
//        for(int i = 0;i<size;i++){
//          TreeNode temp = queue.remove();
//          sub.add(temp.val);
//          if(temp.left!=null)
//            queue.add(temp.left);
//          if(temp.right!=null)
//            queue.add(temp.right);
//        }
//        if(level%2!=0)
//          Collections.reverse(sub);
//        level++;
//        res.add(sub);
//      }
//      return res;
//    }
//
//    public static class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//
//      TreeNode() {}
//
//      TreeNode(int val) {
//        this.val = val;
//      }
//
//      TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//      }
//    }
//}

