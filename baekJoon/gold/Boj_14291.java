package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14291 {

  private static int[][] paper;
  private static boolean[][] bit;
  private static boolean[][] visit;

  private static int N;
  private static int M;

  private static int MAX = 0;


  private static void func(int row, int col) {

    /*
    1. visit을 이용해 bit맵 생성(true, false 조합)
    2. true = 가로, false = 세로로 계산
    3. 최대값 변수 MAX와 비교
     */

    // 다 채웠으면 계산
    if (row == N) {
      cal();
      return;
    }

    // col이 가득 차면 줄바꿈
    if (col == M) {
      func(row + 1, 0);
      return;
    }

    visit[row][col] = true;
    func(row, col + 1);

    visit[row][col] = false;
    func(row, col + 1);
  }

  private static void cal() {
    int sum = 0;
    int digit = 1;

    // 가로값 계산 (visit = true)
    for (int i = 0; i < N; i++) {
      for (int j = M - 1; j >= 0; j--) {
        if (visit[i][j]) {
          sum += paper[i][j] * digit;
          digit *= 10;
        } else {
          digit = 1;
        }
      }
      digit = 1;
    }

    digit = 1;
    // 세로값 계산 (visit = false)
    for (int i = 0; i < M; i++) {
      for (int j = N - 1; j >= 0; j--) {
        if (!visit[j][i]) {
          sum += paper[j][i] * digit;
          digit *= 10;
        } else {
          digit = 1;
        }
      }
      digit = 1;
    }

    // 최대값 계산
    MAX = Math.max(sum, MAX);
  }

  private static int makeBinary(int n) {
    return Integer.parseInt(Integer.toBinaryString(n));
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    paper = new int[N][M];
    bit = new boolean[N][M];
    visit = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < M; j++) {
        paper[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
      }
    }

    func(0, 0);

    System.out.println(MAX);
  }
}
