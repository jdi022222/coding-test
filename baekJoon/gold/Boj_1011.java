package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_1011 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int distance = y - x;
      int cnt = 2;
      int j = 2;
      if (distance <= 3) {
        bw.write(distance + "\n");
      } else {
        distance -= 2;
        while (true) {
          cnt++;
          distance -= j;
          if (distance <= 0) {
            break;
          }
          cnt++;
          distance -= j;
          if (distance <= 0) {
            break;
          }
          j++;
        }
        bw.write(cnt + "\n");
      }
    }
    bw.close();
  }
}
