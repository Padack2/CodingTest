import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] arr = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = 1;
        }
        
        for (int l : lost) {
            arr[l]--;
        }
        
        Arrays.sort(reserve);
        
        for (int r : reserve) {
            arr[r]++;
        }
        
        for (int r : reserve) {
            if (arr[r] < 2) {
                continue;
            }
            if (r > 1 && arr[r - 1] == 0) {
                arr[r - 1] = 1;
                continue;
            }
            if (r != n && arr[r + 1] == 0) {
                arr[r + 1] = 1;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] > 0) answer++;
        }
        
        return answer;
    }
}