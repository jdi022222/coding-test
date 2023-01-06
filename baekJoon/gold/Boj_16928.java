package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928 {

  private static int[] dp = new int[101];
  private static int[] jump = new int[101];
  private static boolean[] visit = new boolean[101];

  public static void main(String[] args) throws IOException {
    Boj_16928.start1();
  }


  private static void start1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N + M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      jump[u] = v;
    }

    bfs();

    System.out.println(dp[100]);
  }


  private static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    visit[1] = true;

    while (!queue.isEmpty()) {
      int poll = queue.poll();

      if (poll == 100) {
        return;
      }

      // 주사위 1~6
      for (int i = 1; i <= 6; i++) {
        int newNum = poll + i;

        if (newNum > 100) {
          continue;
        }

        if (visit[newNum]) {
          continue;
        }

        visit[newNum] = true;

        if (jump[newNum] != 0) {
          if (!visit[jump[newNum]]) {
            queue.add(jump[newNum]);
            visit[jump[newNum]] = true;
            dp[jump[newNum]] = dp[poll] + 1;
          }
          continue;
        }

        dp[newNum] = dp[poll] + 1;
        queue.add(newNum);
      }
    }
  }
}
