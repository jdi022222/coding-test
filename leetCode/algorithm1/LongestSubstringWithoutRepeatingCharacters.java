import java.util.HashSet;
import java.util.Set;

class Solution {

  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    int slow = 0;
    int fast = 0;

    Set<Character> set = new HashSet<>();

    while (fast < s.length()) {
      if (!set.contains(s.charAt(fast))) {
        set.add(s.charAt(fast++));
        max = Math.max(max, set.size());
      } else {
        set.remove(s.charAt(slow++));
      }
    }
    return max;
  }
}