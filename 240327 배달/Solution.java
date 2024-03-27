import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] dist = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 500000;
                }
            }
        }
        
        for (int[] r : road) {
            dist[r[0]][r[1]] = Math.min(r[2], dist[r[0]][r[1]]);
            dist[r[1]][r[0]] = Math.min(r[2], dist[r[1]][r[0]]);
        }
        
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[j][k]);
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (dist[1][i] <= K) {
                answer ++;
            }
        }

        return answer;
    }
}