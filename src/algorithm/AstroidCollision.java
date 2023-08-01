package algorithm;

import java.util.Stack;

public class AstroidCollision {

  public int[] asteroidCollision(int[] asteroids) {
    if(asteroids == null || asteroids.length == 0) return new int[]{-1};

    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i< asteroids.length; i++){
      if(asteroids[i] > 0){
        stack.push(asteroids[i]);
      }else{
        while (!stack.isEmpty() && stack.peek() < -asteroids[i] && stack.peek() > 0){
          stack.pop();
        }
        if(stack.isEmpty() || stack.peek() < 0){
          stack.push(asteroids[i]);
        }else if(stack.peek() == -asteroids[i]){
          stack.pop();
        }
      }
    }
    int[] result = new int[stack.size()];
    for(int i = stack.size() -1 ; i >= 0;  i--){
      result[i] = stack.pop();
    }
    return result;

  }
}
