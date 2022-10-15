package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

  public static void main(String[] args) {
    TextJustification textJustification = new TextJustification();
    List<String> strings =
        textJustification.fullJustify(
            new String[] {"What","must","be","acknowledgment","shall","be"}, 16);
    System.out.println(strings);
  }

  public List<String> fullJustify(String[] words, int maxWidth) {

    List<String> result = new ArrayList<>();
    int currentLength = 0;
    List<String> currentWords = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (currentLength + words[i].length() <= maxWidth) {
        currentLength += words[i].length() + 1;
        currentWords.add(words[i]);
      } else {
        result.add(addSentence(currentWords, currentLength, maxWidth, false));
        currentWords.clear();
        currentWords.add(words[i]);
        currentLength = words[i].length() + 1;
      }
    }

    if (currentWords.size() > 0) {
      result.add(addSentence(currentWords, currentLength, maxWidth, true));
    }
    return result;
  }

  public String addSentence(
      List<String> currentWords, int currentLength, int maxWidth, boolean bEnd) {
    StringBuilder sentence = new StringBuilder();
    currentLength--;
    int wordForSpace = currentWords.size() - 1;
    if (!bEnd  && wordForSpace != 0) {

      int extraSpace = (maxWidth - currentLength) / wordForSpace;
      int extraPadding = (maxWidth - currentLength) % wordForSpace;

      for (int i = 0; i < currentWords.size() - 1; i++) {
        sentence.append(currentWords.get(i));
        sentence.append(" ");
        sentence.append(" ".repeat(Math.max(0, extraSpace)));
        if (extraPadding > 0) {
          sentence.append(" ");
          extraPadding--;
        }
      }
      sentence.append(currentWords.get(currentWords.size() - 1));
    } else {
      for (int i = 0; i < currentWords.size() - 1; i++) {
        sentence.append(currentWords.get(i));
        sentence.append(" ");
      }
      sentence.append(currentWords.get(currentWords.size() - 1));
      int extraSpace = maxWidth - currentLength;
      for(int i = 0; i< extraSpace ; i++){
        sentence.append(" ");
      }
    }
    return sentence.toString();
  }
  //
  //        int endIndex = i -1;
  //        int totalWords = endIndex - startIndex + 1;
  //        int lengthDiff = maxWidth - currentLength - (totalWords - 1);
  //
  //        if (lengthDiff % totalWords == 0) {
  //          int extraSpace = lengthDiff / (totalWords - 1);
  //          if(extraSpace < 0) extraSpace = 1;
  //          StringBuilder extraSpaceStr = new StringBuilder();
  //          for (int k = 0; k < extraSpace; k++) {
  //            extraSpaceStr.append(" ");
  //          }
  //          StringBuilder resultString = new StringBuilder();
  //          for (int j = startIndex; j < endIndex; j++) {
  //            resultString.append(words[j]);
  //            resultString.append(extraSpaceStr);
  //          }
  //          resultString.append(words[endIndex]);
  //          result.add(resultString.toString());
  //        } else {
  //          int extraSpace = lengthDiff / (totalWords-1);
  //          int extraPadding = lengthDiff % (totalWords-1);
  //          StringBuilder extraSpaceStr = new StringBuilder();
  //          for (int k = 0; k < extraSpace; k++) {
  //            extraSpaceStr.append(" ");
  //          }
  //          StringBuilder resultString = new StringBuilder();
  //          for (int j = startIndex; j < endIndex; j++) {
  //            resultString.append(words[j]);
  //            resultString.append(" ");
  //            resultString.append(extraSpaceStr);
  //            if (extraPadding > 0) {
  //              resultString.append(" ");
  //              extraPadding--;
  //            }
  //          }
  //          resultString.append(words[endIndex]);
  //          result.add(resultString.toString());
  //        }
  //        startIndex = i;
  //        currentLength = 0;
  //      }
  //    }
  //    return result;

}
//
// [This     is     an, example         of         text]
// [This    is    an
// [This    is   an
