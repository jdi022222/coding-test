import java.util.StringTokenizer;

class Solution {

  public String reverseWords(String s) {
    StringTokenizer st = new StringTokenizer(s);
    StringBuilder sb = new StringBuilder();

    while (st.countTokens() > 0) {
      String ss = st.nextToken();
      int r = ss.length() - 1;
      while (r >= 0) {
        sb.append(ss.charAt(r));
        r--;
      }
      if (st.countTokens() != 0) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }
}