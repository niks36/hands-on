package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringMinWindow {

  public static void main(String[] args) {
    //https://leetcode.com/problems/minimum-window-subsequence/
    StringMinWindow stringMinWindow = new StringMinWindow();
    System.out.println(
        stringMinWindow.find(
            "A B C D E F A B D A E F D A D",
            "A B D"));
    System.out.println(stringMinWindow.find("Leetcode is a good community for software developers", "is for developers"));
    System.out.println(stringMinWindow.find("Leetcode is a good community for software developers", "is for lawyers"));
    System.out.println(stringMinWindow.find("Leetcode is a good community for software developers", "developers for"));
    System.out.println(stringMinWindow.find("Leetcode is a good community for software developers is xyz for good abc random for", "good for"));
  }

  private List<Integer> find(String string, String words) {
    Map<String, List<Integer>> map = new HashMap<>();
    List<String> list = Arrays.asList(string.split(" "));
    for (int i = 0; i < list.size(); i++) {
      if (!map.containsKey(list.get(i))) {
        map.put(list.get(i), new ArrayList<>());
      }
      map.get(list.get(i)).add(i);
    }
    //System.out.println(map);
    List<String> list2 = Arrays.asList(words.split(" "));
    for (String str : list2) {
      if (!map.containsKey(str)) {
        return Arrays.asList(-1, -1);
      }
    }

    List<Integer> indexes = map.get(list2.get(0));
    Integer startIndex;
    Integer endIndex;
    Integer min = Integer.MAX_VALUE;
    Map<Integer, List<Integer>> resultMap = new HashMap<>();
    for (int index : indexes) {
      startIndex = index;
      endIndex = returnIndex(index,map, list2, 1);
     // System.out.println(startIndex + " " + endIndex);
      if(endIndex != -1){
        if(min > (endIndex - startIndex)){
          min = endIndex - startIndex;
          resultMap.put(min, Arrays.asList(startIndex,endIndex));
        }
      }
    }
    return min == Integer.MAX_VALUE ? Arrays.asList(-1,-1) :  resultMap.get(min);
  }

  private Integer returnIndex(
      int startIndex, Map<String, List<Integer>> map, List<String> wordList, int wordIndex) {
    String word = wordList.get(wordIndex);
    List<Integer> integers = map.get(word);
    for (Integer index : integers) {
      if (index > startIndex) {
        if (wordIndex + 1 == wordList.size()) {
          return index;
        }
        return returnIndex(index, map, wordList, wordIndex + 1);
      }
    }
    return -1;
  }
}
