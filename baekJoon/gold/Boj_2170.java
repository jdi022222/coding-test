package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 선 긋기
public class Boj_2170 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] input = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      input[i][0] = Integer.parseInt(st.nextToken());
      input[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(input, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

    int oldX = input[0][0];
    int oldY = input[0][1];
    int sum = oldY - oldX;

    for (int i = 1; i < n; i++) {
      int newX = input[i][0];
      int newY = input[i][1];

      if (newY <= oldY) {
        continue;
      }

      if (newX <= oldY && oldY <= newY) {
        sum += newY - oldY;
        oldY = newY;
        continue;
      }

      sum += newY - newX;
      oldY = newY;
    }
    System.out.println(sum);
  }
}
