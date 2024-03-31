class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;
                board[i][j] = min(board[i - 1][j], board[i][j - 1], board[i - 1][j - 1]) + 1;
                answer = Math.max(board[i][j], answer);
            }
        }
        
        if (answer == 0) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 1) return 1;
            }
            for (int j = 0; j < board[0].length; j++) {
                if (board[0][j] == 1) return 1;
            }
        }
        
        return answer * answer;
    }
    
    int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}