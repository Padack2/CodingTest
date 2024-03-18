class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int remain = storey % 10;
            
            storey /= 10;
            
            if (remain >= 6 || (remain == 5 && storey % 10 >= 5)) {
                answer += (10 - remain);
                storey ++;
            } else {
                answer += remain;
            }
        }
        
        return answer;
    }
}