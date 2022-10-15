package algorithm;

import java.util.List;
import java.util.Stack;

public class MiniParser {

  public static void main(String[] args) {
    //
  }

  public NestedInteger deserialize(String s) {
    if (s == null) return null;
    if (s.charAt(0) != '[') {
      return new NestedInteger(Integer.parseInt(s));
    }

    NestedInteger current = null;
    Stack<NestedInteger> stack = new Stack<>();

    int startIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '[') {
        if (current != null) {
          stack.push(current);
        }
        current = new NestedInteger();
        startIndex = i + 1;
      } else if (ch == ']') {
        String subString = s.substring(startIndex, i);
        if (!subString.isEmpty()) {
          current.add(new NestedInteger(Integer.parseInt(subString)));
        }
        if (!stack.isEmpty()) {
          NestedInteger pop = stack.pop();
          pop.add(current);
          current = pop;
        }
        startIndex = i + 1;
      } else if (ch == ',') {
        if (s.charAt(i - 1) != ']') {
          String num = s.substring(startIndex, i);
          current.add(new NestedInteger(Integer.parseInt(num)));
        }
        startIndex = i + 1;
      }
    }
    return current;
  }

  public class NestedInteger {
    int val;
    List<NestedInteger> list;

    boolean isInteger() {
      return true;
    }

    Integer getInteger() {
      return val;
    }

    List<NestedInteger> getList() {
      return list;
    }

    public NestedInteger(int value) {
      val = value;
    }

    public NestedInteger() {}

    public void add(NestedInteger nestedInteger) {}
  }
}
