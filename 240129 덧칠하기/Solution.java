class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int prev = section[0];
        
        for (int s : section) {
            if (s - prev + 1 > m) {
                answer ++;
                prev = s;
            }
        }
        
        return answer;
    }
}