package algorithm;

public class DistinctSubstrings {


  class Trie {
    Trie[] children = new Trie[26];
  }

  public int countDistinct(String s) {
    Trie root = new Trie();
    int count = 0;
    Trie current;
    for(int i = 0; i<s.length(); i++){
      current = root;
      for(int j = i; j<s.length(); j++){
        if(current.children[s.charAt(j) - 'a'] == null){
          current.children[s.charAt(j) - 'a'] = new Trie();
          count++;
        }
        current = current.children[s.charAt(j) - 'a'];
      }
    }
    return count;
  }
}
