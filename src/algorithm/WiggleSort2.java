package algorithm;

import java.util.Arrays;

public class WiggleSort2 {

  public void wiggleSort(int[] nums) {
// //   int median = findKthLargest(nums, (nums.length + 1) / 2);
//    int n = nums.length;
//
//    int left = 0, i = 0, right = n - 1;
//
//    while (i <= right) {
//
//      if (nums[newIndex(i,n)] > median) {
//        swap(nums, newIndex(left++,n), newIndex(i++,n));
//      }
//      else if (nums[newIndex(i,n)] < median) {
//        swap(nums, newIndex(right--,n), newIndex(i,n));
//      }
//      else {
//        i++;
//      }
//    }


  }

  private int newIndex(int index, int n) {
    return (1 + 2*index) % (n | 1);
  }

  public void wiggleSort1(int[] nums) {
    int n=nums.length-1;
    //copy values to new array
    int[] newarr= Arrays.copyOf(nums,nums.length);
    //sort new array
    Arrays.sort(newarr);
    //old arr=1,5,1,1,6,4
    //new arr=1,1,1,4,5,6
    //now lets apply odd position and even position
    //odd position
    for(int i=1;i<nums.length;i+=2)
      nums[i]=newarr[n--];
    //even position
    for(int i=0;i<nums.length;i+=2)
      nums[i]=newarr[n--];
  }

}
