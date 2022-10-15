package algorithm;

import java.util.HashMap;

public class FractionToDecimal {

  public static void main(String[] args) {
    //
    FractionToDecimal fractionToDecimal = new FractionToDecimal();
//    System.out.println(fractionToDecimal.fractionToDecimal(1, 2));
//    System.out.println(fractionToDecimal.fractionToDecimal(2, 1));
//    System.out.println(fractionToDecimal.fractionToDecimal(4, 333));
//    System.out.println(fractionToDecimal.fractionToDecimal(93, 7));
    System.out.println(fractionToDecimal.fractionToDecimal(-50, 8));
    System.out.println(fractionToDecimal.fractionToDecimal(-1, -2147483648));
 //   System.out.println(fractionToDecimal.fractionToDecimal1(-1, -2147483648));
  }

  public String fractionToDecimal(int numerator, int denominator) {

    if(numerator == 0) return "0";
    if(denominator == 0) return "0";

    StringBuilder result = new StringBuilder();
    if ((numerator < 0 && denominator > 0) || numerator > 0 && denominator < 0) {
      result.append("-");
    }


    long num = numerator, den = denominator;
    num = Math.abs(num);
    den = Math.abs(den);

    long quotient = num / den;
    long reminder = num % den;

    result.append(quotient);

    if (reminder == 0) {
      return result.toString();
    } else {
      result.append(".");
      HashMap<Long, Integer> map = new HashMap<>();
      while (reminder != 0) {
        if (map.containsKey(reminder)) {
          Integer index = map.get(reminder);
          result.insert(index, "(");
          result.append(")");
          break;
        } else {
          map.put(reminder, result.length());
          reminder *= 10;
          quotient = reminder / den;
          reminder = reminder % den;
          result.append(quotient);
        }
      }
    }
    return result.toString();
  }

  public String fractionToDecimal1(int numerator, int denominator) {
    if (numerator == 0)
      return "0";
    if (denominator == 0)
      return "";

    String result = "";

    // is result is negative
    if ((numerator < 0) ^ (denominator < 0)) {
      result += "-";
    }

    // convert int to long
    long num = numerator, den = denominator;
    num = Math.abs(num);
    den = Math.abs(den);

    // quotient
    long res = num / den;
    result += String.valueOf(res);

    // if remainder is 0, return result
    long remainder = (num % den) * 10;
    if (remainder == 0)
      return result;

    // right-hand side of decimal point
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    result += ".";
    while (remainder != 0) {
      // if digits repeat
      if (map.containsKey(remainder)) {
        int beg = map.get(remainder);
        String part1 = result.substring(0, beg);
        String part2 = result.substring(beg, result.length());
        result = part1 + "(" + part2 + ")";
        return result;
      }

      // continue
      map.put(remainder, result.length());
      res = remainder / den;
      result += String.valueOf(res);
      remainder = (remainder % den) * 10;
    }

    return result;
  }

}
