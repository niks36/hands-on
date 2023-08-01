package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement {

  public static void main(String[] args){

  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if(nums1.length == 0 || nums2.length == 0){
      return new int[]{-1};
    }

    HashMap<Integer,Integer> map = new HashMap<>();

    for(int i = 0; i<nums1.length; i++){
      map.put(nums1[i], i);
    }
    int[] result = new int[nums1.length];
    Arrays.fill(result, -1);

    for(int i = 0; i<nums2.length; i++){
      if(map.containsKey(nums2[i])){
        int key = nums2[i];
        int value = -1;
          for(int j = i +1; j < nums2.length; j++){
              if(nums2[j] > key ){
                value = nums2[j];
                break;
              }
          }
        result[map.get(nums2[i])] = value;
      }
    }
    return result;
  }

}
