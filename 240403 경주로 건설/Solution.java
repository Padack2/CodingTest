import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    class Road {
        public int price;
        public int x;
        public int y;
        public int prevDirecton;
        
        Road(int y, int x, int price, int prevDirecton) {
            this.y = y;
            this.x = x;
            this.price = price;
            this.prevDirecton = prevDirecton;
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        
        int yLen = board.length;
        int xLen = board[0].length;
        
        boolean[][][] visited = new boolean[yLen][xLen][4];
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(0, 0, 0, -1));
        
        while(!q.isEmpty()) {
            Road cur = q.poll();
            
            if (cur.price > answer) {
                continue;
            }

            if (cur.y == yLen - 1 && cur.x == xLen - 1) {
                answer = Math.min(answer, cur.price);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int tx = cur.x + dx[i];
                int ty = cur.y + dy[i];
            
                if (tx < 0 || ty < 0 || tx >= xLen || ty >= yLen || board[ty][tx] == 1) {
                    continue;
                }
                
                int price = cur.price;
                
                if (cur.prevDirecton == -1 || cur.prevDirecton == i) {
                    price += 100;   
                } else {
                    price += 600;
                }
                
                if (!visited[ty][tx][i] || board[ty][tx] >= price) {
                    visited[ty][tx][i] = true;
                    board[ty][tx] = price;
                    
                    q.add(new Road(ty, tx, price, i));
                }
            }

            
        }
        
        return answer;
    }
}