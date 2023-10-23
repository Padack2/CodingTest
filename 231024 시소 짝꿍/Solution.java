import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] same = new int[1001];
        int[] mul = new int[4001];
        
        for (int i = 0; i < weights.length; i++) {
            int sameWeight = same[weights[i]];
            
            if (sameWeight > 0) answer += sameWeight;
            same[weights[i]] ++;
            
            for (int j = 2; j <= 4; j++) {
                int weight = weights[i] * j;
                if (sameWeight > 0) {
                    answer += mul[weight] - sameWeight;
                } else {
                    answer += mul[weight];
                }
                mul[weight] ++;
            }
        }
        
        return answer;
    }
}