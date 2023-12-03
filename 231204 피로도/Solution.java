class Solution {
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        dfs(new boolean[dungeons.length], dungeons, k, 0, "");
        return answer;
    }
    
    void dfs(boolean[] visited, int[][] dungeons, int k, int cnt, String s) {
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                dfs(visited, dungeons, k - dungeons[i][1], cnt + 1, s + i);
                visited[i] = false;
            }
        }
        
        answer = Math.max(cnt, answer);
    }
}