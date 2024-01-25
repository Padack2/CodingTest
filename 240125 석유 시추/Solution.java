import java.util.*;

class Solution {
    public class Point {
        public int y;
        public int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    int[] oil;
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int answer = 0;
        oil = new int[land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    bfs(i, j, land);
                }
            }
        }

        for (int i = 0; i < oil.length; i++) {
            answer = Math.max(oil[i], answer);
        }
        
        return answer;
    }
    
    public void bfs(int y, int x, int[][] land) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        
        int sum = 0;
        int min = x;
        int max = x;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (land[p.y][p.x] == 0) {
                continue;
            }
            
            land[p.y][p.x] = 0;
            sum ++;
            max = Math.max(max, p.x);
            min = Math.min(min, p.x);
            
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                
                if (ny >= 0 && nx >= 0 && ny < land.length && nx < land[0].length && land[ny][nx] == 1) {
                    q.add(new Point(ny, nx));
                }
            }
        }
        
        for (int i = min; i <= max; i++) {
            oil[i] += sum;
        }
    }
}