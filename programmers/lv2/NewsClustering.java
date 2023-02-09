package lv2;

import java.util.ArrayList;
import java.util.Collections;

class NewsClustering {

  public int solution(String str1, String str2) {
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    ArrayList<String> strList1 = new ArrayList<>();
    ArrayList<String> strList2 = new ArrayList<>();

    for (int i = 0; i < str1.length() - 1; i++) {
      char first = str1.charAt(i);
      char second = str1.charAt(i + 1);

      if (areAlphabet(first, second)) {
        strList1.add("" + first + second);
      }
    }

    for (int i = 0; i < str2.length() - 1; i++) {
      char first = str2.charAt(i);
      char second = str2.charAt(i + 1);

      if (areAlphabet(first, second)) {
        strList2.add("" + first + second);
      }
    }

    Collections.sort(strList1);
    Collections.sort(strList2);

    ArrayList<String> intersection = new ArrayList<>();
    ArrayList<String> union = new ArrayList<>();

    for (String s : strList1) {
      if (strList2.remove(s)) {
        intersection.add(s);
      }
      union.add(s);
    }

    for (String s : strList2) {
      union.add(s);
    }

    if (union.size() == 0) {
      return 65536;
    }

    return (int) ((double) intersection.size() / (double) union.size() * 65536);
  }

  public static boolean areAlphabet(char c1, char c2) {
    if ('a' <= c1 && c1 <= 'z' && 'a' <= c2 && c2 <= 'z') {
      return true;
    }
    return false;
  }
}