package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7569 {

  private static int M;
  private static int N;
  private static int H;
  private static int[][][] tomato;
  private static Queue<Spot1> queue = new LinkedList<>();
  private static int oldX, oldY, oldZ, newX, newY, newZ;
  private static int[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1},
      {0, 0, 1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    tomato = new int[N][M][H];

    for (int k = 0; k < H; k++) {
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
          tomato[i][j][k] = Integer.parseInt(st.nextToken());

          // 토마토가 있을 경우 queue에 add
          if (tomato[i][j][k] == 1) {
            queue.add(new Spot1(i, j, k));
          }
        }
      }
    }

    // 계산 및 결과 출력
    System.out.println(bfs());
  }

  private static int bfs() {
    while (!queue.isEmpty()) {
      Spot1 oldSpot = queue.poll();
      oldX = oldSpot.x;
      oldY = oldSpot.y;
      oldZ = oldSpot.z;

      // 상 하 좌 우 위 아래
      for (int i = 0; i < 6; i++) {
        Spot1 newSpot = new Spot1(oldX + move[i][0], oldY + move[i][1], oldZ + move[i][2]);
        newX = newSpot.x;
        newY = newSpot.y;
        newZ = newSpot.z;

        // 범위 벗어날 때
        if (newX < 0 || newY < 0 || newZ < 0 || newX >= N || newY >= M
            || newZ >= H) {
          continue;
        }

        // 토마토가 익지 않았을 때 or 토마토가 익었지만 더 짧은 시간이 있을 때
        if (tomato[newX][newY][newZ] == 0
            || tomato[newX][newY][newZ] > tomato[oldX][oldY][oldZ] + 1) {
          tomato[newX][newY][newZ] = tomato[oldX][oldY][oldZ] + 1;
          queue.add(newSpot);
        }
      }
    }

    int maxDay = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k < H; k++) {
          // 안익은 토마토가 있을 때
          if (tomato[i][j][k] == 0) {
            return -1;
          }
          maxDay = Math.max(maxDay, tomato[i][j][k]);
        }
      }
    }

    return maxDay == 1 ? 0 : maxDay - 1;
  }
}

class Spot1 {

  int x;
  int y;
  int z;

  public Spot1(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
}

