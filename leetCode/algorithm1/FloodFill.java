class Solution {

  static int row;
  static int col;

  static int[] moveX = {-1, 1, 0, 0};
  static int[] moveY = {0, 0, -1, 1};

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if(image[sr][sc] == color) return image;

    row = image.length;
    col = image[0].length;

    int originColor = image[sr][sc];
    image[sr][sc] = color;

    dfs(image, sr, sc, originColor, color);
    return image;
  }

  private static void dfs(int[][] image, int sr, int sc, int originColor, int color) {

    for (int i = 0; i < 4; i++) {
      int newSr = sr + moveX[i];
      int newSc = sc + moveY[i];

      if (newSr < 0 || newSc < 0 || newSr >= row || newSc >= col) {
        continue;
      }
      if (image[newSr][newSc] == originColor) {
        image[newSr][newSc] = color;
        dfs(image, newSr, newSc, originColor, color);
      }
    }
  }
}