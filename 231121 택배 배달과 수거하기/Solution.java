class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int delIdx =  deliveries.length - 1;
        int pickIdx = pickups.length - 1;
        int temp;
        
        while (delIdx >= 0 || pickIdx >= 0) {
            while (delIdx >= 0 && deliveries[delIdx] == 0) {
                delIdx --;
            }
            while (pickIdx >= 0 && pickups[pickIdx] == 0) {
                pickIdx --;
            }
            answer += 2 * Math.max(delIdx + 1, pickIdx + 1);
            
            temp = cap;
            
            while (temp > 0 && delIdx >= 0) {
                if (temp > deliveries[delIdx]) {
                    temp -= deliveries[delIdx];
                    deliveries[delIdx] = 0;
                    delIdx --;
                } else {
                    deliveries[delIdx] -= temp;
                    temp = 0;   
                }
            }
            
            temp = cap;
            while (temp > 0 && pickIdx >= 0) {
                if (temp > pickups[pickIdx]) {
                    temp -= pickups[pickIdx];
                    pickups[pickIdx] = 0;
                    pickIdx --;
                } else {
                    pickups[pickIdx] -= temp;
                    temp = 0;   
                }
            } 
        }
        return answer;
    }
}