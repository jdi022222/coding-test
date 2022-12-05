class Solution {

  public void rotate(int[] nums, int k) {
    int[] nums_clone = nums.clone();
    while (k >= nums.length) {
      k -= nums.length;
    }

    for (int i = 0; i < nums.length; i++) {
      int nextIndex = i - k;
      if (nextIndex < 0) {
        nextIndex += nums.length;
      }
      nums[i] = nums_clone[nextIndex];
    }
  }
}