

import java.util.Stack;

public class MaxStack {

  Stack<Integer> data = new Stack<>();
  Stack<Integer> max = new Stack<>();

  //O(1)
  public void push(int x) {
    data.push(x);
    if (max.isEmpty()) {
      max.push(x);
    } else {
      max.push(Math.max(max.peek(), x));
    }
  }

  //O(1)

  public int pop() {
    max.pop();
    return data.pop();
  }

  //O(1)
  public int top() {
    return data.peek();
  }

  //O(1)
  public int peekMax() {
    return max.peek();
  }

  //O(N)
  public int popMax() {
    int res = max.peek();
    Stack<Integer> tmp = new Stack<>();
    while (data.peek() != res) {
      tmp.push(data.pop());
      max.pop();
    }
    data.pop();
    max.pop();
    while (!tmp.isEmpty()) {
      push(tmp.pop());
    }
    return res;
  }

  public static void main(String[] args) {
    MaxStack maxStack = new MaxStack();
    maxStack.push(3);
    maxStack.push(4);
    maxStack.push(3);
    maxStack.push(2);
    maxStack.push(1);
    System.out.println(maxStack.pop());
    System.out.println(maxStack.popMax());
    System.out.println(maxStack.peekMax());
    System.out.println(maxStack.top());
    System.out.println(maxStack.popMax());
    System.out.println(maxStack.pop());
    System.out.println(maxStack.top());
  }
}
