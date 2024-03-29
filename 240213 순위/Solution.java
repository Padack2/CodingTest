class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n + 1][n + 1];
        
        for(int[] result:results){
            map[result[0]][result[1]] = 1;
            map[result[1]][result[0]] = -1;
        }

        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (map[j][i] !=0 && map[j][i] == map[i][k]) {
                        map[j][k] = map[j][i];
                    }
                }
            }
        }
        
        
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
            if (cnt <= 1) {
                answer++;
            }
        }

        return answer;
    }
}