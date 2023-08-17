package algorithm;

import java.util.Stack;

public class KthSmallestTree {
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    while (p != null) {
      stack.push(p);
      p = p.left;
    }
    int i = 0;
    while (!stack.isEmpty()) {
      TreeNode t = stack.pop();
      i++;

      if (i == k) return t.val;

      TreeNode r = t.right;
      while (r != null) {
        stack.push(r);
        r = r.left;
      }
    }

    return -1;
    }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
