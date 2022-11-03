package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class AlienDictionary {

  public static void main(String[] args) {
    //

    AlienDictionary alienDictionary = new AlienDictionary();
    String alien = alienDictionary.alien(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
    System.out.println(alien);
  }

  public String alien(String[] words) {
    if (words == null || words.length == 0) return "";

    Map<Character, HashSet<Character>> map = new HashMap<>();
    Map<Character, Integer> integerMap = new HashMap<>();

    for (String word : words) {
      for (Character ch : word.toCharArray()) {
        integerMap.put(ch, 0);
      }
    }

    for (int i = 1; i < words.length; i++) {
      String firstWord = words[i - 1];
      String secondWord = words[i];

      int length = Math.min(firstWord.length(), secondWord.length());

      for (int j = 0; j < length; j++) {
        if (firstWord.charAt(j) != secondWord.charAt(j)) {
          Integer currentCount = integerMap.get(secondWord.charAt(j));
          integerMap.put(secondWord.charAt(j), currentCount + 1);
          HashSet<Character> characters = map.get(firstWord.charAt(j));
          if (characters == null) {
            characters = new HashSet<>();
          }
          characters.add(secondWord.charAt(j));
          map.put(firstWord.charAt(j), characters);
          break;
        }
      }
    }

    System.out.println(map);
    System.out.println(integerMap);

    LinkedList<Character> linkedList = new LinkedList<>();
    for (Entry<Character, Integer> entry : integerMap.entrySet()) {
      if (entry.getValue() == 0) {
        linkedList.offer(entry.getKey());
      }
    }
    StringBuilder result = new StringBuilder();
    while (!linkedList.isEmpty()) {
      Character ch = linkedList.pop();
      result.append(ch.toString());

      HashSet<Character> set = map.get(ch);
      if (set != null) {
        for (Character next : set) {
          Integer integer = integerMap.get(next);
          integerMap.put(next, integer - 1);
          if(integer - 1 == 0){
            linkedList.offer(next);
          }
        }
      }
    }

    return result.toString();
  }
}
