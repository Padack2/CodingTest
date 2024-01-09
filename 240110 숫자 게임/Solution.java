import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int prev = 0;
        
        for (int i = 0; i < A.length; i++) {
            for (int j = prev; j < B.length; j++) {
                if (A[i] < B[j]) {
                    prev = j + 1;
                    answer ++;
                    break;
                }
            }
        }
        
        return answer;
    }
}