class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int cur = 0;
        int length = 0;
        int tube = p % m;
        
        while (length < t * m) {
            String number = Integer.toString(cur, n).toUpperCase();
            
            for (int i = 0; i < number.length(); i++) {
                if ((length + i + 1) % m == tube && answer.length() < t) {
                    answer += number.charAt(i);
                } 
            }
            
            cur ++;
            length += number.length();
        }
        
        return answer;
    }
}