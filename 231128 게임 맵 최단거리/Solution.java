import java.util.*;

class Solution {
    class Robot {
        public int y;
        public int x;
        public int distance = 1;
        
        Robot (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        Robot (int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    public int solution(int[][] maps) {
        Queue<Robot> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        queue.offer(new Robot(0, 0));
        visited[0][0] = true;
        
        while (!queue.isEmpty() &&
               !(queue.peek().x == maps[0].length - 1 && queue.peek().y == maps.length - 1)) {
            Robot robot = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = robot.x + dx[i];
                int newY = robot.y + dy[i];
                if (newX >= 0 && newX < maps[0].length && newY >= 0 && newY < maps.length &&
                   !visited[newY][newX] && maps[newY][newX] != 0) {
                    visited[newY][newX] = true;
                    
                    queue.offer(new Robot(newX, newY, robot.distance + 1));
                }
            }
            
        }
        
        return queue.isEmpty() ? -1 : queue.peek().distance;
    }
}