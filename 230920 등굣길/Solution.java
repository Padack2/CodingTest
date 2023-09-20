class Solution {
  int count;
  public int solution(int m, int n, int[][] puddles) {
      count = 0;
      int[][] map = new int[m][n];
      
      for (int i = 0; i < puddles.length; i++) {
          map[puddles[i][0] - 1][puddles[i][1] - 1] = -1;
      }
      
      map[0][0] = 1;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (map[i][j] != -1) {
                  if(i + 1 != m && map[i + 1][j] != -1) {
                      map[i + 1][j] += map[i][j];
                      map[i + 1][j] %= 1000000007;
                  }
                  if(j + 1 != n && map[i][j + 1] != -1) {
                      map[i][j + 1] += map[i][j];
                      map[i][j + 1] %= 1000000007;
                  }
              }
          }
      }
      
      
      // dfs(m - 1, n - 1, map, 0, 0);
      return map[m - 1][n - 1];
  }
  
//     void dfs(int m, int n, boolean[][] map, int currentX, int currentY) {
//         if (currentX == m && currentY == n) {
//             count++;
//             count %= 1000000007;
//             return;
//         }
      
//         if (currentX < m && !map[currentX + 1][currentY]) {
//             dfs(m, n, map, currentX + 1, currentY);
//         }
//         if (currentY < n && !map[currentX][currentY + 1]) {
//             dfs(m, n, map, currentX, currentY + 1);
//         }
//     }
}