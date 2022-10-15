package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

  public static void main(String[] args) {
    //
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

    for (Character c : digits.toCharArray()) {
      List<Character> characters = digitMap.get(Integer.parseInt(c.toString()));
      List<String> midResult = new ArrayList<>();
      if (results.isEmpty()) {
        List<String> collect = characters.stream().map(Object::toString).toList();
        midResult.addAll(collect);
      } else {
        for (String result : results) {
          for (int j = 0; j < characters.size(); j++) {
            midResult.add(result + "" + characters.get(j));
          }
        }
      }
      results = midResult;
    }
    return results;
  }
}
