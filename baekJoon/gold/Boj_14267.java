package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 회사 문화 1
public class Boj_14267 {

  public static void main(String[] args) throws IOException {
    Boj_14267.start();
  }

  private static void start() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<Integer>[] al = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      al[i] = new ArrayList<>();
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      int superior = Integer.parseInt(st.nextToken());
      if (superior == -1) {
        continue;
      } else {
        al[superior].add(i);
      }
    }

    int[] point = new int[n + 1];
    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      point[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
    }

    dfs(point, al, 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(point[i] + " ");
    }
    System.out.println(sb);
  }

  private static void dfs(int[] point, ArrayList<Integer>[] al, int x) {
    for (int y : al[x]) {
      point[y] += point[x];
      dfs(point, al, y);
    }
  }
}
