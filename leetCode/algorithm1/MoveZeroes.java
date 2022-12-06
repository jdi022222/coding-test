package algorithm1;


import java.util.ArrayList;
import java.util.Arrays;

class Solution {

  public void moveZeroes(int[] nums) {
    ArrayList<Integer> al = new ArrayList();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        al.add(nums[i]);
      }
    }
    Arrays.fill(nums, 0);
    for (int i = 0; i < al.size(); i++) {
      nums[i] = al.get(i);
    }
  }
}