package algorithm;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern2 {

  public static void main(String[] args) {
    //
    WordPattern2 wordPattern2 = new WordPattern2();
    boolean b = wordPattern2.wordPatternMatch("abab", "redblueredblue");
    System.out.println(b);
  }

  public boolean wordPatternMatch(String pattern, String s) {
    return isMatch(pattern, 0, s, 0, new HashMap<>(), new HashSet<>());
  }

  private boolean isMatch(
      String pattern,
      int i,
      String s,
      int j,
      HashMap<Character, String> chMap,
      HashSet<String> set) {
    if (i == pattern.length() && j == s.length()) {
      return true;
    }

    if (i == pattern.length() || j == s.length()) {
      return false;
    }
    final char c = pattern.charAt(i);

    String patternString = chMap.get(c);
    if (patternString != null) {
      if (!s.startsWith(patternString, j)) {
        return false;
      }
      return isMatch(pattern, i + 1, s, j + patternString.length(), chMap, set);
    }

    for(int k = j ; k < s.length(); k++){
      String t = s.substring(j,k + 1);

      if(set.contains(t)) continue;

      chMap.put(c, t);
      set.add(t);

      if(isMatch(pattern, i+1, s, k +1, chMap,set)){
        return true;
      }

      chMap.remove(c);
      set.remove(t);
    }
    return false;
  }
}
