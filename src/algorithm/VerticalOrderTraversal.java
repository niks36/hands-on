package algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrderTraversal {

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

  TreeMap<Integer, TreeMap<Integer, Set<Integer>>> map = new TreeMap<>();

  public void verticalTraversal(TreeNode root) {
    solve(root, 0, 0);

    System.out.println(map);
    for (TreeMap<Integer, Set<Integer>> entry : map.values()) {
      for (Set<Integer> set : entry.values()) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
          System.out.println(iterator.next());
        }
      }
    }
  }

  public void solve(TreeNode root, int row, int column) {

    if (root == null) return;

    map.putIfAbsent(column, new TreeMap<>());
    map.get(column).putIfAbsent(row, new HashSet<>());

    map.get(column).get(row).add(root.val);

    solve(root.left, row + 1, column - 1);
    solve(root.right, row + 1, column + 1);
  }

  public static void main(String[] args) {
    //

    TreeNode node15 = new TreeNode(15,null, null);
    TreeNode node7 = new TreeNode(7,null, null);
    TreeNode node20 = new TreeNode(20,node15, node7);
    TreeNode node9 = new TreeNode(9,null, null);
    TreeNode node3 = new TreeNode(3, node9, node20);

    VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
    verticalOrderTraversal.verticalTraversal(node3);


  }
}
