package algorithm;

import java.util.HashMap;
import java.util.List;

public class SmallestComonSubRegion {

  public static void main(String[] args) {
    //
    SmallestComonSubRegion smallestComonSubRegion = new SmallestComonSubRegion();
    String smallestRegion = smallestComonSubRegion.findSmallestRegion(
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

  public TreeNode findCommonRegion(TreeNode root, String region1, String region2){

    if(root == null ||  root.val.equals(region1) || root.val.equals(region2)){
      return root;
    }

    TreeNode left = findCommonRegion(root.left, region1,region2);
    TreeNode right = findCommonRegion(root.right, region1,region2);

    if(left == null) return right;
    else if(right == null) return  left;
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
