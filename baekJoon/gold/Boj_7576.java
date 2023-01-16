package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576 {

  private static ArrayList<Spot3> spots; // 1이 담긴 좌표들
  private static int[][] branch; // 전체 좌표들
  private static boolean[][] visit; // bfs 방문 확인용
  private static int M; // 가로 칸 수
  private static int N; // 세로 칸 수
  private static int[] moveX = {0, 0, -1, 1};
  private static int[] moveY = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    visit = new boolean[N][M];
    branch = new int[N][M];
    spots = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        branch[i][j] = Integer.parseInt(st.nextToken());
        if (branch[i][j] == 1) {
          spots.add(new Spot3(i, j));
        }
      }
    }

    // bfs로 토마토를 익게 만듦
    // 단, 일반적인 bfs와는 다르게 처음 queue를 돌릴 때
    // 1이 포함되어 있는 모든 칸을 add해야 함
    // spots 라는 arrayList 안에 1이 포함되어 있는 칸을 저장 후 bfs
    bfs();

    // 출력
    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (branch[i][j] == 0) {
          System.out.println("-1");
          return;
        }
        max = Math.max(max, branch[i][j]);
      }
    }
    System.out.println(max - 1);
  }

  private static void bfs() {
    Queue<Spot3> queue = new LinkedList<>();
    // 1인 지점을 모두 queue에 add
    for (int i = 0; i < spots.size(); i++) {
      Spot3 s = spots.get(i);
      queue.add(s);
      visit[s.x][s.y] = true;
    }

    // bfs 시작
    while (!queue.isEmpty()) {
      Spot3 s_Poll = queue.poll();
      // 상하좌우 탐색
      for (int i = 0; i < 4; i++) {
        int newX = s_Poll.x + moveX[i];
        int newY = s_Poll.y + moveY[i];

        // 방문할 수 없는 칸이면 continue
        if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
          continue;
        }

        // 이미 방문 했거나, 토마토가 익었거나 없는 칸이면 continue
        if (visit[newX][newY] || branch[newX][newY] != 0) {
          continue;
        }

        queue.add(new Spot3(newX, newY));
        branch[newX][newY] = branch[s_Poll.x][s_Poll.y] + 1;
        visit[newX][newY] = true;
      }
    }
  }
}

// 좌표용 class
class Spot {

  int x;
  int y;

  Spot(int x, int y) {
    this.x = x;
    this.y = y;
  }
}