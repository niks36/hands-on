package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinRoundingErrorTarget {

  public static void main(String[] args) {
    //
    MinRoundingErrorTarget minRoundingErrorTarget = new MinRoundingErrorTarget();
    System.out.println(minRoundingErrorTarget.minimizeError(new String[]{"0.700","2.800","4.900"}, 8));
  }

  public String minimizeError(String[] prices, int target) {
    if(prices.length == 0) return null;

    int sumFloored = 0;
    int sumCeiled = 0;

    List<double[]> doubles = new ArrayList<>();
    for(String price: prices){
      double doublePrice = Double.parseDouble(price);
      int floor = (int)Math.floor(doublePrice);
      int ceil = (int)Math.ceil(doublePrice);

      double floorDifference = doublePrice - (double)floor;
      double ceilDifference = (double)ceil - doublePrice;

      sumFloored += floor;
      sumCeiled += ceil;
      doubles.add(new double[]{ceilDifference - floorDifference, ceilDifference, floorDifference});
    }

    for(double[] d : doubles){
    System.out.println(d[0] + " - " + d[1] + " - " + d[2]);
    }

    if(target > sumCeiled || target < sumFloored) return "-1";

    doubles.sort(Comparator.comparingDouble(o -> o[0]));

    for(double[] d : doubles){
      System.out.println(d[0] + " - " + d[1] + " - " + d[2]);
    }

    double sumError = 0.0;
    int nCeiled = target - sumFloored;
    for (int i = 0; i < nCeiled ; i++){
      sumError += doubles.get(i)[1];
    }
    for (int i = nCeiled; i < doubles.size() ; i++){
      sumError += doubles.get(i)[2];
    }

    return String.format("%.3f", sumError);

  }
}
