package com.tesco.ofs.client;

import java.util.Deque;
import java.util.LinkedList;

/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
Output: 3 3 4 5 5 5 6
Explanation:
Maximum of 1, 2, 3 is 3
Maximum of 2, 3, 1 is 3
Maximum of 3, 1, 4 is 4
Maximum of 1, 4, 5 is 5
Maximum of 4, 5, 2 is 5
Maximum of 5, 2, 3 is 5
Maximum of 2, 3, 6 is 6


 */
public class SlidingWindowUsingDeque {

  public static void main(String[] args) {
    //
    int arr[] = {12, 1, 78, 90, 57, 89, 56};
    int k = 3;
    printMax(arr, arr.length, k);
  }

  // A Dequeue (Double ended queue)
  // based method for printing
  // maximum element of
  // all subarrays of size k
  static void printMax(int arr[], int n, int k) {
    Deque<Integer> deque = new LinkedList<>();

    int i = 0;
    for (; i < k; i++) {
      //System.out.println("Queue before " + deque);
      //System.out.println("arr[i] " + arr[i]);
      //if (!deque.isEmpty()) System.out.println(deque.peekLast());
      while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
        deque.removeLast();
      }
      deque.addLast(i);
    //  System.out.println("Queue after" + deque);
     // System.out.println("=========");
    }

    for(; i < n; i++){
      System.out.println(arr[deque.peek()] + "");
      while (!deque.isEmpty() && deque.peek() <= i -k){
        deque.removeFirst();
      }
      while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
        deque.removeLast();
      }
      deque.addLast(i);
    }
    System.out.println(arr[deque.peek()]);
  }
}

//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
