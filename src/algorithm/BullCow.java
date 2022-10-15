package algorithm;

import java.util.List;
import java.util.stream.Collectors;

public class BullCow {

  public static void main(String[] args) {
    //
    BullCow bullCow = new BullCow();
    System.out.println(bullCow.getHint("1122", "0001"));
  }

  public String getHint(String secret, String guess) {

    List<Character> secretChar =
        secret.chars().mapToObj(value -> (char) value).collect(Collectors.toList());
    List<Character> guessChar =
        guess.chars().mapToObj(value -> (char) value).collect(Collectors.toList());

    boolean[] bolChar = new boolean[secretChar.size()];
    boolean[] used = new boolean[secretChar.size()];

    int bulls = 0, cow = 0;
    for (int i = 0; i < secretChar.size(); i++) {
      if (secretChar.get(i) == guessChar.get(i)) {
        bulls++;
        bolChar[i] = true;
        used[i] = true;
      }
    }

    int cows = 0;
    for (int i = 0; i < secretChar.size(); i++) {
      if (!bolChar[i]) {
        Character guessCharacter = guessChar.get(i);
        for (int j = 0; j < secretChar.size(); j++) {
          if (!used[j] && secretChar.get(j) == guessCharacter) {
            used[j] = true;
            cows++;
            break;
          }
        }
      }
    }

    return bulls + "A" + cows + "B";
  }

  public String getHint1(String secret, String guess) {
    int[] nums = new int[10];
    int bulls = 0;
    int cows = 0;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bulls++;
      } else {
        if (nums[guess.charAt(i) - '0']-- > 0) cows++;
        if (nums[secret.charAt(i) - '0']++ < 0) cows++;
      }
    }
    return bulls + "A" + cows + "B";
  }
}
