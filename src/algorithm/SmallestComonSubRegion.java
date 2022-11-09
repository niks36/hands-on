package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestComonSubRegion {

  public static void main(String[] args) {
    //
    SmallestComonSubRegion smallestComonSubRegion = new SmallestComonSubRegion();
    String smallestRegion =
        smallestComonSubRegion.findSmallestRegion(
            List.of(
                List.of("Earth", "North America", "South America"),
                List.of("North America", "United States", "Canada"),
                List.of("United States", "New York", "Boston"),
                List.of("Canada", "Ontario", "Quebec"),
                List.of("South America", "Brazil")),
            "Quebec",
            "New York");
    System.out.println(smallestRegion);
  }

  public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
    if (regions == null) return "-1";

    TreeNode root = buildTree(regions);
    System.out.println(root);
    TreeNode commonRegion = findCommonRegion(root, region1, region2);

    return commonRegion.val;
  }

  public TreeNode findCommonRegion(TreeNode root, String region1, String region2) {

    if (root == null || root.val.equals(region1) || root.val.equals(region2)) {
      return root;
    }

    TreeNode left = findCommonRegion(root.left, region1, region2);
    TreeNode right = findCommonRegion(root.right, region1, region2);

    if (left == null) return right;
    else if (right == null) return left;
    else return root;
  }

  private TreeNode buildTree(List<List<String>> regions) {
    TreeNode root = null;
    HashMap<String, TreeNode> map = new HashMap<>();
    for (List<String> region : regions) {
      TreeNode node = map.getOrDefault(region.get(0), new TreeNode(region.get(0)));
      map.put(node.val, node);
      if (region.size() >= 2) {
        node.left = new TreeNode(region.get(1));
        map.put(node.left.val, node.left);
      }
      if (region.size() >= 3) {
        node.right = new TreeNode(region.get(2));
        map.put(node.right.val, node.right);
      }

      if (root == null) {
        root = node;
      }
    }

    return root;
  }

  public String findSmallestRegion1(List<List<String>> regions, String region1, String region2) {
    Map<String, String> parent = new HashMap<>();
    Set<String> ancestors = new HashSet<>(); // region1's ancestors

    for (List<String> region : regions)
      for (int i = 1; i < region.size(); ++i) parent.put(region.get(i), region.get(0));

    // Add all of region1's ancestors
    while (region1 != null) {
      ancestors.add(region1);
      region1 = parent.get(region1); // Region1 becomes null in the end
    }

    // Go up from region2 until meet any of region1's ancestors
    while (!ancestors.contains(region2)) region2 = parent.get(region2);

    return region2;
  }

  class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;

    TreeNode(String x) {
      val = x;
    }

    @Override
    public String toString() {
      return "TreeNode{" + "val='" + val + '\'' + ", left=" + left + ", right=" + right + '}';
    }
  }
}
