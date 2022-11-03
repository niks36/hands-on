package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutations {

  public static void main(String[] args) {
    //
    LetterCasePermutations letterCasePermutations = new LetterCasePermutations();
    List<String> strings = letterCasePermutations.letterCasePermutation("airbnb");
    System.out.println(strings);
  }

  public List<String> letterCasePermutation(String S) {
    if (S == null) {
      return new LinkedList<>();
    }
    Queue<String> queue = new LinkedList<>();
    queue.offer(S);

    for (int i = 0; i < S.length(); i++) {
      if(Character.isDigit(S.charAt(i))) continue;
      int size = queue.size();

      for(int j = 0; j < size; j++){
        String str = queue.poll();
        char[] ch = str.toCharArray();

        ch[i] = Character.toUpperCase(ch[i]);
        queue.offer(String.valueOf(ch));

        ch[i] = Character.toLowerCase(ch[i]);
        queue.offer(String.valueOf(ch));
      }
    }

    return new LinkedList<>(queue);
  }
}
