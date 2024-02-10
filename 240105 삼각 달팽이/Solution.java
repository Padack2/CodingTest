class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] piramid = new int[n][n];
        
        int [] dy = {1, 0, -1};
        int [] dx = {0, 1, -1};
        
        int d = 0;
        int num = 1;
        int x = 0;
        int y = -1;

        while (n > 0) {
            for (int i = 0; i < n; i++) {
                y += dy[d];
                x += dx[d];
                piramid[y][x] = num++;
            }
            
            n --;
            d = (d + 1) % 3;
        }
        
        int index = 0;
        for (int i = 0; i < piramid.length; i++) {
            for (int j = 0; j < piramid.length; j++) {
                if (piramid[i][j] != 0) {
                    answer[index++] = piramid[i][j];
                }
            }
        }
        
        return answer;
    }
}