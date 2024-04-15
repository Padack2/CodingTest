class Solution {
    public int solution(int[][] board, int[][] skill) {
        int m = board.length;
        int n = board[0].length;
        int answer = 0;
        int[][] prefix = new int[m + 1][n + 1];
        
        for (int[] s : skill) {
            // 1 공격, 2 회복
            int type = s[0] == 1 ? -1 : 1;
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            int weight = type * degree;
            
            prefix[r1][c1] += weight;
            prefix[r1][c2 + 1] -= weight;
            prefix[r2 + 1][c1] -= weight;
            prefix[r2 + 1][c2 + 1] += weight;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefix[i][j] +=  prefix[i][j - 1];
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] +=  prefix[i - 1][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] += prefix[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}