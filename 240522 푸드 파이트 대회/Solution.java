class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < food.length; i++) {
            int val = food[i] / 2;
            sb.append(String.valueOf(i).repeat(val));
        }
        
        answer = sb.toString() + "0" + sb.reverse().toString();
    
        return answer;
    }
}