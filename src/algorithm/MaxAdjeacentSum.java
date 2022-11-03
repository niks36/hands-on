package algorithm;

public class MaxAdjeacentSum {

  public static void main(String[] args) {
    //
  }
  public int rob(int[] nums) {
    if(nums == null) return 0;
    if(nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];

    int curr = nums[0];
    int curr2 = Math.max(nums[0], nums[1]);

    for(int i = 2; i< nums.length; i++){
      int val = Math.max(curr + nums[i], curr2);
      curr = curr2;
      curr2 = val;
    }
    return curr2;
  }
}
