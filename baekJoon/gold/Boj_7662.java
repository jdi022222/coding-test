package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj_7662 {

  public static void main(String[] args) throws Exception {
    Boj_7662.start();
  }

  private static void start() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {

      TreeMap<Integer, Integer> treeMap = new TreeMap<>();

      int k = Integer.parseInt(br.readLine());
      while (k-- > 0) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        char command = st.nextToken().charAt(0); // 명령어
        int commandNum = Integer.parseInt(st.nextToken()); // 입력 데이터

        // 1-1. 삭제 명령어 && map이 비었을 때
        if (command == 'D' && treeMap.isEmpty()) {
          continue;
        }

        // 1-2. 삭제 명령어
        if (command == 'D') {
          if (commandNum == -1) { // 최소 삭제
            int minValue = treeMap.firstKey();
            if (treeMap.put(minValue, treeMap.getOrDefault(minValue, 0) - 1) == 1) {
              treeMap.remove(minValue);
            }
            continue;
          }
          if (commandNum == 1) { // 최대 삭제
            int maxValue = treeMap.lastKey();
            if (treeMap.put(maxValue, treeMap.getOrDefault(maxValue, 0) - 1) == 1) {
              treeMap.remove(maxValue);
            }
            continue;
          }
        }

        // 2. 추가 명령어
        treeMap.put(commandNum, treeMap.getOrDefault(commandNum, 0) + 1);
      }

      // 최대 최소 출력
      if (treeMap.isEmpty()) {
        bw.write("EMPTY\n");
        continue;
      }
      bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
    }
    bw.close();
  }
}
