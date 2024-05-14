class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int att = getAttack(i);
            
            answer += att > limit ? power : att;
        }
        
        return answer;
    }
    
    int getAttack(int n) {
        int cnt = 0;
        
        if (n == 1) return 1;
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt += 2;
                if (i * i == n) {
                    cnt --;
                }
            }
        }
        
        return cnt;
    }
}


/* 다른 사람의 풀이 */
class Solution {

    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];    
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}