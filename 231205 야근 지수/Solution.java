import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        while (n > 0 && pq.peek() > 0) {
            pq.offer(pq.poll() - 1);
            n--;
        }
        
        while (!pq.isEmpty()) {
            int work = pq.poll();
            
            answer += work * work;
        }
        
        return answer;
    }
}