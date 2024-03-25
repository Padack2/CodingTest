import java.util.*;

class Solution {
    int idx = 0;
    public int[][] solution(int n) {
        int[][] answer = new int[(int) (Math.pow(2,n)-1)][2];
        
        hanoi(n, 1, 2, 3, answer);
            
        return answer;
    }
    
    void hanoi(int n, int start, int mid, int to, int[][] answer){
		if (n == 1) {
            answer[idx++] = new int[] {start, to};
			return;
		}
 
		hanoi(n - 1, start, to, mid, answer);
		answer[idx++] = new int[] {start, to};
		hanoi(n - 1, mid, start, to, answer);
 
	}
}