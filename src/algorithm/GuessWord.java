package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GuessWord {
  public static void main(String[] args) {
    //
    GuessWord guessWord = new GuessWord();
    // "hbaczn"
    // ["gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"]
    // 10

    // "azzzzz"
    // ["abcdef","acdefg","adefgh","aefghi","afghij","aghijk","ahijkl","aijklm","ajklmn","aklmno","almnoz","anopqr","azzzzz"]
    // 10
    guessWord.findSecretWord(
        new String[] {
          "abcdef", "acdefg", "adefgh", "aefghi", "afghij", "aghijk", "ahijkl", "aijklm", "ajklmn",
          "aklmno", "almnoz", "anopqr", "azzzzz"
        });
    // System.out.println(i);
  }

  public void findSecretWord(String[] words) {

    List<String> list = new ArrayList<>(Arrays.asList(words));

    Random random = new Random();
    for (int i = 0, matches = 0; i < 10 && matches != 6; i++) {
      String word = list.get(random.nextInt(list.size()));
      matches = guess(word);
      List<String> newList = new ArrayList<>();
      for (String s : list) {
        if (countMatchingChar(word, s) == matches) {
          newList.add(s);
        }
      }
      list = newList;
    }
  }

  public int countMatchingChar(String s1, String s2) {

    int result = 0;
    for (int i = 0; i < s1.length(); i++) {
      char character1 = s1.charAt(i);
      char character2 = s2.charAt(i);

      if (character1 == character2) result++;
    }

    return result;
  }

  int guess(String s) {
    System.out.println("Guessing with " + s);
    if (s == "hbaczn") {
      System.out.println("FOUND");
      return 6;
    } else {
      int hbaczn = countMatchingChar("azzzzz", s);
      System.out.println("Match word " + hbaczn);
      return hbaczn;
    }
  }
}
