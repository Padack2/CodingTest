class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int y = 5;
        int x = 5;
        
        for (String dir : dirs.split("")) {
            int d = 0;
            switch (dir) {
                case "L": d = 0; break;
                case "R": d = 1; break;
                case "U": d = 2; break;
                case "D": d = 3; break;
            }

            int nextY = y + dy[d];
            int nextX = x + dx[d];
            int tempD = d + (d % 2 == 0 ? 1 : -1);
            if (nextY >= 0 && nextY < 11 && nextX >= 0 && nextX < 11) {
                
                if(!visited[y][x][d] && !visited[nextY][nextX][tempD]) {
                    visited[y][x][d] = true;
                    visited[nextY][nextX][tempD] = true;

                    answer ++;
                }
            
                y = nextY;
                x = nextX;
            } else {
                continue;
            }
        }
        
        return answer;
    }
}