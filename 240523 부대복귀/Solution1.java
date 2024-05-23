import java.util.*;

// 플루이드 워셜
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int MAX_VALUE = 10000000;
        int[][] map = new int[n + 1][n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                map[i][j] = MAX_VALUE;
            }
        }
        
        for (int[] r : roads) {
            map[r[0]][r[1]] = 1;
            map[r[1]][r[0]] = 1;
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        
        for (int i = 0; i < sources.length; i++) {
            if (destination != sources[i]) {
                answer[i] = map[sources[i]][destination];
            }
            
            if (answer[i] == MAX_VALUE) answer[i] = -1;
        }
        
        
        return answer;
    }
}