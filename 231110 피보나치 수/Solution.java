class Solution {
    public int solution(int n) {
        int a = 0;
        int b = 1;
        int answer = 0;
        
        while (n > 1) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
            n--;
        }
        return answer;
    }
}