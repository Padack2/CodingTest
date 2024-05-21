import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        int len = score.length;
        
        while (len >= m) {
            answer += score[len - m] * m;
            len -= m;
            
        }
        
        return answer;
    }
}