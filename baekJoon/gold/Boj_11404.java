package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11404 {

  private static final int INPUT_MAX = 10000001;

  public static void main(String[] args) throws Exception {
    Boj_11404.start();
  }

  private static void start() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // given
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] arr = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = INPUT_MAX;
        if (i == j) {
          arr[i][j] = 0;
        }
      }
    }

    while (m-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr[a][b] = Math.min(arr[a][b], c);
    }

    // when
    // 플로이드 와샬 알고리즘 적용
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
        }
      }
    }

    // then
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr[i][j] == INPUT_MAX) {
          sb.append("0").append(" ");
          continue;
        }
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
