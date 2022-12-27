package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10026 {

  private static int N;
  private static int answer;
  private static char[][] grid1;
  private static char[][] grid2;
  private static boolean[][] visit;

  private static int[] moveX = {-1, 1, 0, 0};
  private static int[] moveY = {0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    Boj_10026.start();
  }

  private static void start() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    grid1 = new char[N][N];
    grid2 = new char[N][N];

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        grid1[i][j] = input.charAt(j);
        grid2[i][j] = input.charAt(j) == 'G' ? 'R' : input.charAt(j);
      }
    }

    answer = 0;
    visit = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j]) {
          search(i, j, grid1[i][j], grid1);
          answer++;
        }
      }
    }
    bw.write(answer + " ");

    answer = 0;
    visit = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j]) {
          search(i, j, grid2[i][j], grid2);
          answer++;
        }
      }
    }
    bw.write(answer + "");

    bw.close();
  }

  private static void search(int x, int y, char c, char[][] grid) {
    visit[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int newX = x + moveX[i];
      int newY = y + moveY[i];

      // 범위를 벗어났을 때
      if (newX < 0 || newY < 0 || newX >= N || newY >= N) {
        continue;
      }

      // 이미 방문했을 때
      if (visit[newX][newY]) {
        continue;
      }

      // 찾고자 하는 문자와 다를 때
      if (grid[newX][newY] != c) {
        continue;
      }

      // 상하좌우 탐색
      search(newX,newY,c, grid);
    }
  }
}