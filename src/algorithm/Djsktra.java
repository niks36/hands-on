package algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class Djsktra {

  public static void main(String[] args) {
    //https://www.youtube.com/watch?v=wjxCG6dOwcY
  }

  public void calculateShortestPath(Node<String> source) {
    source.setDistance(0);
    Set<Node<String>> settledNodes = new HashSet<>();
    Queue<Node<String>> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));
    while (!unsettledNodes.isEmpty()) {
      Node<String> currentNode = unsettledNodes.poll();
      currentNode.getAdjacentNodes()
          .entrySet().stream()
          .filter(entry -> !settledNodes.contains(entry.getKey()))
          .forEach(entry -> {
            evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
            unsettledNodes.add(entry.getKey());
          });
      settledNodes.add(currentNode);
    }
  }

  private void evaluateDistanceAndPath(Node<String> adjacentNode, Integer edgeWeight, Node<String> sourceNode) {
    Integer newDistance = sourceNode.getDistance() + edgeWeight;
    if (newDistance < adjacentNode.getDistance()) {
      adjacentNode.setDistance(newDistance);
      adjacentNode.setShortestPath(
          Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList());
    }
  }

  public void printPaths(List<Node<String>> nodes) {
    nodes.forEach(node -> {
      String path = node.getShortestPath().stream()
          .map(Node::getName).map(Objects::toString)
          .collect(Collectors.joining(" -> "));
      System.out.println((path.isBlank()
          ? "%s : %s".formatted(node.getName(), node.getDistance())
          : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance()))
      );
    });
  }



  @Getter
  @Setter
  @RequiredArgsConstructor
  class Node<String> implements Comparable<Node<String>> {

    private final String name;
    private Integer distance = Integer.MAX_VALUE;
    private List<Node<String>> shortestPath = new LinkedList<>();
    private Map<Node<String>, Integer> adjacentNodes = new HashMap<>();

    public void addAdjacentNode(Node<String> node, int weight) {
      adjacentNodes.put(node, weight);
    }

    @Override
    public int compareTo(Node node) {
      return Integer.compare(this.distance, node.getDistance());
    }

  }
}
