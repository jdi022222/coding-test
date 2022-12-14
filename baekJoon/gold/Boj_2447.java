package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_2447 {

  private static int N;
  private static boolean[][] star;

  public static void main(String[] args) throws IOException {
    Boj_2447.start();
  }

  private static void start() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    star = new boolean[N][N]; // false = star, true = 빈칸

    pattern(N);

    // 출력
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (star[i][j]) {
          bw.write(' ');
        } else {
          bw.write('*');
        }
      }
      bw.write("\n");
    }
    bw.close();
  }

  private static void pattern(int input) {
    if (input == 1) {
      return;
    }

    for (int i = input / 3; i < N; i += input) {
      for (int j = input / 3; j < N; j += input) {
        // 기준 칸으로부터 input/3 개의 칸을 빈칸으로 만들기
        for (int a = 0; a < input / 3; a++) {
          for (int b = 0; b < input / 3; b++) {
            star[i + a][j + b] = true;
          }
        }
      }
    }

    // 재귀
    pattern(input / 3);
  }
}