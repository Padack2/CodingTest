class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if (sticker.length == 1) return sticker[0];
        
        int length = sticker.length;
        
        // 첫 번째 스티커를 찢어서 마지막 인덱스는 탐색하면 안되는 경우
        int[] dp = new int[length];
        // 첫 번째 스티커를 찢지 않은 경우
        int[] dp2 = new int[length];
        
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], sticker[i] + dp[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], sticker[i] + dp2[i - 2]);
        }
    
        return Math.max(dp[length - 2], dp2[length - 1]);
    }
}