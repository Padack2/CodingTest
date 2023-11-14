import java.util.*;

class Solution {
    class Price {
        public int index;
        public int number;
        
        Price(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
    
    public int[] solution(int[] prices) {
        PriorityQueue<Price> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.number - o1.number;
        });
        
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            if (pq.size() > 0) {
                while (pq.size() > 0 && pq.peek().number > prices[i]) {
                    Price price = pq.poll();
                    answer[price.index] = i - price.index;
                }
            }
            pq.offer(new Price(i, prices[i]));
            answer[i] = prices.length - i - 1;
        }

        return answer;
    }
}