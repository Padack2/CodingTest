import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
    
        for (int key : map.keySet()) {
            pq.add(map.get(key));
        }

        int sum = 0;
        
        while(sum < k) {
            sum += pq.poll();
            answer++;
        }
        
        return answer;
    }
}