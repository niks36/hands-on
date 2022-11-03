package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    List<List<Integer>> lists = palindromPair.palindromePairs(
        new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    System.out.println(lists);
  }


  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> result = new ArrayList<>();
    Trie root = new Trie();
    for (int i = 0; i < words.length; i++) {
      addWord(root, words[i], i);
    }

    for (int i = 0; i < words.length; i++) {
      search(root, words, i,result);
    }

    return result;
  }

  private void search(Trie root, String[] word, int index, List<List<Integer>> result) {
    Trie node = root;
    String currWord = word[index];
    for(int i = 0; i < currWord.length(); i++){
      if(node.index >= 0 && node.index != index && isPalindrom(currWord,i, currWord.length() - 1)){
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
        node.list.add(index);
      }

      node = node.child[ch];
    }

    node.list.add(index);
    node.index = index;
  }

  private boolean isPalindrom(String word, int i, int j) {
    while (i < j) {
      if (word.charAt(i++) != word.charAt(j--)) {
        return false;
      }
    }
    return true;
  }
}
