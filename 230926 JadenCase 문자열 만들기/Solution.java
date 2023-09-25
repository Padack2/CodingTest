class Solution {
    public String solution(String str) {
        
        String answer = "";
        boolean blank = true;
        for (String s : str.toLowerCase().split("")) {
            if (s.equals(" ")) {
                blank = true;
            }
            else if (blank) {
                blank = false;
                s = s.toUpperCase();
            }
                
            answer += s;
        }

        return answer;
    }
}