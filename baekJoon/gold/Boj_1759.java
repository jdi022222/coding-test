package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759 {

  static int L;
  static int C;
  static char[] input;
  static char[] output;
  static boolean[] visit;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    input = br.readLine().replace(" ", "").toCharArray();
    output = new char[L];
    visit = new boolean[C];
    Arrays.sort(input);

    password(0, 0);
  }

  // index = map의 index, len = 암호의 길이
  private static void password(int index, int len) {
    if (len == L) {
      int consonant = 0;
      int vowel = 0;
      // 자모음 개수 확인
      for (int i = 0; i < L; i++) {
        if (output[i] == 'a' || output[i] == 'e' || output[i] == 'i' || output[i] == 'o'
            || output[i] == 'u') {
          vowel++;
        } else {
          consonant++;
        }
      }
      // 자음 2개 이상, 모음 1개 이상일 경우 print
      if (consonant >= 2 && vowel >= 1) {
        for (char c : output) {
          System.out.print(c);
        }
        System.out.println();
      }
      return;
    }

    // 조합 탐색
    for (int i = index; i < input.length; i++) {
      if (!visit[i]) {
        visit[i] = true;
        output[len] = input[i];
        password(i + 1, len + 1);
        visit[i] = false;
      }
    }
  }
}
