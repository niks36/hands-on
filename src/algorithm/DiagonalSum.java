package algorithm;

public class DiagonalSum {

  public static void main(String[] args) {
    //
  }

  public int diagonalSum(int[][] nums){
    int sum = 0;
    int n = nums.length;

    for(int i = 0 ;  i< n; i++){
      sum += nums[i][i];
      sum += nums[i][n - i -1];

    }

    if(n % 2 == 1){
      sum -= nums[n/2][n/2];
    }

    return sum;
  }
}
