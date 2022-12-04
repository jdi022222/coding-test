package algorithm1;

class Solution {
  public int search(int[] nums, int target) {
    int right = nums.length - 1;
    int left = 0;
    int mid = 0;
    int ans = -1;
    while(left <= right){
      mid = (left + right)/2;
      int findNum = nums[mid];
      if(findNum > target){
        right = mid - 1;
      }
      else if (findNum < target){
        left = mid + 1;
      }
      else{
        ans = mid;
        break;
      }
    }
    return ans;
  }
}
