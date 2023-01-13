package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1107 {

  private static int N;
  private static int M;
  private static boolean[] isBroken = new boolean[10];
  private static int min = 999999;

  public static void main(String[] args) throws IOException {
    Boj_1107.start();
  }

  private static void start() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    StringTokenizer st;
    if (M != 0) {
      st = new StringTokenizer(br.readLine());

      while (M-- > 0) {
        isBroken[Integer.parseInt(st.nextToken())] = true;
      }
    }
    min = Math.abs(N - 100);

    for (int i = 0; i <= 999999; i++) {
      String s = String.valueOf(i);
      boolean check = true;

      for (int j = 0; j < s.length(); j++) {
        if (isBroken[s.charAt(j) - '0']) {
          check = false;
          break;
        }
      }

      if (check) {
        min = Math.min(min, Math.abs(i - N) + s.length());
      }
    }

    System.out.println(min);
  }
}