package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PyramidTransition {

  public static void main(String[] args) {
    PyramidTransition pyramidTransition = new PyramidTransition();
    boolean b = pyramidTransition.pyramidTransition("BCD", List.of("BCC", "CDE", "CEA", "FFF"));
    System.out.println(b);
    b =
        pyramidTransition.pyramidTransition(
            "ABBBBA",
            List.of(
                "ACA", "ACF", "ACE", "ACD", "ABA", "ABF", "ABE", "ABD", "FCA", "FCF", "FCE", "FCD",
                "FBA", "FBF", "FBE", "FBD", "ECA", "ECF", "ECE", "ECD", "EBA", "EBF", "EBE", "EBD",
                "DCA", "DCF", "DCE", "DCD", "DBA", "DBF", "DBE", "DBD", "CAA", "CAF", "CAE", "CAD",
                "CFA", "CFF", "CFE", "CFD", "CEA", "CEF", "CEE", "CED", "CDA", "CDF", "CDE", "CDD",
                "BAA", "BAF", "BAE", "BAD", "BFA", "BFF", "BFE", "BFD", "BEA", "BEF", "BEE", "BED",
                "BDA", "BDF", "BDE", "BDD", "CCA", "CCF", "CCE", "CCD", "CBA", "CBF", "CBE", "CBD",
                "BCA", "BCF", "BCE", "BCD", "BBA", "BBF", "BBE", "BBD", "CCC", "CCB", "CBC", "CBB",
                "BCC", "BCB", "BBC", "BBB"));
    System.out.println(b);
  }

  public boolean pyramidTransition(String bottom, List<String> allowed) {
    // Construct allowed Map to map allowed characters to Strings in allowed list
    HashMap<String, List<String>> allowedMap = new HashMap<>();
    for (String s : allowed) {
      String temp = s.substring(0, 2);
      if (!allowedMap.containsKey(temp)) {
        allowedMap.put(temp, new ArrayList<>());
      }
      allowedMap.get(temp).add(s.substring(2));
    }
    return pyramidTransition(allowedMap, bottom.length(), 0, bottom, "");
  }

  public boolean pyramidTransition(
      HashMap<String, List<String>> allowedMap,
      int row,
      int index,
      String currentString,
      String nextString) {
    // if you reach the top row, you have successfully created the pyramid
    if (row == 0) {
      return true;
    }


    // if you are on the last index of the current row, move up by one row
    if (index == currentString.length() - 1) {
      return pyramidTransition(allowedMap, row - 1, 0, nextString, "");
    }

    List<String> temp = allowedMap.get(currentString.substring(index, index + 2));

    // if there is no allowed character to be placed, your combination has failed
    if (temp == null) {
      return false;
    }

    boolean result = false;
    // for every allowed character to your combination, construct the nextString and recurse
    for (String s : temp) {
      result |= pyramidTransition(allowedMap, row, index + 1, currentString, nextString + s);
    }

    return result;
  }
}
