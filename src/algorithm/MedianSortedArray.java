package algorithm;

public class MedianSortedArray {

  public static void main(String[] args) {
    //
    MedianSortedArray medianSortedArray = new MedianSortedArray();
    double medianSortedArrays = medianSortedArray.findMedianSortedArrays(new int[]{1, 2},
        new int[]{3});
    System.out.println(medianSortedArrays);
  }

  public double findMedianSortedArrays(int[] num1, int[] num2) {
    if (num1 == null && num2 == null) return 0.00;

    if (num2 == null) {
      if (num1.length % 2 == 0) {
        return num1[num1.length / 2];
      } else {
        return ((float) num1[num1.length / 2] + num1[num1.length / 2 + 1]) / 2;
      }
    }

    if (num1 == null) {
      if (num2.length % 2 == 0) {
        return num2[num2.length / 2];
      } else {
        return ((float) num2[num2.length / 2] + num2[num2.length / 2 + 1]) / 2;
      }
    }

    int i = 0;
    int j = 0;
    int totalLength = num1.length + num2.length;
    int medianLength = totalLength / 2;
    boolean bEven = totalLength % 2 == 0;

    System.out.println(medianLength);
    int currentIndex = 0;
    int[] median = new int[totalLength];
    while (true) {
      if (i < num1.length && j < num2.length) {
        if (num1[i] < num2[j]) {
          median[currentIndex] = num1[i];
          i++;
        } else {
          median[currentIndex] = num2[j];
          j++;
        }
      } else if (i < num1.length) {
        median[currentIndex] = num1[i];
        i++;
      } else if (j < num2.length) {
        median[currentIndex] = num2[j];
        j++;
      }


      if (!bEven && currentIndex == medianLength) {
        System.out.println(currentIndex + " " + medianLength + " " );
        return median[currentIndex];
      }

      if (bEven && currentIndex == medianLength) {
        System.out.println(currentIndex + " " + medianLength + " " );
        return ((float) median[currentIndex] + median[currentIndex - 1]) / 2;
      }
      currentIndex++;
    }
  }
}
