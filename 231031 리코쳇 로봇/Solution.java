import java.util.*;

class Solution {
    final int[] dx = {0, 0, -1, 1};
    final int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] board) {
        int answer = -1;
        
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        
        Node current = null;
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length(); x++) {
                if (board[y].charAt(x) == 'R') {
                    System.out.println(board[y].charAt(x));
                    current = new Node(x, y, 0);
                }
            }
        }
        
        queue.offer(current);
        
        int maxTry = board.length * board[0].length();
        
        while (queue.size() > 0) {
            Node node = queue.poll();
            
            if (board[node.y].charAt(node.x) == 'G') {
                answer = Math.min(answer, node.count);
                if (answer == -1) answer = node.count;
            }
            
            for (int i = 0; i < 4; i++) {
                Node dNode = new Node(node.x, node.y, node.count + 1);
                
                while (dNode.y >= 0 && dNode.y < board.length &&
                      dNode.x >= 0 && dNode.x < board[0].length() &&
                      board[dNode.y].charAt(dNode.x) != 'D') {
                    dNode.y += dy[i];
                    dNode.x += dx[i];
                }
                
                dNode.y -= dy[i];
                dNode.x -= dx[i];
                
                if (!visited[dNode.y][dNode.x]) {
                    queue.offer(dNode);
                }
                
                visited[dNode.y][dNode.x] = true;
            }
            
        }
        
        return answer;
    }
    
    class Node {
        public int x;
        public int y;
        public int count;
        
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}