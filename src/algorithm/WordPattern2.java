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
      int patternIndex,
      String string,
      int stringIndex,
      HashMap<Character, String> chPatternMap,
      HashSet<String> processedString) {
    if (patternIndex == pattern.length() && stringIndex == string.length()) {
      return true;
    }

    if (patternIndex == pattern.length() || stringIndex == string.length()) {
      return false;
    }
    final char c = pattern.charAt(patternIndex);

    String patternString = chPatternMap.get(c);
    if (patternString != null) {
      if (!string.startsWith(patternString, stringIndex)) {
        return false;
      }
      return isMatch(pattern, patternIndex + 1, string, stringIndex + patternString.length(), chPatternMap, processedString);
    }

    for(int k = stringIndex ; k < string.length(); k++){
      String t = string.substring(stringIndex,k + 1);

      if(processedString.contains(t)) continue;

      chPatternMap.put(c, t);
      processedString.add(t);

      if(isMatch(pattern, patternIndex+1, string, k +1, chPatternMap,processedString)){
        return true;
      }

      chPatternMap.remove(c);
      processedString.remove(t);
    }
    return false;
  }

  private boolean isMatch1(
      String pattern,
      int patternIndex,
      String string,
      int stringIndex,
      HashMap<Character, String> chPatternMap,
      HashSet<String> processedString) {
    if( patternIndex == pattern.length() && stringIndex == string.length()){
      return true;
    }

    if( patternIndex == pattern.length() || stringIndex == string.length()){
      return false;
    }

    char ch = pattern.charAt(patternIndex);

    if(chPatternMap.containsKey(ch)){
      String patternString = chPatternMap.get(ch);
      if(!string.startsWith(patternString, stringIndex)){
        return false;
      }
      return isMatch(pattern, patternIndex +1 , string, stringIndex + patternString.length() + 1 , chPatternMap ,processedString);
    }

    for(int i = 0 ; i< string.length(); i++){
      String subString = string.substring(stringIndex, i + 1);
      if(processedString.contains(subString)) continue;;

      chPatternMap.put(ch, subString);
      processedString.add(string);

      if(isMatch(pattern, patternIndex + 1, string, i + 1, chPatternMap ,processedString)){
        return true;
      }

      chPatternMap.remove(ch);
      processedString.remove(string);
    }
    return false;
  }
}
