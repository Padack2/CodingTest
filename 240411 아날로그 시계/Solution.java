class Solution {
    // 시침이 한바퀴를 도는 시간
    final int H_ROUND = 12 * 60 * 60;
    // 분침이 한바퀴를 도는 시간
    final int M_ROUND = 60 * 60;
    // 시침이 한바퀴를 도는 동안 초침이 도는 횟수
    final int H_S_ROUND = 60 * 12 - 1;
    // 분침이 한바퀴를 도는 동안 초침이 도는 횟수
    final int M_S_ROUND = 60 - 1;
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        int startTime = getSecond(h1, m1, s1);
        int endTime = getSecond(h2, m2, s2);
        int count = calculateAlarm(endTime) - calculateAlarm(startTime);
        
        if (checkStartTime(startTime)) count ++;
        
        return count;
    }
    
    int getSecond(int h, int m, int s) {
        return h * 60 * 60 + m * 60 + s;
    }
    
    int calculateAlarm(int time) {
        // H_S_ROUND / H_ROUND 는 초당 초침과 시침이 만나는 횟수
        int h = time * H_S_ROUND / H_ROUND;
        int m = time * M_S_ROUND / M_ROUND;
        
        // 00시 및 12시 정각에는 알림이 동시에 울림
        int penalty = H_ROUND <= time ? 1 : 0;
        
        return h + m - penalty;
    }
    
    boolean checkStartTime(int time) {
        return time * 719 % H_ROUND == 0 || time * 59 % M_ROUND == 0;
    }
}