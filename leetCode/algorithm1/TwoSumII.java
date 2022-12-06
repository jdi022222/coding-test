class Solution {

  public int[] twoSum(int[] numbers, int target) {
    int firstIndex = 0;
    int lastIndex = numbers.length - 1;

    while (true) {
      int sum = numbers[firstIndex] + numbers[lastIndex];
      if (sum == target) {
        return new int[]{++firstIndex, ++lastIndex};
      } else if (sum < target) {
        firstIndex++;
      } else {
        lastIndex--;
      }
    }
  }
}