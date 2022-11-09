package algorithm;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

  public static void main(String[] args) {
    //
    WordSearch2 wordSearch2 = new WordSearch2();
    List<String> words = wordSearch2.findWords(new char[][]{
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    }, new String[]{"eat", "oath", "aak", "ner", "oei", "thflv"});
    System.out.println(words);
  }

  private TrieNode root = new TrieNode();

  public List<String> findWords(char[][] board, String[] words) {

    buildTrie(words);

    List<String> ans = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        dfs(board, i, j, root, ans);
      }
    }

    return ans;
  }

  private void dfs(char[][] board, int i, int j, TrieNode root, List<String> ans) {
    if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
      return;
    }
    if (board[i][j] == '*') {
      return;
    }

    char character = board[i][j];
    TrieNode child = root.children[character - 'a'];
    if (child == null) {
      return;
    }
    if (child.word != null) {
      ans.add(child.word);
      child.word = null;
    }

    board[i][j] = '*';

    dfs(board, i - 1, j, child, ans);
    dfs(board, i + 1, j, child, ans);
    dfs(board, i, j - 1, child, ans);
    dfs(board, i, j + 1, child, ans);
    board[i][j] = character;
  }

  private void buildTrie(String[] words) {
    for (String word : words) {
      TrieNode trieNode = root;
      for (Character ch : word.toCharArray()) {
        int charInt = ch - 'a';
        if (trieNode.children[charInt] == null) {
          trieNode.children[charInt] = new TrieNode();
        }
        trieNode = trieNode.children[charInt];
      }
      trieNode.word = word;
    }
  }

  class TrieNode {
    TrieNode[] children = new TrieNode[26];
    public String word;
  }
}
