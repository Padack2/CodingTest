import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                answer ++;
                
                while (q.size() > 0) {
                    int curNetwork = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (computers[curNetwork][j] == 1 && curNetwork != j && !visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}