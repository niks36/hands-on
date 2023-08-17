package algorithm;

public class RotateArrayKTimes {
  public static void main(String[] args) {
    //
  }

  public void rotate(int[] nums, int k) {
    int start = 0;
    int end = nums.length - 1;

    if(k > nums.length){
      k = k % nums.length;
    }

    reverse(nums, start ,end);

    reverse(nums, start, k-1);
    reverse(nums, k, end);
  }

  private void reverse(int[] nums, int start, int end) {
    while(start <end){
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start ++;
      end--;
    }
  }
}
