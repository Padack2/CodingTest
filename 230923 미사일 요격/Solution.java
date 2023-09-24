import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });
        
        int target = targets[0][1];
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= target) {
                answer++;
                target = targets[i][1];
            }
        }
        
        return answer;
    }
}