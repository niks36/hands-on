package algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

  //https://www.youtube.com/watch?v=Yv2jzDzYlp8
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public static void main(String[] args) {
    //
  }

  public void insertNum(int n){
    if(maxHeap.isEmpty() || maxHeap.peek() >= n){
      maxHeap.add(n);
    }else{
      minHeap.add(n);
    }

    if(maxHeap.size() > minHeap.size() + 1){
      minHeap.add(maxHeap.poll());
    }else if(maxHeap.size() < minHeap.size()){
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian(){
    if(maxHeap.size() == minHeap.size()){
    return (maxHeap.peek()  + minHeap.peek())/2;
    }
    return maxHeap.peek();
  }


}
