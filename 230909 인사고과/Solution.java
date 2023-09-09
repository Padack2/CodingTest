import java.util.*;

class Solution {
    
    public int solution(int[][] scores) {
        int answer = 1;
        int maxScore;
        int[] wanhoScores = scores[0];
        int wanhoScore = scores[0][0] + scores[0][1];

        
        for (int i = 0; i < scores.length; i++) {
            if (!validateScore(scores[i], wanhoScores)) return -1;
        }
        
        for (int i = 0; i < scores.length; i++) {
            boolean insentive = true;
            
            if (wanhoScore >= scores[i][0] + scores[i][1]) {
                continue;
            }
            
            for (int j = 0; j < scores.length; j++) {
                if (!validateScore(scores[j], scores[i])) {
                    insentive = false;
                    break;
                }
            }
            
            if (insentive) {
                answer++;
            }
        }
        
        return answer;
    }
    
    
    public boolean validateScore(int[] a, int[] b) {
        return a[0] <= b[0] || a[1] <= b[1];
    }
    
}