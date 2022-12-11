class Solution {

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    int[] s1CharCount = new int[26];
    int[] s2CharCount = new int[26];

    int len1 = s1.length();
    int len2 = s2.length();

    for (int i = 0; i < len1; i++) {
      s1CharCount[s1.charAt(i) - 'a']++;
      s2CharCount[s2.charAt(i) - 'a']++;
    }

    if (Arrays.equals(s1CharCount, s2CharCount)) {
      return true;
    }

    for (int i = len1; i < len2; i++) {
      s2CharCount[s2.charAt(i) - 'a']++;
      s2CharCount[s2.charAt(i - len1) - 'a']--;
      if (Arrays.equals(s1CharCount, s2CharCount)) {
        return true;
      }
    }

    return false;
  }
}