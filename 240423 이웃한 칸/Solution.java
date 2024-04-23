class Solution {
  int[] dx = {0, 0, -1, 1};
  int[] dy = {-1, 1, 0, 0};

  public int solution(String[][] board, int h, int w) {
      int answer = 0;
              
      for (int i = 0; i < 4; i++) {
          int ny = h + dy[i];
          int nx = w + dx[i];
          
          if (ny < board.length && ny >= 0 && nx >= 0 && nx < board[0].length) {
              if (board[ny][nx].equals(board[h][w])) {
                  answer++;
              }
          }
      }
      
      return answer;
  }
}