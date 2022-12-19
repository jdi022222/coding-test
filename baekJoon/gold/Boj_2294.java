package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2294 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] dp = new int[k + 1]; // 메모이제이션

    // 최대값으로 초기화
    Arrays.fill(dp, Integer.MAX_VALUE - 1);

    // 계산
    // n번 반복
    while (n-- > 0) {
      int coin = Integer.parseInt(br.readLine());
      if (coin <= k) {
        dp[coin] = 1;
        for (int j = coin + 1; j <= k; j++) {
          dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
        }
      }
    }

    if (dp[k] == Integer.MAX_VALUE - 1) {
      System.out.println(-1);
      return;
    }
    System.out.println(dp[k]);
  }
}