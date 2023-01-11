package gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9019 {

  public static void main(String[] args) throws IOException {
    Boj_9019.solution();
  }

  private static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {

      st = new StringTokenizer(br.readLine());

      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      Queue<Register> queue = new LinkedList<>();
      boolean[] visit = new boolean[10000];

      queue.offer(new Register(A, ""));
      visit[A] = true;

      while (!queue.isEmpty()) {
        Register old = queue.poll();

        if (old.num == B) {
          bw.write(old.command + "\n");
          break;
        }

        if (!visit[old.D()]) {
          visit[old.D()] = true;
          queue.add(new Register(old.D(), old.command + "D"));
        }
        if (!visit[old.S()]) {
          visit[old.S()] = true;
          queue.add(new Register(old.S(), old.command + "S"));
        }
        if (!visit[old.L()]) {
          visit[old.L()] = true;
          queue.add(new Register(old.L(), old.command + "L"));
        }
        if (!visit[old.R()]) {
          visit[old.R()] = true;
          queue.add(new Register(old.R(), old.command + "R"));
        }
      }
    }
    bw.close();
  }
}

class Register {

  int num;
  String command;

  Register(int num, String command) {
    this.num = num;
    this.command = command;
  }

  int D() {
    return (this.num * 2) % 10000;
  }

  int S() {
    return this.num - 1 == -1 ? 9999 : this.num - 1;
  }

  int L() {
    return (this.num * 10 + this.num / 1000) % 10000;
  }

  int R() {
    return this.num / 10 + this.num % 10 * 1000;
  }
}