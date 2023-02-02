package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2225 {

  private static final int MOD_VALUE = 1000000000;

  public static void main(String[] args) throws IOException {
    Boj_2225.start();
  }

  private static void start() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] dp = new int[K + 1][N + 1];

    Arrays.fill(dp[1], 1);
    for (int i = 1; i <= K; i++) {
      dp[i][0] = 1;
    }

    for (int i = 2; i <= K; i++) {
      for (int j = 1; j <= N; j++) {
        dp[i][j] = (dp[i - 1][j] % MOD_VALUE + dp[i][j - 1] % MOD_VALUE) % MOD_VALUE;
      }
    }

    System.out.println(dp[K][N]);
  }
}
