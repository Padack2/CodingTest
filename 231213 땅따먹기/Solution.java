import java.util.*;

class Solution {
    int max (int[] arr, int cur) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur != i) {
                max = Math.max(arr[i], max);
            }
        }
        
        return max;
    }
    
    int solution(int[][] land) {
        int answer = 0;
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                land[i][j] += max(land[i-1], j);
            }
        }

        return max(land[land.length - 1], -1);
    }
}