import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });
        
        int target = routes[0][1];
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > target) {
                answer++;
                target = routes[i][1];
            }
        }
        
        return answer;
    }
}