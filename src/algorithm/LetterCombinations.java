package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

  public static void main(String[] args) {
    //
    LetterCombinations letterCombinations = new LetterCombinations();
    List<String> strings = letterCombinations.letterCombinations("567");

    System.out.println(strings);
    System.out.println(strings.size());
  }

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) return new ArrayList<>();
    List<String> results = new ArrayList();
    HashMap<Integer, List<Character>> digitMap = new HashMap<>();
    digitMap.put(1, new ArrayList<>());
    digitMap.put(2, List.of('a', 'b', 'c'));
    digitMap.put(3, List.of('d', 'e', 'f'));
    digitMap.put(4, List.of('g', 'h', 'i'));
    digitMap.put(5, List.of('j', 'k', 'l'));
    digitMap.put(6, List.of('m', 'n', 'o'));
    digitMap.put(7, List.of('p', 'q', 'r', 's'));
    digitMap.put(8, List.of('t', 'u', 'v'));
    digitMap.put(9, List.of('w', 'x', 'y', 'z'));

    Integer firstDigit = Integer.parseInt(String.valueOf(digits.charAt(0)));

    LinkedList<String> queue = new LinkedList<>();
    for (Character ch : digitMap.get(firstDigit)) {
      queue.offer(ch + "");
    }

    for (int i = 1; i < digits.length(); i++) {
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        String poll = queue.poll();
        for (Character ch : digitMap.get(Integer.parseInt(String.valueOf(digits.charAt(i))))) {
          queue.offer(poll + ch);
        }
      }
    }
    return new ArrayList<>(queue);
  }
}
