package algorithm;

import java.util.Stack;

public class BasicCalc {

  public int calculate(String s) {
    int len;
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int number = 0;
    int sign = 1;

    for(int i=0;i<len;i++){
      char ch = s.charAt(i);
      if(Character.isDigit(ch)){
        number = Integer.parseInt(ch + "");
      }else if(ch == '+'){
        result += (number * sign);
        number = 0;
        sign = 1;
      }else if(ch == '-'){
        result += (number * sign);
        number = 0;
        sign = -1;
      }else if(ch == '('){
        stack.push(result);
        stack.push(sign);
        sign = 1;
        result = 0;
      }else if(ch == ')'){
        result += sign * number;
        number = 0;
        result *= stack.pop();
        result += stack.pop();
      }

    }

    if(number != 0) result += sign * number;
    return result;
  }



}
