package gold;

import java.io.*;
import java.util.*;

public class Boj_14500 {

  private static int N;
  private static int M;
  private static int max;
  private static int[][] paper;
  private static boolean[][] visit;

  // 상하좌우
  private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    max = 0;
    paper = new int[N][M];
    visit = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // dfs
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visit[i][j] = true;
        dfs(i, j, paper[i][j], 1);
        visit[i][j] = false;
      }
    }

    System.out.println(max);
  }

  static void dfs(int x, int y, int sum, int count) {

    // 테트로미노 완성 시 수들의 합 계산
    if (count == 4) {
      max = Math.max(max, sum);
      return;
    }

    // 상하좌우 탐색
    for (int i = 0; i < 4; i++) {
      int newX = x + move[i][0];
      int newY = y + move[i][1];

      // 범위 벗어나면 예외 처리
      if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
        continue;
      }

      if (!visit[newX][newY]) {

        // 뻐큐 모양
        if (count == 2) {
          visit[newX][newY] = true;
          dfs(x, y, sum + paper[newX][newY], count + 1);
          visit[newX][newY] = false;
        }

        visit[newX][newY] = true;
        dfs(newX, newY, sum + paper[newX][newY], count + 1);
        visit[newX][newY] = false;
      }
    }
  }
}
