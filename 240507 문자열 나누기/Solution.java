class Solution {
    public int solution(String s) {
        int answer = 0;
        char target = 'A';
        int t = 0;
        int n = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (t == 0 || s.charAt(i) == target) {
                target = s.charAt(i);
                t ++;
            } else {
                n ++;
            }
            
            if (t == n) {
                answer++;
                t = 0;
                n = 0;
            }
        }
        
        return answer + (t + n > 0 ? 1 : 0);
    }
}