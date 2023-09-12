import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String oper : operations) {
            String[] str = oper.split(" ");
            String type = str[0];
            Integer value = Integer.parseInt(str[1]);
            
            if (type.equals("I")) {
                pq.offer(value);
                rq.offer(value);
            } else if (type.equals("D") && pq.size() > 0) {
                if (value < 0) {
                    int min = pq.poll();
                    rq.remove(min);
                } else {
                    int max = rq.poll();
                    pq.remove(max);
                }
            }
        }
        
        if (pq.size() == 0) {
            return new int[] {0, 0};
        } else {
            return new int[] {rq.poll(), pq.poll()};
        }
    }
}