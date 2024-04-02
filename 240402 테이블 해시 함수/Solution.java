import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a, b) -> {
            int com = a[col - 1] - b[col - 1];
            
            if (com == 0) {
                com = b[0] - a[0];
            }

            return com;
        });
        
        for (int i = row_begin; i <= row_end; i++) {
            int num = 0;
            for (int j = 0; j < data[0].length; j++) {
                num += data[i - 1][j] % i;
            }

            answer ^= num;
        }
       
        return answer;
    }
}