import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int count = 0;
        while (pq.size() > 1 && pq.peek() < k) {
            int newFood = pq.poll() + (pq.poll() * 2);
            pq.offer(newFood);
            count++;
        }
        
        if (pq.peek() < k) {
            return -1;
        }
        
        return count;
    }
}