class Solution {
    final int[] dx = {-1, 1, 0, 0};
    final int[] dy = {0, 0, -1, 1};
    boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
       visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0) continue;
                
                visited[i][j] = true;
                numberOfArea ++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, getSize(picture, i, j, picture[i][j]));
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int getSize(int[][] picture, int y, int x, int target) {
        int sum = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (ny < 0 || ny >= picture.length ||
                nx < 0 || nx >= picture[0].length || target != picture[ny][nx]) {
                continue;
            }
            
            if (!visited[ny][nx]) {
                visited[ny][nx] = true;
                sum += getSize(picture, ny, nx, target);
            }
        }
        
        return sum;
    }
}