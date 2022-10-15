package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindowString {

  public static void main(String[] args) {
    //
    MinWindowString minWindowString = new MinWindowString();
    System.out.println(minWindowString.minWindow1("bbaa", "aba"));
  }

  public String minWindow(String s, String t) {

    if(s == null || t == null) return null;

    if(s.length() < t.length()) return "";

    if(s.length() == t.length() && s.equals(t)) return t;

    List<Character> charList = new ArrayList<>();
    for(Character ch : t.toCharArray()){
      charList.add(ch);
    }

    System.out.println(charList);
    int minLength = Integer.MAX_VALUE;
    int startIndex = 0;
    int endIndex = 0;

    for(int i = 0; i<s.length(); i++){

      if(charList.contains(s.charAt(i))){
        ArrayList<Character> subList = new ArrayList<>(charList);
        Character c = s.charAt(i);
        subList.remove(c);

        if(subList.isEmpty()){
          minLength = 1;
          startIndex = i;
          endIndex = i + 1;
          break;
        }
        for(int j = i+1; j < s.length(); j++){
          Character c1 = s.charAt(j);
          subList.remove(c1);

          if(subList.isEmpty()){
            System.out.println(subList + " " + charList);
            System.out.println(minLength + "-" + i +"-" + j);
            if(minLength > (j-i+1)){
              minLength = j -i + 1;
              startIndex = i;
              endIndex = j + 1;
            }
            break;
          }
        }
      }



    }

    System.out.println(minLength + " " + startIndex + " " + endIndex);
    return s.substring(startIndex, endIndex);


  }

  public String minWindow1(String s, String t) {

    if ( s== null || t == null || s.equals(t) || s.isEmpty() || t.isEmpty()) return "";

    Map<Character, Integer> map = new HashMap<>();
    for(Character ch : t.toCharArray()){
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    int i = 0, j = 0, count = map.size();
    while( j < s.length()){
      char endChar = s.charAt(j++);
      if(map.containsKey(endChar)){
        map.put(endChar, map.get(endChar)-1);
        if(map.get(endChar) == 0) {
          count--;
        }
      }

      if(count > 0) continue;
      while (count == 0){
        char startChar = s.charAt(i);
        if(map.containsKey(startChar)){
          map.put(startChar, map.get(startChar) + 1);
          if(map.get(startChar) > 0){
            count++;
          }
        }
        i++;
      }
    }
//https://www.callicoder.com/minimum-window-substring/
    return "";
  }
}
