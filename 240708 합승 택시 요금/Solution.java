class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n + 1][n + 1];
        
        // init
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
                
                map[i][j] = 100000000;
            }
        }
        
        // 플루이드 워셜
        for (int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            map[fare[0]][fare[1]] = fare[2];
            map[fare[1]][fare[0]] = fare[2];
        }
        
        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        
        int min = map[s][a] + map[s][b];
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, map[s][i] + map[i][a] + map[i][b]);
        }
        
        return min;
    }
}