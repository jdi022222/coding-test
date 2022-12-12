class Solution {

  static int row;
  static int col;
  static int cnt;
  static int MAX;
  static boolean[][] visit;

  public int maxAreaOfIsland(int[][] grid) {
    row = grid.length;
    col = grid[0].length;
    visit = new boolean[row][col];
    cnt = 0;
    MAX = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (!visit[i][j] && grid[i][j] == 1) {
          dfs(grid, i, j);
          MAX = Math.max(MAX, cnt);
          cnt = 0;
        }
      }
    }
    return MAX;
  }

  private static void dfs(int[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= row || j >= col) {
      return;
    }
    if (visit[i][j]) {
      return;
    }
    if (grid[i][j] == 1) {
      visit[i][j] = true;
      cnt++;
      dfs(grid,i-1,j);
      dfs(grid,i+1,j);
      dfs(grid,i,j-1);
      dfs(grid,i,j+1);
    }
  }
}