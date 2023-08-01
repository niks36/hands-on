package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement2 {

  public static void main(String[] args){

  }

  public int[] nextGreaterElement(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int result[] = new int[nums.length];
    Arrays.fill(result, -1);
    for(int i = 0; i< nums.length * 2 ; i++){
        while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]){
          result[stack.pop()] = nums[i % nums.length] ;
        }

        if(i < nums.length){
          stack.push(i);
        }
    }
    return result;
  }

}
