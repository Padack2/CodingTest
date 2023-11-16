class Solution {
    public int solution(String[] board) {
        int numO = 0;
        int numX = 0;
        
        char winner = '.';
        
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("OOO") || board[i].equals("XXX")) {
                if (winner == '.' || winner == board[i].charAt(0)) {
                    winner = board[i].charAt(0);
                } else {
                    return 0;
                }
            }
            
            char target = board[0].charAt(i);
            int check = 0;
            
            for (int j = 0; j < 3; j++) {
                char cur = board[i].charAt(j);
                if (cur == 'O') {
                    numO ++;
                } else if (cur == 'X') {
                    numX ++;
                }
                
                if (board[j].charAt(i) == target) {
                    check ++;
                }
            }
            
            if (check == 3) {
                if (winner == '.' || winner == target) {
                    winner = target;
                } else {
                    return 0;
                }
            }
        }
        
        if (board[1].charAt(1) != '.' &&
            ((board[0].charAt(0) == board[1].charAt(1) &&
            board[1].charAt(1) == board[2].charAt(2)) ||
            (board[0].charAt(2) == board[1].charAt(1) &&
            board[1].charAt(1) == board[2].charAt(0)))
        ) {
            if (winner == '.' || winner == board[1].charAt(1)) {
                winner = board[1].charAt(1);
            } else {
                return 0;
            }
        }
        
        if (numX > numO || numO - numX > 1 ||
            (winner == 'X' && numO > numX) ||
            (winner == 'O' && numX == numO)) {
            return 0;
        }
        
        return 1;
    }
}