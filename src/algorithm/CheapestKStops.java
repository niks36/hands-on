package algorithm;

import java.util.Arrays;

public class CheapestKStops {
  public static void main(String[] args) {
    //
    CheapestKStops cheapestKStops = new CheapestKStops();
        int cheapestPrice =
            cheapestKStops.findCheapestPrice(
                4,
                new int[][] {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}},
                0,
                3,
                1);
    //    int cheapestPrice =
    //        cheapestKStops.findCheapestPrice(
    //            3,
    //            new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
    //            0,
    //            2,
    //            0);
    //    int cheapestPrice =
    //        cheapestKStops.findCheapestPrice(
    //            5, new int[][] {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {1, 4, 3}}, 2, 1, 1);

    // 10
    // [[3,4,4],[2,5,6],[4,7,10],[9,6,5],[7,4,4],[6,2,10],[6,8,6],[7,9,4],[1,5,4],[1,0,4],[9,7,3],[7,0,5],[6,5,8],[1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]
    // 6
    // 0
    // 7
//    int cheapestPrice =
//        cheapestKStops.findCheapestPrice(
//            10,
//            new int[][] {
//              {3, 4, 4},
//              {2, 5, 6},
//              {4, 7, 10},
//              {9, 6, 5},
//              {7, 4, 4},
//              {6, 2, 10},
//              {6, 8, 6},
//              {7, 9, 4},
//              {1, 5, 4},
//              {1, 0, 4},
//              {9, 7, 3},
//              {7, 0, 5},
//              {6, 5, 8},
//              {1, 7, 6},
//              {4, 0, 9},
//              {5, 9, 1},
//              {8, 7, 3},
//              {1, 2, 6},
//              {4, 1, 5},
//              {5, 2, 4},
//              {1, 9, 1},
//              {7, 8, 10},
//              {0, 4, 2},
//              {7, 2, 8}
//            },
//            6,
//            0,
//            7);
    System.out.println(cheapestPrice);
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//    Graph graph = new Graph();
//    graph.createGraph(flights);
//    graph.print();
//    return graph.searchDFS1(src, dst, k);
//    Map<Integer, Map<Integer, Integer>> pricesAdjList = new HashMap<>();
//    for (int[] f : flights) {
//      if (!pricesAdjList.containsKey(f[0])) pricesAdjList.put(f[0], new HashMap<>());
//      pricesAdjList.get(f[0]).put(f[1], f[2]);
//    }
//
//    Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
//    pq.add(new int[] {0, src, K + 1});
//    while (!pq.isEmpty()) {
//      int[] top = pq.remove();
//      int price = top[0];
//      int city = top[1];
//      int stops = top[2];
//      if (city == dst) return price;
//      if (stops > 0) {
//        Map<Integer, Integer> adj = pricesAdjList.getOrDefault(city, new HashMap<>());
//        for (int a : adj.keySet()) {
//          pq.add(new int[] {price + adj.get(a), a, stops - 1});
//        }
//      }
//    }
//    return -1;

    int[] prices = new int[n];
    Arrays.fill(prices, Integer.MAX_VALUE);
   // System.out.println(prices);
    prices[src] = 0;
    for (int i = 0; i <= k; i++) {
      int[] temp = Arrays.copyOf(prices, n);
//      for(int j = 0; j< temp.length; j++){
//        System.out.print(temp[j] + " ");
//      }
//      System.out.println();
      for (int[] flight : flights) {
        int cur = flight[0], next = flight[1], price = flight[2];
        if (prices[cur] == Integer.MAX_VALUE) continue;
        temp[next] = Math.min(temp[next], prices[cur] + price);
      }
      prices = temp;
//      for(int j = 0; j< temp.length; j++){
//        System.out.print(temp[j] + " ");
//      }
//      System.out.println();
    }
    return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
  }


}
