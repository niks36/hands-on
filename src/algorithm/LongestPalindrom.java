package algorithm;

public class LongestPalindrom {

  public String longestPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    int len = Integer.MIN_VALUE;

    int start2 = 0;

    String res = "";
    while (start <= s.length() - 1) {


      while (start2 <= end) {
        if (isPalindrome(start2, end, s)) {
          // we already have a palindrome of greater length
          if (len >= (end - start2 + 1)) {
            break;
          }

          res = s.substring(start2, end + 1);
          len = end - start2 + 1;
          break;
        }
        end--;
      }
      start2 = start + 1;
      start++;
      end = s.length() - 1;
    }

    return res;
  }
  boolean isPalindrome(int start, int end, String s) {

    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

}
