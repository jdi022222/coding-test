package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_2470 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[][] arr = new int[N][2];
    for (int i = 0; i < N; i++) {
      int temp = Integer.parseInt(st.nextToken());
      arr[i][0] = Math.abs(temp);
      arr[i][1] = temp;
    }

    Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

    int min = Integer.MAX_VALUE;
    int sum = 0;
    int[] answer = new int[2];

    for (int i = 0; i < N - 1; i++) {
      sum = Math.abs(arr[i][1] + arr[i + 1][1]);
      if (min > sum) {
        min = sum;
        answer[0] = arr[i][1];
        answer[1] = arr[i + 1][1];
      }
    }

    // 출력
    Arrays.sort(answer);
    System.out.println(answer[0] + " " + answer[1]);
  }
}
