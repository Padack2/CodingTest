class Solution {
    public int solution(int n) {
        int answer = 0;

        if (n <= 2) return n;
        
        int a = 1;
        int b = 2;
        int temp;
        
        for (int i = 0; i < n - 2; i++) {
            answer = (a + b) % 1000000007;
            temp = b;
            b = answer;
            a = temp;
        }
        
        return answer;
    }
}