package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리의 지름
public class Boj_1967 {

  private static int n;
  private static int maxIdx;
  private static int maxLen;

  private static ArrayList<Boj_1967.Node> graph[];
  private static boolean[] visit;

  public static void main(String[] args) throws IOException {
    Boj_1967.start();
  }

  private static void start() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    graph = new ArrayList[n + 1];

    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      putEdge(x, y, d);
    }

    // 가장 깊은 종말 노드 찾기
    visit = new boolean[n + 1];
    visit[1] = true;
    findMax(1, 0);

    // 가장 깊은 종말 노드에서부터 먼 종말 노드 찾기
    visit = new boolean[n + 1];
    visit[maxIdx] = true;
    findMax(maxIdx, 0);

    System.out.println(maxLen);
  }

  private static void putEdge(int x, int y, int d) {
    graph[x].add(new Node(y, d));
    graph[y].add(new Node(x, d));
  }

  private static void findMax(int idx, int sum) {
    if (maxLen < sum) {
      maxIdx = idx;
      maxLen = sum;
    }

    for (Node node : graph[idx]) {
      if (!visit[node.num]) {
        visit[node.num] = true;
        findMax(node.num, sum + node.len);
      }
    }
  }

  private static class Node {

    int num;
    int len;

    public Node(int num, int len) {
      this.num = num;
      this.len = len;
    }
  }
}
