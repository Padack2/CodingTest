class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= 2) {
            int count = n / a * b;
            answer += count;
            n = count + n % a;
        }
        
        
        return answer;
    }
}