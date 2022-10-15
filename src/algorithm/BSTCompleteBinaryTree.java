package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BSTCompleteBinaryTree {

  public static class BSTNode {
    public int value;
    public BSTNode left;
    public BSTNode right;

    BSTNode(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    @Override
    public String toString() {
      return "BSTNode{" +
          "value=" + value +
          ", left=" + left +
          ", right=" + right +
          '}';
    }
  }

  public static void main(String[] args) {

    List<Integer> n1 = List.of(17,-1,-1);
    List<Integer> n2 = List.of(15,13,17);
    List<Integer> n3 = List.of(7,-1,-1);
    List<Integer> n4 = List.of(13,-1,-1);
    List<Integer> n5 = List.of(5,3,7);
    List<Integer> n6 = List.of(3,-1,-1);
    List<Integer> n7 = List.of(10,5,15);
    List<List<Integer>> input = new ArrayList<>();
    input.add(n1);
    input.add(n2);
    input.add(n3);
    input.add(n4);
    input.add(n5);
    input.add(n6);
    input.add(n7);
    System.out.println(findRoot(input));
  }


  public static int findRoot(List<List<Integer>> nodes) {
    Map<Integer, BSTNode> nodeMap = new HashMap<>();
    Map<Integer, Integer> parentMap = new HashMap<>();

    for(List<Integer> node : nodes) {
      nodeMap.put(node.get(0), new BSTNode(node.get(0)));
      if(node.get(1) != -1)
        parentMap.put(node.get(1), node.get(0));
      if(node.get(2) != -1)
        parentMap.put(node.get(2), node.get(0));
    }

    for(List<Integer> node: nodes) {
      BSTNode n = nodeMap.get(node.get(0));
      n.left = nodeMap.get(node.get(1));
      n.right = nodeMap.get(node.get(2));
    }

    System.out.println(nodeMap);
    System.out.println(parentMap);

    if(parentMap.size() >= nodeMap.size())
      return -1;

    Set<Integer> heads = new HashSet<>();
    int result = -1;
    for(Integer n: nodeMap.keySet()) {
      if(heads.contains(n))
        heads.remove(n);

      if(parentMap.containsKey(n)){
        int head = parentMap.get(n);
        heads.add(head);
        result = head;
      }
    }
    System.out.println(heads);

    Set<Integer> nodeSet = nodeMap.keySet();
    if(!isBST(nodeMap.get(result), nodeSet) || nodeSet.size() > 0)
      return -1;
    return result;
  }

  public static boolean isBST(BSTNode head, Set<Integer> nodeSet) {
    if(head == null)
      return true;
    nodeSet.remove(head.value);
    if(head.left != null && head.right != null) {
      return (head.value > head.left.value && (isBST(head.left, nodeSet)) && (head.value < head.right.value && isBST(head.right, nodeSet)));
    }
    if(head.left != null) {
      return (head.value > head.left.value && isBST(head.left, nodeSet));
    }
    if(head.right != null) {
      return (head.value < head.right.value && isBST(head.right, nodeSet));
    }
    return true;
  }
}
