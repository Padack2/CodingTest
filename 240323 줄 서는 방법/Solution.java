import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        long[] factorials = new long[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        k--;
        for (int i = 0; i < n; i++) {
            int index = (int) (k / factorials[n - 1 - i]);
            answer[i] = numbers.remove(index);
            k %= factorials[n - 1 - i];
        }

        return answer;
    }
}