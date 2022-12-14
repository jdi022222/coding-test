package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2293 {

  private static int n;
  private static int k;
  private static int[] dp;

  public static void main(String[] args) throws IOException {
    Boj_2293.start();
  }

  private static void start() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    dp = new int[k + 1];
    dp[0] = 1;

    while (n--> 0){
      int coin = Integer.parseInt(br.readLine());
      for (int j = coin; j <= k; j++)
        dp[j] += dp[j - coin];
    }
    System.out.println(dp[k]);
  }
}