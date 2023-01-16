package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_16236 {

  private static int N;

  private static int size; // 상어의 현재 크기
  private static int count; // 상어가 먹이를 먹은 수
  private static int answer; // 상어의 총 이동 횟수
  private static Spot3 location; // 상어의 현재 위치
  private static int[][] moveXY = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};// 상어의 이동

  private static int[][] space; // 상어와 물고기 위치 저장소

  public static void main(String[] args) throws IOException {
    Boj_16236.start();
  }

  private static void start() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    space = new int[N][N];
    size = 2;
    count = 0;
    answer = 0;
    location = new Spot3(0, 0, 0);

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        space[i][j] = Integer.parseInt(st.nextToken());
        if (space[i][j] == 9) {
          location.x = i;
          location.y = j;
        }
      }
    }

    while (true) {
      Spot3 result = bfs(location.x, location.y);

      // System.out.println("spot = " + result.x + " " + result.y + " " + result.move + " size = " + size );

      if (result.move <= 0) {
        break;
      }

      answer += result.move; // 이동 횟수 추가
      location = result; // 상어 위치 update
    }

    System.out.println(answer);
  }


  // 가장 가까운 물고기 bfs 로 찾기
  // @return 가장 가까운 물고기 위치와 이동 횟수, 찾는 물고기 없으면 {-1, -1, -1} return
  private static Spot3 bfs(int x, int y) {
    PriorityQueue<Spot3> queue = new PriorityQueue<>(
        (spot1, spot2) -> spot1.move != spot2.move ? Integer.compare(
            spot1.move, spot2.move)
            : (spot1.x != spot2.x ? Integer.compare(spot1.x, spot2.x) : Integer.compare(spot1.y,
                spot2.y)));

    boolean[][] visit = new boolean[N][N];

    space[x][y] = 0;
    visit[x][y] = true;

    queue.add(new Spot3(x, y, 0));

    while (!queue.isEmpty()) {

      Spot3 oldSpot = queue.poll();
      int oldX = oldSpot.x;
      int oldY = oldSpot.y;

      if (canEat(oldSpot)) {
        if (++count == size) {
          count = 0;
          size++;
        }
        space[oldX][oldY] = 0; // 물고기 제거
        return oldSpot;
      }

      for (int i = 0; i < 4; i++) {
        Spot3 newSpot = new Spot3(oldX + moveXY[i][0], oldY + moveXY[i][1], oldSpot.move + 1);

        int newX = newSpot.x;
        int newY = newSpot.y;

        // 범위 체크
        if (!isInBoundary(newSpot)) {
          continue;
        }

        // 방문 체크
        if (visit[newX][newY]) {
          continue;
        }

        visit[newX][newY] = true;

        if (!canMove(newSpot)) {
          continue;
        }

        queue.offer(newSpot);
      }
    }

    return new Spot3(-1, -1, -1);
  }

  // 상어가 물고기를 먹을 수 있는 크기 체크
  private static boolean canEat(Spot3 spot) {
    if (space[spot.x][spot.y] >= size || space[spot.x][spot.y] == 0) {
      return false;
    }
    return true;
  }

  // 상어가 이동할 수 있는 칸 체크
  private static boolean canMove(Spot3 spot) {
    if (space[spot.x][spot.y] > size) {
      return false;
    }
    return true;
  }

  // 탐색 범위 유효성 체크
  private static boolean isInBoundary(Spot3 spot) {
    if (spot.x < 0 || spot.y < 0 || spot.x >= N || spot.y >= N) {
      return false;
    }
    return true;
  }
}


class Spot3 {

  int x;
  int y;
  int move;

  public Spot3(int x, int y, int move) {
    this.x = x;
    this.y = y;
    this.move = move;
  }
}