class Solution {
    public long solution(int n) {
        long answer = 1;
        
        if (n <= 3) return n;
        
        long a = 1;
        long b = 2;
        long temp = 0;
        for (int i = 2; i < n; i++) {
            answer = (a + b) % 1234567;
            temp = b;
            b = answer;
            a = temp;
        }
        
        
        return answer;
    }
}