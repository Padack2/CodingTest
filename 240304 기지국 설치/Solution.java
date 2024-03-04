class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int prevPos = 1;
        int width = w * 2 + 1;
        int distance = 0;
        
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];
            
            distance = (station - w) - prevPos;
            prevPos = station + w + 1;
            
            if (distance >= 0) {
                answer += distance / width + (distance % width > 0 ? 1 : 0);
            }
            
            if (i == stations.length - 1 && prevPos <= n) {
                distance = n - prevPos + 1;
                answer += distance / width + (distance % width > 0 ? 1 : 0);
            }
        }
        
        return answer;
    }
}