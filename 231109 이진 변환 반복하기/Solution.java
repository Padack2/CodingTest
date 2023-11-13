class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {
            int zero = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero ++;
                }
            }
            
            answer[0] ++;
            answer[1] += zero;

            s = Integer.toString(s.length() - zero, 2);
        }
        return answer;
    }
}