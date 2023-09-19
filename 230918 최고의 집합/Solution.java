import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        if (s < n) {
            return new int[] {-1};
        }
    
        int num = s / n;
        answer = new int[n];
        Arrays.fill(answer, num);
        
        num = s % n;
        
        for (int i = n - 1; i >= 0; i--) {
            if (num == 0) break;
            answer[i]++;
            num--;
        }
        
        return answer;
    }
}
