import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

        Arrays.sort(people);
        
        for (int i = people.length - 1; i >= 0; i--) {
            int p = people[i];
            if (pq.size() == 0) {
                answer ++;
                if (limit - p >= 40) {
                   pq.add(limit - p);
                }
            } else {
                if (pq.peek() < p) {
                    if (limit - p >= 40) {
                       pq.add(limit - p); 
                    }
                    answer ++;
                } else {
                    pq.poll();
                }
            }
        }
        
        return answer;
    }
}