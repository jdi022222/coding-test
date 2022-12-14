package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2133 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] dp = new long[31];
    dp[2] = 3;

    // f(n) = 2 + f(n - 2) * 3 + f(n - 4) * 2 + f(n - 6) * 2 + ... + f(2) * 2
    for (int i = 4; i <= N; i += 2) {

      int sigma = 0;
      for (int j = 2; j <= (i - 2) / 2; j++) {
        sigma += dp[i - 2 * j] * 2;
      }

      // 최종 식
      dp[i] = 2 + dp[i - 2] * 3 + sigma;
    }
    System.out.println(dp[N]);
  }
}