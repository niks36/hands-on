package algorithm;

public class WordDictionary {

  Trie root;
  public WordDictionary() {
    root = new Trie();
  }

  public void addWord(String word) {
    Trie node = root;
    for(Character ch : word.toCharArray()){
      if(node.child[ch - 'a'] == null){
        node.child[ch - 'a'] = new Trie();
      }
      node = node.child[ch - 'a'];
    }
    node.bIsEnd = true;
  }

  public boolean search(String word) {
    Trie node = root;
    return search(word, node);

  }

  public boolean search(String word, Trie node1){
    Trie node = node1;

    if(node == null) return false;
    for(int i = 0; i<word.length(); i++){
      Character ch = word.charAt(i);
      if(ch == '.'){
        for(Trie trie : node.child){
          if(search(word.substring(i+1), trie)){
            return true;
          }
        }
        return false;
      }
      if(node.child[ch - 'a']  == null) return false;
      node = node.child[ch - 'a'];

    }

    return node != null && node.bIsEnd;
  }

  class Trie{
    boolean bIsEnd = false;
    Trie[] child = new Trie[26];

  }

}
