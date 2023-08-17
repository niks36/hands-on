package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CombinationSubStringUnique {

  // abc -> a ,b, c, ab, ac, bc, abc
  // gfg -> g, f, gf, fg, gg, gfg
  public static void main(String[] args){

  }

  public void printUniqueSubseq1(String input){
    if(input == null || input.length() == 0) return;

    Set<String> resultSet = new HashSet<>();
    LinkedList<Pair> list = new LinkedList<>();

    for(int i = 0; i < input.length() ; i++){
      String firstChar = String.valueOf(input.charAt(i));
      if(resultSet.add(firstChar)){
        System.out.println(firstChar);
      }
      list.push(new Pair(i, firstChar));
      while (!list.isEmpty()){
        Pair pair = list.pop();
        for(int j = pair.index + 1; j < input.length(); j++){
          String result = pair.val + input.charAt(j);
          if(resultSet.add(result)){
            System.out.println(result);
          }
          list.push(new Pair(j, result));
        }
      }
    }
  }

  class Pair{
    Integer index;
    String val;

    public Pair(Integer index, String val) {
      this.index = index;
      this.val = val;
    }
  }

}
