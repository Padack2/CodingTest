import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;
        
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(i);
            pq.offer(priorities[i]);
        }
        
        while (!pq.isEmpty()) {
            int index = q.poll();
            if (priorities[index] == pq.peek()) {
                count++;
                pq.poll();
                if (index == location) break;
            } else {
                q.offer(index);
            }
        }

        return count;
    }
}