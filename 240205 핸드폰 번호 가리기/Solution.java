class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int secretLength = phone_number.length() - 4;
        
        for (int i = 0; i < phone_number.length(); i++) {
            if (secretLength > i) {
                answer += "*";
            } else {
                answer += phone_number.charAt(i);
            }
        }
        
        return answer;
    }
}