import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};

    class Point {
        public int y;
        public int x;
        public int distance = 0;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        public Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
    
    public int solution(String[] maps) {
        Point start = new Point(0, 0);
        Point end = new Point(0, 0);
        Point lever = new Point(0, 0);
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char target = maps[i].charAt(j);
                if (target == 'S') {
                    start = new Point(i, j);
                } else if (target == 'E') {
                    end = new Point(i, j);
                } else if (target == 'L') {
                    lever = new Point(i, j);
                }
            }
        }
        
        int distance1 = getDistance(start, lever, maps);
        if (distance1 < 0) return -1;
        
        int distance2 = getDistance(lever, end, maps);
        if (distance2 < 0) return -1;
        
        return distance1 + distance2;
    }
    
    public int getDistance(Point start, Point end, String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<Point> q = new LinkedList<>();
        
        q.offer(start);
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
             if (cur.y == end.y && cur.x == end.x) {
                return cur.distance;
            }
            
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                
                if (x >= 0 && y >= 0 && y < maps.length && x < maps[0].length()
                    && !visited[y][x] && maps[y].charAt(x) != 'X') {
                    visited[y][x] = true;
                    q.offer(new Point(y, x, cur.distance + 1));
                }
            }
        }
        
        return -1;
    }
}