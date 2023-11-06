import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < enemy.length; i++) {
            if (pq.size() < k) {
                pq.offer(enemy[i]);
            } else if (pq.peek() < enemy[i]) {
                n -= pq.poll();
                pq.offer(enemy[i]);
            } else {
                n -= enemy[i];
            }
            
            if (n < 0) {
                return i;
            }
        }
        
        return enemy.length;
    }
}