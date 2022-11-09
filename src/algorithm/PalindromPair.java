package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromPair {

  class Trie {
    Trie[] child;
    Integer index;
    List<Integer> list;

    public Trie() {
      child = new Trie[26];
      index = -1;
      list = new ArrayList<>();
    }

  }

  public static void main(String[] args) {
    //
    PalindromPair palindromPair = new PalindromPair();
//    List<List<Integer>> lists = palindromPair.palindromePairs(
//        new String[]{"abcd", "dcba", "lls", "s", "sssll", "aabbaa"});
    List<List<Integer>> lists = palindromPair.palindromePairs(
        new String[]{"a", ""});
    System.out.println(lists);
  }


  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> result = new ArrayList<>();
    Trie root = new Trie();
    for (int i = 0; i < words.length; i++) {
      addWord(root, words[i], i);
    }

    for (int i = 0; i < words.length; i++) {
      search(root, words[i], i,result);
    }

    return result;
  }

  private void search(Trie root, String currWord, int index, List<List<Integer>> result) {
    Trie node = root;
    for(int i = 0; i < currWord.length(); i++){
      if(node.index >= 0 && node.index != index && isPalindrom(currWord,i, currWord.length() - 1)){
        System.out.println(index + " " + node.index);
        result.add(Arrays.asList(index, node.index));
      }

      node = node.child[currWord.charAt(i) - 'a'];
      if (node == null) return;
    }

    for(int i : node.list){
      if(i == index) continue;
      result.add(Arrays.asList(index, i));
    }
  }

  public void addWord(Trie root, String word, int index) {
    Trie node = root;
    for (int i = word.length() - 1; i >= 0; i--) {
      int ch = word.charAt(i) - 'a';

      if (node.child[ch] == null) {
        node.child[ch] = new Trie();
      }
      if (isPalindrom(word, 0, i)) {
        //System.out.println(word +  " i " + i +" index " + index + " ch " + word.charAt(i));
        node.list.add(index);
      }

      node = node.child[ch];
    }

    node.list.add(index);
    node.index = index;

   // System.out.println(root);
  }

  private boolean isPalindrom(String word, int i, int j) {
    while (i < j) {
      if (word.charAt(i++) != word.charAt(j--)) {
        return false;
      }
    }
    return true;
  }


  public List<List<Integer>> palindromePairs1(String[] words) {
    List<List<Integer>> soln = new ArrayList<>();
    List<Integer> wordsPair = new ArrayList<>();
    Map<String, Integer> wordsMap = new HashMap<>();

    for (int i=0; i<words.length; i++)
      wordsMap.put(words[i], i);

    for (int i=0; i<words.length; i++) {
      if (wordsMap.containsKey("") && !words[i].equals("") && isPalindrome(words[i])) {
        soln.add(Arrays.asList(wordsMap.get(""), wordsMap.get(words[i])));
        soln.add(Arrays.asList(wordsMap.get(words[i]), wordsMap.get("")));
      }

      StringBuilder sb = new StringBuilder(words[i]);
      String revStr = sb.reverse().toString();

      if (wordsMap.containsKey(revStr) && !words[i].equals(revStr))
        soln.add(Arrays.asList(wordsMap.get(words[i]), wordsMap.get(revStr)));

      for (int j=1; j<words[i].length(); j++) {
        String prefix = revStr.substring(0, j);
        String suffix = revStr.substring(j);

        if (isPalindrome(prefix) && wordsMap.containsKey(suffix))
          soln.add(Arrays.asList(i, wordsMap.get(suffix)));
        if (isPalindrome(suffix) && wordsMap.containsKey(prefix))
          soln.add(Arrays.asList(wordsMap.get(prefix), i));
      }
    }
    return soln;
  }

  private boolean isPalindrome(String str) {
    int i = 0, j = str.length()-1;
    while (i <= j) {
      if (str.charAt(i) != str.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }
}
